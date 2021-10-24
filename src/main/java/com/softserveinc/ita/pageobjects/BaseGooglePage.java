package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.*;

public abstract class BaseGooglePage {

    protected WebDriver driver;
    private final By searchBar = By.name("q");
    private final By searchButton = By.name("btnK");

    public BaseGooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public BaseGooglePage searchBarInputText(String searchText) {
        driver
                .findElement(searchBar)
                .sendKeys(searchText);

        return this;
    }

    public BaseGooglePage searchButtonClick() {
        driver
                .findElement(searchButton)
                .click();

        return this;
    }

    public String getSearchBarText() {
        return driver.findElement(searchBar).getAttribute("value");
    }
}
