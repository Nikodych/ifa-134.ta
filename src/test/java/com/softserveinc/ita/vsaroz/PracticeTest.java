package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticeTest {

    private final String productElement = ("//a[@href='http://automationpractice.com/index.php?id_product=3&controller=product']");
    private final String addToCartButtonElement = ("//button[@class='exclusive']//span");
    private final String closeModalButtonElement = ("//span[@class='cross']");
    private final String viewShoppingCartButtonElement = ("//a[@href='http://automationpractice.com/index.php?controller=order']");
    private final String itemsInCart = ("//span[@class='ajax_cart_quantity']");

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("http://automationpractice.com/index.php");
    }

    @Test
    public void verifyAddToCartTest () {
        $x(productElement)
                .shouldBe(visible)
                .click();
        $x(addToCartButtonElement)
                .shouldBe(visible)
                .click();
        $x(closeModalButtonElement)
                .shouldBe(disappear)
                .click();
        $x(viewShoppingCartButtonElement).click();
        var quantity = $x(itemsInCart).getText();
        Integer.parseInt(quantity);

        assertThat(quantity)
                .as("Incorrect product quantity in the shopping cart");
    }
}
