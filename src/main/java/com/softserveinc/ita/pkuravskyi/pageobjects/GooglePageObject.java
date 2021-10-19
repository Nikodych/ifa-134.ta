package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.*;

public class GooglePageObject {

    protected WebDriver driver;
    private By searchBar;
    private By searchButton;
    private By openWikipedia;

    public GooglePageObject(WebDriver driver) {
        this.driver = driver;
        googleSelectors();
    }

    private void googleSelectors() {
        searchBar = By.name("q");
        searchButton = By.name("btnK");
        openWikipedia = By.xpath("//a[contains(@href, 'wikipedia.org')]");
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
}
