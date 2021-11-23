package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class CategoriesPage extends BasePage<CategoriesPage>{

    private final String subCategorySelector = "(//a[contains(@class , 'tile-cats__heading')])[1]";
    private final String productSelector = "(//div[@class = 'goods-tile__inner'])[1]";

    public CategoriesPage openSubCategory() {
        $x(subCategorySelector).click();

        return this;
    }

    public ProductPage openProduct() {
        $x(productSelector).click();

        return new ProductPage();
    }
}
