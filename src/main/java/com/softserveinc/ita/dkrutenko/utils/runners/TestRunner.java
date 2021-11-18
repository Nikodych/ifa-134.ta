package com.softserveinc.ita.dkrutenko.utils.runners;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class TestRunner {

    protected static final String rozetkaUrl = "https://rozetka.com.ua/";
    private static final String chromeProfile = "C:/Users/IT/AppData/Local/Google/Chrome/User Data/";
    private static final String driverPath = "src/main/java/com/softserveinc/ita/dkrutenko/resources/chromedriver.exe";
    private WebDriver driver;

    //uncomment "BeforeSuite" and "AfterMethod" for rozetka login test only
    /*@BeforeSuite
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + chromeProfile);
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
        setWebDriver(driver);
        open(rozetkaUrl);
    }

    @AfterMethod
    public void quit() {
        getWebDriver().manage().deleteAllCookies();
        getWebDriver().quit();
    }
     */
}
