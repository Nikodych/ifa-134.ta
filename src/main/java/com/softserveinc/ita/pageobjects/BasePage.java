package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.ita.models.LanguageSwitcher;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public abstract class BasePage<T extends BasePage<T>> {

    private final SelenideElement searchButtonElement = $x("//button[contains(@class, 'search-form__submit')]");

    @Step("BasePage: Clicked on main page logo")
    public HomePage clickOnMainPageLogo() {
        $x("//a[@class='header__logo']").click();

        return new HomePage();
    }

    @Step("BasePage: Opened side menu")
    public MenuModal openSideMenu() {
        $x("//button[@class = 'header__button']").click();

        return new MenuModal();
    }

    @Step("BasePage: Opened catalog")
    public CatalogModal openCatalog() {
        $x("//button[contains(@id, 'fat-menu')]").click();

        return new CatalogModal();
    }

    @Step("BasePage: Set text '{inputText}' in search bar")
    public T setTextInSearchBar(String inputText) {
        var search = $x("//input[@name = 'search']");
        search.click();
        search.clear();
        search.setValue(inputText);

        return (T) this;
    }

    @Step("BasePage: Performed search")
    public ProductModel performSearch() {
        searchButtonElement.click();

        return new ProductModel();
    }

    @Step("BasePage: Opened user modal window")
    public UserModal openUserModalWindow() {
        $x("//rz-user[@class='header-actions__component']").click();

        return new UserModal();
    }

    @Step("BasePage: Opened basket")
    public BasketModal openBasket() {
        $x("//rz-cart[@class = 'header-actions__component']").click();

        return new BasketModal();
    }

    @Step("BasePage: Switched language to {language}")
    public T switchLanguageTo(LanguageSwitcher language) {
        $x(format("//a[contains(@class, 'lang__link') and contains(text(), '%s')]", language.name())).click();

        return (T) this;
    }

    public boolean isLanguageSwitchedTo(LanguageSwitcher language) {
        var verificationWord = language.getVerificationWord();
        var searchButtonText = searchButtonElement.getText();

        return searchButtonText.equals(verificationWord);
    }

    @Step("BasePage: Closed advertising banner if displayed")
    public T closeAdvertisingBannerIfDisplayed() {
        if ($("#rz-banner").is(exist)) {
            $("span .exponea-close-cross").click();
        }

        return (T) this;
    }

    @Step("BasePage: Clicked on header menu")
    public T clickOnHeaderMenuButton() {
        $x("//button[@class='header__button']").click();

        return (T) this;
    }

    @Step("BasePage: Clicked on one of displayed mobile app link")
    public HeaderMenuModal selectMobileAppLink(String appLink) {
        $x("//ul[@class='side-stores__buttons']//img[contains(@alt, '" + appLink + "')]")
                .shouldBe((visible), ofSeconds(8))
                .click();

        return new HeaderMenuModal();
    }

    @Step("BasePage: Opened comparison page")
    public ComparisonPage openComparisonPage() {
        $("rz-comparison button")
                .shouldBe(visible)
                .hover()
                .click();
        $("a.comparison-modal__link").click();

        return new ComparisonPage();
    }
}
