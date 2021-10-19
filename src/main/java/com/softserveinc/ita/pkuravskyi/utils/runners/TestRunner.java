package com.softserveinc.ita.pkuravskyi.utils.runners;

import com.softserveinc.ita.pkuravskyi.pageobjects.GooglePageObject;
import com.softserveinc.ita.pkuravskyi.pageobjects.WikipediaPageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    protected GooglePageObject googlePage;
    protected WikipediaPageObject wikipediaPage;
    protected String driverPath = "src/main/java/com/softserveinc/ita/pkuravskyi/resources/chromedriver.exe";
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        //Installing chrome driver
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.google.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
