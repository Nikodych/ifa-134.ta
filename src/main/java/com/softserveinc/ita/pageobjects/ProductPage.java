package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage<ProductPage>{

    private final String categorySelector = "//ul[@class = 'breadcrumbs ng-star-inserted']";

    public boolean isCategoryCorrect(String title) {
        return $x(categorySelector).getText().contains(title);
    }
}
