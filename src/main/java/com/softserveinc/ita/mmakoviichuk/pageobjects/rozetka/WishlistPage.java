package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.$$x;
import static org.openqa.selenium.By.xpath;

public class WishlistPage extends RozetkaBasePage {

    private final By goodsSelector = xpath("//div[@class = 'goods-tile__inner']");

    public boolean isContainsProductId(String id) {
        boolean isContains = false;
        for (WebElement product : getWishlist()) {
            if (id.equals(product.getAttribute("data-goods-id"))) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    public List<WebElement> getWishlist() {
        return $$x(goodsSelector);
    }
}
