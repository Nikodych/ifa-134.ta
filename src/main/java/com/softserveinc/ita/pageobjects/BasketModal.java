package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$;

public class BasketModal extends BasePage<BasketModal> {

    public CheckoutPage goToCheckout() {
        $("a.cart-receipt__submit").click();

        return new CheckoutPage();
    }

    public BasketModal addOneMoreProduct() {
        $("button.cart-counter__button:nth-of-type(2)").click();

        return this;
    }
}
