import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html", "json:cucumber-json-report.json"},
        features = "src/test/java/features",
        glue = "steps"


)

public class RunCucumberTest {

}

