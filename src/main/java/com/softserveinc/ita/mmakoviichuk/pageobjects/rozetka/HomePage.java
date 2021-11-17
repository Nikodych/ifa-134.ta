package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.mmakoviichuk.models.Template.CATEGORY_SELECTOR_TEMPLATE;
import static java.lang.String.format;

public class HomePage extends RozetkaBasePage {

    public void openCategory(String categoryName) {
        $x(format(CATEGORY_SELECTOR_TEMPLATE.getTemplate(), categoryName)).click();
    }
}
