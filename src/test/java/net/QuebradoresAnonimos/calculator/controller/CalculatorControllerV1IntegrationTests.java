package net.QuebradoresAnonimos.calculator.controller;

import net.QuebradoresAnonimos.calculator.model.Product;
import net.QuebradoresAnonimos.calculator.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@DisplayName("MOCK: Testes do Controlador de Cálculo do Desconto no Preço do Produto")
public class CalculatorControllerV1IntegrationTests {
    @Autowired
    CalculatorControllerV1 driver;

    @MockBean
    ProductRepository productRepository;

    String clientType;

    @BeforeEach
    void setup() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(new Product(1L, 100.00)));
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.of(new Product(2L, 100.00)));
    }

    @Nested
    @DisplayName("Quando o Cliente é do tipo 'A'")
    class ClientTypeA {

        @BeforeEach
        void setup() {
            clientType = "A";
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade de 1 até 99 ENTÃO preço do produto com desconto é $90")
        void whenProductIsPrice100AndClientTypeIsAAndQuantityGreaterEqualsTo1LessThen100THENProductPrice90 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 1;
            Integer quantityMax = 99;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(90.00));
            assertThat(productMax.getPrice(), is(90.00));
        }

    }
}
