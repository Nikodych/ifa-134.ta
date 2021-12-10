package com.softserveinc.ita.utils;

import static java.lang.Integer.parseInt;

public class NumberUtil {

    public static int parseIntPrice(String testPrice) {
        return parseInt(testPrice.replaceAll("\\s|₴", ""));
    }
}
