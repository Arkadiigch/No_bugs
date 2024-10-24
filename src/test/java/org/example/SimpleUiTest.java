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
        // Генерация пароля, что бы повторить его потом
        String password = RandomData.generatePassword();
        // Генерация никнейма, для проверки
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

    // Негативные тесты
    // Ввод только имени и фамилии
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly(){
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        RegisterAccountPage.open();
        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .addressStreet("")
                .addressCity("")
                .addressState("")
                .zipCode("")
                .phoneNumber("")
                .ssn("")
                .username("")
                .password("")
                .repeatedPassword("")
                .build();
        // Шаги
        registerAccountPage.register(bankAccount);
        // Проверка ожидаемого
        registerAccountPage.getAddressStreetError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getAddressCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getAddressStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipcodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getConfirmPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    // Ввод только Адреса (3 поля, улица, город, штат)
    @Test
    public void userCanNotCreateAccountWithAddressOnly(){
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        RegisterAccountPage.open();
        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName("")
                .lastName("")
                .addressStreet(RandomData.randomString())
                .addressCity(RandomData.randomString())
                .addressState(RandomData.randomString())
                .zipCode("")
                .phoneNumber("")
                .ssn("")
                .username("")
                .password("")
                .repeatedPassword("")
                .build();
        // Шаги
        registerAccountPage.register(bankAccount);
        // Проверка
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getZipcodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getConfirmPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    // Несовпадение паролей
    @Test
    public void userCannotEnterTheSamePasswords(){
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        RegisterAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .addressStreet(RandomData.randomString())
                .addressCity(RandomData.randomString())
                .addressState(RandomData.randomString())
                .zipCode(RandomData.randomInt())
                .phoneNumber(RandomData.randomInt())
                .ssn(RandomData.randomString())
                .username(RandomData.randomString())
                .password(RandomData.randomString())
                .repeatedPassword(RandomData.randomString())
                .build();

        // Шаги
        registerAccountPage.register(bankAccount);

        // Проверка
        registerAccountPage.getConfirmPasswordError().shouldHave(Condition.exactText("Passwords did not match."));

    }
}
