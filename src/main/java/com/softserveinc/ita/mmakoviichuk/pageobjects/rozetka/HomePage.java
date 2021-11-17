package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends RozetkaBasePage {

    private final String CATEGORY_SELECTOR_TEMPLATE = "//a[@class ='menu-categories__link' and contains(text(), '%s')]";
    public void openCategory(String categoryName) {
        $x(format(CATEGORY_SELECTOR_TEMPLATE, categoryName)).click();
    }
}
