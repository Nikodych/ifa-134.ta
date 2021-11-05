package com.softserveinc.ita.vsaroz.utils.runners;

import com.softserveinc.ita.vsaroz.resources.DataProvider;
import com.softserveinc.ita.vsaroz.pageobjects.RozetkaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {
    private WebDriver driver;
    protected RozetkaPage rozetkaPage;

    @BeforeSuite
    public void beforeSuite() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/softserveinc/ita/vsaroz/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void open() {
        driver.get("https://rozetka.com.ua/ua");
        rozetkaPage = new RozetkaPage(driver);
    }

    @AfterClass
        public void afterClass() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
