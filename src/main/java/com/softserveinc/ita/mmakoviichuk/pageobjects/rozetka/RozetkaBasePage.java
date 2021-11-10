package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public abstract class RozetkaBasePage {

    private final String dropdownCategorySelector = "//ul[@class = 'menu-categories ng-star-inserted']/li/a";
    private final String catalogButtonSelector  = "//button[@id='fat-menu']";
    private final String loginButtonSelector = "//li[contains(@class , 'user')]";
    private final String emailInputSelector = "//input[@id = 'auth_email']";
    private final String passwordInputSelector = "//input[@id = 'auth_pass']";
    private final String enterButtonSelector = "//button[contains(@class , 'auth-modal__submit')]";
    private final String wishListIconSelector  = "//li[contains(@class, 'wishlist')]";

    public String getDropdownCategoryUrl(int index) {
        $x(catalogButtonSelector).click();
        var dropCatUrl = getDropdownCategoryList()
                .get(index)
                .getAttribute("href")
                .replaceAll("https://rozetka.com.ua|https://rozetka.com.ua/ua", "");
        $x(catalogButtonSelector).click();

        return dropCatUrl;
    }

    public void openCategoryFromDropdown(int index) {
        getDropdownCategoryList()
                .get(index)
                .click();
    }

    public void logIn(String email, String password) {
        $x(loginButtonSelector).click();
        $x(emailInputSelector).sendKeys(email);
        $x(passwordInputSelector).sendKeys(password);
        $x(enterButtonSelector).click();
    }

    public WishlistPage openWishList() {
        $x(wishListIconSelector ).click();

        return new WishlistPage();
    }

    public ElementsCollection getDropdownCategoryList() {
        $x(loginButtonSelector).click();

        return Selenide.$$x(dropdownCategorySelector);
    }
}
