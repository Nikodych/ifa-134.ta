package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends RozetkaPageObject {
    private WebElement homePage;
    private WebElement marketName;

    public MainPage(WebDriver driver) {
        super(driver);
        webElements();
    }

    private void webElements() {
        homePage = driver.findElement(By.cssSelector("div > a > picture"));
    }

    public WebElement getHomePage() {
        return homePage;
    }

    public String getMarketName() {
        marketName = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='main-copyright_color_gray']")));
        String rozetka = marketName.getText();

        return rozetka;
    }

    public void clickHomePage() {
        getHomePage().click();
    }


}
