package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class SearchResultPage extends  BasePage<SearchResultPage> {

    private final String subCategorySelector =  "//rz-widget-list//ul/li//a[contains(@Class , 'tile-cats__heading')]";
    private final String filteredItemsSelector = "//div[@class='goods-tile__inner']";
    private final String showmoreButtonSelector = "//a[@class='show-more show-more--horizontal']";
    private final String activePageNumbersSelector = "//a[@class='pagination__link ng-star-inserted pagination__link_state_active']";

    public SearchResultPage openSubCategoryByOrderNumber(int orderNumber ) {
        $$x(subCategorySelector)
                .shouldBe(sizeGreaterThan(0), ofSeconds(10))
                .get(orderNumber)
                .click();

        return this;
    }

    public SearchResultPage filterByBrand(String producer) {
        $x(format("//a[@Class='checkbox-filter__link'][@href='/ua/notebooks/c80004/producer=%s/']", producer)).click();

        return this;
    }

    public SearchResultPage setMinimalPrice(String price) {
        var minPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']").shouldBe(visible, ofSeconds(6));
        minPriceField.click();
        minPriceField.setValue(price);

        return this;
    }

    public SearchResultPage setMaximalPrice(String price) {
        var maxPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']").shouldBe(visible, ofSeconds(6));
        maxPriceField.click();
        maxPriceField.setValue(price);

        return this;
    }

    public SearchResultPage clickOnPriceButton() {
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']").click();

        return this;
    }

    public SearchResultPage filterAvailableItems() {
        $x("//div[@data-filter-name='sell_status']//a//label[contains(text(), 'Є в наявності')]")
                .shouldBe(visible, ofSeconds(6))
                .click();

        return this;
    }

    public void getFirstFilteredItem(int itemNumber) {
        var firstItem = $$x(filteredItemsSelector).get(itemNumber);

        firstItem
                .shouldBe(visible, ofSeconds(6))
                .click();
    }

    public void showMoreItems() {
        $x(showmoreButtonSelector)
                .shouldBe(visible, ofSeconds(5))
                .click();
        $x(showmoreButtonSelector)
                .shouldBe(visible, ofSeconds(5))
                .click();
    }
}