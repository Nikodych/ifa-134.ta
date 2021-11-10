package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.*;
import static java.lang.String.format;

public class SoftServePage {

    private SelenideElement sidebarSection;

    public void switchSidebarSection (String section) {
        sidebarSection = $x(format("//a[div[@class = 'side-navigation__title' and text() = '%s']]", section));
        sidebarSection.click();
    }

    public boolean isSidebarSwitched() {
        waitForAttributeChanges(
                sidebarSection,
                "class",
                "side-navigation__link_active");

        return sidebarSection.getAttribute("class").contains("side-navigation__link_active");
    }
}
