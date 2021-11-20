package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends BasePage<HomePage> {

    public String getLastProductOfSection(String sectionName) {
        var selectedSection = $x(format("//*[contains(@class, 'main-goods__heading') and contains(text(), '%s')]", sectionName));
        var lastProductOfSelectedSection = selectedSection.$$x("./following-sibling::ul//a[@class = 'tile__title']").last();

        lastProductOfSelectedSection.click();

        return lastProductOfSelectedSection.getText();
    }
}
