package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.pageobjects.RozetkaPage;
import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserveinc.ita.pkuravskyi.pageobjects.BasePage.getCurrentUrl;

public class RozetkaTest extends TestRunner {

    @BeforeClass
    public void setUpTest() {
        homePage = "https://rozetka.com.ua/ua/";
        rozetkaPage = new RozetkaPage();
    }

    @Test
    public void verifyLanguageChangeTest() {
        rozetkaPage.changeLanguage();
        Assert.assertEquals(getCurrentUrl(), "https://rozetka.com.ua/");
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
        Assert.assertEquals(rozetkaPage.getSelectedCategoryName(), category);
    }
}
