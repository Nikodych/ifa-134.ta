package com.softserveinc.ita.dkrutenko;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class webSearchTest {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {

        //Installing and using driver
       System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Documents//GitHub//chromedriver.exe");
    }

    //pageLoad time and Implicit wait
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize browser window
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        // driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        //Launching actual url
        driver.get("https://www.google.com/");
        driver.manage().deleteAllCookies();
    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if(!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("Congratulations, " + testName + " has finished working.");
        }
    }

    @DataProvider
    public Object[][] urls () {
        return new Object[][]{
                {"YouTube"},
                {"Driver"},
                {"GitHub"}
        };
    }
            @Test(dataProvider = "urls")
        public void testSearch (String url) {
            //Looking for YouTube
            driver.findElement(By.name("q")).sendKeys(url);
            //Use simple locators
            WebElement searchIcon = driver.findElement(By.name("btnK"));
            searchIcon.click();
            driver.findElement(By.partialLinkText(url)).click();
            String result = driver.findElement(By.partialLinkText(url)).getText();

            Assert.assertTrue(result.contains(url));
            System.out.println("The test is finished");
        }
    }


