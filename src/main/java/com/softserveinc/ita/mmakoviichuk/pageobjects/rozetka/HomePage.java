package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class HomePage extends RozetkaBasePage {

    private final String category = "//ul[@class = 'menu-categories menu-categories_type_main']/li/a";

    public void openCategory(int index) {
        getCategoryList().get(index).click();
    }

    public String getCategoryUrl(int index) {
        return getCategoryList()
                .get(index)
                .getAttribute("href")
                .replaceAll("https://rozetka.com.ua|https://rozetka.com.ua/ua", "");
    }

    private ElementsCollection getCategoryList() {
        return $$x(category);
    }

    //TODO
    public String getCurrentUrl(String url) {
        return url;
    }
}
