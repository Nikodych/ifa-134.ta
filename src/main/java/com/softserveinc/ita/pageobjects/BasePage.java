package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.ita.models.LanguageSwitcher;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static com.softserveinc.ita.models.RandomUtil.getRandomNumber;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

//TODO: move methods not related to this page to other page objects
public abstract class BasePage<T extends BasePage<T>> {

    private final SelenideElement searchButtonElement = $x("//button[contains(@class, 'search-form__submit')]");

    @Step("BasePage: open side menu")
    public MenuModal openSideMenu() {
        $x("//button[@class = 'header__button']").click();

        return new MenuModal();
    }

    @Step("BasePage: open catalog")
    public CatalogModal openCatalog() {
        $x("//button[contains(@id, 'fat-menu')]").click();

        return new CatalogModal();
    }

    @Step("BasePage: set text '{inputText}' in search bar")
    public T setTextInSearchBar(String inputText) {
        var search = $x("//input[@name = 'search']");
        search.click();
        search.clear();
        search.setValue(inputText);

        return (T) this;
    }

    @Step("BasePage: perform search")
    public SearchResultPage performSearch() {
        searchButtonElement.click();

        return new SearchResultPage();
    }

    @Step("BasePage: open user modal window")
    public UserModal openUserModalWindow() {
        $x("//rz-user[@class='header-actions__component']").click();

        return new UserModal();
    }

    @Step("BasePage: open basket")
    public BasketModal openBasket() {
        $x("//rz-cart[@class = 'header-actions__component']").click();

        return new BasketModal();
    }

    @Step("BasePage: switch language to {language}")
    public BasePage<T> switchLanguageTo(LanguageSwitcher language) {
        $x(format("//a[contains(@class, 'lang__link') and contains(text(), '%s')]", language.name())).click();

        return this;
    }

    @Step("BasePage: verify that language was switched to {language}")
    public boolean isLanguageSwitchedTo(LanguageSwitcher language) {
        var verificationWord = language.getVerificationWord();
        var searchButtonText = searchButtonElement.getText();

        return searchButtonText.equals(verificationWord);
    }

    @Step("BasePage: open '{categoryName}' category")
    public T selectRequiredCategory(String categoryName) {
        $x("//a[@class ='menu-categories__link' and contains(text(),'" + categoryName + "')]").click();

        return (T) this;
    }

    @Step("BasePage: select random sub category")
    public ProductPage selectRandomSubCategory() {
        var list = $$x("//*[@Class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted']")
                .shouldBe(sizeNotEqual(0), ofSeconds(10));
        list
                .get(getRandomNumber(list.size()))
                .click();

        return new ProductPage();
    }

    @Step("BasePage: close advertising banner if it's displayed")
    public T closeAdvertisingBannerIfDisplayed() {
        var banner = $("#rz-banner").should(exist);
        if (banner.isDisplayed()) {
            $("span .exponea-close-cross").click();
        }

        return (T) this;
    }
}
