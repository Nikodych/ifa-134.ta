package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage<T> {

    protected WebDriver driver;
    protected By searchBar;
    protected By searchButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public T searchBarInputText(String searchText) {
        driver
                .findElement(searchBar)
                .sendKeys(searchText);

        return (T) this;
    }

    public T searchButtonClick() {
        driver
                .findElement(searchButton)
                .click();

        return (T) this;
    }

    public String getSearchBarText() {
        return driver
                .findElement(searchBar)
                .getAttribute("value");
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }
}
