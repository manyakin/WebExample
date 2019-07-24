package settings;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebMethods extends WebSettings {

    protected void click(final By name) {
        $(name).click();
    }

    protected void click(final String name) {
        $(name).click();
    }

    protected void check(final By name) {
        $(name).should(visible);
    }

    protected void check(final String name) {
        $(name).should(visible);
    }

    protected String getText(final String name) {
        return $(byXpath(name)).getText();
    }

    protected void setValue(final By name, final String city) {
        $(name).setValue(city);
    }

    protected void setValue(final String name, final String city) {
        $(name).setValue(city);
    }

    protected void haveText(final String name, final String text) {
        $(name).shouldHave(text(text));
    }

    protected void setList(final String name, final String city) {
        $$(name).findBy(text(city)).click();
    }

}
