package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.pageobjects.CategoriesPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {

    protected CategoriesPage categoriesPage = new CategoriesPage();
    protected ProductPage productPage = new ProductPage();
    protected HomePage homePage = new HomePage();

    @BeforeMethod
    public void openHomePage() {
        open("https://rozetka.com.ua/ua/");
    }
}
