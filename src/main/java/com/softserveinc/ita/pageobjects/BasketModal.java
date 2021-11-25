package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketModal extends BasePage<BasketModal> {

    public String getProductTitle() {
        return $x("//a[@class = 'cart-product__title']").getText();
    }

    public CheckoutPage goToCheckout() {
        $("a.cart-receipt__submit").click();

        return new CheckoutPage();
    }

    public BasketModal addOneMoreProduct() {
        $("button.cart-counter__button:nth-of-type(2)").click();

        return this;
    }
}
