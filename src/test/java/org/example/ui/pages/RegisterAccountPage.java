package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;
@Getter
public class RegisterAccountPage {
    // Элементы Страницы
    SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    SelenideElement addressStreetInput = element(Selectors.byId("customer.address.street"));

    SelenideElement addressCityInput = element(Selectors.byId("customer.address.city"));

    SelenideElement addressStateInput = element(Selectors.byId("customer.address.state"));

    SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));

    SelenideElement phoneNumberInput = element(Selectors.byId("customer.phoneNumber"));

    SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));

    SelenideElement usernameInput = element(Selectors.byId("customer.username"));

    SelenideElement passwordInput = element(Selectors.byId("customer.password"));

    SelenideElement repeatedPasswordInput = element(Selectors.byId("repeatedPassword"));

    SelenideElement registerButton = element(Selectors.byValue("Register"));

    // Ошибки
    SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    public static void open(){
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        addressStreetInput.sendKeys(bankAccount.getAddressStreet());
        addressCityInput.sendKeys(bankAccount.getAddressCity());
        addressStateInput.sendKeys(bankAccount.getAddressState());
        zipCodeInput.sendKeys(bankAccount.getZipCode());
        phoneNumberInput.sendKeys(bankAccount.getPhoneNumber());
        ssnInput.sendKeys(bankAccount.getSsn());
        usernameInput.sendKeys(bankAccount.getUsername());
        passwordInput.sendKeys(bankAccount.getPassword());
        repeatedPasswordInput.sendKeys(bankAccount.getRepeatedPassword());

        registerButton.click();
    }
}
