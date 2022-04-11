package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".\\src\\test\\resources\\features",
        glue= "steps",
        plugin = {
                "pretty","html:target/html-reports/report.html"},
        tags= "@register",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)

public class runner {

}