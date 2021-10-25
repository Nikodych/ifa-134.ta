package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageModal extends BasePage {

    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement loginButton;
    private WebElement sideUserMenu;
    private WebElement userEmail;
    private WebElement exitButton;

    public LoginPageModal(WebDriver driver) {
        super(driver);
    }

   public WebElement getEmailField() {
        emailInput = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("auth_email")));

        return emailInput;
    }

    public WebElement getPasswordField() {
        passwordInput = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("auth_pass")));

        return passwordInput;
    }

    public WebElement getLoginButton() {
        loginButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']")));

        return loginButton;
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public WebElement getSideUserMenu() {
        sideUserMenu = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='header__button']")));

        return sideUserMenu;
    }

    public void clickSideUserMenu() {
        getSideUserMenu().click();
    }

    public String getUserEmailTitle() {
        userEmail = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='side-menu__auth-caption']")));
        String userEmailText = userEmail.getText();

        return userEmailText;
    }

    public WebElement getExitButton() {
        exitButton = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='side-menu__item side-menu__item--bordered-bottom ng-tns-c5-0 ng-star-inserted']")));

        return exitButton;
    }

    public void clickExitButton() {
        getExitButton().click();
    }

    //functional
    public void fillEmailField(String text) {

        getEmailField().clear();
        getEmailField().sendKeys(text);
    }

    public void fillPasswordField(String text) {
        getPasswordField().click();
        getPasswordField().clear();
        getPasswordField().sendKeys(text);
    }
}
