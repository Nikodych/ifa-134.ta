package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @Test
    public void verifyProductSwitchingTabsTest() {
        var testCategoryName = "Ноутбуки та комп’ютери";
        var testProductTabName = "Характеристики";

        homePage
                .openCategory(testCategoryName)
                .openSubCategory()
                .openProduct()
                .switchProductTabTo(testProductTabName);

        ProductPage productPage = new ProductPage();

        assertThat(productPage.isCorrectTabDisplayed())
                .as("Correct product tab should be displayed")
                .isTrue();
    }
}
