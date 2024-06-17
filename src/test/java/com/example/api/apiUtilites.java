package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class apiUtilites {

    private static final String BASE_URI = "https://restful-booker.herokuapp.com";

    static {
        RestAssured.baseURI = BASE_URI;
    }

    public static Response get(String endpoint) {
        return given()
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint, String body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response put(String endpoint, String body ) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    public static Response delete(String endpoint) {
        return given()
                .when()
                .delete(endpoint);
    }

    public static RequestSpecification request() {
        return given().baseUri(BASE_URI);
    }
}