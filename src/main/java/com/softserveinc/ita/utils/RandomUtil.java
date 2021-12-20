package com.softserveinc.ita.utils;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtil {

    public static int getRandomNumber(int upperBound) {
        return new Random().nextInt(upperBound);
    }
}
