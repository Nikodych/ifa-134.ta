package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    private HomePage homePage = new HomePage();

    @DataProvider
    public Object[][] rozetkaCategoryData() {
        return new Object[][]{
                {"Товари для геймерів"},
                {"Побутова техніка"}
        };
    }
    @Test(dataProvider = "rozetkaCategoryData")
    public void categoryTest(String title) {
         homePage.openCategory(title)
                .openSubCategory()
                .openProduct();

        assertThat(new ProductPage().getProductCategory().contains(title))
                .as("Product should correspond " + title + " category")
                .isTrue();
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void dropdownCategoryTest(String title) {
        homePage.openCatalog()
                .openDropdownCategory(title)
                .openSubCategory()
                .openProduct();

        assertThat(new ProductPage().getProductCategory().contains(title))
                .as("Product should correspond " + title + " category")
                .isTrue();
    }

    @Test(enabled = false)
    public void verifyLanguageSwitchingTest() {
        var languageToSwitch = homePage.isLanguageSwitchedTo(UA) ? RU : UA;
        homePage.switchLanguageTo(languageToSwitch);
        var isLanguageSwitched = homePage.isLanguageSwitchedTo(languageToSwitch);

        assertThat(isLanguageSwitched)
                .as("Language should be switched")
                .isTrue();
    }
}
