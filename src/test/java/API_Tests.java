import groovy.lang.Singleton;
import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class API_Tests {

    private static RequestSpecification spec;

    @BeforeAll
    static void Specification(){
        RestAssured.baseURI = "https://qa-stand-login.inzhenerka.tech/api";
        spec = given()
                .queryParam("API_KEY", "API_KEY123");
    }



    @ParameterizedTest
    @CsvSource({
            "testuser7",
            "testuser2"
    })
    @Order(1)
    void getUser(String username) {

        spec.when()
                .get("/users/" + username)
                .then()
                .statusCode(200)
                .body("username", equalTo(username));

    }

    @ParameterizedTest
    @CsvSource({
            "testuser8"
    })
    @Order(2)
    void createNewUser(String name) {
        String requestBody = """
    {
        "admin": false,
        "age": 45,
        "description": "Привет! Я - счастливый студент ИнженеркаТех",
        "jobtitle": "Старший Тестировщик",
        "name": "Владимир Тестировович",
        "password": "password123",
        "username": "testuser8"
    }
    """;
        spec
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201);


    }
    @ParameterizedTest
    @CsvSource({
            "testuser8"
    })
    @Order(3)
    void updateUserInfo(String name) {
        String requestBody = """
    {
        "admin": false,
        "age": 45,
        "description": "Привет! Я - счастливый студент ИнженеркаТех и я сегодня изучил REST API",
        "jobtitle": "Стажер Тестировщик",
        "name": "Архипов А.А.",
        "password": "password123",
        "username": "testuser8"
    }
    """;

        spec
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/users/"+name)
                .then()
                .statusCode(200);


    }

    @Order(4)
    @ParameterizedTest()
    @CsvSource({
            "testuser8"
    })
    void deleteUser(String username)
    {
        spec
                .when()
                .delete("/users/"+username)
                .then()
                .statusCode(200);

    }



}
