package com.softserveinc.ita.vsaroz.pageobjects;

import com.softserveinc.ita.vsaroz.models.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.vsaroz.utils.runners.ElementUtils.*;

public class JoinFormPage {

    private final String homepageJoinButtonElement = "//a[@href='/join']";
    private final String firstnameInputElement = "//input[@name='user[first_name]']";
    private final String lastnameInputElement = "//input[@name='user[last_name]']";
    private final String emailInputElement = "//input[@name='user[email]']";
    private final String usernameInputElement = "//input[@name='user[username]']";
    private final String passwordInputElement = "//input[@name='user[password]']";
    private final String joinButtonElement = "//a[@class='btn btn-default btn-block-level js-fake-join-form-submit-button']";
    private final String avatarElement = "//img[@src='https://images.unsplash.com/placeholder-avatars/extra-large.jpg?auto=format&fit=crop&w=32&h=32&q=60&crop=faces&bg=fff']";
    private final String viewProfileElement = "//a[@href='/@vsaroz11']";
    private final String profileNameField = "//div[@class='dJnu9 CjK9V Fu4vG lP2EO']";

    public void clickHomepageJoinButtonElement() {
        $x(homepageJoinButtonElement).click();
    }

    public void fillInputs(User user) {
        setText(firstnameInputElement, user.getFirstName());
        setText(lastnameInputElement, user.getLastName());
        setText(emailInputElement, user.getEmail());
        setText(usernameInputElement, user.getUserName());
        setText(passwordInputElement, user.getPassword());
    }

    public void signUp() {
        $x(joinButtonElement)
                .shouldBe(visible)
                .click();
    }

    public void clickAvatarAndProfileElements() {
        $x(avatarElement).click();
        $x(viewProfileElement).click();
    }

    public String verifyRegistration() {
        var newUser = $x(profileNameField).getText();
        return newUser;
    }
}