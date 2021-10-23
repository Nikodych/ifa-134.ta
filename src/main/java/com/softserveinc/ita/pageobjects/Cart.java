package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cart extends RozetkaPageObject {

    private WebElement addToCartButton;
    private WebElement cart;
    private WebElement itemString;

    public Cart(WebDriver driver) {
        super(driver);
        webElements();
    }

    private void webElements() {
        addToCartButton = driver.findElement(By.xpath("//*[@class='buy-button__label ng-star-inserted']"));
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }
    public WebElement getCart() {
        cart = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//rz-cart[@class='header-actions__component']")));

        return cart;
    }

    public void clickCart() {
        getCart().click();
    }

    public String itemString() {
        itemString = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cart-product__title']")));
        String expected = itemString.getText();

        return expected;
    }
    }
