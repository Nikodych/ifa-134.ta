package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class LoginPageModal extends BasePage {

    private final By emailInputSelector = id("auth_email");
    private final By passwordInputSelector = id("auth_pass");
    private final By loginButtonSelector = xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");
    private final By sideUserMenuButtonSelector = xpath("//button[@class='header__button']");
    private final By userEmailTitleSelector = xpath("//p[@class='side-menu__auth-caption']");
    private final By exitButtonSelector = xpath("//button[@class='button button--large side-menu__button']");

    public LoginPageModal(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        waitForElementVisibility(loginButtonSelector).click();
    }

    public void clickSideUserMenu() {
        waitForClickabelElement(sideUserMenuButtonSelector).click();
    }

    public String getUserEmailTitle() {
        return waitForElementVisibility(userEmailTitleSelector).getText();
    }

    public void clickExitButton() {
        waitForClickabelElement(exitButtonSelector).click();
    }

    public void fillEmailField(String text) {
        waitForClickabelElement(emailInputSelector).click();
        waitForClickabelElement(emailInputSelector).clear();
        waitForClickabelElement(emailInputSelector).sendKeys(text);
    }

    public void fillPasswordField(String text) {
        waitForClickabelElement(passwordInputSelector).click();
        waitForClickabelElement(passwordInputSelector).clear();
        waitForClickabelElement(passwordInputSelector).sendKeys(text);
    }
}
