package com.softserveinc.ita.pkuravskyi.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<T> {

    protected String searchBar;
    protected String searchButton;

    public T searchBarInputText(String searchText) {
        $x(searchBar).setValue(searchText);

        return (T) this;
    }

    public T searchButtonClick() {
        $x(searchButton).click();

        return (T) this;
    }

    public String getSearchBarText() {
        return $x(searchBar).getAttribute("value");
    }
}
