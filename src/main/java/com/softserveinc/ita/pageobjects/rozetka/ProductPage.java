package com.softserveinc.ita.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends RozetkaBasePage {

    private WebElement wishlist;
    private WebElement id;

    public ProductPage(WebDriver driver) {
        super(driver);
        wishlist = driver.findElement(By.xpath("//li[@class = 'product-actions__item']//button[contains(@class, 'wish-button')]"));
        id = driver.findElement(By.xpath("//p[@class = 'product__code detail-code']"));
    }

    public void addWish() {
        wishlist.click();
    }

    public String getId() {
        return id.getText().replaceAll("[^0-9]", "");
    }
}
