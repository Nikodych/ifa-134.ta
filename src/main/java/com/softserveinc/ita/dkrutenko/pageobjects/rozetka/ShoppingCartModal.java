package com.softserveinc.ita.dkrutenko.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class ShoppingCartModal extends ShoppingCartPage {

    private final By cartContinueButtonSelector = cssSelector("div.cart-footer.ng-star-inserted > a");
    private final By cartCloseButtonSelector = xpath("//button[@class='modal__close ng-star-inserted']");
    private final By cartSideMenuButtonSelector = xpath("//button[@class='button button--white button--small context-menu__toggle']");
    private final By deleteFromCartButtonSelector = xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']");

    public ShoppingCartModal(WebDriver driver) {
        super(driver);
    }

    public void clickCartContinueButton() {
        waitForClickabelElement(cartContinueButtonSelector).click();
    }

    public void clickShoppingCartCloseButton() {
        waitForElementVisibility(cartCloseButtonSelector).click();}

    public void clickCartSideMenu() {
        waitForClickabelElement(cartSideMenuButtonSelector).click();
    }

    public void clickDeleteFromShoppingCart() {
        waitForElementVisibility(deleteFromCartButtonSelector).click();
    }

    public void deleteFromShoppingCart() {
        clickCartSideMenu();
        clickDeleteFromShoppingCart();
    }
}
