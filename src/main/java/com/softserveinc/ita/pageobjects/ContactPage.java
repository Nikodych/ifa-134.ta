package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import javax.swing.text.Element;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.util.stream.Collectors.*;

public class ContactPage extends BasePage<ContactPage> {

    private final SelenideElement searchSelector = $x("//div[@Class='autocomplete']/input[@name='search']");

    public ContactPage fillCitySearchField(String expectedCity) {
        searchSelector.click();
        searchSelector.clear();
        searchSelector.setValue(expectedCity);

        return this;
    }

    public List<String> getListOfCities() {
        return $$x("//ul[@class='autocomplete__list dialog']/li")
                .shouldBe(sizeNotEqual(0))
                .stream()
                .map(SelenideElement::text)
                .collect(toList());
    }

    public ContactPage selectRequiredCity(String expectedCity) {
        getListOfCities()
                .stream()
                .filter(text -> text.contains(expectedCity))
                .collect(toList());

        return this;
    }

    public ContactPage selectShopFromSidebar(int requiredValue) {
        $x("//select[@id='contactsDeliveryType']").selectOption(requiredValue);

        return this;
    }

    public List<String> getListOfAddresses() {
        return $$x("//span[@class='contacts-map__toggle-address']")
                .shouldHave(sizeNotEqual(0))
                .stream()
                .map(SelenideElement::text)
                .collect(toList());
    }

    public ContactPage clickOnExpectedCityTag(String expectedCity) {
        var list = $$x("//*[@class='tags__item ng-star-inserted']");
        list.find(text(expectedCity)).click();

        return this;
    }

    public List<String> getPointOfDeliveryAddressesList(String expectedAddress) {
        return $$x("//div[@class='shop__body']//p[@class='shop__address shop__address--bold']")
                .stream()
                .map(SelenideElement::text)
                .filter(text -> text.contains(expectedAddress))
                .collect(toList());
    }
}
