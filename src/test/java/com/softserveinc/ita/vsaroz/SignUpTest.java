package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import com.softserveinc.ita.vsaroz.pageobjects.JoinFormPage;
import com.softserveinc.ita.vsaroz.repo.UserRepo;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SignUpTest {
    private final JoinFormPage joinFormPage = new JoinFormPage();

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://unsplash.com/login");
    }

    @Test
    public void verifySignUpTest() {
        joinFormPage.clickHomepageJoinButtonElement();
        joinFormPage.fillInputs(UserRepo.getUsersContacts());
        joinFormPage.signUp();
        joinFormPage.clickAvatarAndProfileElements();

        String newUserProfileName = joinFormPage
                .verifyRegistration()
                .trim();

        assertThat(newUserProfileName)
                .as("Something wrong with your registration")
                .isEqualTo("vitalii1 saroz1");
    }
}