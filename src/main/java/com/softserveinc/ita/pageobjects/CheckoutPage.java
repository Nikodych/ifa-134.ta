package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.ita.models.CustomerOrderData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class CheckoutPage extends BasePage<CheckoutPage> {

    private final SelenideElement surnameFieldElement = $("div.js-surname input");
    private final SelenideElement nameFieldElement = $("div.js-name input");
    private final SelenideElement phoneFieldElement = $("div.js-phone input");
    private final SelenideElement cityFieldElement = $("div.js-city input");
    private final String CITY_DROPDOWN_SELECTOR_TEMPLATE = "//li[contains(@Class,'autocomplete__item')]/b[normalize-space()=contains(text(),'%s')]";

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

    public CheckoutPage setCustomerData(CustomerOrderData customerOrderData) {
        surnameFieldElement.setValue(customerOrderData.getSurname());
        nameFieldElement.setValue(customerOrderData.getName());
        phoneFieldElement.setValue(customerOrderData.getPhone());
        cityFieldElement.setValue(customerOrderData.getCity());

        var cityDropdownItem = $x(format(CITY_DROPDOWN_SELECTOR_TEMPLATE, customerOrderData.getCity()));
        if (cityDropdownItem
                .getText()
                .contains(customerOrderData.getCity())) {
            cityDropdownItem.click();
        }

        return this;
    }

    public BasketModal editOrder() {
        $("a.checkout-product__edit-button")
                .shouldBe(visible)
                .click();

        return new BasketModal();
    }

    public int getProductPrice() {
        var productPrice = $("span.checkout-product__price_color_red")
                .getText()
                .replaceAll(" ₴", "");

        return parseInt(productPrice);
    }

    public int getProductTotalPrice() {
        var productTotalPrice = $(".js-product-amount dd")
                .getText()
                .replaceAll(" ₴", "");

        return parseInt(productTotalPrice);
    }

    public int getProductQuantity() {
        var productQuantity = $(".js-product-quantity dd").getText();

        return parseInt(productQuantity);
    }
}
