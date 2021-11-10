package com.softserveinc.ita.vsaroz.tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.softserveinc.ita.vsaroz.pageobjects.RozetkaPage;
import com.softserveinc.ita.vsaroz.utils.runners.TestRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class RozetkaTest extends TestRunner {

    @Test
    public void rozetkaTest() {
        rozetkaPage.clickOnMenuItem();
        rozetkaPage.clickLapTop();
        rozetkaPage.filterByBrand();
    }
}