package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.pageobjects.Cart;
import com.softserveinc.ita.pageobjects.CartSideMenu;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.SearchField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        driver = new ChromeDriver();
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
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public SearchField loadSearch() {
        return new SearchField(driver);
    }
        public Cart loadCart () {
            return new Cart(driver);
        }
        public HomePage loadHomePage () {
            return new HomePage(driver);
        }
        public CartSideMenu loadCartSideMenu () {
            return new CartSideMenu(driver);
        }
    }
