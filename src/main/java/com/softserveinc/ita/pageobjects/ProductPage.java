package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage>{

    private final String categorySelector = "//ul[@class = 'breadcrumbs ng-star-inserted']";
    private final String buySelector = "//button[contains(@class , 'buy-button button button_with_icon ')]";
    private final String productTitleSelector = "//h1[@class='product__title']";

    public boolean isCategoryCorrect(String title) {
        return $x(categorySelector).getText().contains(title);
    }

    public BasketModal addToCart() {
        $x(buySelector).click();

        return new BasketModal();
    }

    public String getProductTitle() {
        return $x(productTitleSelector).getText();
    }
}