package com.softserveinc.ita.utils.runners;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public abstract class TestRunner {

    @BeforeMethod
    public void openHomePage() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = ofSeconds(8).toMillis();
        open("https://rozetka.com.ua/ua/");
    }
}
