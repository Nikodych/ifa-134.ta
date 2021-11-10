package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends RozetkaBasePage {

    private final String wishlistButton = "//li[@class = 'product-actions__item']//button[contains(@class, 'wish-button')]";
    private final String productIdLabel = "//p[@class = 'product__code detail-code']";

    public void addToWishlist() {
        $x(wishlistButton).click();
    }

    public String getProductId() {
        return $x(productIdLabel)
                .getText()
                .replaceAll("[^0-9]", "");
    }
}
