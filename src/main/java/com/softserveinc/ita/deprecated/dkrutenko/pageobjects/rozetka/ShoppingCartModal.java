package com.softserveinc.ita.deprecated.dkrutenko.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartModal extends ShoppingCartPage {

    private final String cartContinueButtonSelector = "//a[@class='button button_size_medium button_color_gray cart-footer__continue ng-star-inserted']";
    private final String cartCloseButtonSelector = "//button[@class='modal__close ng-star-inserted']";
    private final String cartSideMenuButtonSelector = "//button[@class='button button--white button--small context-menu__toggle']";
    private final String deleteFromCartButtonSelector = "//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']";

    public void clickCartContinueButton() {
        $x(cartContinueButtonSelector).click();
    }

    public void clickShoppingCartCloseButton() {
        $x(cartCloseButtonSelector).click();
    }

    public void clickCartSideMenu() {
        $x(cartSideMenuButtonSelector).click();
    }

    public void clickDeleteFromShoppingCart() {
        $x(deleteFromCartButtonSelector).click();
    }

    public void deleteFromShoppingCart() {
        clickCartSideMenu();
        clickDeleteFromShoppingCart();
    }
}
