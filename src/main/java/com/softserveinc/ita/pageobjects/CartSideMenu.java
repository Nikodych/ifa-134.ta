package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartSideMenu extends RozetkaPageObject {
    private WebElement continueButton;
    private WebElement cartClose;
    private WebElement cartMenu;
    private WebElement deleteFromCart;

    public CartSideMenu(WebDriver driver) {
        super(driver);
        webElements();
    }
    private void webElements() {
         continueButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-footer.ng-star-inserted > a")));
         cartClose = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close ng-star-inserted']")));
         cartMenu = driver.findElement(By.xpath("//button[@class='button button--white button--small context-menu__toggle']"));
         deleteFromCart = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")));
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
    //functional voids
    public void removeFromCart() {
        clickCartMenu();
        clickDeleteFromCart();
    }
}
