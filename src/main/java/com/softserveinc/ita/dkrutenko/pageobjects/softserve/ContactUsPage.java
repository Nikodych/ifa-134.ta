package com.softserveinc.ita.dkrutenko.pageobjects.softserve;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.Keys.*;

public class ContactUsPage extends MainPage {

    private final By firstNameFieldSelector = id("firstName");
    private final By lastNameFieldSelector = id("lastName");
    private final By emailFieldSelector = id("email");
    private final By companyFieldSelector = id("company");
    private final By phoneNumberFieldSelector = id("phoneNumber");
    private final By messageFieldSelector = id("message");
    private final By formModalMenuButtonSelector = xpath("//select[@class='form-input__select']");
    private final By selectFormModalMenuSelector = id("typeOfInquiry");
    private final By acceptTermsAndConditionsSelector = xpath("//input[@name='isTermsAccepted']/ancestor::label");
    private final By acceptUpdatesAndOffersSelector = xpath("//input[@name='isUpdatedOffersAccepted']/ancestor::label");

    public void fillContactPageFields(String firstNameText, String lastNameText, String emailText, String companyText,
                                      String phoneNumberText, String messageText) {
        var firstName = $x(firstNameFieldSelector);
        firstName.click();
        firstName.sendKeys(firstNameText);

        var lastName = $x(lastNameFieldSelector);
        lastName.click();
        lastName.sendKeys(lastNameText);

        var email = $x(emailFieldSelector);
        email.click();
        email.sendKeys(emailText);

        var company = $x(companyFieldSelector);
        company.click();
        company.sendKeys(companyText);

        var phoneNumber = $x(phoneNumberFieldSelector);
        phoneNumber.click();
        phoneNumber.sendKeys(phoneNumberText);

        var message = $x(messageFieldSelector);
        message.click();
        message.sendKeys(messageText);
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
