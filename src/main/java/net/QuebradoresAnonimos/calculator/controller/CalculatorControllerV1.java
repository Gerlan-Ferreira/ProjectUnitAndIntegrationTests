package net.QuebradoresAnonimos.calculator.controller;

import net.QuebradoresAnonimos.calculator.model.Product;
import net.QuebradoresAnonimos.calculator.repository.ProductRepository;
import net.QuebradoresAnonimos.calculator.service.DiscountFactorCalculatorService;
import net.QuebradoresAnonimos.calculator.service.ProductDiscountCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "/calculator/v1",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class CalculatorControllerV1 {

    @Autowired
    DiscountFactorCalculatorService discountFactorCalculationService;

    @Autowired
    ProductDiscountCalculationService productDiscountCalculationService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public Product getProductWithDiscount(
            @RequestParam(required = false) Long productId,
            @RequestParam(required = false) String clientType,
            @RequestParam(required = false) Integer quantity)
    {
        Double discountFactor = discountFactorCalculationService.calculate(clientType, quantity);
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product;
        if(productOptional.isPresent()) {
            product = productOptional.get();
            return productDiscountCalculationService.calculate(product, discountFactor);
        }
        return new Product();
    }

}
