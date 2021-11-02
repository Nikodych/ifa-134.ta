package com.softserveinc.ita.pkuravskyi.utils.runners;

import com.softserveinc.ita.pkuravskyi.pageobjects.GooglePage;
import com.softserveinc.ita.pkuravskyi.pageobjects.SoftServePage;
import com.softserveinc.ita.pkuravskyi.pageobjects.WikipediaPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    public static final int defaultTimeout = 10;
    protected GooglePage googlePage;
    protected WikipediaPage wikipediaPage;
    protected SoftServePage softServePage;
    private static final String driverPath = "src/main/java/com/softserveinc/ita/pkuravskyi/resources/chromedriver.exe";
    @Getter
    private static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .pageLoadTimeout(50, TimeUnit.SECONDS);
        driver
                .manage()
                .timeouts()
                .implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();
    }

    @BeforeMethod
    public void openWebsite() {
        driver.get("https://www.softserveinc.com/en-us");
        googlePage = new GooglePage(getDriver());
        wikipediaPage = new WikipediaPage(getDriver());
        softServePage = new SoftServePage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
