package com.softserveinc.ita.mmakoviichuk.runners;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

abstract public class TestRunner {

    @Getter
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\Ferrl\\AppData\\Local\\Google\\Chrome\\User Data");
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\softserveinc\\ita\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void open() {
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        // disable for wishlist test
        //driver.manage().deleteAllCookies();
        driver.quit();
    }

}
