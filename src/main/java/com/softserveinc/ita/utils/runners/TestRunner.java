package com.softserveinc.ita.utils.runners;

import com.softserveinc.ita.utils.listeners.SelenideTestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;

@Listeners({SelenideTestListener.class})
public abstract class TestRunner {

    @BeforeMethod
    public void openHomePage() {
        timeout = 10000;
        open("https://rozetka.com.ua/ua/");
    }
}
