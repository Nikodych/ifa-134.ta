package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends RozetkaPageObject {
    private WebElement homePage;
    private WebElement marketName;
    private WebElement languageButton;

    public MainPage(WebDriver driver) {
        super(driver);
        webElements();
    }

    private void webElements() {
        homePage = driver.findElement(By.cssSelector("div > a > picture"));
        languageButton = driver.findElement(By.xpath("//a[@class='lang__link ng-star-inserted']"));
    }

    public WebElement getHomePage() {
        return homePage;
    }

    public void clickHomePage() {
        getHomePage().click();
    }

    public String getMarketName() {
        marketName = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='main-copyright_color_gray']")));
        String rozetka = marketName.getText();

        return rozetka;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public void clickLanguageButton() {
        getLanguageButton().click();
    }
    //functional
    public void fillEmailField(String text) {
        getEmailField().click();
        getEmailField().clear();
        getEmailField().sendKeys(text);
    }

    public void fillPasswordField(String text) {
        getPasswordField().click();
        getPasswordField().clear();
        getPasswordField().sendKeys(text);
    }
}
