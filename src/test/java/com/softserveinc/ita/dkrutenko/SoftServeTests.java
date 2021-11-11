package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.dkrutenko.pageobjects.softserve.ContactUsPage;
import com.softserveinc.ita.dkrutenko.pageobjects.softserve.MainPage;
import com.softserveinc.ita.dkrutenko.utils.runners.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;

public class SoftServeTests extends TestRunner {

    private final MainPage softServeMainPage = new MainPage();

    @BeforeMethod
    private void openUrl() {
        open(softServeUrl);
    }

    @DataProvider
    public Object[][] softServeChangeLanguageVerification() {
        return new Object[][]{
                {"We are advisors, engineers, and designers solving business challenges with innovative technology solutions",
                        "SoftServe berät Unternehmen weltweit in Digitalisierungs- prozessen und arbeitet am neuesten Stand der Technik",
                        "SoftServe - це провідна ІТ-компанія, що займається консалтингом та надає послуги у сфері цифрових технологій"}};
    }

    @Test(dataProvider = "softServeChangeLanguageVerification")
    public void verifyChangeLanguageFunction(String english, String german, String ukrainian) {
        softServeMainPage.clickAcceptCookieMessageButton();
        softServeMainPage.clickHeaderMenuButton();
        softServeMainPage.clickLanguageSwitcher();
        
        var getTitle = softServeMainPage.getTitle();
        var expectedTitle = getTitle.contains(english)
                || getTitle.contains(german)
                || getTitle.contains(ukrainian);
        assertTrue(expectedTitle);

        softServeMainPage.clickHeaderMenuButton();
        softServeMainPage.clickLanguageSwitcher();
        assertTrue(expectedTitle);
    }

    @DataProvider
    public Object[][] softServeContactUsFieldsVerification() {
        return new Object[][]{
                {"Dmytro", "Krutenko", "dospecwork@gmail.com", "SoftServe Academy",
                        "+380957125027", "test ''contact us'' page", "4"}};
    }

    @Test(dataProvider = "softServeContactUsFieldsVerification")
    public void verifyContactUsFields(String firstName, String lastName, String email,
                                      String company, String phone, String message, String expectedCategory) {
        softServeMainPage.clickAcceptCookieMessageButton();
        softServeMainPage.clickHeaderContactsMenuButton();
        ContactUsPage contactUsPage = softServeMainPage.clickViewFullContactPage();

        contactUsPage.fillContactPageFields(firstName, lastName, email, company, phone, message);
        contactUsPage.clickFormInputModalMenu();
        contactUsPage.selectFormInputModalMenu(expectedCategory);

        contactUsPage.clickAcceptTermsAndPolicyCheckbox();
        contactUsPage.clickAcceptUpdatesAndOffersCheckbox();
        var actualEmail = contactUsPage.getAttributeFromEmailField();
        assertEquals(actualEmail, email);
    }
}
