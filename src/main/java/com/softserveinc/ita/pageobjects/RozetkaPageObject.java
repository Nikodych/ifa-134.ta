package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class RozetkaPageObject {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private WebElement addCartButton;
    private WebElement search;
    private WebElement searchButton;
    private WebElement continueButton;
    private WebElement cartClose;
    private WebElement cart;
    private WebElement cartMenu;
    private WebElement deleteFromCart;

    public RozetkaPageObject(WebDriver driver) {
        this.driver = driver;
        webElements();
    }
    //rozetka webElements
        private void webElements() {
                addCartButton = driver.findElement(By.xpath("//*[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']"));
                search = driver.findElement(By.name("search"));
                searchButton = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
                continueButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-footer.ng-star-inserted > a")));
                cartClose = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close ng-star-inserted']")));
                cart = driver.findElement(By.xpath("//rz-cart[@class='header-actions__component']"));
                cartMenu = driver.findElement(By.xpath("//button[@class='button button--white button--small context-menu__toggle']"));
                deleteFromCart = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button--medium button--with-icon button--link context-menu-actions__button']")));
    }
    //page object
    //add cart button
    public WebElement getAddCartButton() {
        return addCartButton;
    }
    public void clickAddCartButton() {
        getAddCartButton().click();
    }
    //search field
    public WebElement getSearch() {
        return search;
    }
    public void searchClear() {
        getSearch().clear();
    }
    public void searchClick() {
        getSearch().click();
    }
    public void searchSendKeys(String text) {
        getSearch().sendKeys(text);
    }
    //search button
    public WebElement getSearchButton() {
        return searchButton;
    }
    public void clickSearchButton() {
        getSearchButton().click();
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
    //shopping cart
    public WebElement getCart() {
        return cart;
    }
    public void clickCart() {
        getCart().click();
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

    //find elements
    private void findRozetkaElements(String searchText) {
        searchClick();
        searchClear();
        searchSendKeys(searchText);
    }


}
