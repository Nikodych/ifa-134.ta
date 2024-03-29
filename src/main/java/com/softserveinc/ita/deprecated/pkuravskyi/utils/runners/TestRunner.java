package com.softserveinc.ita.deprecated.pkuravskyi.utils.runners;

import com.codeborne.selenide.Configuration;
import com.softserveinc.ita.deprecated.pkuravskyi.pageobjects.GooglePage;
import com.softserveinc.ita.deprecated.pkuravskyi.pageobjects.RozetkaPage;
import com.softserveinc.ita.deprecated.pkuravskyi.pageobjects.SoftServePage;
import com.softserveinc.ita.deprecated.pkuravskyi.pageobjects.WikipediaPage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class TestRunner {

    protected GooglePage googlePage;
    protected WikipediaPage wikipediaPage;
    protected SoftServePage softServePage;
    protected RozetkaPage rozetkaPage;
    protected static String homePage;

    @BeforeMethod
    public void openHomePage() {
        Configuration.browserSize = "1920x1080";
        open(homePage);
    }
}
