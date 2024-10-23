package org.example.ui.datas;

import com.codeborne.selenide.Selectors;
import lombok.Builder;
import lombok.Data;

import static com.codeborne.selenide.Selenide.element;

@Data
@Builder
public class BankAccount {
    private String firstName;
    private String lastName;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String zipCode;
    private String phoneNumber;
    private String ssn;
    private String username;
    private String password;
    private String repeatedPassword;
}
