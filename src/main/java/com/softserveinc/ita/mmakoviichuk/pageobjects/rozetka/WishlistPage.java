package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class WishlistPage extends RozetkaBasePage {

    private final List<WebElement> goodsElementsList;

    public WishlistPage(WebDriver driver) {
        super(driver);
        By goodsSelector = xpath("//div[@class = 'goods-tile__inner']");
        goodsElementsList = driver.findElements(goodsSelector);
    }

    public boolean isContainsProductId(String id) {
        boolean isContains = false;
        for (WebElement product : goodsElementsList) {
            if (id.equals(product.getAttribute("data-goods-id"))) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }
}
