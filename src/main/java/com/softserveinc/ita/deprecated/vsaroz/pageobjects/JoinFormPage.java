package com.softserveinc.ita.deprecated.vsaroz.pageobjects;

import com.softserveinc.ita.deprecated.vsaroz.models.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.deprecated.vsaroz.utils.runners.ElementUtils.*;

public class JoinFormPage {

    private final String homepageJoinButtonSelector = "//a[@href='/join']";
    private final String firstnameInputSelector = "//input[@name='user[first_name]']";
    private final String lastnameInputSelector = "//input[@name='user[last_name]']";
    private final String emailInputSelector = "//input[@name='user[email]']";
    private final String usernameInputSelector = "//input[@name='user[username]']";
    private final String passwordInputSelector = "//input[@name='user[password]']";
    private final String joinButtonSelector = "//a[@class='btn btn-default btn-block-level js-fake-join-form-submit-button']";
    private final String avatarIconSelector = "//img[@src='https://images.unsplash.com/placeholder-avatars/extra-large.jpg?auto=format&fit=crop&w=32&h=32&q=60&crop=faces&bg=fff']";
    private final String viewProfileButtonSelector = "//a[@href='/@vsaroz11']";
    private final String profileNameFieldSelector = "//div[@class='dJnu9 CjK9V Fu4vG lP2EO']";

    public void pressJoin() {
        $x(homepageJoinButtonSelector).click();
    }

    public void setUserRegistrationData(User user) {
        setText(firstnameInputSelector, user.getFirstName());
        setText(lastnameInputSelector, user.getLastName());
        setText(emailInputSelector, user.getEmail());
        setText(usernameInputSelector, user.getUserName());
        setText(passwordInputSelector, user.getPassword());
    }

    public void signUp() {
        $x(joinButtonSelector)
                .shouldBe(visible)
                .click();
    }

    public void openProfileDropDownMenu() {
        $x(avatarIconSelector).click();
    }

    public void openUserPage () {
        $x(viewProfileButtonSelector).click();
    }

    public String getUserProfileName() {
        return $x(profileNameFieldSelector)
                .getText()
                .trim();
    }
}