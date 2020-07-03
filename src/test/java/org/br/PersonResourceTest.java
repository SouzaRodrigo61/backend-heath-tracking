package org.br;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PersonResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/person")
          .then()
             .statusCode(200);
    }

}