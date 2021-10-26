package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartModal extends ShoppingCartPage {

    private WebElement cartContinueButton;
    private WebElement cartCloseButton;
    private WebElement cartMenu;
    private WebElement deleteFromCart;

    public ShoppingCartModal(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingCartContinueButton() {
        cartContinueButton = driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cart-footer.ng-star-inserted > a")));

        return cartContinueButton;
    }

    public void clickShoppingCartContinueButton() {
        getShoppingCartContinueButton().click();
    }

    public WebElement getShoppingCartCloseButton() {
        cartCloseButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close ng-star-inserted']")));

        return cartCloseButton;
    }

    public void clickShoppingCartCloseButton() {getShoppingCartCloseButton().click();}

    public WebElement getCartSideMenu() {
        cartMenu = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button--white button--small context-menu__toggle']")));

        return cartMenu;
    }

    public void clickCartSideMenu() {
        getCartSideMenu().click();
    }

    public WebElement getDeleteFromShoppingCart() {
        deleteFromCart = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")));

        return deleteFromCart;
    }

    public void clickDeleteFromShoppingCart() {
        getDeleteFromShoppingCart().click();
    }

    public void deleteFromShoppingCart() {
        clickCartSideMenu();
        clickDeleteFromShoppingCart();
    }
}
