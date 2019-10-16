package cases;

import io.qameta.allure.Epic;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import settings.WebSettings;

import static pages.GeoPositionPage.City.OMSK;
import static pages.GeoPositionPage.City.SPB;
import static pages.HomePage.Url.OMSK_LINK;
import static pages.HomePage.Url.SPB_LINK;
import static pages.HomePage.Vacancy.*;

@Epic("Web example")
public class Tests extends WebSettings {

    @BeforeTest(description = "Инициализация страниц")
    public void preparing() {
        objHome = new HomePage();
        objLogin = new LoginPage();
        objGeo = new GeoPositionPage();
        objResult = new ResultSearchPage();
        objVacancy = new VacancyCardPage();
        objEmployer = new EmployerCardPage();
    }

    @Test(description = "Отображение ошибок валидации на форме авторизации")
    public void viewFullLoginForm() {
        objHome.openAuthSite();
        objLogin.viewFullLoginForm()
                .viewValidateError();
    }

    @Test(description = "Проверка соответствия выбранного города через алерт геопозиции")
    public void checkMatchingSelectCityThroughAlert() {
        objHome.openBasicSite()
               .openSelectCityFormWithAlert();
        objGeo.selectCityFromList(SPB);
        objHome.checkCurrentUrl(SPB_LINK);
    }

    @Test(description = "Проверка соответствия выбранного города через ссылку в хидере")
    public void checkMatchingSelectCityThroughLink() {
        objHome.openBasicSite()
               .openSelectCityFormWithLink();
        objGeo.selectCityWithSearch(OMSK);
        objHome.checkCurrentUrl(OMSK_LINK);
    }

    @Test(description = "Проверка совпадения результата поиска по вакансии")
    public void checkMatchingResultSearchVacancy() {
        objHome.openBasicSite()
               .search(Manager);
        objResult.viewSuccessResult(Manager);
    }

    @Test(description = "Отображение элементов карточки вакансии")
    public void checkViewVacancyCard() {
        objHome.openBasicSite()
               .selectProposedCity()
               .search(Seller);
        objResult.openVacancyCard();
        objVacancy.viewCard();
    }

    @Test(description = "Проверка перехода на карточку работодателя с формы поиска")
    public void checkOpenEmployerCardWithSearchForm() {
        objHome.openBasicSite()
               .search(Manager);
        objResult.openEmployerCard();
        objEmployer.viewOpenEmployerCardForm();
    }

    @Test(description = "Проверка перехода на карточку работодателя с карточки вакансии")
    public void checkOpenEmployerCardWithVacancyCard() {
        objHome.openBasicSite()
               .search(Seller);
        objResult.openVacancyCard();
        objVacancy.openEmployerCard();
        objEmployer.viewOpenEmployerCardForm();
    }

    @Test(description = "Проверка отображения элементов алерта - Я хочу работать тут")
    public void checkViewAlertWantWorkHere() {
        objHome.openBasicSite()
               .search(Manager);
        objResult.openVacancyCard();
        objVacancy.openEmployerCard();
        objEmployer.openWantWorkAlert()
                   .viewAlertWantWork();
    }

    @Test(description = "Проверка успешного поиска вакансии")
    public void checkSuccessSearchVacancy() {
        objHome.openBasicSite()
               .selectProposedCity()
               .search(Seller);
        objResult.viewSuccessResultAfterSearch();
    }

    @Test(description = "Проверка неудачного поиска вакансии")
    public void checkFailedSearchVacancy() {
        objHome.openBasicSite()
               .selectProposedCity()
               .search(NotExist);
        objResult.viewFailedResultAfterSearch(NotExist);
    }

}
