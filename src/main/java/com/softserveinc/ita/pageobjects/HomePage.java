package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.util.stream.Collectors.*;

public class HomePage extends BasePage<HomePage> {

    private final String GOODS_SECTION_TEMPLATE = "//h2[contains(text(), '%s')]";
    private final ElementsCollection listOfLastViewedItems = $$x("//section[@class='main-goods ng-star-inserted'][1]//li");

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

    public List<String> getListOfLastViewedItem() {
        var listOfElements = listOfLastViewedItems
                .stream()
                .map(SelenideElement::text)
                .collect(toList());

        return listOfElements;
    }

    public HomePage getTitleOfLastViewedItem() {
        getListOfLastViewedItem()
                .stream()
                .findFirst()
                .toString();

        return this;
    }

    public ProductPage clickOnLastViewedItem() {
        listOfLastViewedItems
                .stream()
                .findFirst()
                .get()
                .click();

        return new ProductPage();
    }
}
