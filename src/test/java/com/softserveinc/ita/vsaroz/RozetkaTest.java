package com.softsgit cheerveinc.ita.vsaroz;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.softserveinc.ita.vsaroz.pageobjects.RztkPageObjects;
import com.softserveinc.ita.vsaroz.utils.runners.TestRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class RozetkaTest extends TestRunner {
    @Test
    public void rozetkaTest() {
        RztkPageObjects rztk = new RztkPageObjects();
            rztk.findLapTop();
    }



}