package pages;

import io.qameta.allure.Step;
import settings.WebMethods;

public class LoginPage extends WebMethods {

    private static final String LOGIN_FORM = ".light-page-content__title";
    private static final String LOGIN_FORM_TITLE = "Вход в личный кабинет";

    @Step("Отображение полной формы входа")
    public void viewFullLoginForm() {
        haveText(LOGIN_FORM, LOGIN_FORM_TITLE);
    }

}
