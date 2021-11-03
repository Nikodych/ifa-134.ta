package com.softserveinc.ita.pkuravskyi.utils.runners;

import com.softserveinc.ita.pkuravskyi.pageobjects.GooglePage;
import com.softserveinc.ita.pkuravskyi.pageobjects.RozetkaPage;
import com.softserveinc.ita.pkuravskyi.pageobjects.SoftServePage;
import com.softserveinc.ita.pkuravskyi.pageobjects.WikipediaPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    public static final int defaultTimeout = 15;
    protected GooglePage googlePage;
    protected WikipediaPage wikipediaPage;
    protected SoftServePage softServePage;
    protected RozetkaPage rozetkaPage;
    private static final String driverPath = "src/main/java/com/softserveinc/ita/pkuravskyi/resources/chromedriver.exe";
    private static final String googleUrl = "https://www.google.com.ua/";
    private static final String rozetkaUrl = "https://rozetka.com.ua/";
    private static final String softServeUrl = "https://www.softserveinc.com/en-us";
    @Getter
    private static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/Paul/AppData/Local/Google/Chrome/User Data/");
        driver = new ChromeDriver(options);
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
        driver.get(softServeUrl);
        googlePage = new GooglePage(getDriver());
        wikipediaPage = new WikipediaPage(getDriver());
        rozetkaPage = new RozetkaPage(getDriver());
        softServePage = new SoftServePage(getDriver());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
