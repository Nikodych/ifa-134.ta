package com.softserveinc.ita.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishlistPage extends RozetkaBasePage {

    private List<WebElement> goods;

    public WishlistPage(WebDriver driver) {
        super(driver);
        goods = driver.findElements(By.xpath("//ul[contains(@class , 'wish-grid')]"));
    }

    public boolean containsId(String id) {
        boolean check = false;
        for (WebElement product : goods) {
            if (id.equals(product.findElement(By.xpath("//div[@class = 'goods-tile__inner']")).getAttribute("data-goods-id"))) {
                check = true;
                break;
            }
        }
        return check;
    }
}
