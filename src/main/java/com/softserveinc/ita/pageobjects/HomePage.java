package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends BasePage<HomePage>{
    private final String CATEGORY_SELECTOR_TEMPLATE = "//a[@class ='menu-categories__link' and contains(text(), '%s')]";

    public CategoriesPage openCategory(String categoryName) {
        $x(format(CATEGORY_SELECTOR_TEMPLATE, categoryName)).click();

        return new CategoriesPage();
    }
}