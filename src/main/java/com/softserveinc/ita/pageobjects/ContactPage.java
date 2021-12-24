package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.*;

public class ContactPage extends BasePage<ContactPage> {

    private final SelenideElement citySearchField = $x("//div[@Class='autocomplete']/input[@name='search']");
    private final ElementsCollection suggestCitiesList = $$x("//ul[@class='autocomplete__list dialog']/li");

    @Step("ContactPage: filled city search field with {expectedCity}")
    public ContactPage fillCitySearchField(String expectedCity) {
        citySearchField
                .shouldBe(visible)
                .click();
        citySearchField.clear();
        citySearchField.setValue(expectedCity);

        return this;
    }

    public String getErrorMessage() {
        return $x("//div[@class='autocomplete']//p")
                .getText()
                .trim();
    }

    public List<String> getSuggestedCitiesList() {
        return suggestCitiesList
                .shouldBe(sizeNotEqual(0), ofSeconds(12))
                .stream()
                .map(SelenideElement::getText)
                .collect(toList());
    }

    @Step("ContactPage: selected required city: {expectedCity}")
    public ContactPage selectRequiredCity(String expectedCity) {
        suggestCitiesList
                .shouldBe(sizeNotEqual(0), ofSeconds(12))
                .filterBy(text(expectedCity))
                .get(0)
                .click();

        return this;
    }

    @Step("ContactPage: selected {requiredCategory} shop category from sidebar")
    public ContactPage selectShopFromSidebar(int requiredCategory) {
        $x("//select[@id='contactsDeliveryType']")
                .shouldBe(visible, ofSeconds(12))
                .selectOption(requiredCategory);

        return this;
    }

    public List<String> getAddressList() {
        return $$x("//*[@class='contacts-map__toggle-address']")
                .shouldHave(sizeNotEqual(0), ofSeconds(12))
                .stream()
                .map(SelenideElement::text)
                .collect(toList());
    }

    @Step("ContactPage: click on 'Show more")
    public ContactPage showMoreTags() {
        $x("//button[@class='button tags__link tags__toggle ng-star-inserted']")
                .shouldBe(visible)
                .click();

        return this;
    }

    @Step("ContactPage: clicked on {expectedCity} city tag")
    public ContactPage clickOnExpectedCityTag(String expectedCity) {
        $$x("//*[@class='tags__item ng-star-inserted']")
                .shouldHave(sizeNotEqual(0), ofSeconds(12))
                .find(text(expectedCity))
                .click();

        return this;
    }

    public List<String> getPointOfDeliveryAddressesList(String expectedAddress) {
        return $$x("//div[@class='shop__body']//p[@class='shop__address shop__address--bold']")
                .shouldHave(sizeNotEqual(0), ofSeconds(12))
                .stream()
                .map(SelenideElement::getText)
                .filter(text -> text.contains(expectedAddress))
                .collect(toList());
    }
}
