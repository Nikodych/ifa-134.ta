package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.*;
import com.softserveinc.ita.models.LanguageSwitcher;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.softserveinc.ita.utils.runners.ElementsUtil.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.time.Duration.*;


public abstract class BasePage<T> {

    private final SelenideElement searchButtonElement = $x("//button[contains(@class, 'search-form__submit')]");
    private final String selectFromPriceModalMenuSelector = "div > rz-sort > select";

    public MenuModal openMenu() {
        $x("//button[@class = 'header__button']").click();

        return new MenuModal();
    }

    public CatalogModal openCatalog() {
        $x("//button[contains(@id, 'fat-menu')]").click();

        return new CatalogModal();
    }

    public T closeAdvertisingBanner() {
        var banner = $x("//span[@class='exponea-close-cross']").shouldBe(visible);
        if (banner.isDisplayed()) {
            banner.click();
        }
        return (T) this;
    }

    public T setTextInSearchBar(String inputText) {
        var search = $x("//input[@name = 'search']");
        search.click();
        search.clear();
        search.setValue(inputText);

        return (T) this;
    }

    public List<String> getGoodsList(String item) {
        return getListWithGoods("//*[@class='goods-tile__title']", item);
    }

    public String getFirstRequiredItem(String item) {
        return getGoodsList(item)
                .stream()
                .findFirst()
                .toString();
    }

    public String getLastRequiredItem(String item) {
        var list = getGoodsList(item);

        return list.get(list.size() - 1);
    }

    public T clickSearchButton() {
        $x("//button[contains(@class, 'search-form__submit')]").click();

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

    public T selectCategory(String categoryName) {
        $x("//a[@class ='menu-categories__link' and contains(text(),'" + categoryName + "')]").click();

        return (T) this;
    }

    public T selectRandomSubCategory() {
        randomizerForListCategories("//*[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted']");

        return (T) this;
    }

    public T setMinimalPrice(String price) {
        setPriceValueInFilter("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']", price);

        return (T) this;
    }

    public T setMaximalPrice(String price) {
        setPriceValueInFilter("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']", price);

        return (T) this;
    }

    public String getPriceFromFirstItem() {
        return $x("//ul[@class='catalog-grid ng-star-inserted']/li[1]//span[@class='goods-tile__price-value']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    public T selectFromCheapToExpensive() {
        selectPriceFilterFromModalMenu(1, selectFromPriceModalMenuSelector);

        return (T) this;
    }

    public T selectFromExpensiveToCheap() {
        selectPriceFilterFromModalMenu(2, selectFromPriceModalMenuSelector);

        return (T) this;
    }

    public T clickOnPriceButton() {
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']").click();

        return (T) this;
    }
}
