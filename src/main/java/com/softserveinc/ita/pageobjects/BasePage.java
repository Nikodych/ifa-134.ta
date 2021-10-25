package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private WebElement userButton;
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement loginButton;
    private WebElement sideUserMenu;
    private WebElement userEmail;
    private WebElement exitButton;
    private By search = By.name("search");
    private By searchButton = By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage getSearch() {
        driver.findElement(search);

        return this;
    }

    public void searchClick() {
        getSearch().click();
    }

    public void searchClear() {
        getSearch().clear();
    }

    public void searchSendKeys(String text) {
        getSearch().sendKeys(text);
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public void clickSearchButton() {
        getSearchButton().click();
    }


    public WebElement getUserButton() {
        userButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//rz-user[@class='header-actions__component']")));

        return userButton;
    }

    public void clickUserButton() {
        getUserButton().click();
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

    public WebDriverWait waitElementCondition() {
        driverWait = new WebDriverWait(driver,500);

        return driverWait;
    }

    public WebDriverWait pageLoadTimeout() {
       driverWait = new WebDriverWait(driver, 5);
       driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);

       return pageLoadTimeout();
    }

    public WebDriverWait implicitlyTimeout() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return implicitlyTimeout();
    }
}
