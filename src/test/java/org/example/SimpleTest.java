package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/b3b98b66db2f44708ada38b4fec751da";
    }

    @Test
    public void userShouldBeAbleToCreateAUnicornEntity(){
        // Создание сущности Unicorn
        String id =given()
                .body("{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Blue\" \n" + "}")
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
        .extract()
                .path("_id");
        // Проверка того, что она создалась
        given()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void userShouldBeAbleDeleteExistingUnicorn(){
        // Создание сущности Unicorn
        String id =given()
                .body("{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Blue\" \n" + "}")
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
        .extract()
                .path("_id");
        // Удаление
        given().delete("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        // Проверка того, что она удалилась
        given()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
    @Test
    public void TheUserShouldBeFbleToChangeTheTailColorOfAnExistingUnicorn(){
        // Создание сущности Unicorn
        String id =given()
                .body("{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Blue\" \n" + "}")
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract()
                .path("_id");
        // Замена цвета хвоста
        given()
                .body("{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Gren\" \n" + "}")
                .contentType(ContentType.JSON)
                .put("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
        // Проверка того, что цвет поменялась
        given()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
