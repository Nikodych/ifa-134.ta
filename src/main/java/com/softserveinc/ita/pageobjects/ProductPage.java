package com.softserveinc.ita.pageobjects;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.*;

public class ProductPage extends BasePage<ProductPage> {

    private final String productCategorySelector = "//ul[@class = 'breadcrumbs ng-star-inserted']";
    private final String filteredItemsSelector = "//div[@class='goods-tile__inner']";
    private final String productNameSelector = "//h1[@class='product__title']";
    private final String productPriceSelector = "//p[contains(@Class, 'product-prices__big')]";
    private final String productAvailabilitySelector = "//p[@class='status-label status-label--green ng-star-inserted']";


    public String getProductCategory() {
        return $x(productCategorySelector).getText();
    }

    public void getFirstFilteredItem(int itemNumber) {
        var firstItem = $$x(filteredItemsSelector).get(itemNumber);

        firstItem
                .shouldBe(visible, ofSeconds(6))
                .click();
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
}