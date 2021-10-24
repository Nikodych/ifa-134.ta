package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.pageobjects.rozetka.CategoriesPage;
import com.softserveinc.ita.pageobjects.rozetka.HomePage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RozetkaTest extends TestRunner {

    @BeforeMethod
    public void open() {
        getDriver().get("https://rozetka.com.ua/");
        getDriver().manage().window().maximize();;
    }

    @Test
    public void categoryTest() {
        String categoryTitle = new HomePage(getDriver()).getCategory().toLowerCase();
        new HomePage(getDriver()).categoryClick();
        Assert.assertEquals(categoryTitle, new CategoriesPage(getDriver()).getCategory().toLowerCase());
    }

    @Test
    public void dropdownCategoryTest() {
        HomePage homePage = new HomePage(getDriver());
        String categoryTitle = homePage.getDropdownCategory().toLowerCase();
        homePage.dropdownCategoryClick();
        Assert.assertEquals(categoryTitle, new CategoriesPage(getDriver()).getCategory().toLowerCase());
    }
}
