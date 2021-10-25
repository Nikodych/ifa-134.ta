package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchField extends BasePage {

    private WebElement search;
    private WebElement searchButton;
    private List<WebElement> goods;
    private WebElement expectedItem;

    public SearchField(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getGoodsList() {
        goods = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@class='goods-tile__title']"),30));

        return goods;
    }

    public WebElement getExpectedItem(String text) {
        expectedItem = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text)));

        return expectedItem;
    }

    public void fillSearch(String text) {
        searchClick();
        searchClear();
        searchSendKeys(text);
    }
    }
