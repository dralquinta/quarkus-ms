package com.dralquinta.microservice.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class SomethingResourceTest {
    @Test
    void testGetSomethingEndpoint() {
        given()
                .when().get("/api/v1/something")
                .then()
                .statusCode(200)
                .body("message", is("mock-something"))
                .body("source", is("mock-postgresql"));
    }

}
