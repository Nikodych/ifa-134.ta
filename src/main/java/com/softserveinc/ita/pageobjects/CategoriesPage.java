package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.models.RandomUtil.getRandomNumber;
import static java.time.Duration.ofSeconds;

public class CategoriesPage extends BasePage<CategoriesPage> {

    public CategoriesPage openSubCategory() {
        $x("(//a[contains(@class,'tile-cats__heading')])[1]").click();

        return this;
    }

    public ProductPage openProduct() {
        $x("(//div[@class='goods-tile__inner'])[1]").click();

        return new ProductPage();
    }

    public CategoriesPage selectRequiredCategory(String categoryName) {
        $x("//a[@class ='menu-categories__link' and contains(text(),'" + categoryName + "')]").click();

        return this;
    }

    public SearchResultPage selectRandomSubCategory() {
        var list = $$x("//*[@Class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted']")
                .shouldBe(sizeNotEqual(0), ofSeconds(10));
        list
                .get(getRandomNumber(list.size()))
                .click();

        return new SearchResultPage();
    }
}