package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import org.openqa.selenium.WebElement;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.*;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SoftServePage {

    private WebElement sidebarSection;

    public void sidebarClick (String section) {
        sidebarSection = $x(xpath(format("//a[div[@class = 'side-navigation__title' and text() = '%s']]", section)));
        sidebarSection.click();
    }

    public boolean isSidebarActive() {
        waitForAttributeChanges(
                sidebarSection,
                "class",
                "side-navigation__link_active");

        return sidebarSection.getAttribute("class").contains("side-navigation__link_active");
    }
}
