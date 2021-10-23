package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.pageobjects.rozetka.CategoriesPage;
import com.softserveinc.ita.pageobjects.rozetka.HomePage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RozetkaTest extends TestRunner {

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void categoryTest() {
        HomePage homePage = new HomePage(driver);
        String categoryTitle = homePage.getCategory().toLowerCase();
        homePage.categoryClick();
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        Assert.assertEquals(categoryTitle, categoriesPage.getCategory().toLowerCase());
    }
    @Test
    public void dropdownCategoryTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String categoryTitle = homePage.getDropdownCategory().toLowerCase();
        homePage.dropdownCategoryClick();
        Thread.sleep(2000);
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        Assert.assertEquals(categoryTitle, categoriesPage.getCategory().toLowerCase());
    }
}
