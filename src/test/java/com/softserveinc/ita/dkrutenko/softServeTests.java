package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.dkrutenko.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class softServeTests extends TestRunner {

    @DataProvider
    public Object[][] softServeLangVerification() {
        return new Object[][]{
                {"We are advisors, engineers, and designers solving business challenges with innovative technology solutions",
                        "SoftServe berät Unternehmen weltweit in Digitalisierungs- prozessen und arbeitet am neuesten Stand der Technik",
                        "SoftServe - це провідна ІТ-компанія, що займається консалтингом та надає послуги у сфері цифрових технологій"}};
    }

    @Test(dataProvider = "softServeLangVerification")
    public void verifyLanguageSwitcher(String english, String deutch, String ukrainian) {
        softServeBasePage.clickAcceptCookieMessageButton();
        softServeBasePage.clickHeaderMenuButton();
        softServeBasePage.clickLanguageSwitcher();
        var expectedTitle = softServeBasePage.getTitle().contains(english)
                || softServeBasePage.getTitle().contains(deutch)
                || softServeBasePage.getTitle().contains(ukrainian);
        assertTrue(expectedTitle);

        softServeBasePage.clickHeaderMenuButton();
        softServeBasePage.clickLanguageSwitcher();
        assertTrue(expectedTitle);
    }

    @DataProvider
    public Object[][] softServeContactVerification() {
        return new Object[][]{
                {"Dmytro", "Krutenko", "dospecwork@gmail.com", "SoftServe Academy",
                        "+380957125027", "test ''contact us'' page", "4"}};
    }

    @Test(dataProvider = "softServeContactVerification")
    public void verifyContactUsPage(String firstName, String lastName, String email,
                                    String company, String phone, String message, String expectedCategory) {
        softServeBasePage.clickAcceptCookieMessageButton();
        softServeBasePage.clickHeaderContactsMenuButton();
        softServeBasePage.clickViewFullPage();
        contactUsPage.fillContactPageFields(firstName, lastName, email, company, phone, message);
        contactUsPage.clickFormModalMenu();
        contactUsPage.selectFromModalMenu(expectedCategory);
        var actualEmail = contactUsPage.getAttributeFromEmailField();
        contactUsPage.clickAcceptTermsAndPolicyCheckbox();
        contactUsPage.clickAcceptUpdatesAndOffersCheckbox();
        assertEquals(actualEmail, email);
    }
}
