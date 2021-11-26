package com.softserveinc.ita.deprecated.dkrutenko.pageobjects.rozetka;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.*;
import static java.util.stream.Collectors.toList;

public class SearchGoods extends BasePage {

    private final String goodsElementsListSelector = "//*[@class='goods-tile__title']";

    public ElementsCollection getGoodsList() {
        return $$x(goodsElementsListSelector);
    }

    public String getRequiredProductName(String item) {
        var list = getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(toList());

        return list.stream().findFirst().toString();
    }

        public ShoppingCartModal findActualtem(String text) {
            $(byPartialLinkText(text)).click();

            return new ShoppingCartModal();
        }
    }