package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.*;
import static org.openqa.selenium.By.xpath;

public class RozetkaBasePage {

    private final By dropdownCategorySelector = xpath("//ul[@class = 'menu-categories ng-star-inserted']/li/a");
    private final By catalogButtonSelector  = xpath("//button[@id='fat-menu']");
    private final By loginButtonSelector = xpath("//li[contains(@class , 'user')]");
    private final By emailInputSelector = xpath("//input[@id = 'auth_email']");
    private final By passwordInputSelector = xpath("//input[@id = 'auth_pass']");
    private final By enterButtonSelector = xpath("//button[contains(@class , 'auth-modal__submit')]");
    private final By wishListIconSelector  = xpath("//li[contains(@class, 'wishlist')]");

    private final List<WebElement> categoryList;

    public RozetkaBasePage() {
        categoryList = $$x(dropdownCategorySelector);
    }

    public String getDropdownCategoryUrl(int index) {
        $x(catalogButtonSelector).click();
        var dropCatUrl = categoryList
                .get(index)
                .getAttribute("href");
        $x(catalogButtonSelector).click();

        return dropCatUrl;
    }

    public void dropdownCategoryClick(int index) {
        $x(catalogButtonSelector).click();
        categoryList
                .get(index)
                .click();
    }

    public void logIn(String email, String password) {
        $x(loginButtonSelector).click();
        $x(this.emailInputSelector).sendKeys(email);
        $x(this.passwordInputSelector).sendKeys(password);
        $x(enterButtonSelector).click();
    }

    public void openWishList() {
        $x(wishListIconSelector ).click();
    }
}
