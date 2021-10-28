package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ProductPage extends RozetkaBasePage {

    private By wishlistButton = xpath("//li[@class = 'product-actions__item']//button[contains(@class, 'wish-button')]");
    private By productIdLabel = xpath("//p[@class = 'product__code detail-code']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToWishlist() {
        driver.findElement(wishlistButton).click();
    }

    public String getProductId() {

        return driver
                .findElement(productIdLabel)
                .getText()
                .replaceAll("[^0-9]", "");
    }
}
