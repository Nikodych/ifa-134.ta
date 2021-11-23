package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage>{

    private final String buySelector = "//button[contains(@class , 'buy-button button button_with_icon ')]";
    private final String productTitleSelector = "//h1[@class='product__title']";
    private final String productCategorySelector = "//ul[@class = 'breadcrumbs ng-star-inserted']";

    public BasketModal addToCart() {
        $x(buySelector).shouldBe(Condition.visible).click();
        Configuration.timeout = 8000;

        return new BasketModal();
    }

    public String getProductTitle() {
        return $x(productTitleSelector).getText();
    }

    public String getProductCategory() {
        return $x(productCategorySelector).getText();
    }
}