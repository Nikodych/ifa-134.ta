package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class BasketModal extends BasePage<BasketModal> {

    private final String productTitleSelector = "//a[@class = 'cart-product__title']";

    public boolean isProductInBasket(String productTitle) {
        return $x(productTitleSelector).getText().contains(productTitle);
    }
}
