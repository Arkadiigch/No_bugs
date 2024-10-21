package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/260345913c4d4f85acc92e1a7ad6fe9d";
    }

    @Test
    public void userShouldBeAbleToCreateAUnicornEntity(){
        // Создание сущности Unicorn
        String id = UnicornRequests.createUnicorn("{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Blue\" \n" + "}");
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
        String id = UnicornRequests.createUnicorn("{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Blue\" \n" + "}");
        // Удаление
        UnicornRequests.deleteUnicorn(id);
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
        String id = UnicornRequests.createUnicorn("{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Blue\" \n" + "}");
        // Замена цвета хвоста
        UnicornRequests.updateUnicorn(id,"{\n" + "  \"name\": \"Rainbow\",\n" + "  \"tailColor\": \"Green\" \n" + "}");
        // Проверка того, что цвет поменялась
        given()
                .get("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
