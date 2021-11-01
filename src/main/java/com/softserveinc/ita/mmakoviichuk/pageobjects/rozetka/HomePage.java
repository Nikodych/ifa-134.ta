package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage extends RozetkaBasePage {

    private final List<WebElement> categoryList;

    public HomePage(WebDriver driver) {
        super(driver);
        By category = xpath("//ul[@class = 'menu-categories menu-categories_type_main']/li/a");
        categoryList = driver.findElements(category);
    }

    public void categoryClick(int index) {
        categoryList.get(index).click();
    }

    public String getCategoryUrl(int index) {
        return categoryList.get(index).getAttribute("href");
    }
}
