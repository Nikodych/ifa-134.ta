package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import com.softserveinc.ita.mmakoviichuk.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class RozetkaBasePage extends BasePage {

    private By dropdownCategorySelector = xpath("//ul[@class = 'menu-categories ng-star-inserted']/li/a");
    private By catalogButtonSelector  = xpath("//button[@id='fat-menu']");
    private By loginButtonSelector = xpath("//li[contains(@class , 'user')]");
    private By email = xpath("//input[@id = 'auth_email']");
    private By passwordInputSelector = xpath("//input[@id = 'auth_pass']");
    private By enterButtonSelector = xpath("//button[contains(@class , 'auth-modal__submit')]");
    private By wishListIconSelector  = xpath("//li[contains(@class, 'wishlist')]");

    private List<WebElement> categoryList;

    public RozetkaBasePage(WebDriver driver) {
        super(driver);
        categoryList = driver.findElements(dropdownCategorySelector);
    }

    public String getDropdownCategoryUrl(int index) {
        driver
                .findElement(catalogButtonSelector)
                .click();
        var dropCatUrl = categoryList
                .get(index)
                .getAttribute("href");
        driver
                .findElement(catalogButtonSelector)
                .click();

        return dropCatUrl;
    }

    public void dropdownCategoryClick(int index) {
        driver
                .findElement(catalogButtonSelector)
                .click();
        categoryList
                .get(index)
                .click();
    }

    public void logIn(String email, String password) {
        driver
                .findElement(loginButtonSelector)
                .click();
        waitForVisibility(this.email).sendKeys(email);
        waitForVisibility(this.passwordInputSelector).sendKeys(password);
        waitForVisibility(enterButtonSelector).click();
    }

    public void wishlistClick() {
        driver.findElement(wishListIconSelector ).click();
    }
}