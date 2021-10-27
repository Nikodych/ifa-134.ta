package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage  {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private final By searchFieldSelector = name("search");
    private final By searchButtonSelector = xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']");
    private final By logoIconSelector = cssSelector("div > a > picture");
    private final By languageButtonSelector = xpath("//a[@class='lang__link ng-star-inserted']");
    private final By marketNameLabelSelector = xpath("//p[@class='main-copyright_color_gray']");
    private final By userButtonSelector = xpath("//rz-user[@class='header-actions__component']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 100);
}

    public void clickSearchField() {
        driver.findElement(searchFieldSelector).click();
    }

    public void clearSearchField() {
        driver.findElement(searchFieldSelector).clear();
    }

    public void sendKeysToSearchField(String text) {
        driver.findElement(searchFieldSelector).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    public void clickLogoIcon() {
        driver.findElement(logoIconSelector).click();
    }

    public void clickLanguageButton() {
        driver.findElement(languageButtonSelector).click();
    }

    public String getMarketNameTitle() {

        return waitForElementVisibility(marketNameLabelSelector).getText();
    }

    public void clickUserButton() {
        waitForClickabelElement(userButtonSelector).click();
    }

    public WebElement waitForClickabelElement(By locator) {

        return driverWait.until(elementToBeClickable(locator));
    }

    public WebElement waitForElementVisibility(By locator) {

        return driverWait.until(visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitOnElementsList(By locator, int amount) {

        return  driverWait.until(numberOfElementsToBeMoreThan(locator, amount));
    }

}
