package com.softserveinc.ita.deprecated.dkrutenko.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPageModal extends BasePage {

    private final String emailInputSelector = "//input[@id='auth_email']";
    private final String passwordInputSelector = "//input[@id='auth_pass']";
    private final String loginButtonSelector = "//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']";
    private final String sideUserMenuButtonSelector = "//button[@class='header__button']";
    private final String userEmailTitleSelector = "//p[@class='side-menu__auth-caption']";
    private final String exitButtonSelector = "//button[@class='button button--large side-menu__button']";

    public void clickLoginButton() {
        $x(loginButtonSelector).click();
    }

    public void clickSideUserMenu() {
        $x(sideUserMenuButtonSelector).click();
    }

    public String getUserEmailTitle() {
        return $x(userEmailTitleSelector).getText().trim();
    }

    public void clickExitButton() {
        $x(exitButtonSelector).click();
    }

    public void fillEmailField(String text) {
        var waitForEmail = $x(emailInputSelector);

        waitForEmail.click();
        waitForEmail.clear();
        waitForEmail.sendKeys(text);
    }

    public void fillPasswordField(String text) {
        var waitForPassword = $x(passwordInputSelector);

        waitForPassword.click();
        waitForPassword.clear();
        waitForPassword.sendKeys(text);
    }
}
