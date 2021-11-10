package com.softserveinc.ita.vsaroz.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SignUpTest {

    private String firstName = "UsersFirstName";
    private String lastName = "YourLastName";
    private String email = "test.testadmin@gmail.com";
    private String userName = "YourUserName";
    private String password = "987654321";

    private final SelenideElement Join = $x("//a[@href='/join']");
    private final SelenideElement typeFirstName = $x("//input[@name='user[first_name]']");
    private final SelenideElement typeLastName = $x("//input[@name='user[last_name]']");
    private final SelenideElement typeEmail = $x("//input[@name='user[email]']");
    private final SelenideElement typeUserName = $x("//input[@name='user[username]']");
    private final SelenideElement typePassword = $x("//input[@name='user[password]']");
    private final SelenideElement buttonJoin = $x("//a[@class='btn btn-default btn-block-level js-fake-join-form-submit-button']");

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://unsplash.com/login");
    }

    @Test
    public void signUpTest() {
        $(Join).click();
        $(typeFirstName).sendKeys(firstName);
        $(typeLastName).sendKeys(lastName);
        $(typeEmail).sendKeys(email);
        $(typeUserName).sendKeys(userName);
        $(typePassword).sendKeys(password);
        $(buttonJoin).shouldBe(Condition.visible).click();
    }
}