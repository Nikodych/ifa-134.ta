package com.softserveinc.ita.dkrutenko.pageobjects.softserve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$x;
import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$$x;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.By.*;

public class ContactUsPage extends BasePage {
    private final By firstNameSelector = id("firstName");
    private final By lastNameSelector = id("lastName");
    private final By emailSelector = id("email");
    private final By companySelector = id("company");
    private final By phoneNumberSelector = id("phoneNumber");
    private final By messageSelector = id("message");
    private final By formHelpSelector = xpath("//select[@class='form-input__select']");
    private final By formBoxSelector = xpath("//div[@class='form-input']");
    private final By selectHelpFormSelector = id("typeOfInquiry");
    private final By acceptTermsAndUpdatesSelector = xpath("//div[@class='form-input__checkbox-label']");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public String emailField() {
        return $x(emailSelector).getAttribute("value").trim();
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

    public void clickFormButton() {
        $x(formHelpSelector).click();
    }

    public void clickSelectForm(String text) {
        var selectForm = $x(selectHelpFormSelector);
        Select value = new Select(selectForm);
        value.selectByValue(text);
        selectForm.click();
    }

  /*  public void clickAcceptTermsAndPolicy() {
        var eng = "I have read and accepted";
        var ukr = "Я ознайомився";
        var de = "Ich habe";
        var selector = $x(acceptTermsAndUpdatesSelector);
        var termsAccept = selector.getText();
        if (termsAccept.contains(eng) || termsAccept.contains(ukr) || termsAccept.contains(de)) {
            selector.click();
        }if (selector.isSelected()) {
            System.out.println("selected");
        }else{
            System.out.println("not selected");
        }
    }

   */

    public void clickUpdateOnLatestProducts() {
        var eng = "I would like to be updated on latest products";
        var ukr = "Я хочу отримувати повідомлення про найновіші продукти";
        var de = "Ich möchte Informationen über aktuelle Produkte";
        var selector = $x(partialLinkText("*"));
        var acceptUpdates = selector.getText();
        if (acceptUpdates.contains(eng) || acceptUpdates.contains(ukr) || acceptUpdates.contains(de)) {
            selector.click();
        }if (selector.isSelected()) {
            System.out.println("selected");
        }else{
            System.out.println("not selected");
        }
    }
}
