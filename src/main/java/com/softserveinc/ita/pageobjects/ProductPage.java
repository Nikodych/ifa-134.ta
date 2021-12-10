package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static java.lang.String.format;

public class ProductPage extends BasePage<ProductPage> {

    private final String productSelector = "(//div[@class = 'goods-tile__inner'])";
    private final String productPriceSelector = "//p[contains(@Class, 'product-prices__big')]";
    private final String PRODUCT_TAB_SELECTOR_TEMPLATE = "//li[contains(@Class,'tabs__item')]/a[contains(text(),'%s')]";

    public String getPriceFromFirstItem() {
        return $x("//ul[@class='catalog-grid ng-star-inserted']/li[1]//span[@class='goods-tile__price-value']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    @Step("ProductPage: Added to cart")
    public BasketModal addToCart() {
        $x("//button[contains(@class,'buy-button button button_with_icon')]")
                .hover()
                .click();

        return new BasketModal();
    }

    public String getProductTitle() {
        return $x("//h1[@class='product__title']").getText();
    }

    public String getProductCategory() {
        return $x("//ul[@class='breadcrumbs ng-star-inserted']").getText();
    }

    @Step("ProductPage: Switched product tab to '{productTab}'")
    public ProductPage switchProductTabTo(String productTab) {
        $x(format(PRODUCT_TAB_SELECTOR_TEMPLATE, productTab)).click();

        return this;
    }

    public boolean isCorrectTabDisplayed() {
        var activeTabText = getActiveTabText();
        var productTabHeadingText = $("*.product-tabs__heading").getText();

        switch (activeTabText) {
            case "Купують разом":
                return productTabHeadingText.startsWith("Аксесуари");
            case "Залишити відгук":
                return productTabHeadingText.startsWith("Додати відгук");
            default:
                return productTabHeadingText.contains(activeTabText);
        }
    }

    private String getActiveTabText() {
        return $("a.tabs__link--active")
                .getText()
                .replaceAll("\\d", "");
    }

    public String getProductPrice() {
        return $x(productPriceSelector)
                .getText()
                .replaceAll("₴", " ")
                .trim();
    }

    public ProductPage openProductByNumber(int productNumber) {
        $$x(productSelector)
                .shouldBe(sizeGreaterThan(0), ofSeconds(10))
                .get(productNumber)
                .click();

        return this;
    }
}