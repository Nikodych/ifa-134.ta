package com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.ElementsUtil.*;

public class CategoriesPage {

    public String getCategoryUrl(String url) {
        return waitForUrlChanges(url);
    }
}
