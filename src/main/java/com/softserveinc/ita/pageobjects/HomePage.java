package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends BasePage<HomePage> {

    private final String GOODS_SECTION_TEMPLATE = "//h2[contains(text(), '%s')]";

    public String getLastProductTitleOfSection(String sectionName) {
        return $x(format(GOODS_SECTION_TEMPLATE, sectionName))
                .$$x("./following-sibling::ul//a[@class = 'tile__title']")
                .last()
                .getText();
    }

    public ProductPage openLastProductOfSection(String sectionName) {
        var lastProductOfSection = getLastProductTitleOfSection(sectionName);

        $x(format(GOODS_SECTION_TEMPLATE, sectionName))
                .$x(format("./following-sibling::ul//a[contains(@title,'%s')]", lastProductOfSection))
                .click();

        return new ProductPage();
    }
}
