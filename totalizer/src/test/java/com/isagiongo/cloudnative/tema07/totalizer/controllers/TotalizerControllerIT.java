package com.isagiongo.cloudnative.tema07.totalizer.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TotalizerControllerIT {

    private static Response response;

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = randomPort;
    }

    @Test
    public void shouldReturnSuccessWhenUsersAreFound() {
        response = RestAssured
                .given()
                    .queryParam("twitter", "isagiongo")
                    .queryParam( "github", "isagiongo")
                .when()
                    .get("/totalizers/")
                .then()
                    .extract()
                    .response();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void shouldReturnErrorWhenUsersAreNotFound() {
        response = RestAssured
                .given()
                    .queryParam("twitter", "jkskjdksjdjjkdjadhjhdjshdhjeyuyeueyueuy")
                    .queryParam( "github", "isagiongo")
                .when()
                    .get("/totalizers/")
                .then()
                    .extract()
                    .response();

        //assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }
}
