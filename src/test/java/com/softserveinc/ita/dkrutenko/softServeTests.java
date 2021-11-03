package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.dkrutenko.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class softServeTests extends TestRunner {

    @DataProvider
    public Object[][] softServeLangVerification() {
        return new Object[][]{
            {"We are advisors, engineers, and designers solving business challenges with innovative technology solutions" ,
             "SoftServe berät Unternehmen weltweit in Digitalisierungs- prozessen und arbeitet am neuesten Stand der Technik",
             "SoftServe - це провідна ІТ-компанія, що займається консалтингом та надає послуги у сфері цифрових технологій"} };
        }

    @Test(dataProvider = "softServeLangVerification")
    public void verifyLanguageSwitcher(String english, String deutch, String ukrainian) {
    softServeBasePage.acceptCookieMessageButton();
    softServeBasePage.clickMenuButton();
    softServeBasePage.clickLanguageSwitcher();
    var expectedTitle = softServeBasePage.getTitle().contains(english)
            || softServeBasePage.getTitle().contains(deutch)
            || softServeBasePage.getTitle().contains(ukrainian);
        assertTrue(expectedTitle);
    }
    }
