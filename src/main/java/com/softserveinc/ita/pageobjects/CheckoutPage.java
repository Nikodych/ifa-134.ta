package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.softserveinc.ita.repos.CustomerOrderDataRepo.getCustomerOrderData;
import static java.lang.Integer.parseInt;

public class CheckoutPage extends BasePage<CheckoutPage> {

    private final String cityDropdownSelector = "li.autocomplete__item";
    private final String surnameField = "div.js-surname input";
    private final String nameField = "div.js-name input";
    private final String phoneField = "div.js-phone input";
    private final String cityField = "div.js-city input";

    public String getSurnameFieldText() {
        return $(surnameField).getValue();
    }

    public String getNameFieldText() {
        return $(nameField).getValue();
    }

    public String getPhoneFieldText() {
        return $(phoneField).getValue();
    }

    public String getCityFieldText() {
        return $(cityField).getValue();
    }

    public CheckoutPage inputCustomerData() {
        $(surnameField).setValue(getCustomerOrderData().getSurname());
        $(nameField).setValue(getCustomerOrderData().getName());
        $(phoneField).setValue(getCustomerOrderData().getPhone());
        var customerCity = $(cityField).setValue(getCustomerOrderData().getCity());

        if ($(cityDropdownSelector)
                .getText()
                .contains(customerCity.getText())) {
            $(cityDropdownSelector).click();
        }

        return this;
    }

    public BasketModal editOrder() {
        $("a.checkout-product__edit-button").click();

        return new BasketModal();
    }

    public int getProductPrice() {
        var productPrice = $("span.checkout-product__price_color_red")
                .getText()
                .replaceAll(" ₴", "");

        return parseInt(productPrice);
    }

    public int getProductAmountPrice() {
        var productAmountPrice = $(".js-product-amount dd")
                .getText()
                .replaceAll(" ₴", "");

        return parseInt(productAmountPrice);
    }

    public int getProductCount() {
        var productCount = $(".js-product-quantity dd")
                .getText();

        return parseInt(productCount);
    }
}
