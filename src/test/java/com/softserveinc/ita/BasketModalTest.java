package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        var productTitle = homePage
                .openCategory(title)
                .openSubCategory()
                .openProduct()
                .getProductTitle();

        var basketModal = new ProductPage().addToCart();

        assertThat(basketModal.getProductTitle())
                .as("Product should be in cart")
                .contains(productTitle);
    }
}
