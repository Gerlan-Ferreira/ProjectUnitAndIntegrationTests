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

        @Test
        @DisplayName("E preço do produto é $100 E quantidade de 100 até 999 ENTÃO preço do produto com desconto é $95")
        void whenProductIsPrice100AndClientTypeIsAAndQuantityGreaterEqualsTo100LessThen1000THENProductPrice95 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 100;
            Integer quantityMax = 999;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(95.00));
            assertThat(productMax.getPrice(), is(95.00));
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade maior ou igual a 1000  ENTÃO preço do produto com desconto é $100")
        void whenProductIsPrice100AndClientTypeIsAAndQuantityGreaterEqualsTo1000THENProductPrice100 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 1000;
            Integer quantityMax = 1001;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(100.00));
            assertThat(productMax.getPrice(), is(100.00));
        }

    }
    @Nested
    @DisplayName("Quando o Cliente é do tipo 'B'")
    class ClientTypeB {

        @BeforeEach
        void setup() {
            clientType = "B";
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade de 1 até 99 ENTÃO preço do produto com desconto é $85")
        void whenProductIsPrice100AndClientTypeIsBAndQuantityGreaterEqualsTo1LessThen100THENProductPrice85 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 1;
            Integer quantityMax = 99;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(85.00));
            assertThat(productMax.getPrice(), is(85.00));
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade de 100 até 999 ENTÃO preço do produto com desconto é $90")
        void whenProductIsPrice100AndClientTypeIsBAndQuantityGreaterEqualsTo100LessThen1000THENProductPrice90 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 100;
            Integer quantityMax = 999;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(90.00));
            assertThat(productMax.getPrice(), is(90.00));
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade maior ou igual a 1000  ENTÃO preço do produto com desconto é $95")
        void whenProductIsPrice100AndClientTypeIsBAndQuantityGreaterEqualsTo1000THENProductPrice95 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 1000;
            Integer quantityMax = 1001;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(95.00));
            assertThat(productMax.getPrice(), is(95.00));
        }


    }

    @Nested
    @DisplayName("Quando o Cliente é do tipo 'C'")
    class ClientTypeC {

        @BeforeEach
        void setup() {
            clientType = "C";
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade de 1 até 99 ENTÃO preço do produto com desconto é $80")
        void whenProductIsPrice100AndClientTypeIsCAndQuantityGreaterEqualsTo1LessThen100THENProductPrice80 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 1;
            Integer quantityMax = 99;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(80.00));
            assertThat(productMax.getPrice(), is(80.00));
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade de 100 até 999 ENTÃO preço do produto com desconto é $85")
        void whenProductIsPrice100AndClientTypeIsCAndQuantityGreaterEqualsTo100LessThen1000THENProductPrice85 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 100;
            Integer quantityMax = 999;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(85.00));
            assertThat(productMax.getPrice(), is(85.00));
        }

        @Test
        @DisplayName("E preço do produto é $100 E quantidade maior ou igual a 1000  ENTÃO preço do produto com desconto é $90")
        void whenProductIsPrice100AndClientTypeIsCAndQuantityGreaterEqualsTo1000THENProductPrice90 () {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantityMin = 1000;
            Integer quantityMax = 1001;
            /* Act */
            Product productMin = driver.getProductWithDiscount(1L, clientType, quantityMin);
            Product productMax = driver.getProductWithDiscount(2L, clientType, quantityMax);
            /* Assert */
            assertThat(productMin.getPrice(), is(90.00));
            assertThat(productMax.getPrice(), is(90.00));
        }


    }
}
