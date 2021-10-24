package com.softserveinc.ita.utils.runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

abstract public class TestRunner {

    private WebDriver driver;
    private String driverPath = "C:\\Users\\Ferrl\\IdeaProjects\\ifa-134.ta\\src\\main\\java\\com\\softserveinc\\ita\\drivers\\chromedriver.exe";

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
