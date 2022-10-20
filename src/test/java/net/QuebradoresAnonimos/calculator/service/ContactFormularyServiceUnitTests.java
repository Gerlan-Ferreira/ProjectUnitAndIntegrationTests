package net.QuebradoresAnonimos.calculator.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@DisplayName("Testes do Serviço de Formulario de Contato")
public class ContactFormularyServiceUnitTests {
    /*Arrange*/

    String name;
    String email;
    String typeMessage;
    Integer age;
    String writeHereYourMessage;

    @Autowired
    ContactFormularyService driver;

    @Nested
    @DisplayName("Mensagem de Sucesso")
    class SuccessMessage{

        @BeforeEach
        public void Setup(){
            name = "QuebradoresAnonimos";
            email = "quebradores@bing.com.br";
            writeHereYourMessage = "Lets find bugs!";
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo DUVIDA e a idade é menor que 18 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsDuvidaAndAgeLessThan18THENSuccessMessage(){

            typeMessage= "Dúvida";
            age = 17;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo DUVIDA e a idade é maior ou igual a 18 anos e menor ou igual a 60 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsDuvidaAndAgeBetween18And60THENSuccessMessage(){
            typeMessage = "Dúvida";
            age = 55;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo DUVIDA e a idade é maior que 60 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsDuvidaAndAgeAbove60THENSuccessMessage(){
            typeMessage = "Dúvida";
            age = 72;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo SUGESTAO e a idade é menor que 18 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsSugestaoAndAgeLessThan18THENSuccessMessage(){
            typeMessage = "Sugestão";
            age = 10;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo SUGESTAO e a idade é maior ou igual a 18 anos e menor ou igual a 60 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsSugestaoAndAgeBetween18And60THENSuccessMessage(){
            typeMessage = "Sugestão";
            age = 39;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo SUGESTAO e a idade é maior que 60 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsSugestaoAndAgeAbove60THENSuccessMessage(){
            typeMessage = "Sugestão";
            age = 77;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo RECLAMACAO e a idade é menor que 18 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsReclamacaoAndAgeLessThan18THENSuccessMessage(){
            typeMessage = "Reclamação";
            age = 13;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo RECLAMACAO e a idade é maior ou igual a 18 anos e menor ou igual a 60 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsReclamacaoAndAgeBetween18And60THENSuccessMessage(){
            typeMessage = "Reclamação";
            age = 33;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }

        @Test
        @DisplayName("Quando a mensagem é do tipo RECLAMACAO e a idade é maior que 60 anos ENTAO Mensagem Enviada Com Sucesso!")
        public void whenMessageTypeIsReclamacaoAndAgeAbove60THENSuccessMessage(){
            typeMessage = "Reclamação";
            age = 89;

            String message = driver.returnMessage(name,email,age,typeMessage,writeHereYourMessage);

            assertThat(message, is("Mensagem enviada com sucesso!"));
        }



        @AfterEach
        public void tearDown(){
            typeMessage = null;
            age = null;
        }

    }

    @Nested
    @DisplayName("Mensagem de Falha")
    class FailMessage{

        @BeforeEach
        public void Setup(){
            age = 15;
        }

        @Test
        @DisplayName("Quando o campo NOME estiver vazio, e email, tipo de mensagem e escreva aqui sua mensagem preenchidos ENTAO Sua mensagem não pôde ser enviada no momento! Tente mais tarde.")
        public void whenFieldNameIsEmptyAndFieldsEmailTypeMessageAndWriteHereYourMessageFilledTHENSuaMensagemNaoPodeSerEnviadaNoMomentoTenteMaisTarde(){
            name = "";
            email = "quebradores@bing.com.br";
            writeHereYourMessage = "Lets find bugs!";
            typeMessage = "Dúvida";

            String message = driver.returnMessage(name,email, age,writeHereYourMessage,typeMessage);

            assertThat(message, is("Sua mensagem não pôde ser enviada no momento! Tente mais tarde."));
        }

        @Test
        @DisplayName("Quando o campo EMAIL estiver vazio, e nome, tipo de mensagem e escreva aqui sua mensagem preenchidos ENTAO Sua mensagem não pôde ser enviada no momento! Tente mais tarde.")
        public void whenFieldEmailIsEmptyAndFieldsNameTypeMessageAndWriteHereYourMessageFilledTHENSuaMensagemNaoPodeSerEnviadaNoMomentoTenteMaisTarde(){
            name = "QuebradoresAnonimos";
            email = "";
            writeHereYourMessage = "Lets find bugs!";
            typeMessage = "Dúvida";

            String message = driver.returnMessage(name,email, age,writeHereYourMessage,typeMessage);

            assertThat(message, is("Sua mensagem não pôde ser enviada no momento! Tente mais tarde."));
        }

        @Test
        @DisplayName("Quando o campo TIPO DE MENSAGEM estiver vazio, e nome, email e escreva aqui sua mensagem preenchidos ENTAO Sua mensagem não pôde ser enviada no momento! Tente mais tarde.")
        public void whenFieldTypeMessageIsEmptyAndFieldsNameEmailAndWriteHereYourMessageFilledTHENSuaMensagemNaoPodeSerEnviadaNoMomentoTenteMaisTarde(){
            name = "QuebradoresAnonimos";
            email = "quebradores@bing.com.br";
            typeMessage = "";
            writeHereYourMessage = "Lets find bugs!";

            String message = driver.returnMessage(name,email, age,writeHereYourMessage,typeMessage);

            assertThat(message, is("Sua mensagem não pôde ser enviada no momento! Tente mais tarde."));
        }

        @Test
        @DisplayName("Quando o campo ESCREVA AQUI SUA MENSAGEM estiver vazio, e nome, email e tipo de mensagem preenchidos ENTAO Sua mensagem não pôde ser enviada no momento! Tente mais tarde.")
        public void whenFieldWriteHereYourMessageIsEmptyAndFieldsNameEmailAndWriteHereYourMessageFilledTHENSuaMensagemNaoPodeSerEnviadaNoMomentoTenteMaisTarde(){
            name = "QuebradoresAnonimos";
            email = "quebradores@bing.com.br";
            typeMessage = "Dúvida";
            writeHereYourMessage = "";


            String message = driver.returnMessage(name,email, age,writeHereYourMessage,typeMessage);

            assertThat(message, is("Sua mensagem não pôde ser enviada no momento! Tente mais tarde."));
        }

    }



}
