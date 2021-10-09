package com.softserveinc.ita.vsaroz;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class SampleTest {
    @BeforeSuite
    public void beforeSuite() {
        //Installing chrome driver
        System.setProperty("webdriver.chrome.driver", "E://SoftServe//chromedriver_win32//chromedriver.exe");
    }
    @Test
    public void firstTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://mkt.uz.ua/");
    }

}
