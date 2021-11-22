package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.*;
import com.softserveinc.ita.models.LanguageSwitcher;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.softserveinc.ita.utils.runners.ElementsUtil.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.time.Duration.*;
import static java.util.stream.Collectors.*;
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

    public void searchBarInputField(String inputText) {
        var search = $x("//input[@name = 'search']");
        search.click();
        search.clear();
        search.setValue(inputText);
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
        var list = getGoodsList(item);

        return list.get(list.size() - 1);
    }

    public void clickSearchButton() {
        $x("//button[contains(@class, 'search-form__submit')]").click();
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

    public void selectCategory() {
        $x("//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//a[contains(@href, 'telefony')]").click();
    }

    public void selectSubcategory() {
        $x("//div[@class='tile-cats']//a[contains(@href, 'all-tv')]").click();
    }

    public void selectRandomSubCategory() {
        var random = new Random();
        var list = $$x("//*[@class='portal-grid__cell ng-star-inserted']");
        var randomCategory = list.get(random.nextInt(list.size()));
        randomCategory.click();
    }

    public T setMinimalPrice(String price) {
        var minPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']");
        minPriceField.click();
        minPriceField.setValue(price);

        return (T) this;
    }

    public void setMaximalPrice(String price) {
        var maxPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']");
        maxPriceField.click();
        maxPriceField.setValue(price);
    }

    public String listOfPrices(String price) {
        var list = $$x("//span[@class='goods-tile__price-value']")
                .stream()
                .map(SelenideElement::text)
                .filter(text->text.contains(price))
                .collect(toList());

        return list.get(0);
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
