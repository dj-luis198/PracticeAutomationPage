package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.Base;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".\\src\\test\\resources\\features",
        glue= "steps",
        plugin = {
                "pretty","html:target/html-reports/report.html"},
        tags= "@test",
        monochrome = true
)

public class runner {
    @AfterClass
    public static void close(){
        Base.quit();
    }

}