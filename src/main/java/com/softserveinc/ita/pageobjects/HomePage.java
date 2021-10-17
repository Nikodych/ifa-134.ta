package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends RozetkaPageObject {
    private WebElement homePage;

    public HomePage(WebDriver driver) {
        super(driver);
        webElements();
    }
    private void webElements() {
        homePage = driver.findElement(By.cssSelector("div > a > picture"));
    }
    //home page
    public WebElement getHomePage() {
        return homePage;
    }
    public void clickHomePage() {
        getHomePage().click();
    }
}
