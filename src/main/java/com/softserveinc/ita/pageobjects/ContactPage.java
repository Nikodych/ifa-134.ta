package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.*;
import static java.util.stream.Collectors.*;

public class ContactPage extends BasePage<ContactPage> {

    private final SelenideElement searchSelector = $x("//div[@Class='autocomplete']/input[@name='search']");
    private final ElementsCollection listOfCitiesSelector = $$x("//ul[@class='autocomplete__list dialog']/li");

    public ContactPage fillCitySearchField(String expectedCity) {
        searchSelector.shouldBe(visible).click();
        searchSelector.clear();
        searchSelector.setValue(expectedCity);

        return this;
    }

    public String getActualCity(String expectedCity) {
        return listOfCitiesSelector
                .shouldBe(sizeNotEqual(0))
                .stream()
                .map(SelenideElement::text)
                .filter(text->text.contains(expectedCity))
                .collect(toList())
                .stream()
                .findFirst()
                .toString()
                .trim();
    }

    public ContactPage selectRequiredCity(String expectedCity) {
        listOfCitiesSelector
                .shouldBe(sizeNotEqual(0),ofSeconds(12))
                .filterBy(text(expectedCity))
                .get(0)
                .click();

        return this;
    }

    public ContactPage selectShopFromSidebar(int requiredValue) {
        $x("//select[@id='contactsDeliveryType']")
                .shouldBe(visible)
                .selectOption(requiredValue);

        return this;
    }

    public String getAddressList(String expectedAddress) {
        return $$x("//span[@class='contacts-map__toggle-address']")
                .shouldHave(sizeNotEqual(0))
                .shouldHave(itemWithText(expectedAddress))
                .stream()
                .map(SelenideElement::text)
                .collect(toList())
                .stream()
                .findFirst()
                .toString()
                .trim();
    }

    public ContactPage clickOnExpectedCityTag(String expectedCity) {
        var list = $$x("//*[@class='tags__item ng-star-inserted']");
        list.find(text(expectedCity)).click();

        return this;
    }

    public List<String> getPointOfDeliveryAddressesList(String expectedAddress) {
        return $$x("//div[@class='shop__body']//p[@class='shop__address shop__address--bold']")
                .shouldHave(sizeNotEqual(0))
                .stream()
                .map(SelenideElement::text)
                .filter(text -> text.contains(expectedAddress))
                .collect(toList());
    }
}
