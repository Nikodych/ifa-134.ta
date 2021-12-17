package com.softserveinc.ita.pageobjects;

import com.softserveinc.ita.models.Product;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.utils.NumberUtil.parseIntPrice;

public class ProductModel {

    public static int getPrice() {
        return parseIntPrice($x("//p[contains(@class, 'product-prices__big')]").getText());
    }

    public static int getPriceBeforeDiscount() {
        return parseIntPrice($x("//p[contains(@class, 'product-prices__small')]").getText());
    }

    public static String getTitle() {
        return $x("//h1[@class='product__title']").getText();
    }

    public Product getProductInfo() {
        return Product.builder()
                .name(getTitle())
                .price(getPrice())
                .priceBeforeDiscount(getPriceBeforeDiscount())
                .build();
    }
}
