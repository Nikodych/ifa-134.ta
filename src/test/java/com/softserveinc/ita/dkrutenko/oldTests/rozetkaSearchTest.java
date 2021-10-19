package com.softserveinc.ita.dkrutenko.oldTests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class rozetkaSearchTest {
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeSuite
    public void beforeSuite() {
<<<<<<< HEAD:src/test/java/com/softserveinc/ita/dkrutenko/oldTests/rozetkaSearchTest.java
        System.setProperty("webdriver.chrome.driver", "C://Users//IT//Documents//GitHub//ifa-134.ta//src//main//java//com//softserveinc//ita//resources//chromedriver.exe");
=======
        System.setProperty("webdriver.chrome.driver", "C://Users//dokp//Documents//GitHub//ifa-134.ta//src//main//java//com//softserveinc//ita//resources//chromedriver.exe");
>>>>>>> b10ec08fef0f79983b793ec7f7c281befb40ed8d:src/test/java/com/softserveinc/ita/dkrutenko/rozetkaSearchTest.java
    }
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.google.com/");
    }

    @DataProvider
    public Object[][] rozetkaItems () {
        return new Object[][]{
                {"Samsung Galaxy S21 8/256GB Phantom Pink"},
                {"Samsung Galaxy A72 6/128GB White"},
                {"Samsung Galaxy Watch 4 Classic 46mm Black"},
                {"23.8"+'"'+" "+"Samsung S24R350 Dark Silver"} };
    }
    @Test(dataProvider = "rozetkaItems")
    public void testRozetkaSearchItems (String item) {
        //searching rozetka in google
        driver.findElement(By.name("q")).sendKeys("rozetka");
        //use simple locator to click on "search" button
        WebElement searchIcon = driver.findElement(By.name("btnK"));
        searchIcon.click();
        //move on rozetka marketplace
        driver.findElement(By.partialLinkText("rozetka")).click();
        WebElement search = driver.findElement(By.name("search"));
        search.click();
        search.clear();
        search.sendKeys("samsung");
        //click on search button
        driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")).click();
        //setting up WebDriverWait plugin for element with defined expected condition and time
        driverWait = new WebDriverWait(driver, 1000);
        //use Expected Conditions for List of WebElement to catch our item from requirement
        List<WebElement> goods =  driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@class='goods-tile__title']"),20));
        //stream our WebElement list,getting text and searching for our required item
        List<WebElement> phoneList = goods
                        .stream()
                        .filter(i->i.getText()
                        .contains(item))
                        .collect(Collectors.toList());
        //add text from WebElement list to our list of Strings while using loop
        List<String> list = new ArrayList<>();
        for(int i = 0; i<phoneList.size(); i++)
            list.add(phoneList.get(i).getText());
       Assert.assertTrue(list.get(0).contains(item));
        }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    }