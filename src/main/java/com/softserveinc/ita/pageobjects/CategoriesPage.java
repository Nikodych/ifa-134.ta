package com.softserveinc.ita.pageobjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class CategoriesPage extends BasePage<CategoriesPage> {

    @Step("CategoriesPage: open sub category")
    public CategoriesPage openSubCategory() {
        $x("(//a[contains(@class,'tile-cats__heading')])[1]").click();

        return this;
    }

    @Step("CategoriesPage: open product")
    public ProductPage openProduct() {
        $x("(//div[@class='goods-tile__inner'])[1]").click();

        return new ProductPage();
    }
}