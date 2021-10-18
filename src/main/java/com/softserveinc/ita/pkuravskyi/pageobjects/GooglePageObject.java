package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.*;

public class GooglePageObject {

    protected WebDriver driver;

    private WebElement searchBar;
    private WebElement searchButton;
    private WebElement searchWikipediaPage;

    public GooglePageObject(WebDriver driver) {
        this.driver = driver;
        googleSelectors();
    }

    private void googleSelectors() {
        searchBar = driver.findElement(By.xpath("//*[@name = 'q']"));
        searchButton = driver.findElement(By.xpath("//*[@name = 'btnK']"));
        searchWikipediaPage = driver.findElement(By.xpath("//a[contains(@href, 'wikipedia.org')]"));
    }

    public void searchBarInputText(String searchText) {
        searchBar.sendKeys(searchText);
    }

    public void searchButtonClick() {
        searchButton.click();
    }

    public void searchWikipediaPageClick() {
        searchWikipediaPage.click();
    }
}
