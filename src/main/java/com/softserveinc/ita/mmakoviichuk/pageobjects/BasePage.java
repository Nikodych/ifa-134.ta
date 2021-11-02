package com.softserveinc.ita.mmakoviichuk.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(visibilityOfElementLocated(locator));
    }

    public void waitForAttributeChanges(WebElement webElement, String attribute, String value) {
        wait.until(attributeContains(webElement, attribute, value));
    }

    public String waitForUrlChanges(String url) {
        wait.until(urlToBe(url));

        return url;
    }
}