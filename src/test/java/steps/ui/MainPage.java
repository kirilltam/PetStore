package steps.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement SearchField = $x("//*[@id='text']");
    private final SelenideElement Weather = $x("//div[contains(@class, 'VanillaReact OrganicTitle OrganicTitle_multiline Typo Typo_text_l Typo_line_m organic__title-wrapper')]/a[contains(@href, 'https://yandex.ru/pogoda/samui')]");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void checkYa() {
        SearchField.setValue("Какая сейчас погода на Самуи").click();
        Weather.click();


    }
}
