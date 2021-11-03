package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import com.softserveinc.ita.mmakoviichuk.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.xpath;

public class RozetkaBasePage extends BasePage {

    private final By dropdownCategorySelector = xpath("//ul[@class = 'menu-categories ng-star-inserted']/li/a");
    private final By catalogButtonSelector  = xpath("//button[@id='fat-menu']");
    private final By loginButtonSelector = xpath("//li[contains(@class , 'user')]");
    private final By emailInputSelector = xpath("//input[@id = 'auth_email']");
    private final By passwordInputSelector = xpath("//input[@id = 'auth_pass']");
    private final By enterButtonSelector = xpath("//button[contains(@class , 'auth-modal__submit')]");
    private final By wishListIconSelector  = xpath("//li[contains(@class, 'wishlist')]");

    private final List<WebElement> categoryList;

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
        $x(this.emailInputSelector).sendKeys(email);
        $x(this.passwordInputSelector).sendKeys(password);
        $x(enterButtonSelector).click();
    }

    public void openWishList() {
        driver.findElement(wishListIconSelector ).click();
    }
}
