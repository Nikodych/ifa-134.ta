package com.softserveinc.ita.models;

import com.codeborne.selenide.ElementsCollection;
import lombok.experimental.UtilityClass;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.*;
import static java.time.Duration.ofSeconds;

@UtilityClass
public class RandomUtil {

    public static void randomizerForListCategories(ElementsCollection selector) {
        var random = new Random();
        var list = selector.shouldBe(sizeNotEqual(0), ofSeconds(10));
        list
                .get(random.nextInt(list.size()))
                .click();
    }
}
