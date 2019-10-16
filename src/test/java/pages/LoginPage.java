package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import settings.WebMethods;

import static com.codeborne.selenide.Selectors.byXpath;

public class LoginPage extends WebMethods {

    private static final String LOGIN_FORM = ".light-page-content__title";
    private static final String LOGIN_FORM_TITLE = "Вход в личный кабинет";
    private static final String LOGIN_ERROR ="//div[@data-message-name='username']";
    private static final String PASSWORD_ERROR ="//div[@data-message-name='password']";
    private static final By LOGIN_BUTTON = byXpath("//input[@data-qa='account-login-submit']");

    @Step("Отображение полной формы входа")
    public LoginPage viewFullLoginForm() {
        haveText(LOGIN_FORM, LOGIN_FORM_TITLE);
        return this;
    }

    @Step("Отображение ошибок валидации")
    public void viewValidateError() {

        click(LOGIN_BUTTON);
        String errorLogin = getText(LOGIN_ERROR);
        Assert.assertEquals(errorLogin, "Обязательное поле", "Не совпадает подсказка!");
        String errorPassword = getText(PASSWORD_ERROR);
        Assert.assertEquals(errorPassword, "Обязательное поле", "Не совпадает подсказка!");
    }

}
