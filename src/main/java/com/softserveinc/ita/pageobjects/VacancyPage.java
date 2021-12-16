package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.repos.VacancyUserRepo.*;
import static com.softserveinc.ita.utils.ElementsUtil.*;
import static com.softserveinc.ita.utils.RandomUtil.*;
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

    public VacancyPage fillVacancyPageFields() {
        setText($x("//input[@id='first_name']"), getVacancyUser().getFirstName());
        setText($x("//input[@id='last_name']"), getVacancyUser().getLastName());
        setText($x("//input[@id='phone']"), getVacancyUser().getPhone());
        setText(emailFieldSelector, getVacancyUser().getEmail());

        return this;
    }

    public VacancyPage selectCategoryAndDepartament() {
        selectModalMenu($x("//div[@class='form__row ng-star-inserted'][1]/select"), getVacancyUser().getCategoryValue());
        selectModalMenu($x("//div[@class='form__row ng-star-inserted'][2]/select"), getVacancyUser().getDepartamentValue());

        return this;
    }

    public String getAttributeFromEmailField() {
        return emailFieldSelector.getAttribute("value").trim();
    }

    public String getTextFromCategoryModal(String categoryId) {
        return $x("//*[@id='categories']/option["+categoryId+"]")
                .getText()
                .trim();
    }
}
