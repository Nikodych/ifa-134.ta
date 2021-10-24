package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.pageobjects.GooglePage;
import com.softserveinc.ita.pageobjects.WikipediaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    protected GooglePage googlePage;
    protected WikipediaPage wikipediaPage;
    private final String driverPath = "src/main/java/com/softserveinc/ita/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .pageLoadTimeout(20, TimeUnit.SECONDS);
        driver
                .manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();
    }

    @BeforeMethod
    public void openGoogle() {
        driver.get("https://www.google.com/");
        googlePage = new GooglePage(driver);
        wikipediaPage = new WikipediaPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
