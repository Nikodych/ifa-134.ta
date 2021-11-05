package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.$$x;
import static org.openqa.selenium.By.xpath;

public class HomePage extends RozetkaBasePage {

    private final By category = xpath("//ul[@class = 'menu-categories menu-categories_type_main']/li/a");

    public void openCategory(int index) {
        getCategoryList().get(index).click();
    }

    public String getCategoryUrl(int index) {
        return getCategoryList()
                .get(index)
                .getAttribute("href")
                .replaceAll("https://rozetka.com.ua|https://rozetka.com.ua/ua", "");
    }

    private List<WebElement> getCategoryList() {
        return $$x(category);
    }
}
