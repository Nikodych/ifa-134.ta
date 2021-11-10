package com.softserveinc.ita.mmakoviichuk.utils.runners;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ElementsUtil {

    public static void waitForAttributeChanges(SelenideElement selenideElement, String attribute, String value) {
        selenideElement.shouldBe(Condition.attribute(attribute, value));
    }

}
