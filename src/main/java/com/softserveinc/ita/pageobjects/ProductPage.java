package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage>{

    public BasketModal addToCart() {
        String buySelector = "//button[contains(@class,'buy-button button button_with_icon')]";
        $x(buySelector)
                .hover()
                .click();

        return new BasketModal();
    }

    public String getProductTitle() {
        String productTitleSelector = "//h1[@class='product__title']";

        return $x(productTitleSelector).getText();
    }

    public String getProductCategory() {
        String productCategorySelector = "//ul[@class='breadcrumbs ng-star-inserted']";

        return $x(productCategorySelector).getText();
    }
}