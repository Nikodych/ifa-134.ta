package com.softserveinc.ita.deprecated.vsaroz.utils.runners;

import com.codeborne.selenide.Configuration;
import com.softserveinc.ita.deprecated.vsaroz.pageobjects.RozetkaPage;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.*;

public abstract class TestRunner {
    protected RozetkaPage rozetkaPage = new RozetkaPage();

    @BeforeSuite
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }
}