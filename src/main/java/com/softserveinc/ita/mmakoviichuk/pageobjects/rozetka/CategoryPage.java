package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public class CategoryPage extends RozetkaBasePage{

    private static final String categoryTitle = "//h1[@class = 'portal__heading ng-star-inserted']";

    public String getCategoryTitle() {
        return $x(categoryTitle).getText();
    }
}
