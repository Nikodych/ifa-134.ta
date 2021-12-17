package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.ita.pageobjects.modals.User;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.repos.VacancyUserRepo.*;
import static com.softserveinc.ita.utils.ElementsUtil.*;
import static com.softserveinc.ita.utils.RandomUtil.*;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class VacancyPage extends BasePage<VacancyPage> {
    private final SelenideElement emailFieldSelector = $x("//input[@id='email']");

    public VacancyPage selectRandomCategory() {
        var categoriesList = $$x("//*[@class='list-item ng-star-inserted']")
                .shouldBe(sizeNotEqual(0), ofSeconds(10));
        categoriesList
                .get(getRandomNumber(categoriesList.size()))
                .click();

        return this;
    }

    public VacancyPage clickOnSendDataButton() {
        $x("//button[@class='button button--green button--medium want-work__submit ng-star-inserted']").click();

        return this;
    }

    public VacancyPage fillVacancyPageFields(User user) {
        setText($x("//input[@id='first_name']"), user.getFirstName());
        setText($x("//input[@id='last_name']"), user.getLastName());
        setText($x("//input[@id='phone']"), user.getPhone());
        setText(emailFieldSelector, user.getEmail());

        return this;
    }

    public VacancyPage selectCategoryAndDepartament(User user) {
        selectOptionFromMenu($x("//div[@class='form__row ng-star-inserted'][1]/select"), user.getCategoryValue());
        selectOptionFromMenu($x("//div[@class='form__row ng-star-inserted'][2]/select"), user.getDepartamentValue());

        return this;
    }

    public String getAttributeFromEmailField() {
        return emailFieldSelector.getAttribute("value").trim();
    }

    public String getTextFromCategoryModal() {
        return $x("//*[@id='categories']")
                .getText()
                .trim();
    }
}
