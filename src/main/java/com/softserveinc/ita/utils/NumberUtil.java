package com.softserveinc.ita.utils;

import lombok.experimental.UtilityClass;

import static java.lang.Integer.parseInt;

@UtilityClass
public class NumberUtil {

    public static int parseIntPrice(String testPrice) {
        return parseInt(testPrice.replaceAll("\\s|₴", ""));
    }
}
