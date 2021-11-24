package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.ita.models.LanguageSwitcher;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public abstract class BasePage<T> {

    private final SelenideElement searchButtonElement = $x("//button[contains(@class, 'search-form__submit')]");

    public MenuModal openMenu() {
        $x("//button[@class = 'header__button']").click();

        return new MenuModal();
    }

    public CatalogModal openCatalog() {
        $x("//button[contains(@id, 'fat-menu')]").click();

        return new CatalogModal();
    }

    public T searchBarInputText(String inputText) {
        $x("//input[@name = 'search']").setValue(inputText);

        return (T) this;
    }

    public T search() {
        searchButtonElement.click();

        return (T) this;
    }

    public UserModal openUserModalWindow() {
        $x("//rz-user[@class='header-actions__component']").click();

        return new UserModal();
    }

    public BasketModal openBasket() {
        $x("//rz-cart[@class = 'header-actions__component']").click();

        return new BasketModal();
    }

    public T switchLanguageTo(LanguageSwitcher language) {
        $x(format("//a[contains(@class, 'lang__link') and contains(text(), '%s')]", language.name())).click();

        return (T) this;
    }

    public boolean isLanguageSwitchedTo(LanguageSwitcher language) {
        var verificationWord = language.getVerificationWord();
        var searchButtonText = searchButtonElement.getText();

        return searchButtonText.equals(verificationWord);
    }

    public T closeAdBanner() {
        if ($("#rz-banner")
                .should(exist)
                .isDisplayed()) {
            $("span .exponea-close-cross").click();
        }

        return (T) this;
    }
}
