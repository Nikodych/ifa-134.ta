package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.parseInt;

public class ProductPage extends BasePage<ProductPage> {

    private final String productCategorySelector = "//ul[@class = 'breadcrumbs ng-star-inserted']";
    private final String filteredItemsSelector = "//div[@class='goods-tile__inner']";
    private final String productNameSelector = "//h1[@class='product__title']";
    private final String productPriceSelector = "//p[@class='product-prices__big']";
    private final String productAvailabilitySelector = "//p[@class='status-label status-label--green ng-star-inserted']";


    public String getProductCategory() {
        return $x(productCategorySelector).getText();
    }

    public void getFirstFilteredItem() {
        var firstItem = $$x(filteredItemsSelector)
                .stream()
                .findFirst()
                .get();

        firstItem
                .shouldBe(visible)
                .click();
    }

    public String getProductTitle() {
        return $x(productNameSelector).getText();
    }

    public String getProductPrice() {
        var itemPrice = $x(productPriceSelector)
                .getText()
                .replaceAll("₴", " ")
                .trim();

        return itemPrice;
    }

    public boolean getItemStatus() {
        var status = $x(productAvailabilitySelector).isDisplayed();

        return status;
    }
}