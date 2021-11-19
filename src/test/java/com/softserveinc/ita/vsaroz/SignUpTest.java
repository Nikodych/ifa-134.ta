package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import com.softserveinc.ita.vsaroz.pageobjects.JoinFormPage;
import com.softserveinc.ita.vsaroz.repo.UserRepo;
import org.testng.annotations.*;
import com.softserveinc.ita.vsaroz.models.User;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SignUpTest extends JoinFormPage {
    private final JoinFormPage joinFormPage = new JoinFormPage();

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://unsplash.com/login");
    }

    @DataProvider
    public Object[][] loginformFillInputs() {
        return new Object[][]{
                {new UserRepo().getUsersContacts()}};
    }

    @Test(dataProvider = "loginformFillInputs")
    public void verifySignUpTest(User user) {
        $x(homepageJoinButtonElement).click();
        joinFormPage.fillInputs(user);
        $x(joinButtonElement)
                .shouldBe(visible)
                .click();
        $x(avatarElement).click();

        assertThat(viewProfileElement)
                .as("Some Errors occured while registration");
    }
}