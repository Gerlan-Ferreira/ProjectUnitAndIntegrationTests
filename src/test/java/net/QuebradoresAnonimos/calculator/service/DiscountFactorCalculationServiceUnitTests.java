package net.QuebradoresAnonimos.calculator.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@DisplayName("Testes do Serviço de Cálculo do Fator de Desconto")
public class DiscountFactorCalculationServiceUnitTests {
    /* Arrange */
    String clientType;
    Integer quantityMin;
    Integer quantityMax;
    @Autowired
    DiscountFactorCalculatorService driver;
    @Nested
    @DisplayName("Quando o cliente é do tipo A")
    class ClientTypeA{

        @BeforeEach
        public void setup(){
            clientType="A";
        }


        @Test
        @DisplayName("E Quantidade entre 1 e 99 ENTÃO o desconto é 10%")
        public void whenClientAQuantityLessThen100ThenDiscount10Percent(){
            //AAA Pattern => Arrange, then Act, finally Assert


            quantityMin=1;
            quantityMax=99;

            /* Act */

            Double resultMin = driver.calculate(clientType, quantityMin);
            Double resultMax = driver.calculate(clientType, quantityMax);

            /* Assert */

            assertThat(resultMin, is( 0.90));
            assertThat(resultMax,is( 0.90));

        }

        @Test
        @DisplayName("E Quantidade entre 100 e 999 ENTÃO o desconto é 5%")
        public void whenClientAQuantityGreater100AndQuantityLower1000THENDiscount5Percent(){
            quantityMin = 100;
            quantityMax = 999;

            Double resultMin = driver.calculate(clientType, quantityMin);
            Double resultMax = driver.calculate(clientType, quantityMax);

            assertThat(resultMin, is(0.95));
            assertThat(resultMax, is(0.95));
        }

        @Test
        @DisplayName("E Quantidade maior ou igual a 1000 ENTAO Desconto é 0%")
        public void whenClientTypeAQuantityGreaterEqual1000THENDiscount0Percent(){
            quantityMin = 1000;

            Double resultMin = driver.calculate(clientType, quantityMin);

            assertThat(resultMin, is(1.0));
        }
    }

    @Nested
    @DisplayName("Quando o cliente é do tipo B")
    class ClientTypeB{

        @BeforeEach
        public void setup(){
            clientType="B";
        }


        @Test
        @DisplayName("E Quantidade entre 1 e 99 ENTÃO o desconto é 15%")
        public void whenClientAQuantityLessThen100ThenDiscount10Percent(){
            //AAA Pattern => Arrange, then Act, finally Assert


            quantityMin=1;
            quantityMax=99;

            /* Act */

            Double resultMin = driver.calculate(clientType, quantityMin);
            Double resultMax = driver.calculate(clientType, quantityMax);

            /* Assert */

            assertThat(resultMin, is( 0.85));
            assertThat(resultMax,is( 0.85));

        }

        @Test
        @DisplayName("E Quantidade entre 100 e 999 ENTÃO o desconto é 10%")
        public void whenClientAQuantityGreater100AndQuantityLower1000THENDiscount5Percent(){
            quantityMin = 100;
            quantityMax = 999;

            Double resultMin = driver.calculate(clientType, quantityMin);
            Double resultMax = driver.calculate(clientType, quantityMax);

            assertThat(resultMin, is(0.90));
            assertThat(resultMax, is(0.90));
        }

        @Test
        @DisplayName("E Quantidade maior ou igual a 1000 ENTAO desconto é 5%")
        public void whenClientTypeAQuantityGreaterEqual1000THENDiscount0Percent(){
            quantityMin = 1000;

            Double resultMin = driver.calculate(clientType, quantityMin);

            assertThat(resultMin, is(0.95));
        }
    }

    @Nested
    @DisplayName("Quando o cliente é do tipo C")
    class ClientTypeC{

        @BeforeEach
        public void setup(){
            clientType="C";
        }


        @Test
        @DisplayName("E Quantidade entre 1 e 99 ENTÃO o desconto é 20 %")
        public void whenClientAQuantityLessThen100ThenDiscount10Percent(){
            //AAA Pattern => Arrange, then Act, finally Assert


            quantityMin=1;
            quantityMax=99;

            /* Act */

            Double resultMin = driver.calculate(clientType, quantityMin);
            Double resultMax = driver.calculate(clientType, quantityMax);

            /* Assert */

            assertThat(resultMin, is( 0.80));
            assertThat(resultMax,is( 0.80));

        }

        @Test
        @DisplayName("E Quantidade entre 100 e 999 ENTÃO o desconto é 15%")
        public void whenClientAQuantityGreater100AndQuantityLower1000THENDiscount5Percent(){
            quantityMin = 100;
            quantityMax = 999;

            Double resultMin = driver.calculate(clientType, quantityMin);
            Double resultMax = driver.calculate(clientType, quantityMax);

            assertThat(resultMin, is(0.85));
            assertThat(resultMax, is(0.85));
        }

        @Test
        @DisplayName("E Quantidade maior ou igual a 1000 ENTAO desconto é 10%")
        public void whenClientTypeAQuantityGreaterEqual1000THENDiscount0Percent(){
            quantityMin = 1000;

            Double resultMin = driver.calculate(clientType, quantityMin);

            assertThat(resultMin, is(0.90));
        }
    }

    @AfterEach
    public void tearDown(){
        clientType=null;
    }

}
