package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageModal extends BasePage {

    private By emailInput = By.id("auth_email");
    private By passwordInput = By.id("auth_pass");
    private By loginButton = By.xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");
    private By sideUserMenu = By.xpath("//button[@class='header__button']");
    private By userEmail = By.xpath("//p[@class='side-menu__auth-caption']");
    private By exitButton = By.xpath("//button[@class='button button--large side-menu__button']");

    public LoginPageModal(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }

    public void clickSideUserMenu() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.elementToBeClickable(sideUserMenu)).click();
    }

    public String getUserEmailTitle() {
        waitElementCondition();
        String emailTitle = driverWait.until(ExpectedConditions.visibilityOfElementLocated(userEmail)).getText();

        return emailTitle;
    }

    public void clickExitButton() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.elementToBeClickable(exitButton)).click();
    }

    public void fillEmailField(String text) {
        waitElementCondition();
        driverWait.until(ExpectedConditions.elementToBeClickable(emailInput)).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(emailInput)).clear();
        driverWait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(text);
    }

    public void fillPasswordField(String text) {
        waitElementCondition();
        driverWait.until(ExpectedConditions.elementToBeClickable(passwordInput)).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(passwordInput)).clear();
        driverWait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(text);
    }
}
