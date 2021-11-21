package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.softserveinc.ita.repos.CustomerOrderDataRepo.getCustomerOrderData;
import static java.lang.Integer.parseInt;

public class CheckoutPage extends BasePage<CheckoutPage> {

    private final SelenideElement cityDropdownElement = $("li.autocomplete__item");
    private final SelenideElement surnameFieldElement = $("div.js-surname input");
    private final SelenideElement nameFieldElement = $("div.js-name input");
    private final SelenideElement phoneFieldElement = $("div.js-phone input");
    private final SelenideElement cityFieldElement = $("div.js-city input");

    public String getSurnameFieldText() {
        return surnameFieldElement.getValue();
    }

    public String getNameFieldText() {
        return nameFieldElement.getValue();
    }

    public String getPhoneFieldText() {
        return phoneFieldElement.getValue();
    }

    public String getCityFieldText() {
        return cityFieldElement.getValue();
    }

    public CheckoutPage inputCustomerData() {
        surnameFieldElement.setValue(getCustomerOrderData().getSurname());
        nameFieldElement.setValue(getCustomerOrderData().getName());
        phoneFieldElement.setValue(getCustomerOrderData().getPhone());
        var customerCity = cityFieldElement.setValue(getCustomerOrderData().getCity());

        if (cityDropdownElement
                .getText()
                .contains(customerCity.getText())) {
            cityDropdownElement.click();
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
