package com.softserveinc.ita.mmakoviichuk.utils.runners;

import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Condition.attribute;

@UtilityClass
public class ElementsUtil {

    public static void expectedAttribute(SelenideElement selenideElement, String attribute, String value) {
        selenideElement.shouldHave(attribute(attribute, value));
    }

}
