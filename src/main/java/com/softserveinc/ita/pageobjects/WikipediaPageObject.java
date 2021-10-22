package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.*;

public class WikipediaPageObject {

    protected WebDriver driver;
    private By searchBar;
    private By searchButton;
    private By selectSoftServeUrl;

    public WikipediaPageObject(WebDriver driver) {
        this.driver = driver;
        wikipediaSelectors();
    }

    private void wikipediaSelectors() {
        searchBar = By.name("search");
        searchButton = By.xpath("//input[@name = 'go']");
        selectSoftServeUrl = By.xpath("//a[contains(@href, 'softserveinc')]");
    }

    public void searchBarInputText(String searchText) {
        driver.findElement(searchBar).sendKeys(searchText);
    }

    public void searchButtonClick() {
        driver.findElement(searchButton).click();
    }

    public void selectSoftServeUrlClick() {
        driver.findElement(selectSoftServeUrl).click();
    }
}
