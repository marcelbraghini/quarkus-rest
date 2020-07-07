package br.com.marcelbraghini.quarkusrest.service;

import br.com.marcelbraghini.quarkusrest.model.User;
import io.quarkus.test.junit.QuarkusTest;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class UserServiceTest {

    @Inject
    UserService userService;

    @ConfigProperty(name = "quarkus.token")
    String token;

    @Test
    public void testUserSave() {
        final User user = new User("maquinaZ",
                "Maquina Z",
                "https://google.com.br",
                "Chapecó-SC-Brasil",
                "Desenvolvedor Front-End");
        assertNotNull(userService.save(user));
    }

    @Test
    public void testUserAll() {
        assertNotNull(userService.getAll());
    }

    @Test
    public void testFindAndDelete() {
        final User user = userService.save(new User("crazydog",
                "Crazy Dog",
                "https://google.com.br",
                "Chapecó-SC-Brasil",
                "Desenvolvedor Full Stack"));

        final User userSaved = userService.findById(user.get_id());
        assertEquals("Crazy Dog", userSaved.getName());

        userService.remove(userSaved.get_id().toHexString());
        assertNull(userService.findByName("Crazy Dog"));
        assertNull(userService.findByLogin("crazydog"));
    }

    @Test
    public void testToken() {
        assertEquals("kasdhasdhuyasGDUGASgduAGSDGASHDGJAHSD", token);
    }

}
