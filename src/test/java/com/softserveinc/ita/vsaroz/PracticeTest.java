package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeTest {

    private final SelenideElement product = $x("//a[@href='http://automationpractice.com/index.php?id_product=3&controller=product']");
    private final SelenideElement add = $x("//button[@class='exclusive']//span");
    private final SelenideElement closeModal = $x("//span[@class='cross']");

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("http://automationpractice.com/index.php");
    }

    @Test
    public void modalWindowTest () {
        (product)
                .shouldBe(visible)
                .click();
        (add)
                .shouldBe(visible)
                .click();
        (closeModal)
                .shouldBe(disappear)
                .click();
    }
}
