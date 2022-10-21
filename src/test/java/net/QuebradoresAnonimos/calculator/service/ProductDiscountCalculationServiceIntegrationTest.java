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

    @BeforeAll
    public static void setupAll() {
        productRepository = new ProductRepositoryStub();
    }

    @Test
    @DisplayName("Quando o Desconto é de 0% ENTÃO Preço do Produto permanece em $100")
    public void whenDiscountIs0PercentThenProductPricesRemainsTheSame() {
        // AAA Pattern => Arrange, then Act, finally Assert
        /* Arrange */
        Double discountFactor = 1.0;
        Product product = productRepository.findById(1L);
        /* Act */
        Product result = driver.calculate(product, discountFactor);
        /* Assert */
        assertThat(result.getPrice(), is(100.00));

    }
    @Test
    @DisplayName("Quando o Desconto é de 5% ENTÃO Preço do Produto cai de $100 para $95")
    public void whenDiscountIs5PercentThenProductPricesLower5Percent() {
        // AAA Pattern => Arrange, then Act, finally Assert
        /* Arrange */
        Double discountFactor = 0.95;
        Product product = productRepository.findById(1L);
        /* Act */
        Product result = driver.calculate(product, discountFactor);
        /* Assert */
        assertThat(result.getPrice(), is(95.00));

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

    @Test
    @DisplayName("Quando o Desconto é de 15% ENTÃO Preço do Produto cai de $100 para $85")
    public void whenDiscountIs15PercentThenProductPricesLower15Percent() {
        // AAA Pattern => Arrange, then Act, finally Assert
        /* Arrange */
        Double discountFactor = 0.85;
        Product product = productRepository.findById(1L);
        /* Act */
        Product result = driver.calculate(product, discountFactor);
        /* Assert */
        assertThat(result.getPrice(), is(85.00));

    }

    @Test
    @DisplayName("Quando o Desconto é de 20% ENTÃO Preço do Produto cai de $100 para $80")
    public void whenDiscountIs20PercentThenProductPricesLower20Percent() {
        // AAA Pattern => Arrange, then Act, finally Assert
        /* Arrange */
        Double discountFactor = 0.80;
        Product product = productRepository.findById(1L);
        /* Act */
        Product result = driver.calculate(product, discountFactor);
        /* Assert */
        assertThat(result.getPrice(), is(80.00));

    }

}
