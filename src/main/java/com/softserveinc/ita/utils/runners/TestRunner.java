package com.softserveinc.ita.utils.runners;

import com.codeborne.selenide.Configuration;
import com.softserveinc.ita.pageobjects.CheckoutPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {

    protected HomePage homePage = new HomePage();
    protected ProductPage productPage = new ProductPage();
    protected CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeMethod
    public void openHomePage() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;
        open("https://rozetka.com.ua/ua/");
    }
}
