package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import com.softserveinc.ita.mmakoviichuk.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class RozetkaBasePage extends BasePage {

    private By dropdownCategory = xpath("(//a[contains (@class, 'menu-categories__link js-menu-categories__link')])[2]");
    private By catalog = xpath("//button[@id='fat-menu']");
    private By login = xpath("//li[contains(@class , 'user')]");
    private By email = xpath("//input[@id = 'auth_email']");
    private By password = xpath("//input[@id = 'auth_pass']");
    private By enter = xpath("//button[contains(@class , 'auth-modal__submit')]");
    private By wishlist = xpath("//li[contains(@class, 'wishlist')]");

    public RozetkaBasePage(WebDriver driver) {
        super(driver);
    }

    public String getDropdownCategory() {
        driver.findElement(catalog).click();
        var dropCat = driver.findElement(dropdownCategory).getText();
        driver.findElement(catalog).click();

        return dropCat;
    }

    public void dropdownCategoryClick() {
        driver.findElement(catalog).click();
        driver.findElement(dropdownCategory).click();
    }

    public void logIn(String email, String password) {
        driver.findElement(login).click();
        waitForVisibility(this.email).sendKeys(email);
        waitForVisibility(this.password).sendKeys(password);
        waitForVisibility(enter).click();
    }
    public void wishlistClick() {
        driver.findElement(wishlist).click();
    }
}
