package com.softserveinc.ita.mmakoviichuk.utils.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {

    public static final int defaultTimeout = 15;

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
