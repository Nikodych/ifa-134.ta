package com.softserveinc.ita.dkrutenko.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    private final String searchFieldSelector = "//input[@name = 'search']";
    private final String searchButtonSelector = "//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']";
    private final String logoIconSelector = "//a[@class='header__logo']";
    private final String languageButtonSelector = "//a[@class='lang__link ng-star-inserted']";
    private final String marketNameLabelSelector = "//p[@class='main-copyright_color_gray']";
    private final String userButtonSelector = "//rz-user[@class='header-actions__component']";

    public void clickSearchButton() {
        $x(searchButtonSelector).click();
    }

    public void clickLogoIcon() {
        $x(logoIconSelector).click();
    }

    public void clickLanguageButton() {
        $x(languageButtonSelector).click();
    }

    public String getMarketNameTitle() {
        return $x(marketNameLabelSelector).getText();
    }

    public void clickUserButton() {
        $x(userButtonSelector).click();
    }

    public void fillSearchField(String text) {
        var search = $x(searchFieldSelector);

        search.click();
        search.clear();
        search.sendKeys(text);
    }
}
