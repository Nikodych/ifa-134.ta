package com.softserveinc.ita.dkrutenko.pageobjects.softserve;

import com.softserveinc.ita.dkrutenko.pageobjects.softserve.usermodel.User;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.*;

public class ContactUsPage extends MainPage {

    private final String firstNameFieldSelector = "//*[@id = 'firstName']";
    private final String lastNameFieldSelector = "//*[@id = 'lastName']";
    private final String emailFieldSelector = "//*[@id = 'email']";
    private final String companyFieldSelector = "//*[@id = 'company']";
    private final String phoneNumberFieldSelector = "//*[@id = 'phoneNumber']";
    private final String messageFieldSelector = "//*[@id = 'message']";
    private final String selectFormModalMenuSelector = "//*[@id = 'typeOfInquiry']";
    private final String formModalMenuButtonSelector = "//select[@class='form-input__select']";
    private final String acceptTermsAndConditionsSelector = "//input[@name='isTermsAccepted']/ancestor::label";
    private final String acceptUpdatesAndOffersSelector = "//input[@name='isUpdatedOffersAccepted']/ancestor::label";

    public void fillContactPageFields(User user) {
        var firstName = $x(firstNameFieldSelector);
        firstName.click();
        firstName.sendKeys(user.getFirstname());

        var lastName = $x(lastNameFieldSelector);
        lastName.click();
        lastName.sendKeys(user.getLastname());

        var email = $x(emailFieldSelector);
        email.click();
        email.sendKeys(user.getEmail());

        var company = $x(companyFieldSelector);
        company.click();
        company.sendKeys(user.getCompany());

        var phoneNumber = $x(phoneNumberFieldSelector);
        phoneNumber.click();
        phoneNumber.sendKeys(user.getPhone());

        var message = $x(messageFieldSelector);
        message.click();
        message.sendKeys(user.getMessage());
    }

    public String getAttributeFromEmailField() {
        return $x(emailFieldSelector).getAttribute("value").trim();
    }

    public void clickFormInputModalMenu() {
        $x(formModalMenuButtonSelector).click();
    }

    public void selectFormInputModalMenu(String text) {
        var selectForm = $x(selectFormModalMenuSelector);
        var value = new Select(selectForm);
        value.selectByValue(text);
        selectForm.click();
    }

    public void clickAcceptTermsAndPolicyCheckbox() {
        $x(acceptTermsAndConditionsSelector).sendKeys(SPACE);
    }

    public void clickAcceptUpdatesAndOffersCheckbox() {
        $x(acceptUpdatesAndOffersSelector).sendKeys(SPACE);
    }
}
