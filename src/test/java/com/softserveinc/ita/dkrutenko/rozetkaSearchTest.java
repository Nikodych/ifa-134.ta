package com.softserveinc.ita.dkrutenko;

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
import org.testng.ITestResult;
import org.testng.annotations.*;

public class rozetkaSearchTest {
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long EXPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Documents//GitHub//chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        //setting up new Chrome driver
        driver = new ChromeDriver();
        //page load time
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //wait amout of time before it throws "No such Element Exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximize chrome window
        driver.manage().window().maximize();
    }
//implicitly wait for 2 seconds and quit the driver(close chrome window)
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
    }
//load google.com and delete cookies before work
    @BeforeMethod
    public void beforeMethod() {
        //Launching actual url
        driver.get("https://www.google.com/");
        driver.manage().deleteAllCookies();
    }
    //print some message after test finish
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if(!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("Congratulations, " + testName + " has finished working.");
        }
    }
    //required items for search
    @DataProvider
    public Object[][] rozetkaItems () {
        return new Object[][]{
               {"Samsung Galaxy S21 8/256GB Phantom Pink"},
                {"Samsung Galaxy A72 6/128GB White"},
                {"Samsung Galaxy Watch 4 Classic 46mm Black"},
                {"23.8"+'"'+" "+"Samsung S24R350 Dark Silver"}

        };
    }
    //Our test with DataProvider that have required items for search
    @Test(dataProvider = "rozetkaItems")
    public void testRozetka (String item) {   //This item - is string from DataProvider
        //searching rozetka in google
        driver.findElement(By.name("q")).sendKeys("rozetka");
        //use simple locator to click on "search" button
        WebElement searchIcon = driver.findElement(By.name("btnK"));
        searchIcon.click();
        //move on rozetka marketplace
        driver.findElement(By.partialLinkText("rozetka")).click();
        //wait for loading page
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        //search samsung
        WebElement search = driver.findElement(By.name("search"));
        search.click();
        search.clear();
        search.sendKeys("samsung");
        //wait for loading page with goods
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
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
        //print our list
        System.out.println(list);
        //check if our list have an item from DataProvider
       Assert.assertTrue(list.get(0).contains(item));
        }
    }
