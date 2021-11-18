package com.softserveinc.ita.pkuravskyi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum LanguageSwitcher {

    RU("Найти"),
    UA("Знайти");

    @Getter
    private final String verificationWord;
}
