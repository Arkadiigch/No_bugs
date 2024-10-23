package org.example;

import com.codeborne.selenide.*;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {
    public static void setupUiTests(){
        Configuration.baseUrl = "https://parabank.parasoft.com";
    }

    // Успешный тест регистрации
    @Test
    public void aUserCanRegister(){
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        RegisterAccountPage.open();

        // Подготовка данных
        String password = RandomData.generatePassword();
        String generatedUsername = RandomData.randomString();
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .addressStreet(RandomData.randomString())
                .addressCity(RandomData.randomString())
                .addressState(RandomData.randomString())
                .zipCode(RandomData.randomInt())
                .phoneNumber(RandomData.randomInt())
                .ssn(RandomData.randomString())
                .username(generatedUsername)
                .password(password)
                .repeatedPassword(password)
                .build();

        // Шаги
        registerAccountPage.register(bankAccount);

        // Проверка
        SelenideElement titleHi = element(Selectors.byClassName("title"));
        titleHi.shouldHave(Condition.exactText("Welcome " + generatedUsername));
    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly(){
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        RegisterAccountPage.open();
        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString()).lastName(RandomData.randomString())
                .build();
        // Шаги
        registerAccountPage.register(bankAccount);
        // Проверка ожидаемого
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
    }
}
