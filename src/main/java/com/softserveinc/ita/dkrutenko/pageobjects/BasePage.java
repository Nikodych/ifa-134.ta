package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage  {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private By search = By.name("search");
    private By searchButton = By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']");
    private By logo = By.cssSelector("div > a > picture");
    private By languageButton = By.xpath("//a[@class='lang__link ng-star-inserted']");
    private By marketName = By.xpath("//p[@class='main-copyright_color_gray']");
    private By userButton = By.xpath("//rz-user[@class='header-actions__component']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
}

    public void searchClick() {
        driver.findElement(search).click();
    }

    public void searchClear() {
        driver.findElement(search).clear();
    }

    public void searchSendKeys(String text) {
        driver.findElement(search).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickLanguageButton() {
        driver.findElement(languageButton).click();
    }

    public String getMarketNameTitle() {
        waitElementCondition();
        String rozetka = driverWait.until(ExpectedConditions.visibilityOfElementLocated(marketName)).getText();

        return rozetka;
    }

    public void clickUserButton() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.elementToBeClickable(userButton)).click();
    }

    public WebDriverWait waitElementCondition() {
        driverWait = new WebDriverWait(driver,500);

        return driverWait;
    }
}
