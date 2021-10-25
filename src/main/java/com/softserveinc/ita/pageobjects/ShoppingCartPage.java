package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

    private WebElement addToCartButton;
    private WebElement cartButton;
    private WebElement itemString;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        addToCartButton = driver.findElement(By.xpath("//*[@class='buy-button__label ng-star-inserted']"));

        return addToCartButton;
    }

    public void clickAddToCartButton() {getAddToCartButton().click();}

    public WebElement getCartButton() {
        cartButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//rz-cart[@class='header-actions__component']")));

        return cartButton;
    }

    public void clickCartButton() {
        getCartButton().click();
    }

    public String getProductTitle() {
        itemString = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cart-product__title']")));
        String actual = itemString.getText();

        return actual;
    }
}
