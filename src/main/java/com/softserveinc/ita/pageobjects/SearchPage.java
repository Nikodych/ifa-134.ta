package com.softserveinc.ita.pageobjects;

import java.util.List;

import static com.softserveinc.ita.utils.runners.ElementsUtil.getListWithGoods;

public class SearchPage extends BasePage {

    public List<String> getGoodsList(String item) {
        return getListWithGoods("//*[@class='goods-tile__title']", item);
    }

    public String getFirstRequiredItem(String item) {
        return getGoodsList(item)
                .stream()
                .findFirst()
                .toString();
    }

    public String getLastRequiredItem(String item) {
        var list = getGoodsList(item);

        return list.get(list.size() - 1);
    }
}
