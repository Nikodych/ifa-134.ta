package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.pageobjects.HomePage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {
    protected HomePage homePage = new HomePage();

    @BeforeMethod
    public void openHomePage() {
        open("https://rozetka.com.ua/");
    }
}
