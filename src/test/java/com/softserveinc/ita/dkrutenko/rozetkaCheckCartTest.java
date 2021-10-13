package com.softserveinc.ita.dkrutenko;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class rozetkaCheckCartTest {
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Admin//Documents//GitHub//chromedriver.exe");
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
        driver.get("https://rozetka.com.ua/");
    }
    @DataProvider
    public Object[][] rozetkaCheckCartItems () {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S21"},
                {"iphone",   "iPhone 12 Pro Max"},
                {"samsung", "Samsung Galaxy A72"} };
    }
    @Test(dataProvider = "rozetkaCheckCartItems")
    //searchItem = samsung or etc; item = some phone or etc.
    public void testRozetka (String searchItem, String item) {
        WebElement search = driver.findElement(By.name("search"));
        search.click();
        search.clear();
        search.sendKeys(searchItem);
        //wait for loading page with goods
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        //click on search button
        driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")).click();
        //wait for visibility of our item
        driverWait = new WebDriverWait(driver,20);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(item))).click();
        //wait for next loading page and click on "Buy(Add to cart)" button
        driver.findElement(By.xpath("//*[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']")).click();
        //close current window
        WebElement continueButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-footer.ng-star-inserted > a")));
        continueButton.click();
        //move on the main page
        driver.findElement(By.cssSelector("div > a > picture")).click();
        //click on cart button
        driver.findElement(By.xpath("//rz-cart[@class='header-actions__component']")).click();
        String phone = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cart-product__title']"))).getText();
        //check that if our phone is available in cart
        Assert.assertTrue(phone.contains(item));
        driver.findElement(By.xpath("//button[@class='button button--white button--small context-menu__toggle']")).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']"))).click();
        //close current window
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close ng-star-inserted']"))).click();
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}