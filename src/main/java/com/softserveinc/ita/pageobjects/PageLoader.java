package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageLoader {
private WebDriver driver;

    public SearchGoods loadSearchGoods() {return new SearchGoods(driver);}

    public ShoppingCartPage loadShoppingCartPage() {return new ShoppingCartPage(driver);}

    public ShoppingCartModal loadShoppingCartModal() {return new ShoppingCartModal(driver);}

    public LoginPageModal loadLoginPageModal() { return new LoginPageModal(driver); }
}
