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

public class test2 {
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long EXPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;
    private WebDriverWait driverWait;
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
        //Maximize chrome window
        driver.manage().window().maximize();
    }
//quit driver(close chrome window) after test
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.quit();
    }
//load google.com and delete cookies before work
    @BeforeMethod
    public void beforeMethod() {
        //Launching actual url
        driver.get("https://www.google.com/");
        driver.manage().deleteAllCookies();
    }
    //print string after test
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if(!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("Congratulations, " + testName + " has finished working.");
        }
    }
    //our items that should be found
    @DataProvider
    public Object[][] rozetkaItems () {
        return new Object[][]{
               {"Samsung Galaxy S21 8/256GB Phantom Pink"},
                {"Samsung Galaxy A72 6/128GB White"},
                {"Samsung Galaxy Watch 4 Classic 46mm Black"},
                {"23.8"+'"'+" "+"Samsung S24R350 Dark Silver"}

        };
    }
    //Our test with DataProvider
    @Test(dataProvider = "rozetkaItems")
    public void testRozetka (String item) {   //This item - is string from DataProvider
        //searching for rozetka
        driver.findElement(By.name("q")).sendKeys("rozetka");
        //Use simple locators
        WebElement searchIcon = driver.findElement(By.name("btnK"));
        searchIcon.click();
        driver.findElement(By.partialLinkText("rozetka")).click();
        //waiting for page
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.name("search"));
        search.click();
        search.clear();
        search.sendKeys("samsung");
        //waiting for page
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        //click on search button
        driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")).click();
        //taking list of elements on website
        driverWait = new WebDriverWait(driver, 100);
        List<WebElement> elements =  driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@class='goods-tile__title']"),20));
        List<WebElement> phoneList = elements
                        .stream()
                        .filter(i->i.getText()
                        .contains(item))
                        .collect(Collectors.toList());
//transform list of WebElements to list of strings
        List<String> list = new ArrayList<>();
        for(int i = 0; i<phoneList.size(); i++)
            list.add(phoneList.get(i).getText());
        //print our list
        System.out.println(list);
        //check if our list have an item from DataProvider
       Assert.assertTrue(list.get(0).contains(item));
        }
    }



