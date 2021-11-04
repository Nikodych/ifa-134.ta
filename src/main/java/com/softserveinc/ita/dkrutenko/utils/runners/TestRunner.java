package com.softserveinc.ita.dkrutenko.utils.runners;

import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.LoginPageModal;
import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.SearchGoods;
import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.ShoppingCartModal;
import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.ShoppingCartPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {
    public static final int defaultTimeout = 20;

    protected SearchGoods searchGoods;
    protected ShoppingCartPage shoppingCartPage;
    protected ShoppingCartModal shoppingCartModal;
    protected LoginPageModal loginPageModal;
    protected static final String rozetkaUrl = "https://rozetka.com.ua/";
    protected static final String softServeUrl = "https://www.softserveinc.com/";
    private static final String setDriver = "src/main/java/com/softserveinc/ita/dkrutenko/resources/chromedriver.exe";
    @Getter
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", setDriver);
        //comment lines 27,28,29 if you won't use your current profile with cookies
        ChromeOptions profile = new ChromeOptions();
        profile.addArguments("user-data-dir=C:/Users/dokp/AppData/Local/Google/Chrome/User Data/");
        driver = new ChromeDriver(profile);
        //driver = new ChromeDriver();      //uncomment this for test without cookies
        driver
                .manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();
    }

    @BeforeMethod
    public void open() {
        searchGoods = new SearchGoods(driver);
        loginPageModal = new LoginPageModal(driver);
        shoppingCartModal = new ShoppingCartModal(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        driver
                .manage()
                .timeouts()
                .pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
