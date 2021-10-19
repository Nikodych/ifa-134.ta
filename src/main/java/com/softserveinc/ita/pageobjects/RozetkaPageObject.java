package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class RozetkaPageObject {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private WebElement homePage;
    private WebElement cart;

    public RozetkaPageObject(WebDriver driver) {
        this.driver = driver;
        webElements();
    }

    //rozetka webElements
    private void webElements() {
        homePage = driver.findElement(By.cssSelector("div > a > picture"));
        cart = driver.findElement(By.xpath("//rz-cart[@class='header-actions__component']"));
    }
    //----------------------------------------page object constructor----------------------------------------
    //home page
    public WebElement getHomePage() {
        return homePage;
    }
    public void clickHomePage() {
        getHomePage().click();
    }
    //shopping cart
    public WebElement getCart() {
        return cart;
    }
    public void clickCart() {
        getCart().click();
    }
    }