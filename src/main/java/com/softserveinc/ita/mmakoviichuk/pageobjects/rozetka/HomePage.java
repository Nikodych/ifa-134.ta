package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends RozetkaBasePage {

    private static final String category = "//a[@class ='menu-categories__link' and contains(text(), '%s')]";

    public void openCategory(String categoryName) {
        $x(format(category, categoryName)).click();
    }
}
