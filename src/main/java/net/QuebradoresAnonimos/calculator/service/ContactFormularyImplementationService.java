package net.QuebradoresAnonimos.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class ContactFormularyImplementationService implements ContactFormularyService {

    @Override
    public String returnMessage(String name, String email, Integer age, String typeMessage, String writeHereYourMessage) {

        if ((name != "") && (email != "") && (writeHereYourMessage!="")){
            switch (typeMessage){

                case "Dúvida":
                case "Sugestão":
                case "Reclamação":
                    if ((age >= 1) && (age < 18)){

                        return "Mensagem enviada com sucesso!";

                    } else if ((age >= 18) && (age <= 60) ) {

                        return "Mensagem enviada com sucesso!";

                    } else if (age > 60) {

                        return "Mensagem enviada com sucesso!";
                    }

                    break;
            }
        }

        return "Sua mensagem não pôde ser enviada no momento! Tente mais tarde.";

    }
}
