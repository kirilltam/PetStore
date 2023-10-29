package UIsteps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement SearchField = $x("//*[@id='text']");
    private final SelenideElement Weather = $x("//div[@class='organic__url-text']/a/@href");

        public MainPage(String url) {
        Selenide.open(url);
    }
    public void checkYa() {
        SearchField.setValue("Какая сейчас погода на Самуи").click();
        Weather.click();


    }
}
