package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<T> {

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
}
