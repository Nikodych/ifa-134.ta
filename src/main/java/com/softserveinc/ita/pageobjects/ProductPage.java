package com.softserveinc.ita.pageobjects;


import com.softserveinc.ita.pageobjects.modals.BasketModal;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.utils.NumberUtil.parseIntPrice;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

//TODO: move methods not related to this page to other page objects
public class ProductPage extends BasePage<ProductPage> {

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

    public int getProductPrice() {
        return parseIntPrice($x("//p[contains(@class, 'product-prices__big')]").getText());
    }

    public int getProductPriceBeforeDiscount() {
        return parseIntPrice($x("//p[contains(@class, 'product-prices__small')]").getText());
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
        var productTabHeadingText = $("main *.product-tabs__heading")
                .shouldBe(visible)
                .getText();

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

    @Step("ProductPage: Switched photo to '{index}'")
    public ProductPage switchPhotoTo(int index) {
        $x(format("//li[@class = 'gallery-thumbnails__item ng-star-inserted'][%s]", index)).hover();

        return this;
    }

    public String getImgSource() {
        return $x("//img[@class = 'picture-container__picture']").getAttribute("src");
    }
}

