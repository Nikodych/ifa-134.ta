package com.softserveinc.ita.models;

import java.util.EnumSet;

import static java.util.EnumSet.allOf;

public interface IUiTextEnum {

    static <T extends Enum<T> & IUiTextEnum> T fromValue(String name, Class<T> enumType) {
        EnumSet<T> all = allOf(enumType);

        for (T aEnum : all) {
            if (aEnum.name().equalsIgnoreCase(name)) {
                return aEnum;
            }
        }
        throw new IllegalArgumentException("Unknown " + enumType.getSimpleName() + ": " + name);
    }
}
