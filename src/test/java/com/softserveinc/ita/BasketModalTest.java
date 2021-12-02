package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestListener;
import com.softserveinc.ita.utils.runners.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({TestListener.class})
public class BasketModalTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @DataProvider
    public Object[][] rozetkaCategoryData() {
        return new Object[][]{
                {"Товари для геймерів"},
                {"Побутова техніка"}
        };
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void verifyAddingProductToCartTest(String title) {
        var expectedProductTitle = homePage
                .openCategory(title)
                .openSubCategory()
                .openProduct()
                .getProductTitle();

        var actualProductTitle = new ProductPage()
                .addToCart()
                .getProductTitle();

        assertThat(actualProductTitle)
                .as("Product should be in cart")
                .contains(expectedProductTitle);
    }
}
