package com.softserveinc.ita.mmakoviichuk.models;

public enum Template {
    CATEGORY_SELECTOR_TEMPLATE ("//a[@class ='menu-categories__link' and contains(text(), '%s')]"),
    DROPDOWN_CATEGORY_SELECTOR_TEMPLATE ("//a[@class = 'menu-categories__link js-menu-categories__link' and contains(text(), '%s')]"),
    SIDEBAR_SELECTOR_TEMPLATE ("//a[div[@Class = 'side-navigation__title' and text() = '%s']]");

    private String template;

    Template(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
