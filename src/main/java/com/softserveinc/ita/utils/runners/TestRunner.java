package com.softserveinc.ita.utils.runners;

import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {

    @BeforeMethod
    public void openHomePage() {
        timeout = 8000;
        open("https://rozetka.com.ua/");
    }
}
