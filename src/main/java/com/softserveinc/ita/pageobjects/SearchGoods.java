package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchGoods extends BasePage {

    private List<WebElement> goods;
    private WebElement actualItem;

    public SearchGoods(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getGoodsList() {
        goods = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@class='goods-tile__title']"), 30));

        return goods;
    }

    public WebElement getActualItem(String text) {
        actualItem = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text)));

        return actualItem;
    }
    public void fillSearch(String text) {
        searchClick();
        searchClear();
        searchSendKeys(text);
    }
}
