package com.softserveinc.ita.vsaroz;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticeTest {

    private final SelenideElement productElement = $x("//a[@href='http://automationpractice.com/index.php?id_product=3&controller=product']");
    private final SelenideElement addToCartButtonElement = $x("//button[@class='exclusive']//span");
    private final SelenideElement closeModalButtonElement = $x("//span[@class='cross']");
    private final SelenideElement viewShoppingCartButtonElement = $x("//a[@href='http://automationpractice.com/index.php?controller=order']");
    private final SelenideElement itemsInCart = $x("//span[@class='ajax_cart_quantity']");

    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open("http://automationpractice.com/index.php");
    }

    @Test
    public void verifyAddToCartTest () {
        productElement
                .shouldBe(visible)
                .click();
        addToCartButtonElement
                .shouldBe(visible)
                .click();
        closeModalButtonElement
                .shouldBe(disappear)
                .click();
        viewShoppingCartButtonElement.click();
        String quantity = itemsInCart.getText();
        assertThat(quantity).isNotNull();
    }
}
