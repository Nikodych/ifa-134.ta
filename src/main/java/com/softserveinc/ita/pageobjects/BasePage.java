package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.ita.models.LanguageSwitcher;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

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

    public T searchBarInputField(String inputText) {
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
}
