package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import settings.WebMethods;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HomePage extends WebMethods {

    static final By SEARCH_BLOCK = byClassName("supernova-dashboard-search");

    private static final By ALERT_GEO_ACCEPT = byText("Всё верно");
    private static final By ALERT_GEO_OTHER = byText("Выбрать другой");
    private static final By SEARCH_FIELD = byXpath("//input[@data-qa='search-input']");
    private static final String SEARCH_FRAME_BUTTON = "span.supernova-search-submit-text";
    private static final By SEARCH_BUTTON = byXpath("//button[@data-qa='navi-search__button']");
    private static final By TEXT_GEO_LINK = byXpath("//button[@data-qa='mainmenu_areaSwitcher']");
    private static final By SEARCH_FRAME_FIELD = byXpath("//input[@data-qa='vacancy-serp__query']");

    public enum Vacancy {
        Seller("Продавец"),
        Manager("Менеджер"),
        NotExist("Онтарибиолог");

        public String description;
        Vacancy(String description) {
            this.description = description;
        }
        public String getDescription() {return description;}
    }

    public enum Url {
        SITE_LINK("https://hh.ru"),
        SPB_LINK("https://spb.hh.ru/?customDomain=1"),
        OMSK_LINK("https://omsk.hh.ru/?customDomain=1"),
        AUTH_LINK("https://omsk.hh.ru/account/login?backurl=%2F");

        private String description;
        Url(String description) {
            this.description = description;
        }
        public String getDescription() {return description;}
    }

    @Step("Переход на главную страницу сайта")
    public HomePage openBasicSite() {
        open(Url.SITE_LINK.description);
        return this;
    }

    @Step("Переход на страницу авторизации")
    public void openAuthSite() {
        open(Url.AUTH_LINK.description);
    }

    @Step("Переход на форму выбора города c помощью алерта")
    public void openSelectCityFormWithAlert() {
        click(ALERT_GEO_OTHER);
        check(GeoPositionPage.SEARCH_FIELD);
    }

    @Step("Выбор предложенного города")
    public HomePage selectProposedCity() {
        click(ALERT_GEO_ACCEPT);
        return this;
    }

    @Step("Переход на страницу выбора города через ссылку формы")
    public void openSelectCityFormWithLink() {
        click(TEXT_GEO_LINK);
        check(GeoPositionPage.SEARCH_FIELD);
    }

    @Step("Поиск вакансии")
    public void search(Vacancy name) {
        if ($(SEARCH_FIELD).exists()) {setValue(SEARCH_FIELD, name.description);}
        else {setValue(SEARCH_FRAME_FIELD, name.description);}

        if ($(byCssSelector(SEARCH_FRAME_BUTTON)).exists()) {click(SEARCH_FRAME_BUTTON);}
        else {click(SEARCH_BUTTON);}
    }

    @Step("Проверка совпадения указанного адреса")
    public void checkCurrentUrl(Url expect) {
        Assert.assertEquals(url(), expect.description, "Не совпадает ожидаемый url");
    }

}
