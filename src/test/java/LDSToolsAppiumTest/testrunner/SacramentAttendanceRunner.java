package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        tags = {"@jft"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class SacramentAttendanceRunner extends BaseDriver {


}
