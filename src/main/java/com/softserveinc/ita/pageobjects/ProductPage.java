package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class ProductPage extends BasePage<ProductPage> {

    private final String productCategorySelector = "//ul[@class = 'breadcrumbs ng-star-inserted']";
    private final String productSelector = "(//div[@class = 'goods-tile__inner'])";
    private final String productNameSelector = "//h1[@class='product__title']";
    private final String productPriceSelector = "//p[contains(@Class, 'product-prices__big')]";
    private final String productAvailabilitySelector = "//p[@class='status-label status-label--green ng-star-inserted']";

    public String getProductCategory() {
        return $x(productCategorySelector).getText();
    }

    public String getProductTitle() {
        return $x(productNameSelector)
                .getText()
                .trim();
    }

    public String getProductPrice() {
        return $x(productPriceSelector)
                .getText()
                .replaceAll("₴", " ")
                .trim();
    }

    public String getItemStatus() {
        var productStatus =  $x(productAvailabilitySelector)
                .getText()
                .trim();

        return productStatus;
    }

    public ProductPage openProductByNumber(int productNumber) {
        $$x(productSelector)
                .shouldBe(sizeGreaterThan(0), ofSeconds(10))
                .get(productNumber)
                .click();

        return this;
    }
}