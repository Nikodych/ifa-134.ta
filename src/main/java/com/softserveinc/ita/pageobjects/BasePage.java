package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void waitForAttributeChanges(WebElement webElement, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(webElement, attribute, value));
    }
}
