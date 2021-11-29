package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

//TODO: move methods not related to this page to other page objects
public class ProductPage extends BasePage<ProductPage> {

    public String getPriceFromFirstItem() {
        return $x("//ul[@class='catalog-grid ng-star-inserted']/li[1]//span[@class='goods-tile__price-value']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    public BasketModal addToCart() {
        $x("//button[contains(@class,'buy-button button button_with_icon')]")
                .hover()
                .click();

        return new BasketModal();
    }

    public ProductPage getProductTitle() {
        $x("//h1[@class='product__title']").getText();

        return this;
    }

    public String getProductCategory() {
        return $x("//ul[@class='breadcrumbs ng-star-inserted']").getText();
    }

    public ProductPage selectFirstItemFromProductPage() {
        var requiredItem = $$x("//div[@class='goods-tile__inner']")
                .stream()
                .findFirst()
                .get();

        requiredItem
                .shouldBe(visible, ofSeconds(8))
                .click();

        return new ProductPage();
    }
}

