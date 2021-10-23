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

    public RozetkaPageObject(WebDriver driver) {
        this.driver = driver;
        webElements();
    }

    private void webElements() {
        homePage = driver.findElement(By.cssSelector("div > a > picture"));
    }

    public WebElement getHomePage() {
        return homePage;
    }

    public void clickHomePage() {
        getHomePage().click();
    }
    //ExpectectCondition for elements
    public WebDriverWait waitElementCondition() {
        driverWait = new WebDriverWait(driver,500);

        return driverWait;
    }
    //page load time
    public WebDriverWait pageLoadTimeout() {
       driverWait = new WebDriverWait(driver, 5);
       driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);

       return pageLoadTimeout();
    }
    //implicitly timeout
    public WebDriverWait implicitlyTimeout() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return implicitlyTimeout();
    }
    }
