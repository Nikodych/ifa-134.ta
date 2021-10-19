package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

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
    //ExpectectCondition for elements
    public WebDriverWait waitElementCondition() {
        driverWait = new WebDriverWait(driver,500);
        return driverWait;
    }
    //page load time
    public WebDriverWait pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return pageLoadTimeout();
    }
    //implicitly timeout
    public WebDriverWait implicitlyTimeout() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return implicitlyTimeout();
    }
}