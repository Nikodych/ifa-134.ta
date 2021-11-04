package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.xpath;

public class ProductPage extends RozetkaBasePage {

    private final By wishlistButton = xpath("//li[@class = 'product-actions__item']//button[contains(@class, 'wish-button')]");
    private final By productIdLabel = xpath("//p[@class = 'product__code detail-code']");

    public void addToWishlist() {
        $x(wishlistButton).click();
    }

    public String getProductId() {
        return $x(productIdLabel)
                .getText()
                .replaceAll("[^0-9]", "");
    }
}
