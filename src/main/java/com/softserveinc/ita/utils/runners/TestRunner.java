package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.pageobjects.ShoppingCartPage;
import com.softserveinc.ita.pageobjects.ShoppingCartModal;
import com.softserveinc.ita.pageobjects.MainPage;
import com.softserveinc.ita.pageobjects.SearchField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    public WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src//main//java//com//softserveinc//ita//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void open() {
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public SearchField loadSearch() {return new SearchField(driver);}

        public ShoppingCartPage loadShoppingCartPage () {return new ShoppingCartPage(driver);}

        public ShoppingCartModal loadShoppingCartModal() {return new ShoppingCartModal(driver);}

        public MainPage loadMainPage () { return new MainPage(driver); }
    }
