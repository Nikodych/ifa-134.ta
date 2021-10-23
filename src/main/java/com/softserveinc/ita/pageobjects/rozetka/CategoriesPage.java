package com.softserveinc.ita.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesPage {

    protected WebDriver driver;
    private WebElement category;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        category = driver.findElement(By.xpath("//h1[contains(@class, 'portal__heading ng-star-inserted')]"));
    }
    public String getCategory() {
        return category.getText();
    }
}
