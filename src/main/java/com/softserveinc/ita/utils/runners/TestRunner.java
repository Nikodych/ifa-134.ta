package com.softserveinc.ita.utils.runners;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {

    @BeforeMethod
    public void openHomePage() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }
}