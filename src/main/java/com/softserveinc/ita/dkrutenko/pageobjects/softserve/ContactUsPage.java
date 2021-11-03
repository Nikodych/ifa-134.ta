package com.softserveinc.ita.dkrutenko.pageobjects.softserve;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.*;

public class ContactUsPage extends BasePage {
    private final By firstNameSelector = id("firstName");
    private final By lastNameSelector = id("lastName");
    private final By emailSelector = id("email");
    private final By companySelector = id("company");
    private final By phoneNumberSelector = id("phoneNumber");
    private final By messageSelector = id("message");
    private final By clickFormModalMenuButton = xpath("//select[@class='form-input__select']");
    private final By selectFromModalMenu = id("typeOfInquiry");
    private final By acceptTermsAndUpdatesSelector = xpath("//input[@name='isTermsAccepted']/ancestor::label");
    private final By acceptUpdatesOfferSelector = xpath("//input[@name='isUpdatedOffersAccepted']/ancestor::label");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactPageFields(String firstNameText, String lastNameText, String emailText,
                                      String companyText, String phoneNumberText, String messageText) {
        var firstName = $x(firstNameSelector);
        firstName.click();
        firstName.sendKeys(firstNameText);

        var lastName = $x(lastNameSelector);
        lastName.click();
        lastName.sendKeys(lastNameText);

        var email = $x(emailSelector);
        email.click();
        email.sendKeys(emailText);

        var company = $x(companySelector);
        company.click();
        company.sendKeys(companyText);

        var phoneNumber = $x(phoneNumberSelector);
        phoneNumber.click();
        phoneNumber.sendKeys(phoneNumberText);

        var message = $x(messageSelector);
        message.click();
        message.sendKeys(messageText);
    }

    public String emailField() {
        return $x(emailSelector).getAttribute("value").trim();
    }

    public void clickFormModalMenuButton() {
        $x(clickFormModalMenuButton).click();
    }

    public void selectFromModalMenu(String text) {
        var selectForm = $x(selectFromModalMenu);
        Select value = new Select(selectForm);
        value.selectByValue(text);
        selectForm.click();
    }

    public void clickAcceptTermsAndPolicy() {
        $x(acceptTermsAndUpdatesSelector).sendKeys(Keys.SPACE);
    }

    public void clickUpdateOnLatestProducts() {
        $x(acceptUpdatesOfferSelector).sendKeys(Keys.SPACE);
    }
}