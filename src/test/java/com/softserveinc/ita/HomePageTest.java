package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.CategoriesPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.pageobjects.SearchResultPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    private HomePage homePage = new HomePage();
    private SearchResultPage searchResultPage = new SearchResultPage();
    private CategoriesPage categoriesPage = new CategoriesPage();
    private ProductPage productPage = new ProductPage();

    @DataProvider
    public Object[][] rozetkaCategoryData() {
        return new Object[][]{
                {"Товари для геймерів"},
                {"Побутова техніка"},
                {0},
                {0}
        };
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void verifyCategoryTransitionTest(String title, int orderNumber, int productNumber) {
        homePage.openCategory(title);
        searchResultPage.openSubCategoryByOrderNumber(orderNumber);
        productPage.openProductByNumber(productNumber);

        var actualTitle = new ProductPage().getProductCategory();

        assertThat(actualTitle)
                .as("Product should correspond " + title + " category")
                .contains(title);
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void verifyCategoryTransitionThroughDropdownTest(String title, int orderNumber, int productNumber) {
        homePage
                .openCatalog()
                .openDropdownCategory(title);
        searchResultPage.openSubCategoryByOrderNumber(orderNumber);
        productPage.openProductByNumber(productNumber);

        var actualTitle = new ProductPage().getProductCategory();

        assertThat(actualTitle)
                .as("Product should correspond " + title + " category")
                .contains(title);
    }

    @Test
    public void verifyLanguageSwitchingTest() {
        var languageToSwitch = homePage.isLanguageSwitchedTo(UA) ? RU : UA;
        homePage.switchLanguageTo(languageToSwitch);
        var isLanguageSwitched = homePage.isLanguageSwitchedTo(languageToSwitch);

        assertThat(isLanguageSwitched)
                .as("Language should be switched")
                .isTrue();
    }
}
