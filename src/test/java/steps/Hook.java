package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Base;

import java.io.File;
import java.io.IOException;

public class Hook extends Base {
    public Hook() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
            if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "image"+scenario.getId());
        }
    }
}

