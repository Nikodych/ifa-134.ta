package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public abstract class RozetkaBasePage {

    private final String DROPDOWN_CATEGORY_SELECTOR_TEMPLATE = "//a[@class = 'menu-categories__link js-menu-categories__link' and contains(text(), '%s')]";
    private final String catalogButtonSelector  = "//button[@id='fat-menu']";
    private final String loginButtonSelector = "//li[contains(@class , 'user')]";
    private final String emailInputSelector = "//input[@id = 'auth_email']";
    private final String passwordInputSelector = "//input[@id = 'auth_pass']";
    private final String enterButtonSelector = "//button[contains(@class , 'auth-modal__submit')]";
    private final String wishListIconSelector  = "//li[contains(@class, 'wishlist')]";

    public void openCategoryFromDropdown(String title) {
        $x(catalogButtonSelector).click();
        $x(format(DROPDOWN_CATEGORY_SELECTOR_TEMPLATE, title)).click();
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
}
