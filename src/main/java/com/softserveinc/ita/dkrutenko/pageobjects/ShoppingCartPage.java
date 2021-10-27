package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

    private By addToCartButton = By.xpath("//*[@class='buy-button__label ng-star-inserted']");
    private By cartButton = By.xpath("//rz-cart[@class='header-actions__component']");
    private By productTitle = By.xpath("//a[@class='cart-product__title']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCartButton() {
        waitElementCondition();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(cartButton)).click();
    }

    public String getProductTitle() {
        waitElementCondition();
        String actual = driverWait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();

        return actual;
    }
}
