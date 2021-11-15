package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.*;
import static java.lang.String.format;

public class SoftServePage {

    public void switchSidebarSection (String section) {
        $x(format("//a[div[@Class = 'side-navigation__title' and text() = '%s']]", section)).click();
    }

    public boolean isSidebarSwitched(String section) {
        expectedAttribute(
                $x(format("//a[div[@class = 'side-navigation__title' and text() = '%s']]", section)),
                "class",
                "side-navigation__link_active");

        return $x(format("//a[div[@class = 'side-navigation__title' and text() = '%s']]", section)).getAttribute("class").contains("side-navigation__link_active");
    }
}
