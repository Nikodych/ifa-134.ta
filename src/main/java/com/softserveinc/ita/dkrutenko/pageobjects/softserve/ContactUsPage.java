package com.softserveinc.ita.dkrutenko.pageobjects.softserve;

import com.softserveinc.ita.dkrutenko.pageobjects.softserve.models.User;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$x;
import com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil;

import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.*;
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

        setText(firstNameFieldSelector, user.getFirstname());
        setText(lastNameFieldSelector, user.getLastname());
        setText(emailFieldSelector, user.getEmail());
        setText(companyFieldSelector, user.getCompany());
        setText(phoneNumberFieldSelector, user.getPhone());
        setText(messageFieldSelector, user.getMessage());
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
