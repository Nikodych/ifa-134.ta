package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CatalogModal extends BasePage<CatalogModal> {

    private final String DROPDOWN_CATEGORY_SELECTOR_TEMPLATE = "//a[@class = 'menu-categories__link js-menu-categories__link' and contains(text(), '%s')]";

    public void openDropdownCategory(String title) {
        $x(format(DROPDOWN_CATEGORY_SELECTOR_TEMPLATE, title)).click();
    }
}
