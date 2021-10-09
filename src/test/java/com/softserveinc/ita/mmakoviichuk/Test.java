package com.softserveinc.ita.mmakoviichuk;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Test {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Ferrl\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");

    }
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @org.testng.annotations.Test
    public void test() {
        boolean check = false;
        driver.findElement(By.xpath("//input[@title=\"Пошук\"]")).sendKeys("Selenium", Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//h3[@class=\"LC20lb DKV0Md\"]"));
        for (WebElement searchResult : results) {
            if (searchResult.getText().contains("Вікіпедія")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
        System.out.println("Test is finished");
    }
}
