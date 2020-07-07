package br.com.marcelbraghini.quarkusrest.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGenerateKey() {
        final User user = new User("crazydog",
                "Crazy Dog",
                "https://google.com.br",
                "Chapecó-SC-Brasil",
                "Desenvolvedor Full Stack");

        assertEquals("XxcrazydogxCrazyDogxX", user.generateKey());
    }

}
