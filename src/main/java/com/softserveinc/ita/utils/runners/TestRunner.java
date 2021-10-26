package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.pageobjects.LoginPageModal;
import com.softserveinc.ita.pageobjects.SearchGoods;
import com.softserveinc.ita.pageobjects.ShoppingCartModal;
import com.softserveinc.ita.pageobjects.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

protected SearchGoods searchGoods;
protected ShoppingCartPage shoppingCartPage;
protected ShoppingCartModal shoppingCartModal;
protected LoginPageModal loginPageModal;
protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src//main//java//com//softserveinc//ita//resources//chromedriver.exe");
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
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
