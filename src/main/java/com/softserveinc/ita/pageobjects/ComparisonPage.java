package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class ComparisonPage extends BasePage<ComparisonPage> {

    private final SelenideElement compareOnlyDifferencesButtonElement = $("button.comparison-settings__toggle");

    @Step("ComparisonPage: Clicked on 'Add another product to compare' button")
    public SearchResultPage addAnotherProductToCompare() {
        $("a.comparison-settings__button")
                .shouldBe(visible)
                .click();

        return new SearchResultPage();
    }

    @Step("ComparisonPage: Removed product from compare")
    public ComparisonPage removeProductFromCompare() {
        $("button.context-menu__toggle").click();
        $("rz-trash-icon button")
                .should(appear)
                .click();
        // need to wait because of rozetka's bug after deleting product
        sleep(400);

        return this;
    }

    public String getShareLink() {
        $("button use[href='#icon-link']").click();

        return clipboard().getText();
    }

    public boolean isOnlyDifferencesButtonDisplayed() {
        return compareOnlyDifferencesButtonElement.isDisplayed();
    }

    public int getProductsQuantityInCompareList() {
        return $("ul.products-grid")
                .shouldBe(visible)
                .$$("li")
                .size();
    }

    @Step("ComparisonPage: Showed only differences between products")
    public ComparisonPage showOnlyDifferencesBetweenProducts() {
        compareOnlyDifferencesButtonElement.click();
        $("button.comparison-settings__toggle--toggled").should(appear);

        return this;
    }

    public boolean areOnlyDifferentCharacteristicsDisplayed() {
        var productsQuantityInCompare = getProductsQuantityInCompareList();
        var productsCharacteristics = $$("div.comparison-grid dd")
                .stream()
                .map(SelenideElement::getText)
                .collect(toList());

        // check if products have the same characteristics in 'Only differences' compare
        for (var i = 0; i <= productsCharacteristics.size() - 1; i += productsQuantityInCompare) {
            var characteristicOfFirstProduct = productsCharacteristics.get(i);
            var characteristicOfSecondProduct = productsCharacteristics.get(i + 1);

            if (characteristicOfFirstProduct.equals(characteristicOfSecondProduct)) {
                // scroll to same characteristics (for screenshot)
                $x(format("(//div[@Class='comparison-grid']//dd)[%d]", i)).scrollTo();

                return false;
            }
        }

        return true;
    }
}
