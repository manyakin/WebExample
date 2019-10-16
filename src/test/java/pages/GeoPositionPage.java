package pages;

import io.qameta.allure.Step;
import settings.WebMethods;

import static com.codeborne.selenide.Selectors.byText;

public class GeoPositionPage extends WebMethods {

    static final String SEARCH_FIELD = "#area-search-input";
    private static final String SEARCH_RESULT_LIST = ".area-switcher-autocomplete-city";

    public enum City {
        OMSK("Омск"),
        SPB("Санкт-Петербург");

        public String description;
        City(String description) {
            this.description = description;
        }
        public String getDescription() {return description;}
    }

    @Step("Выбор города из списка")
    public void selectCityFromList(City city) {
        click(byText(city.description));
        check(HomePage.SEARCH_BLOCK);
    }

    @Step("Выбор города при помощи поиска")
    public void selectCityWithSearch(City city) {
        setValue(SEARCH_FIELD, city.description);
        setList(SEARCH_RESULT_LIST, city.description);
        check(HomePage.SEARCH_BLOCK);
    }

}
