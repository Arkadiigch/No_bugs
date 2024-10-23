package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/260345913c4d4f85acc92e1a7ad6fe9d";
    }

    @Test
    public void userShouldBeAbleToCreateAUnicornEntity(){
        // Создание сущности Unicorn
        Unicorn unicorn = new Unicorn("Troi","Yellow");
        Unicorn createUnicorn = UnicornRequests.createUnicorn(unicorn);
        // Проверка того, что она создалась
        given()
                .get("/unicorn/" + createUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void userShouldBeAbleDeleteExistingUnicorn(){
        // Создание сущности Unicorn
        Unicorn unicorn = new Unicorn("Pony","Pink");
        Unicorn createUnicorn = UnicornRequests.createUnicorn(unicorn);
        // Удаление
        UnicornRequests.deleteUnicorn(createUnicorn.getId());
        // Проверка того, что она удалилась
        given()
                .get("/unicorn/" + createUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
    @Test
    public void TheUserShouldBeFbleToChangeTheTailColorOfAnExistingUnicorn(){
        // Создание сущности Unicorn
        Unicorn unicorn = new Unicorn("Pony","Pink");
        Unicorn createUnicorn = UnicornRequests.createUnicorn(unicorn);
        // Замена цвета хвоста
        unicorn.setTailColor("Green");
        UnicornRequests.updateUnicorn(createUnicorn.getId(), unicorn);
        // Проверка того, что цвет поменялась
        given()
                .get("/unicorn/" + createUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
