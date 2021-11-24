package com.softserveinc.ita.utils.runners;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

@UtilityClass
public class ElementsUtil {

    public void selectPriceFilterFromModalMenu(int value, String selector) {
        var selectCheap = $(selector).should(Condition.appear);
        var index = new Select(selectCheap);
        index.selectByIndex(value);
    }

    public void setPriceValueInFilter(String selector, String price) {
        var maxPriceField = $x(selector);
        timeout = 5000;
        maxPriceField.click();
        maxPriceField.setValue(price);
    }

    public void randomizerForListCategories(String selector) {
        var random = new Random();
        var list = $$x(selector)
                .shouldBe(sizeGreaterThan(0), ofSeconds(10));
        list
                .get(random.nextInt(list.size()))
                .click();
    }

    public List<String> getListWithGoods(String selector, String item) {
        return $$x(selector)
                .shouldBe(CollectionCondition.sizeGreaterThan(0), ofSeconds(8))
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(toList());
    }
}