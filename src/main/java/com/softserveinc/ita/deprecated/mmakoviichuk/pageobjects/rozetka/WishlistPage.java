package com.softserveinc.ita.deprecated.mmakoviichuk.pageobjects.rozetka;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$x;

public class WishlistPage extends RozetkaBasePage {

    private final String goodsSelector = "//div[@class = 'goods-tile__inner']";

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

    private ElementsCollection getWishlist() {
        return $$x(goodsSelector);
    }
}
