package com.softserveinc.ita.pageobjects;

import com.softserveinc.ita.utils.runners.TestRunner;
import org.openqa.selenium.WebDriver;

public abstract class PageLoader extends TestRunner {

    public WebDriver driver;

    public SearchGoods loadSearch() {return new SearchGoods(driver);}

    public ShoppingCartPage loadShoppingCartPage() {return new ShoppingCartPage(driver);}

    public ShoppingCartModal loadShoppingCartModal() {return new ShoppingCartModal(driver);}

    public LoginPageModal loadLoginPageModal() { return new LoginPageModal(driver); }
}
