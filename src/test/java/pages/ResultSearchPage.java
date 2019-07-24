package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import settings.WebMethods;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.switchTo;

public class ResultSearchPage extends WebMethods {

    private static final String VACANCY_LINK = ".resume-search-item__name > a";
    private static final String RESULT_SEARCH_PAGE = "//h1[@data-qa='page-title']";
    private static final By EMPLOYER_LINK = byXpath("//a[@data-qa='vacancy-serp__vacancy-employer']");

    @Step("Проверка корректного заголовка после успешного поиска вакансии")
    public void viewSuccessResultAfterSearch() {
        String titleSearch = getText(RESULT_SEARCH_PAGE);
        Assert.assertTrue(titleSearch.contains("вакансий") |
                                   titleSearch.contains("вакансии") |
                                   titleSearch.contains("вакансия"), "Некорректный текст заголовка");
    }

    @Step("Проверка корректного заголовка после некорректного поиска вакансии")
    public void viewFailedResultAfterSearch(final HomePage.Vacancy name) {
        String titleSearch = getText(RESULT_SEARCH_PAGE);
        Assert.assertTrue(titleSearch.contains("По запросу «" + name.description + "» ничего не найдено"), "Некорректный текст заголовка");
    }

    @Step("Проверка корректноо названия заголовка введенной вакансии")
    public void viewSuccessResult(final HomePage.Vacancy name) {
        String titleSearch = getText(RESULT_SEARCH_PAGE);
        Assert.assertTrue(titleSearch.contains(name.description), "Некорректный текст вакансии");
    }

    @Step("Переход в карточку вакансии")
    public void openVacancyCard() {
        click(VACANCY_LINK);
        switchTo().window(1);
    }

    @Step("Переход в карточку работодателя")
    public void openEmployerCard() {
        click(EMPLOYER_LINK);
    }

}
