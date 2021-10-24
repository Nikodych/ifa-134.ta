package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.*;

public abstract class BaseWikipediaPage {

    protected WebDriver driver;
    private final By searchBar = By.name("search");
    private final By searchButton = By.xpath("//input[@name = 'go']");

    public BaseWikipediaPage(WebDriver driver) {
        this.driver = driver;
    }

    public BaseWikipediaPage searchBarInputText(String searchText) {
        driver
                .findElement(searchBar)
                .sendKeys(searchText);

        return this;
    }

    public BaseWikipediaPage searchButtonClick() {
        driver
                .findElement(searchButton)
                .click();

        return this;
    }

    public String getSearchBarText() {
        return driver.findElement(searchBar).getAttribute("value");
    }
}
