package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public BasketModal addProductToBasket() {
        $("div.product-about__block button.buy-button").click();

        return new BasketModal();
    }

    public String getProductName() {
        return $("h1.product__title").getText();
    }
}
