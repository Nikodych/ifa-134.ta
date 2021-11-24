package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class CategoriesPage extends BasePage<CategoriesPage>{

    public CategoriesPage openSubCategory() {
        $x("(//a[contains(@class,'tile-cats__heading')])[1]").click();

        return this;
    }

    public ProductPage openProduct() {
        $x("(//div[@class='goods-tile__inner'])[1]").click();

        return new ProductPage();
    }
}