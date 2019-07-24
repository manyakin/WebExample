package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import settings.WebMethods;

import static com.codeborne.selenide.Selectors.byText;

public class EmployerCardPage extends WebMethods {

    private static final String ALERT_FORM = ".bloko-drop__content-wrapper";
    private static final String ALERT_SERVICE_LINK = ".applicant-services-service";
    private static final By WANT_WORK_TEXT = byText("Я хочу тут работать");
    private static final By ALERT_SUPPORT_TEXT = byText("Служба поддержки");
    private static final String ALERT_LOGIN_LINK = "div.bloko-gap.bloko-gap_left.bloko-gap_right";
    private static final By ALERT_SERVICE_TEXT = byText("Соглашение об оказании услуг");
    private static final By ALERT_INTEREST_TEXT = byText("Работодатель точно заметит вашу заинтересованность");
    private static final String ALERT_LOGIN_LINK_TEXT = "Для того, чтобы воспользоваться данной услугой, необходимо авторизоваться на сайте.";
    private static final String ALERT_SERVICE_LINK_TEXT = "Отправьте резюме напрямую! Вы будете выделены в результатах поиска, а резюме попадет в специальную папку «Хотят у вас работать».";

    @Step("Отображение формы работодателя")
    public void viewOpenEmployerCardForm() {
        check(WANT_WORK_TEXT);
    }

    @Step("Открытие алерта - Я хочу тут работать")
    public EmployerCardPage openWantWorkAlert() {
        click(WANT_WORK_TEXT);
        return this;
    }

    @Step("Отображение элементов алерта - Я хочу тут работать")
    public void viewAlertWantWork() {
        check(ALERT_FORM);
        check(ALERT_SUPPORT_TEXT);
        check(ALERT_SERVICE_TEXT);
        check(ALERT_INTEREST_TEXT);
        haveText(ALERT_LOGIN_LINK, ALERT_LOGIN_LINK_TEXT);
        haveText(ALERT_SERVICE_LINK, ALERT_SERVICE_LINK_TEXT);
    }

}
