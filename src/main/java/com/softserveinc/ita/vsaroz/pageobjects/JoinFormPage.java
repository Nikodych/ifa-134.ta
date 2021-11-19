package com.softserveinc.ita.vsaroz.pageobjects;

import com.softserveinc.ita.vsaroz.models.User;

import static com.softserveinc.ita.vsaroz.utils.runners.ElementUtils.setText;

public class JoinFormPage {

    protected final String homepageJoinButtonElement = ("//a[@href='/join']");
    private final String firstnameInputElement = ("//input[@name='user[first_name]']");
    private final String lastnameInputElement = ("//input[@name='user[last_name]']");
    private final String emailInputElement = ("//input[@name='user[email]']");
    private final String usernameInputElement = ("//input[@name='user[username]']");
    private final String passwordInputElement = ("//input[@name='user[password]']");
    protected final String joinButtonElement = ("//a[@class='btn btn-default btn-block-level js-fake-join-form-submit-button']");
    protected String avatarElement = ("//img[@src='https://images.unsplash.com/placeholder-avatars/extra-large.jpg?auto=format&fit=crop&w=32&h=32&q=60&crop=faces&bg=fff']");
    protected String viewProfileElement = ("//a[@href='/@sarozv']");

    public void fillInputs(User user) {

        setText(firstnameInputElement, user.getFirstName());
        setText(lastnameInputElement, user.getLastName());
        setText(emailInputElement, user.getEmail());
        setText(usernameInputElement, user.getUserName());
        setText(passwordInputElement, user.getPassword());
    }
}
