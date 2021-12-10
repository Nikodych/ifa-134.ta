package com.softserveinc.ita.utils.runners;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;

@Listeners({TestListener.class})
public abstract class TestRunner {

    @BeforeMethod
    public void openHomePage() {
        Configuration.browserSize = "1920x1080";
        timeout = 8000;
        open("https://rozetka.com.ua/ua/");
    }
}