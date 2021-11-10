package com.softserveinc.ita.vsaroz.utils.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.softserveinc.ita.vsaroz.pageobjects.RozetkaPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Condition.*;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public abstract class TestRunner {
    protected RozetkaPage rozetkaPage = new RozetkaPage();

    @BeforeSuite
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }

    @AfterClass
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWindow();
    }
}
