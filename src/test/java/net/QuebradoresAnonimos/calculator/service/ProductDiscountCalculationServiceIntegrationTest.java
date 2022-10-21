package net.QuebradoresAnonimos.calculator.service;

import net.QuebradoresAnonimos.calculator.model.Product;
import net.QuebradoresAnonimos.calculator.repository.stub.ProductRepositoryStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class ProductDiscountCalculationServiceIntegrationTest {
    @Autowired
    ProductDiscountCalculationService driver;
    static ProductRepositoryStub productRepository;

    // Double productDefaultPrice = 100.00;

    @BeforeAll
    public static void setupAll() {
        productRepository = new ProductRepositoryStub();
    }

    @Test
    @DisplayName("Quando o Desconto é de 10% ENTÃO Preço do Produto cai de $100 para $90")
    public void whenDiscountIs10PercentThenProductPricesLower10Percent() {
        // AAA Pattern => Arrange, then Act, finally Assert
        /* Arrange */
        Double discountFactor = 0.90;
        Product product = productRepository.findById(1L);
        /* Act */
        Product result = driver.calculate(product, discountFactor);
        /* Assert */
        assertThat(result.getPrice(), is(90.00));

    }
}
