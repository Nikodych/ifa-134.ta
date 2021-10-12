package com.softserveinc.ita.dkrutenko;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class rozetkaCheckCartTest {
    private final String URL= "https://rozetka.com.ua/";
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
        driver.get(URL);
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
    public Object[][] rozetkaCheckCartItems () {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S21"},
                {"iphone",   "iPhone 12 Pro Max"},
                {"samsung", "Samsung Galaxy A72"},

        };
    }
    //Our test with DataProvider that have required items for search
    @Test(dataProvider = "rozetkaCheckCartItems")
    //searchItem = samsung, item = some phone or etc.
    public void testRozetka (String searchItem, String item) {
        //search samsung
        WebElement search = driver.findElement(By.name("search"));
        search.click();
        search.clear();
        search.sendKeys(searchItem);
        //wait for loading page with goods
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        //click on search button
        driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")).click();
        driverWait = new WebDriverWait(driver,20);
        //wait for visibility of our item
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(item))).click();
        //wait for next loading page and click on "Buy(Add to cart)" button
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']")).click();
        //close current window
        WebElement continueButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-footer.ng-star-inserted > a")));
        continueButton.click();
        //move on the main page
        driver.findElement(By.cssSelector("div > a > picture")).click();
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        //click on cart button
        driver.findElement(By.xpath("//rz-cart[@class='header-actions__component']")).click();
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        //taking string from the item in cart
         String phone = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cart-product__title']"))).getText();
        System.out.println(phone);
        //check that if our phone is available in cart
        Assert.assertTrue(phone.contains(item));
        //click on context menu button
        driver.findElement(By.xpath("//button[@class='button button--white button--small context-menu__toggle']")).click();
        //click on "remove" button
        driver.manage().timeouts().pageLoadTimeout(6,TimeUnit.SECONDS);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']"))).click();
        //close current windows
        driver.manage().timeouts().pageLoadTimeout(6,TimeUnit.SECONDS);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close ng-star-inserted']"))).click();

    }
}
