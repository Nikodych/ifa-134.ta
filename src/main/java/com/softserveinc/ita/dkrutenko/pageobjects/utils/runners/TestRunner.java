package com.softserveinc.ita.dkrutenko.pageobjects.utils.runners;

import com.softserveinc.ita.dkrutenko.pageobjects.LoginPageModal;
import com.softserveinc.ita.dkrutenko.pageobjects.SearchGoods;
import com.softserveinc.ita.dkrutenko.pageobjects.ShoppingCartModal;
import com.softserveinc.ita.dkrutenko.pageobjects.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

protected SearchGoods searchGoods;
protected ShoppingCartPage shoppingCartPage;
protected ShoppingCartModal shoppingCartModal;
protected LoginPageModal loginPageModal;
protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
            "src/main/java/com/softserveinc/ita/dkrutenko/pageobjects/resources/chromedriver.exe");
        //uncomment line 27,28 and 29 for login test to avoid captcha
        //ChromeOptions profile = new ChromeOptions();
        //profile.addArguments("user-data-dir=C:/Users/dokp/AppData/Local/Google/Chrome/User Data/");
        //driver = new ChromeDriver(profile);
        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.get("https://rozetka.com.ua/");
        driver
                .manage()
                .timeouts()
                .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies(); //comment this for login test too
        driver.quit();
    }
}
