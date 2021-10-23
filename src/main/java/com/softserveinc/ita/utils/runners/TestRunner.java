package com.softserveinc.ita.utils.runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    protected WebDriver driver;
    private String driverPath = "C:\\Users\\Ferrl\\IdeaProjects\\ifa-134.ta\\src\\main\\java\\com\\softserveinc\\ita\\drivers\\chrome_driver.exe";

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
