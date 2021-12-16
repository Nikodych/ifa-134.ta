package com.softserveinc.ita.models.repos;

import com.softserveinc.ita.models.ProductModel;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.utils.NumberUtil.parseIntPrice;

public class ProductRepo {

    public static int getPrice() {
        return parseIntPrice($x("//p[contains(@class, 'product-prices__big')]").getText());
    }

    public static int getPriceBeforeDiscount() {
        return parseIntPrice($x("//p[contains(@class, 'product-prices__small')]").getText());
    }

    public static String getTitle() {
        return $x("//h1[@class='product__title']").getText();
    }

    public ProductModel getProductInfo() {
        return ProductModel.builder()
                .name(getTitle())
                .price(getPrice())
                .priceBeforeDiscount(getPriceBeforeDiscount())
                .build();
    }
}
