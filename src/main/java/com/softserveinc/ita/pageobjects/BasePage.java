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

    private WebElement search;
    private WebElement searchButton;
    private WebElement logo;
    private WebElement languageButton;
    private WebElement marketName;
    private WebElement userButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webElements();
    }

    private void webElements() {
        search = driver.findElement(By.name("search"));
        searchButton = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
        logo = driver.findElement(By.cssSelector("div > a > picture"));
        languageButton = driver.findElement(By.xpath("//a[@class='lang__link ng-star-inserted']"));
    }

    public WebElement getSearch() {
        return search;
    }
    public void clickSearch() {
        getSearch().click();
    }
    public void clearSearch() {
        getSearch().clear();
    }
    public void sendKeysSearch(String text) {
        getSearch().sendKeys(text);
    }
public WebElement getSearchButton() {
        return searchButton;
}
    public void clickSearchButton() {
        getSearchButton().click();
    }
public WebElement getLogo() {
        return logo;
}
    public void clickLogo() {
        getLogo().click();
    }
public WebElement getLanguageButton() {
        return languageButton;
}
    public void clickLanguageButton() {
        getLanguageButton().click();
    }

    public String getMarketName() {
        marketName = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='main-copyright_color_gray']")));
        String rozetka = marketName.getText();

        return rozetka;
    }

    public WebElement getUserButton() {
        userButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//rz-user[@class='header-actions__component']")));

        return userButton;
    }

    public void clickUserButton() {
        getUserButton().click();
    }

    public WebDriverWait waitElementCondition() {
        driverWait = new WebDriverWait(driver,500);

        return driverWait;
    }
}
