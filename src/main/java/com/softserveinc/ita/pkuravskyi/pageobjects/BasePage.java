package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;

import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;
import static com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner.*;

public abstract class BasePage<T> {

    protected By searchBar;
    protected By searchButton;

    public T searchBarInputText(String searchText) {
        $x(searchBar).sendKeys(searchText);

        return (T) this;
    }

    public T searchButtonClick() {
        $x(searchButton).click();

        return (T) this;
    }

    public String getSearchBarText() {
        return $x(searchBar).getAttribute("value");
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
