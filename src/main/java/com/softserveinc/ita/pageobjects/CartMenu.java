package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartMenu extends RozetkaPageObject {
    private WebElement addToCartButton;
    private WebElement continueButton;
    private WebElement cartClose;
    private WebElement cartMenu;
    private WebElement deleteFromCart;

    public CartMenu(WebDriver driver) {
        super(driver);
        webElements();
    }
    private void webElements() {
        addToCartButton = driver.findElement(By.xpath("//*[@class='buy-button__label ng-star-inserted']"));
        continueButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-footer.ng-star-inserted > a")));
        continueButton = driver.findElement(By.cssSelector("div.cart-footer.ng-star-inserted > a"));
        cartClose = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close ng-star-inserted']")));
        cartMenu = driver.findElement(By.xpath("//button[@class='button button--white button--small context-menu__toggle']"));
        deleteFromCart = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")));
    }
    //----------------------------------------page object---------------------------------------------
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }
    //continue shopping button
    public WebElement getContinueButton() {
        return continueButton;
    }
    public void clickContinueButton() {
        getContinueButton().click();
    }
    //cart close (X)
    public WebElement getCartClose() {
        return cartClose;
    }
    public void clickCartClose() {
        getCartClose().click();
    }
    //cart context menu
    public WebElement getCartMenu() {
        return cartMenu;
    }
    public void clickCartMenu() {
        getCartMenu().click();
    }
    //delete from cart in context menu
    public WebElement getDeleteFromCart() {
        return deleteFromCart;
    }
    public void clickDeleteFromCart() {
        getDeleteFromCart().click();
    }
    //functional
    public void removeFromCart() {
        clickCartMenu();
        clickDeleteFromCart();
    }
    }