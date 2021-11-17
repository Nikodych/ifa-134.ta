package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class SoftServePage {
    private final String SIDEBAR_SELECTOR_TEMPLATE = "//a[div[@Class = 'side-navigation__title' and text() = '%s']]";

    public void switchSidebarSection (String section) {
        $x(format(SIDEBAR_SELECTOR_TEMPLATE, section)).click();
    }

    public boolean isSidebarSwitched(String section) {
        var condition = attribute("class", "side-navigation__link side-navigation__link_active");

        return $x(format(SIDEBAR_SELECTOR_TEMPLATE, section))
                .shouldHave(condition)
                .has(condition);
    }
}
