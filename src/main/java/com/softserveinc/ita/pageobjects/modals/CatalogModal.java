package com.softserveinc.ita.pageobjects.modals;

import com.softserveinc.ita.pageobjects.BasePage;
import com.softserveinc.ita.pageobjects.CategoriesPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CatalogModal extends BasePage<CatalogModal> {

    @Step("CatalogModal: Opened dropdown category '{title}'")
    public CategoriesPage openDropdownCategory(String title) {
        $x(format("//a[@class='menu-categories__link js-menu-categories__link' and contains(text(), '%s')]", title)).click();

        return new CategoriesPage();
    }
}
