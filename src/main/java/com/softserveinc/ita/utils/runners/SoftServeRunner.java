package com.softserveinc.ita.utils.runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class SoftServeRunner {

    protected WebDriver driver;
    private String driverPath = "C:\\Users\\Ferrl\\IdeaProjects\\ifa-134.ta\\src\\main\\java\\com\\softserveinc\\ita\\drivers\\chrome_driver.exe";

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.softserveinc.com/en-us");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
