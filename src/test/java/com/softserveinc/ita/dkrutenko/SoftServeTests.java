package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.dkrutenko.pageobjects.softserve.ContactUsPage;
import com.softserveinc.ita.dkrutenko.pageobjects.softserve.MainPage;
import com.softserveinc.ita.dkrutenko.pageobjects.softserve.models.User;
import com.softserveinc.ita.dkrutenko.pageobjects.softserve.models.repo.UserRepo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.open;

public class SoftServeTests {
    protected static final String softServeUrl = "https://www.softserveinc.com/";
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
        assertThat(expectedTitle);

        softServeMainPage.clickHeaderMenuButton();
        softServeMainPage.clickLanguageSwitcher();
        assertThat(expectedTitle);
    }

    @DataProvider
    public Object[][] softServeContactUsFieldsVerification() {
        return new Object[][]{
                {new UserRepo().getContactUsUser()}};
    }

    @Test(dataProvider = "softServeContactUsFieldsVerification")
    public void verifyContactUsFields(User user) {
        softServeMainPage.clickAcceptCookieMessageButton();
        softServeMainPage.clickHeaderContactsMenuButton();
        ContactUsPage contactUsPage = softServeMainPage.clickViewFullContactPage();

        contactUsPage.fillContactPageFields(user);
        contactUsPage.clickFormInputModalMenu();
        contactUsPage.selectFormInputModalMenu(user.getExpectedCategory());

        contactUsPage.clickAcceptTermsAndPolicyCheckbox();
        contactUsPage.clickAcceptUpdatesAndOffersCheckbox();
        var actualEmail = contactUsPage.getAttributeFromEmailField();
        assertThat(actualEmail.equals(user.getEmail()));
    }
}
