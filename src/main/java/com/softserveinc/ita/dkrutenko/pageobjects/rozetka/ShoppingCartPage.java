package com.softserveinc.ita.dkrutenko.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ShoppingCartPage extends BasePage {

    private final By addToCartButtonSelector = xpath("//*[@class='buy-button__label ng-star-inserted']");
    private final By cartButtonSelector = xpath("//rz-cart[@class='header-actions__component']");
    private final By cartProductTitleLabelSelector = xpath("//a[@class='cart-product__title']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButtonSelector).click();
    }

    public void clickCartButton() {
        waitForElementVisibility(cartButtonSelector).click();
    }

    public String getProductTitle() {
        return waitForElementVisibility(cartProductTitleLabelSelector).getText();
    }
}
