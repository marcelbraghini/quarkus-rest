package br.com.marcelbraghini.quarkusrest.endpoint;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testGet() {
        given()
                .when().get("/users")
                .then()
                .statusCode(200)
                .body("$.size()", is(1));
    }

}