package com.softserveinc.ita.deprecated.mmakoviichuk.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;

public class CategoryPage extends RozetkaBasePage{

    private final String categoryTitleSelector = "//h1[@class = 'portal__heading ng-star-inserted']";

    public String getCategoryTitle() {
        return $x(categoryTitleSelector).getText();
    }
}
