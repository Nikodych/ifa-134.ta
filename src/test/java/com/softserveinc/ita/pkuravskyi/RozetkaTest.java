package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.pageobjects.RozetkaPage;
import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserveinc.ita.pkuravskyi.models.LanguageSwitcher.RU;
import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {

    @BeforeClass
    public void setUpTest() {
        homePage = "https://rozetka.com.ua/ua/";
        rozetkaPage = new RozetkaPage();
    }

    @Test
    public void verifyLanguageChangeTest() {
        rozetkaPage.changeLanguageTo(RU);
        var isLangChanged = rozetkaPage.isLanguageChangedTo(RU);
        assertThat(isLangChanged)
                .as("Language should be changed")
                .isEqualTo(true);
    }

    @DataProvider
    public Object[][] categories() {
        return new Object[][]{
                {"Зоотовари"}, {"Спорт і захоплення"}, {"Товари для геймерів"}
        };
    }

    @Test(dataProvider = "categories")
    public void verifyCategoriesOpeningTest(String category) {
        rozetkaPage.selectCategory(category);
        var selectedCategoryName = rozetkaPage.getSelectedCategoryName();
        assertThat(selectedCategoryName)
                .as("Category name should be correct")
                .contains(category);
    }
}
