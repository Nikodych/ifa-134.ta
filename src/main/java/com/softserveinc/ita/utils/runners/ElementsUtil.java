package com.softserveinc.ita.utils.runners;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

@UtilityClass
public class ElementsUtil {

    public static List<String> getListWithGoods(ElementsCollection selector, String item) {
        return selector
                .shouldBe(CollectionCondition.sizeGreaterThan(0), ofSeconds(8))
                .stream()
                .map(SelenideElement::getText)
                .filter(text -> text.contains(item))
                .collect(toList());
    }
}