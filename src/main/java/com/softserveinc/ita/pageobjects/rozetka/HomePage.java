package com.softserveinc.ita.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class HomePage extends RozetkaBasePage {

    private By category = xpath("(//a[@class = 'menu-categories__link'])[2]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void categoryClick() {
        driver.findElement(category).click();
    }

    public String getCategory() {
        return driver.findElement(category).getText();
    }
}
