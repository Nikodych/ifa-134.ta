package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class CategoriesPage extends BasePage<CategoriesPage>{

    public CategoriesPage openSubCategory() {
        String subCategorySelector = "(//a[contains(@class,'tile-cats__heading')])[1]";
        $x(subCategorySelector).click();

        return this;
    }

    public ProductPage openProduct() {
        String productSelector = "(//div[@class='goods-tile__inner'])[1]";
        $x(productSelector).click();

        return new ProductPage();
    }
}