package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;

public abstract class BasePage<T> {

    protected WebDriver driver;
    protected By searchBar;
    protected By searchButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public T searchBarInputText(String searchText) {
        $x(searchBar).sendKeys(searchText);

        return (T) this;
    }

    public T searchButtonClick() {
        $x(searchButton).click();

        return (T) this;
    }

    public String getSearchBarText() {
        return $x(searchBar).getAttribute("value");
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }
}
