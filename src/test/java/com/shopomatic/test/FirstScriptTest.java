package com.shopomatic.test;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
public class FirstScriptTest {

    @Test
    public void shouldReturnExpectedProducts() {
        given().auth()
                .basic("test", "user1Pass")
                .when()
                .get("http://localhost:9292/products")
                .then()
                .assertThat()
                .body(Matchers.equalTo("[\"Soccer Ball\",\"Stadium\",\"Thinking Cap\",\"Coffee Cup\"]"))
                .statusCode(200);

    }
}
