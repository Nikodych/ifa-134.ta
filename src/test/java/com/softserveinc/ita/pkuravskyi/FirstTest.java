package com.softserveinc.ita.pkuravskyi;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        //Installing chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/softserveinc/ita/drivers/chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyWikipedia() {
        //Search for Wikipedia and open it
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Wikipedia");
        driver.findElement(By.xpath("//input[@name = 'btnK']")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'wikipedia.org')]")).click();
        driver.findElement(By.name("search")).sendKeys("SoftServe");
        driver.findElement(By.xpath("//input[@name = 'go']")).click();
        driver.findElement(By.xpath("//span[@class = 'tocnumber' and text() = '2']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}