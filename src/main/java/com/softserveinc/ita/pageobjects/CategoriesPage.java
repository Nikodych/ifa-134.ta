package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CategoriesPage extends BasePage<CategoriesPage>{

    private final String subCategorySelector = "(//a[contains(@class , 'tile-cats__heading')])[1]";
    private final String productSelector = "(//div[@class = 'goods-tile__inner'])[1]";

    public CategoriesPage openSubCategory() {
        $x(subCategorySelector).click();

        return this;
    }

    public CategoriesPage openProduct() {
        $x(productSelector).click();

        return this;
    }
}