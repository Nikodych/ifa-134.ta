package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.*;

public class ContactPage extends BasePage<ContactPage> {

    private final SelenideElement searchSelector = $x("//div[@Class='autocomplete']/input[@name='search']");
    private final ElementsCollection listOfCitiesSelector = $$x("//ul[@class='autocomplete__list dialog']/li");

    public ContactPage fillCitySearchField(String expectedCity) {
        searchSelector
                .shouldBe(visible)
                .click();
        searchSelector.clear();
        searchSelector.setValue(expectedCity);

        return this;
    }

    public String getErrorMessage() {
        return $x("//div[@class='autocomplete']//p")
                .getText()
                .trim();
    }

    public String getActualCity(String expectedCity) {
        return listOfCitiesSelector
                .shouldBe(sizeNotEqual(0), ofSeconds(12))
                .find(text(expectedCity))
                .getText()
                .trim();
    }

    public ContactPage selectRequiredCity(String expectedCity) {
        listOfCitiesSelector
                .shouldBe(sizeNotEqual(0), ofSeconds(12))
                .filterBy(text(expectedCity))
                .get(0)
                .click();

        return this;
    }

    public ContactPage selectShopFromSidebar(int requiredValue) {
        $x("//select[@id='contactsDeliveryType']")
                .shouldBe(visible, ofSeconds(12))
                .selectOption(requiredValue);

        return this;
    }

    public List<String> getAddressList() {
        return $$x("//*[@class='contacts-map__toggle-address']")
                .shouldHave(sizeNotEqual(0), ofSeconds(12))
                .stream()
                .map(SelenideElement::text)
                .collect(toList());
    }

    public ContactPage clickOnShowMoreTagsButton() {
        $x("//button[@class='button tags__link tags__toggle ng-star-inserted']")
                .shouldBe(visible)
                .click();

        return this;
    }

    public ContactPage clickOnExpectedCityTag(String expectedCity) {
        var list = $$x("//*[@class='tags__item ng-star-inserted']").shouldHave(sizeNotEqual(0), ofSeconds(12));
        list
                .find(text(expectedCity))
                .click();

        return this;
    }

    public String getPointOfDeliveryAddressesList(String expectedAddress) {
        return $$x("//div[@class='shop__body']//p[@class='shop__address shop__address--bold']")
                .shouldHave(sizeNotEqual(0), ofSeconds(12))
                .find(text(expectedAddress))
                .getText()
                .trim();
    }
}
