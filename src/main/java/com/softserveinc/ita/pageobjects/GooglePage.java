package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.*;

public class GooglePage {

    protected WebDriver driver;
    private By searchBar;
    private By searchButton;
    private By openWikipedia;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        googleSelectors();
    }

    public void searchBarInputText(String searchText) {
        driver.findElement(searchBar).sendKeys(searchText);
    }

    public void searchButtonClick() {
        driver.findElement(searchButton).click();
    }

    public void openWikipediaClick() {
        driver.findElement(openWikipedia).click();
    }

    private void googleSelectors() {
        searchBar = By.name("q");
        searchButton = By.name("btnK");
        openWikipedia = By.xpath("//a[contains(@href, 'wikipedia.org')]");
    }
}
