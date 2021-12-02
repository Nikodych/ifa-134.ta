package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.softserveinc.ita.models.SocialMedia;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage extends BasePage<HomePage> {

    private final String GOODS_SECTION_TEMPLATE = "//h2[contains(text(), '%s')]";

    public CategoriesPage openCategory(String categoryName) {
        $x(format("//a[@class='menu-categories__link' and contains(text(), '%s')]", categoryName)).click();

        return new CategoriesPage();
    }

    public String getLastProductTitleOfSection(String sectionName) {
        return $x(format(GOODS_SECTION_TEMPLATE, sectionName))
                .$$x("./following-sibling::ul//a[@class = 'tile__title']")
                .last()
                .getText();
    }

    public ProductPage openLastProductOfSection(String sectionName) {
        var lastProductOfSection = getLastProductTitleOfSection(sectionName);

        $x(format(GOODS_SECTION_TEMPLATE, sectionName))
                .$x(format("./following-sibling::ul//a[contains(@title,\"%s\")]", lastProductOfSection))
                .click();

        return new ProductPage();
    }

    public HomePage openSocialMediaPage(String mediaName) {
        $x(format("//a[contains(@class, 'socials__link') and @title = '%s']", mediaName)).click();

        return this;
    }

    public boolean isSocialMediaCorrect(String mediaName) {
        var expectedUrl = SocialMedia.valueOf(mediaName.toUpperCase()).getSocialMediaLink();
        Selenide.switchTo().window(1);
        var actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Selenide.closeWindow();

        return actualUrl.equals(expectedUrl);
    }
}
