package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.pageobjects.Cart;
import com.softserveinc.ita.pageobjects.CartSideMenu;
import com.softserveinc.ita.pageobjects.MainPage;
import com.softserveinc.ita.pageobjects.SearchField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C://Users//dokp//Documents//GitHub//ifa-134.ta//src//main//java//com//softserveinc//ita//resources//chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        ChromeOptions profile = new ChromeOptions();
        profile.addArguments("user-data-dir=C:/Users/dokp/AppData/Local/Google/Chrome/User Data/");
        driver = new ChromeDriver(profile);
       // driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //driver.manage().deleteAllCookies();
        driver.quit();
    }

    public SearchField loadSearch() {
        return new SearchField(driver);
    }

        public Cart loadCart () {
            return new Cart(driver);
        }

        public CartSideMenu loadCartSideMenu () {
            return new CartSideMenu(driver);
        }

        public MainPage loadMainPage () { return new MainPage(driver); }
    }
