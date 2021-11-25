package com.softserveinc.ita.pageobjects;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.softserveinc.ita.utils.runners.ElementsUtil.getListWithGoods;

public class SearchResultPage extends BasePage<SearchResultPage> {

    public List<String> getGoodsList(String item) {
        return getListWithGoods($$x("//*[@class='goods-tile__title']"), item);
    }
}
