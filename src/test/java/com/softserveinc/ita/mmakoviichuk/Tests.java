package com.softserveinc.ita.mmakoviichuk;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.List;

public class Tests {

    WebDriver driver;
    private String driverPath = "C:\\Users\\Ferrl\\IdeaProjects\\ifa-134.ta\\src\\main\\java\\com\\softserveinc\\ita\\drivers\\chromedriver.exe";

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test
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

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
