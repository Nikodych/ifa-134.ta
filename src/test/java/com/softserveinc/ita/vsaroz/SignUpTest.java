package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SignUpTest {

    private String firstName = "UsersFirstName";
    private String lastName = "YourLastName";
    private String email = "test.testadmin@gmail.com";
    private String userName = "YourUserName";
    private String password = "987654321";

    private final SelenideElement homepageJoinButtonElement = $x("//a[@href='/join']");
    private final SelenideElement firstnameInputElement = $x("//input[@name='user[first_name]']");
    private final SelenideElement lastnameInputElement = $x("//input[@name='user[last_name]']");
    private final SelenideElement emailInputElement = $x("//input[@name='user[email]']");
    private final SelenideElement usernameInputElement = $x("//input[@name='user[username]']");
    private final SelenideElement passwordInputElement = $x("//input[@name='user[password]']");
    private final SelenideElement joinButtonElement = $x("//a[@class='btn btn-default btn-block-level js-fake-join-form-submit-button']");

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://unsplash.com/login");
    }

    @Test
    public void verifySignUpTest() {
        homepageJoinButtonElement.click();
        firstnameInputElement.sendKeys(firstName);
        lastnameInputElement.sendKeys(lastName);
        emailInputElement.sendKeys(email);
        usernameInputElement.sendKeys(userName);
        passwordInputElement.sendKeys(password);
        joinButtonElement
                .shouldBe(visible)
                .click();
    }
}