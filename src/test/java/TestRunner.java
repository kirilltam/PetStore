import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps", // Пакет с шагами
        plugin = {"pretty", "html:target/cucumber-report.html"} // Плагин для создания отчетов
)

public class TestRunner {

}

