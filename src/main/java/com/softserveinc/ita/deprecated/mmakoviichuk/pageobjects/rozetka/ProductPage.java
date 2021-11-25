package com.softserveinc.ita.deprecated.mmakoviichuk.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends RozetkaBasePage {

    private final String wishlistButtonSelector = "//li[@class = 'product-actions__item']//button[contains(@class, 'wish-button')]";
    private final String productIdLabelSelector = "//p[@class = 'product__code detail-code']";

    public void addToWishlist() {
        $x(wishlistButtonSelector).click();
    }

    public String getProductId() {
        return $x(productIdLabelSelector)
                .getText()
                .replaceAll("[^0-9]", "");
    }
}
