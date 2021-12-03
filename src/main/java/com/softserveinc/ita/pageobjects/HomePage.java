package com.softserveinc.ita.pageobjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

public class HomePage extends BasePage<HomePage> {

    private final String GOODS_SECTION_TEMPLATE = "//h2[contains(text(), '%s')]";
    private final ElementsCollection listOfLastViewedItems = $$x("//a[@class='tile__title']");

    @Step("HomePage: open '{categoryName}' category")
    public CategoriesPage openCategory(String categoryName) {
        $x(format("//a[@class='menu-categories__link' and contains(text(), '%s')]", categoryName)).click();

        return new CategoriesPage();
    }

    @Step("HomePage: get last product's title of section '{sectionName}' ")
    public String getLastProductTitleOfSection(String sectionName) {
        return $x(format(GOODS_SECTION_TEMPLATE, sectionName))
                .$$x("./following-sibling::ul//a[@class = 'tile__title']")
                .last()
                .getText();
    }

    @Step("HomePage: open last product of section '{sectionName}'")
    public ProductPage openLastProductOfSection(String sectionName) {
        var lastProductOfSection = getLastProductTitleOfSection(sectionName);

        $x(format(GOODS_SECTION_TEMPLATE, sectionName))
                .$x(format("./following-sibling::ul//a[contains(@title,\"%s\")]", lastProductOfSection))
                .click();

        return new ProductPage();
    }

    public List<String> getTitlesFromListOfLastViewedProducts() {

        return listOfLastViewedItems
                .shouldBe(sizeNotEqual(0), ofSeconds(8))
                .stream()
                .map(SelenideElement::text)
                .collect(toList());
    }

    public ProductPage openLastViewedItemByTitle(String expectedItem) {
        listOfLastViewedItems
                .shouldHave(itemWithText(expectedItem))
                .stream()
                .findAny()
                .get()
                .click();

        return new ProductPage();
    }
}
