package com.softserveinc.ita.pkuravskyi.pageobjects;

import com.softserveinc.ita.pkuravskyi.models.LanguageSwitcher;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class RozetkaPage extends BasePage<RozetkaPage> {

    private final String CATEGORIES_LIST_TEMPLATE = "//a[@class ='menu-categories__link' and contains(text(), '%s')]";
    private final String selectedCategorySelector = "//h1[@class = 'portal__heading ng-star-inserted']";
    private final String selectedProductSelector = "//h1[@class = 'catalog-heading ng-star-inserted']";
    private final String LANGUAGE_SWITCH_BUTTON_TEMPLATE = "//a[contains(@class, 'lang__link') and contains(text(), '%s')]";

    public RozetkaPage() {
        searchBar = "//input[contains(@class, 'search-form__input')]";
        searchButton = "//button[contains(@class, 'search-form__submit')]";
    }

    public RozetkaPage changeLanguageTo(LanguageSwitcher language) {
        $x(format(LANGUAGE_SWITCH_BUTTON_TEMPLATE, language.name())).click();

        return this;
    }

    public boolean isLanguageChangedTo(LanguageSwitcher language) {
        var verificationWord = language.getVerificationWord();

        return $(searchButton)
                .getText()
                .contains(verificationWord);
    }

    public RozetkaPage selectCategory(String categoryName) {
        $x(format(CATEGORIES_LIST_TEMPLATE, categoryName)).click();

        return this;
    }

    public String getSelectedCategoryName() {
        return $x(selectedCategorySelector).getText();
    }

    public String getSelectedProductName() {
        return $x(selectedProductSelector).getText();
    }

}
