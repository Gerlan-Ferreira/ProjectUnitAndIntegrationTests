package net.QuebradoresAnonimos.calculator.service;

import net.QuebradoresAnonimos.calculator.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductDiscountCalculationImplementService implements ProductDiscountCalculationService{
    @Override
    public Product calculate(Product product, Double discountFactor) {
        product.setPrice(product.getPrice() * discountFactor);
        return product;
    }
}