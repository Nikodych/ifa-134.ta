package com.softserveinc.ita.dkrutenko.utils.runners;

import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.LoginPageModal;
import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.SearchGoods;
import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.ShoppingCartModal;
import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.ShoppingCartPage;

public abstract class TestRunner {

    protected SearchGoods searchGoods;
    protected ShoppingCartPage shoppingCartPage;
    protected ShoppingCartModal shoppingCartModal;
    protected LoginPageModal loginPageModal;
    protected static final String rozetkaUrl = "https://rozetka.com.ua/";
    protected static final String softServeUrl = "https://www.softserveinc.com/";
}