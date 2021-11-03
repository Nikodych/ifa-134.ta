package com.softserveinc.ita.vsaroz.utils.runners;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.softserveinc.ita.vsaroz.pageobjects.RztkPageObjects;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class TestRunner extends RztkPageObjects {
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C://Users//vital//ifa-134.ta//src//test//java//com//softserveinc//ita//vsaroz//resources//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void open() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/ua");
    }

    @AfterClass
        public void afterClass() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
