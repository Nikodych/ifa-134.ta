package com.softserveinc.ita.pkuravskyi;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class test1 {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        //Installing chrome driver
        System.setProperty("webdriver.chrome.driver", "E://SoftServe//chromedriver_win32//chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testWikipedia() throws InterruptedException {
        //Search for Wikipedia and open it
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Wikipedia");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name = 'btnK']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[contains(@href, 'wikipedia.org')]")).click();
        Thread.sleep(500);
        driver.findElement(By.name("search")).sendKeys("SoftServe");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name = 'go']")).click();
        Thread.sleep(800);
        driver.findElement(By.xpath("//span[@class = 'tocnumber' and text() = '2']")).click();
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Test has been completed!");
    }
}
