package com.softserveinc.ita.vsaroz.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PracticeTest {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/softserveinc/ita/vsaroz/resources/chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
        public void beforeMethod() {
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    //Search by XPath and some selectors
    public void testMarket () {
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?id_product=3&controller=product']")).click();
        driver.findElement(By.id("add_to_cart")).click();
        driver.findElement(By.linkText("Sign in")).click();
    }
}
