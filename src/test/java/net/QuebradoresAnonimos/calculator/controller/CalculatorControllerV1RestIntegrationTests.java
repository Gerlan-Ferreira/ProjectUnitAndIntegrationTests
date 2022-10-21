package net.QuebradoresAnonimos.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.QuebradoresAnonimos.calculator.model.Product;
import net.QuebradoresAnonimos.calculator.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("REST INTEGRATION: Testes do Controlador de Cálculo do Desconto no Preço do Produto")
public class CalculatorControllerV1RestIntegrationTests {

    final static String BASE_URI = "/calculatorDiscount/v1";
    final static Long DEFAULT_PRODUCT_ID = 1L;

    @Autowired
    MockMvc driver;
    @Autowired
    ProductRepository productRepository;

    Product productDefault = new Product(DEFAULT_PRODUCT_ID, 100.00);

    String clientType;

    @BeforeEach
    void setup() {
        /* Arrange */
        productDefault = productRepository.save(productDefault);
    }

    @Nested
    @DisplayName("Quando o Cliente é do tipo 'A'")
    class ClientTypeA {

        @BeforeEach
        void setup() {
            clientType = "A";
        }

        @Test
        void whenProductIsPrice100AndClientTypeIsAAndQuantityGreaterEqualsTo1LessThen100THENProductPrice90() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 1;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(90.00));
        }

        @Test
        void whenProductIsPrice100AndClientTypeIsAAndQuantityGreaterEqualsTo100LessThen1000THENProductPrice95() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 100;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(95.00));
        }

        @Test
        void whenProductIsPrice100AndClientTypeIsAAndQuantityGreaterEqualsTo1000THENProductPrice100() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 1000;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(100.00));
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
        void whenProductIsPrice100AndClientTypeIsBAndQuantityGreaterEqualsTo1LessThen100THENProductPrice85() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 1;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(85.00));
        }

        @Test
        void whenProductIsPrice100AndClientTypeIsBAndQuantityGreaterEqualsTo100LessThen1000THENProductPrice90() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 100;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(90.00));
        }

        @Test
        void whenProductIsPrice100AndClientTypeIsBAndQuantityGreaterEqualsTo1000THENProductPrice95() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 1000;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(95.00));
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
        void whenProductIsPrice100AndClientTypeIsCAndQuantityGreaterEqualsTo1LessThen100THENProductPrice80 () throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 1;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(80.00));
        }

        @Test
        void whenProductIsPrice100AndClientTypeIsCAndQuantityGreaterEqualsTo100LessThen1000THENProductPrice85() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 100;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(85.00));
        }

        @Test
        void whenProductIsPrice100AndClientTypeIsCAndQuantityGreaterEqualsTo1000THENProductPrice90() throws Exception {
            // AAA Pattern => Arrange, then Act, finally Assert
            /* Arrange */
            Integer quantity = 1000;

            /* Act */
            String responseJsonString = driver.perform(get(BASE_URI)
                            .param("clientType", clientType)
                            .param("quantity", String.valueOf(quantity))
                            .param("productId", String.valueOf(DEFAULT_PRODUCT_ID))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            Product result = new ObjectMapper().readValue(responseJsonString, Product.class);

            /* Assert */
            assertThat(result.getPrice(), is(90.00));
        }
    }

    @AfterEach
    void tearDown() {
        productRepository.delete(productDefault);
    }
}
