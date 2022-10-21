package net.QuebradoresAnonimos.calculator;

import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
class CalculatorApplicationBaseTests {

    public static String readFileFromResources(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(file).toURI())));
    }


}
