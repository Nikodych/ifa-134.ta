package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    private String menuButtonSelector = "//button[@class = 'header__button']";
    private String catalogButtonSelector = "//button[contains(@class, 'menu__toggle')]";
    private String searchBarSelector = "//input[@name = 'search']";
    private String searchButtonSelector = "//button[contains(@class, 'search-form__submit')]";
    private String logInButtonSelector = "//rz-user[@class='header-actions__component']";
    private String basketButtonSelector = "//rz-cart[@class = 'header-actions__component']";

    public BasePage openMenu() {
        $x(menuButtonSelector).click();

        return this;
    }

    public BasePage openCatalog() {
        $x(catalogButtonSelector).click();

        return this;
    }

    public BasePage searchBarInputText(String inputText) {
        $x(searchBarSelector).setValue(inputText);

        return this;
    }

    public BasePage search() {
        $x(searchButtonSelector).click();

        return this;
    }

    public BasePage openLogInMenu() {
        $x(logInButtonSelector).click();

        return this;
    }

    public BasePage openBasket() {
        $x(basketButtonSelector).click();

        return this;
    }
}
