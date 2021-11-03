package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTest extends TestRunner {

    @Test
    public void verifyLanguageChange() {
        rozetkaPage.changeLanguage();
        Assert.assertEquals(rozetkaPage.currentUrl(), "https://rozetka.com.ua/ua/");
    }

    @Test
    public void verifyCategoriesOpen() {
        rozetkaPage.selectCategory("Товары для дома");
        Assert.assertEquals(rozetkaPage.verifySelectedCategory(), "Товары для дома");
    }
}
