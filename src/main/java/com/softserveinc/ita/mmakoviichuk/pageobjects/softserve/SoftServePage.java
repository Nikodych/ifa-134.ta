package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.mmakoviichuk.models.Template.SIDEBAR_SELECTOR_TEMPLATE;
import static java.lang.String.format;

public class SoftServePage {

    public void switchSidebarSection (String section) {
        $x(format(SIDEBAR_SELECTOR_TEMPLATE.getTemplate(), section)).click();
    }

    public boolean isSidebarSwitched(String section) {
        var condition = Condition.attribute("class", "side-navigation__link side-navigation__link_active");

        return $x(format(SIDEBAR_SELECTOR_TEMPLATE.getTemplate(), section))
                .shouldHave(condition)
                .has(condition);
    }
}
