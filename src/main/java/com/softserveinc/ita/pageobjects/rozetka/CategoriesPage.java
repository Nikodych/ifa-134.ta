package com.softserveinc.ita.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesPage extends RozetkaBasePage {

    private WebElement category;

    public CategoriesPage(WebDriver driver) {
        super(driver);
        category = driver.findElement(By.xpath("//h1[contains(@class, 'portal__heading ng-star-inserted')]"));
    }
    public String getCategory() {
        return category.getText();
    }
}