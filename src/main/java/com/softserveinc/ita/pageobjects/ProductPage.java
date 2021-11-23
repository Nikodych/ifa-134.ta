package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage>{

    private final String productCategorySelector = "//ul[@class = 'breadcrumbs ng-star-inserted']";

    public String getProductCategory() {
        return $x(productCategorySelector).getText();
    }
}
