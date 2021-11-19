package com.softserveinc.ita.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LanguageSwitcher {

    UA("Знайти"),
    RU("Найти");

    private final String verificationWord;
}
