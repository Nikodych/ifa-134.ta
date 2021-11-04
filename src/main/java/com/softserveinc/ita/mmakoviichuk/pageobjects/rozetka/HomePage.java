package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.*;
import static org.openqa.selenium.By.xpath;

public class HomePage extends RozetkaBasePage {

    private final By category = xpath("//ul[@class = 'menu-categories menu-categories_type_main']/li/a");
    private final List<WebElement> categoryList;

    public HomePage() {
        categoryList = $$x(category);
    }

    public void categoryClick(int index) {
        categoryList.get(index).click();
    }

    public String getCategoryUrl(int index) {
        return categoryList.get(index).getAttribute("href");
    }
}
