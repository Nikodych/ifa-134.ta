package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.softserveinc.ita.models.LanguageSwitcher;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.time.Duration.*;

public abstract class BasePage<T extends BasePage<T>> {

    private final SelenideElement searchButtonElement = $x("//button[contains(@class, 'search-form__submit')]");

    public T clickOnMainPageLogo() {
        $x("//a[@class='header__logo']").click();

        return (T) this;
    }

    public MenuModal openSideMenu() {
        $x("//button[@class = 'header__button']").click();

        return new MenuModal();
    }

    public CatalogModal openCatalog() {
        $x("//button[contains(@id, 'fat-menu')]").click();

        return new CatalogModal();
    }

    public T setTextInSearchBar(String inputText) {
        var search = $x("//input[@name = 'search']");
        search.click();
        search.clear();
        search.setValue(inputText);

        return (T) this;
    }

    public SearchResultPage performSearch() {
        searchButtonElement.click();

        return new SearchResultPage();
    }

    public UserModal openUserModalWindow() {
        $x("//rz-user[@class='header-actions__component']").click();

        return new UserModal();
    }

    public BasketModal openBasket() {
        $x("//rz-cart[@class = 'header-actions__component']").click();

        return new BasketModal();
    }

    public BasePage<T> switchLanguageTo(LanguageSwitcher language) {
        $x(format("//a[contains(@class, 'lang__link') and contains(text(), '%s')]", language.name())).click();

        return this;
    }

    public boolean isLanguageSwitchedTo(LanguageSwitcher language) {
        var verificationWord = language.getVerificationWord();
        var searchButtonText = searchButtonElement.getText();

        return searchButtonText.equals(verificationWord);
    }

    public T closeAdvertisingBannerIfDisplayed() {
        var banner = $("#rz-banner").should(exist);
        if (banner.isDisplayed()) {
            $("span .exponea-close-cross").click();
        }

        return (T) this;
    }

    public T clickOnHeaderMenuButton() {
        $x("//button[@class='header__button']").click();

        return (T) this;
    }

    public T selectMobileAppLink(String appLink) {
        $x("//ul[@class='side-stores__buttons']//img[contains(@alt, '" + appLink + "')]")
                .shouldBe((visible), ofSeconds(8))
                .click();

        return (T) this;
    }

    public String getTitleFromGooglePlayApp() {
        return $x("//*[@class='AHFaub']//ancestor::span")
                .getAttribute("innerText");
    }

    public String getTitleFromAppStore() {
        return $x("//h1[@class='product-header__title app-header__title']").getText();
    }
}
