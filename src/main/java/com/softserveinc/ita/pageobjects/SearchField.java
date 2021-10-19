package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchField extends RozetkaPageObject {
    private WebElement search;
    private WebElement searchButton;
    private List<WebElement> goods;
    private WebElement expectedItem;

    public SearchField(WebDriver driver) {
        super(driver);
        webElements();
    }

    private void webElements() {
        search = driver.findElement(By.name("search"));
        searchButton = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
    }
    //-------------------------------------------page object constructor-------------------------------------------
    public WebElement getSearch() {
        return search;
    }
    public void searchClick() {
        getSearch().click();
    }
    public void searchClear() {
        getSearch().clear();
    }
    public void searchSendKeys(String text) {
        getSearch().sendKeys(text);
    }
    public WebElement getSearchButton() {
        return searchButton;
    }
    public void clickSearchButton() {
        getSearchButton().click();
    }
    //goods
    public List<WebElement> getGoodsList() {
        goods = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@class='goods-tile__title']"),30));
        return goods;
    }
    //expectedItem
    public WebElement getExpectedItem(String text) {
        expectedItem = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text)));
        return expectedItem;
    }
    //-----functional methods-----//
    public void fillSearch(String text) {
        searchClick();
        searchClear();
        searchSendKeys(text);
    }

    }