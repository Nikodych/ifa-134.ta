package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.WebDriver;


public class CategoriesPage extends RozetkaBasePage {

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryUrl(String url) {
        return waitForUrlChanges(url);
    }
}
