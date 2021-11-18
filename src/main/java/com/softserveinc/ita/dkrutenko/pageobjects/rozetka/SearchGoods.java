package com.softserveinc.ita.dkrutenko.pageobjects.rozetka;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.*;
import static java.util.stream.Collectors.toList;

public class SearchGoods extends BasePage {

    private final String goodsElementsListSelector = "//*[@class='goods-tile__title']";

    public List<String> getGoodsList(String item) {
        return $$x(goodsElementsListSelector)
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(toList());
    }

    public String getFirstRequiredItem(String item) {
        return getGoodsList(item).stream().findFirst().toString();
    }

    public String getLastRequiredItem(String item) {
        var list = getGoodsList(item);

        return list.get(list.size() -1);
    }

    public ShoppingCartModal findActualtem(String text) {
        $(byPartialLinkText(text)).click();

        return new ShoppingCartModal();
    }
}
