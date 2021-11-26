package com.softserveinc.ita.pageobjects;

import com.softserveinc.ita.models.LanguageSwitcher;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.softserveinc.ita.models.RandomUtil.getRandomNumber;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<T extends BasePage<T>> {

    private final SelenideElement searchButtonElement = $x("//button[contains(@class, 'search-form__submit')]");

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

    public T selectRequiredCategory(String categoryName) {
        $x("//a[@class ='menu-categories__link' and contains(text(),'" + categoryName + "')]").click();

        return (T) this;
    }

    public ProductPage selectRandomSubCategory() {
        var list = $$x("//*[@Class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted']")
                .shouldBe(sizeNotEqual(0), ofSeconds(10));
        list
                .get(getRandomNumber(list.size()))
                .click();

        return new ProductPage();
    }

    public T closeAdBanner() {
        var banner = $("#rz-banner")
                .should(exist);
               if(banner.isDisplayed()) {
            $("span .exponea-close-cross").click();
        }

        return (T) this;
    }
}
