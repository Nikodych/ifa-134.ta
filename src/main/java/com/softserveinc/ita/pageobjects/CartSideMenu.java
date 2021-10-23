package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartSideMenu extends Cart {

    private WebElement cartContinue;
    private WebElement cartClose;
    private WebElement cartMenu;
    private WebElement deleteFromCart;

    public CartSideMenu(WebDriver driver) {
        super(driver);
    }

    public WebElement getContinueButton() {
        cartContinue = driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cart-footer.ng-star-inserted > a")));
        return cartContinue;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public WebElement getCartClose() {
        cartClose = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close ng-star-inserted']")));

        return cartClose;
    }

    public void clickCartClose() {getCartClose().click();}
    //cart context menu
    public WebElement getCartMenu() {
        cartMenu = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button--white button--small context-menu__toggle']")));

        return cartMenu;
    }

    public void clickCartMenu() {
        getCartMenu().click();
    }

    public WebElement getDeleteFromCart() {
        deleteFromCart = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")));

        return deleteFromCart;
    }

    public void clickDeleteFromCart() {
        getDeleteFromCart().click();
    }

    public void deleteFromCart() {
        clickCartMenu();
        clickDeleteFromCart();
    }
}
