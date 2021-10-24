package com.softserveinc.ita.pageobjects.rozetka;

import com.softserveinc.ita.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private WebElement category;
    private WebElement dropdownCategory;
    private WebElement catalog;

    public HomePage(WebDriver driver) {
        super(driver);
        category = driver.findElement(By.xpath("(//a[@class = 'menu-categories__link'])[2]"));
        catalog = driver.findElement(By.xpath("//button[@id='fat-menu']"));
        dropdownCategory = driver.findElement(By.xpath("(//a[contains (@class, 'menu-categories__link js-menu-categories__link')])[2]"));
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
}
