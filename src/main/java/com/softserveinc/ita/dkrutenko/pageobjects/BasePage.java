package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage  {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private By search = By.name("search");
    private By searchButton = By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']");
    private By logo = By.cssSelector("div > a > picture");
    private By languageButton = By.xpath("//a[@class='lang__link ng-star-inserted']");
    private WebElement marketName;
    private WebElement userButton;

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

    public String getMarketName() {
        marketName = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='main-copyright_color_gray']")));
        String rozetka = marketName.getText();

        return rozetka;
    }

    public WebElement getUserButton() {
        userButton = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//rz-user[@class='header-actions__component']")));

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
