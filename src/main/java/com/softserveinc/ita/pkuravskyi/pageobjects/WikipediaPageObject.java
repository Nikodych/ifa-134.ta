package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.*;

public class WikipediaPageObject {

    protected WebDriver driver;

    private WebElement searchBarWikipedia;
    private WebElement searchButtonWikipedia;
    private WebElement selectContentWikipedia;

    public WikipediaPageObject(WebDriver driver) {
        this.driver = driver;
        wikipediaSelectors();
    }

    private void wikipediaSelectors() {
        searchBarWikipedia = driver.findElement(By.name("search"));
        searchButtonWikipedia = driver.findElement(By.xpath("//input[@name = 'go']"));
        selectContentWikipedia = driver.findElement(By.xpath("//span[@class = 'tocnumber' and text() = '2']"));
    }

    public void searchBarWikipediaInputText(String searchText) {
        searchBarWikipedia.sendKeys(searchText);
    }

    public void searchButtonWikipediaClick() {
        searchButtonWikipedia.click();
    }

    public void selectContentWikipediaClick() {
        selectContentWikipedia.click();
    }
}
