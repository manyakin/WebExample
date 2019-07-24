package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import settings.WebMethods;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;

public class VacancyCardPage extends WebMethods {

    private static final String VACANCY_NAME = ".vacancy-title ";
    private static final String VACANCY_BODY = ".vacancy-section";
    private static final String VACANCY_SALARY = ".vacancy-salary";
    private static final String COMPANY_CARD = ".vacancy-company-name";
    private static final String COMPANY_NAME = ".vacancy-company-name-wrapper";
    private static final By SHOW_CONTACTS = byText("Показать контакты");
    private static final String VACANCY_CONTACTS = ".vacancy-contacts__title-closed";
    private static final By COMPANY_LINK = byXpath("//a[@data-qa='vacancy-response-link-top']");
    private static final By COMPANY_EXPERIENCE = byXpath("//span[@data-qa='vacancy-experience']");
    private static final By VACANCY_EMPLOYMENT = byXpath("//p[@data-qa='vacancy-view-employment-mode']");
    private static final By VACANCY_OTHER = byXpath("//div[@data-qa='vacancy-view-vacancies-from-search']");

    @Step("Отображение элементов карточки вакансии")
    public void viewCard() {
        check(VACANCY_NAME);
        check(COMPANY_NAME);
        check(VACANCY_BODY);
        check(COMPANY_LINK);
        check(SHOW_CONTACTS);
        check(VACANCY_OTHER);
        check(VACANCY_SALARY);
        check(VACANCY_CONTACTS);
        check(COMPANY_EXPERIENCE);
        check(VACANCY_EMPLOYMENT);
    }

    @Step("Переход в карточку работодателя")
    public void openEmployerCard() {
        click(COMPANY_CARD);
    }

}
