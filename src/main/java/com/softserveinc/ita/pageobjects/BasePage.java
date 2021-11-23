package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.*;
import com.softserveinc.ita.models.LanguageSwitcher;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.softserveinc.ita.utils.runners.ElementsUtil.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

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

    public T setTextInSearchBar(String inputText) {
        var search = $x("//input[@name = 'search']");
        search.click();
        search.clear();
        search.setValue(inputText);

        return (T) this;
    }

    public List<String> getGoodsList(String item) {
        return $$x("//*[@class='goods-tile__title']")
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(toList());
    }

    public String getFirstRequiredItem(String item) {
        return getGoodsList(item)
                .stream()
                .findFirst()
                .toString();
    }

    public String getLastRequiredItem(String item) {
        timeout = 8000;
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
        $x("//a[@class ='menu-categories__link' and contains(text(),'"+categoryName+"')]").click();

    return (T) this;
    }

    public void selectRandomSubCategory() {
        var random = new Random();
        timeout = 15000;
        var list = $$x("//*[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted']")
                .shouldBe(sizeGreaterThan(0));
        list
                .get(random.nextInt(list.size()))
                .click();
    }

    public T setMinimalPrice(String price) {
        var minPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']");
        timeout = 5000;
        minPriceField.click();
        minPriceField.setValue(price);

        return (T) this;
    }

    public T setMaximalPrice(String price) {
        var maxPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']");
        timeout = 5000;
        maxPriceField.click();
        maxPriceField.setValue(price);

        return (T) this;
    }

    public String getFirstItemPrice(String itemPrice) {
        return $x("//span[@class='goods-tile__price-value']")
                .shouldHave(text(itemPrice), Duration.ofSeconds(12))
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
