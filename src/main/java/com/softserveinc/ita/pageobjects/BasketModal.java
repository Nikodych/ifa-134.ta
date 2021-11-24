package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class BasketModal extends BasePage<BasketModal> {

    public String getProductTitle() {
        String productTitleSelector = "//a[@class = 'cart-product__title']";

        return $x(productTitleSelector).getText();
    }
}
