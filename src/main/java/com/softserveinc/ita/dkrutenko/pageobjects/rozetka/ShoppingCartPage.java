package com.softserveinc.ita.dkrutenko.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartPage extends BasePage {

    private final String addToCartButtonSelector = "//*[@class='buy-button__label ng-star-inserted']";
    private final String cartButtonSelector = "//rz-cart[@class='header-actions__component']";
    private final String cartProductTitleLabelSelector = "//a[@class='cart-product__title']";

    public ShoppingCartModal clickAddToCartButton() {
        $x(addToCartButtonSelector).click();

        return new ShoppingCartModal();
    }

    public void clickCartButton() {
        $x(cartButtonSelector).click();
    }

    public String getProductTitle() {
        return $x(cartProductTitleLabelSelector).getText();
    }
}
