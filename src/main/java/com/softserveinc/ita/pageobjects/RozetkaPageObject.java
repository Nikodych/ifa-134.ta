package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public abstract class RozetkaPageObject {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private final Long ONE_SECOND_DELAY = 1000L;

    private WebElement homePage;
    private WebElement userButton;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement sideUserMenu;
    private WebElement userEmail;
    private WebElement exitButton;

    public RozetkaPageObject(WebDriver driver) {
        this.driver = driver;
        webElements();
    }

    private void webElements() {
        homePage = driver.findElement(By.cssSelector("div > a > picture"));
        userButton = driver.findElement(By.xpath("//li[@class='header-actions__item header-actions__item--user']"));
    }

    public WebElement getHomePage() {
        return homePage;
    }

    public void clickHomePage() {
        getHomePage().click();
    }

    public WebElement getUserButton() {
        return userButton;
    }

    public void clickUserButton() {
        getUserButton().click();
    }

    public WebElement getEmailField() {
        emailField = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("auth_email")));

        return emailField;
    }

    public WebElement getPasswordField() {
        passwordField = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("auth_pass")));

        return passwordField;
    }

    public WebElement getLoginButton() {
        loginButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']")));

        return loginButton;
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public WebElement getSideUserMenu() {
        sideUserMenu = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//svg[@class='ng-tns-c5-0']")));

        return sideUserMenu;
    }

    public void clickSideUserMenu() {
        getSideUserMenu().click();
    }

    public String checkUserEmail() {
        userEmail = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='side-menu__auth-caption']")));
        String userEmailField = userEmail.getText();

        return userEmailField;
    }

    public WebElement getExitButton() {
        exitButton = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button--large side-menu__button']")));

    return getExitButton();
    }

    public void clickExitButton() {
        getExitButton().click();
    }
    //ExpectectCondition for elements
    public WebDriverWait waitElementCondition() {
        driverWait = new WebDriverWait(driver,500);

        return driverWait;
    }
    //page load time
    public WebDriverWait pageLoadTimeout() {
       driverWait = new WebDriverWait(driver, 5);
       driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);

       return pageLoadTimeout();
    }
    //implicitly timeout
    public WebDriverWait implicitlyTimeout() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return implicitlyTimeout();
    }

    public void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
