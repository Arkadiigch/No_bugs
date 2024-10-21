package org.example.api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {
    public static void createStudent(String body) {
        given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/student")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"));
    }
}
