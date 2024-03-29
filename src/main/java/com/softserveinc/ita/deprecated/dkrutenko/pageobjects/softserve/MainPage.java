package com.softserveinc.ita.deprecated.dkrutenko.pageobjects.softserve;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final String cookieButtonSelector = "//button[@class='cookie-message__cta-button']";
    private final String headerMenuContactUsButtonSelector = "//button[@class='menu__contacts-button menu__contacts-button_black menu__contacts-button_black']";
    private final String headerMenuButtonSelector = "//button[@class='menu__button menu__button_background_white']";
    private final String viewFullContactPageSelector = "//a[@class='pop-up-form__external-link']";
    private final String languageSwitcherSelector = "//li[@class='language-switcher__item']";
    private final String titleSelector = "//p[@class='title__paragraph title__paragraph_listed smaller-font']";

    public void clickAcceptCookieMessageButton() {
        $x(cookieButtonSelector).click();
    }

    public void clickHeaderContactsMenuButton() {
        $x(headerMenuContactUsButtonSelector).click();
    }

    public void clickHeaderMenuButton() {
        $x(headerMenuButtonSelector).click();
    }

    public ContactUsPage clickViewFullContactPage() {
        $x(viewFullContactPageSelector).click();

        return new ContactUsPage();
    }

    public void clickLanguageSwitcher() {
        $x(languageSwitcherSelector).click();
    }

    public String getTitle() {
        return $x(titleSelector).getText();
    }
}
