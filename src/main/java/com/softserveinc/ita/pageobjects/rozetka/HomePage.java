package com.softserveinc.ita.pageobjects.rozetka;

import com.softserveinc.ita.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private WebElement category;
    private WebElement dropdownCategory;
    private WebElement catalog;
    private WebElement login;
    private WebElement email;
    private WebElement password;
    private WebElement enter;
    private WebElement wishlist;

    public HomePage(WebDriver driver) {
        super(driver);
        category = driver.findElement(By.xpath("(//a[@class = 'menu-categories__link'])[2]"));
        catalog = driver.findElement(By.xpath("//button[@id='fat-menu']"));
        dropdownCategory = driver.findElement(By.xpath("(//a[contains (@class, 'menu-categories__link js-menu-categories__link')])[2]"));
    }

    public void loginInit(String email, String password) {
        login = waitForVisibility(By.xpath("//li[contains(@class , 'user')]"));
        login.click();
        this.email = waitForVisibility(By.xpath("//input[@id = 'auth_email']"));
        this.email.sendKeys(email);
        this.password = waitForVisibility(By.xpath("//input[@id = 'auth_pass']"));
        this.password.sendKeys(password);
        enter = waitForVisibility(By.xpath("//button[contains(@class , 'auth-modal__submit')]"));
        enter.click();
    }

    public void categoryClick() {
        category.click();
    }

    public void dropdownCategoryClick() {
        catalog.click();
        dropdownCategory.click();
    }

    public String getCategory() {
        return category.getText();
    }

    public String getDropdownCategory() {
        catalog.click();
        var dropCat = dropdownCategory.getText();
        catalog.click();

        return dropCat;
    }
    public void wishlistClick() {
        wishlist = waitForVisibility(By.xpath("//li[contains(@class, 'wishlist')]"));
        wishlist.click();
    }
}
