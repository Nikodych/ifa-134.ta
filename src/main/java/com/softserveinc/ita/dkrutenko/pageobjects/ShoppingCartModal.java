package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartModal extends ShoppingCartPage {

    private By cartContinueButton = By.cssSelector("div.cart-footer.ng-star-inserted > a");
    private By cartCloseButton = By.xpath("//button[@class='modal__close ng-star-inserted']");
    private By cartSideMenu = By.xpath("//button[@class='button button--white button--small context-menu__toggle']");
    private By deleteFromCart = By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']");

    public ShoppingCartModal(WebDriver driver) {
        super(driver);
    }

    public void clickCartContinueButton() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.elementToBeClickable(cartContinueButton)).click();
    }

    public void clickShoppingCartCloseButton() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(cartCloseButton)).click();}

    public void clickCartSideMenu() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.elementToBeClickable(cartSideMenu)).click();
    }

    public void clickDeleteFromShoppingCart() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(deleteFromCart)).click();
    }

    public void deleteFromShoppingCart() {
        clickCartSideMenu();
        clickDeleteFromShoppingCart();
    }
}
