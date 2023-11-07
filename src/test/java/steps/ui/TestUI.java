package steps.ui;


import io.cucumber.java.ru.Когда;
import hooks.WebHooks;


public class TestUI extends WebHooks {
    public final static String YaUrl = "https://ya.ru/";

    @Когда("Запуск страницы$")
    public void check() {
        MainPage mainPage = new MainPage(YaUrl);
        mainPage.checkYa();

    }
}
