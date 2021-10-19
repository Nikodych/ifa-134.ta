package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart extends RozetkaPageObject {
    private WebElement addToCartButton;
    private WebElement cart;

    public Cart(WebDriver driver) {
        super(driver);
        webElements();
    }
    private void webElements() {
        addToCartButton = driver.findElement(By.xpath("//*[@class='buy-button__label ng-star-inserted']"));
        cart = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted']"));
    }
    //----------------------------------------page object---------------------------------------------
    public WebElement getAddToCartButton() {return addToCartButton; }
    public void clickAddToCartButton() {getAddToCartButton().click(); }
    public WebElement getCart() {return cart; }
    public void clickCart() {getCart().click(); }
}