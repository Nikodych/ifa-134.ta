package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticeTest {

    private final String productSelector = "//a[@href='http://automationpractice.com/index.php?id_product=3&controller=product']";
    private final String addToCartButtonSelector = "//button[@class='exclusive']//span";
    private final String closeModalButtonSelector = "//span[@class='cross']";
    private final String shoppingCartButtonSelector = "//a[@href='http://automationpractice.com/index.php?controller=order']";
    private final String itemsInCartSelector = "//span[@class='ajax_cart_quantity']";

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("http://automationpractice.com/index.php");
    }

    @Test
    public void verifyAddToCartTest() {
        $x(productSelector)
                .shouldBe(visible)
                .click();
        $x(addToCartButtonSelector)
                .shouldBe(visible)
                .click();
        $x(closeModalButtonSelector)
                .shouldBe(disappear)
                .click();
        $x(shoppingCartButtonSelector).click();
        var quantity = $x(itemsInCartSelector).getText();

        assertThat(parseInt(quantity))
                .as("Incorrect product quantity in the shopping cart")
                .isGreaterThan(0);
    }
}