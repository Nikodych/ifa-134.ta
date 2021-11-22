package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import com.softserveinc.ita.vsaroz.pageobjects.JoinFormPage;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.softserveinc.ita.vsaroz.repo.UserRepo.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SignUpTest {
    private JoinFormPage joinFormPage;

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://unsplash.com/login");
        joinFormPage = new JoinFormPage();
    }

    @Test
    public void verifySignUpTest() {
        joinFormPage.pressJoin();
        joinFormPage.setUserRegistrationData(getUsersContacts());
        joinFormPage.signUp();
        joinFormPage.profileDropDownMenu();
        joinFormPage.moveToUserPage();

        String newUserProfileName = joinFormPage.getUserProfileName();

        assertThat(newUserProfileName)
                .as("Something wrong with your registration")
                .isEqualTo("vitalii1 saroz1");
    }
}