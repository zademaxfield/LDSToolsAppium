package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        tags = {"@all and @SacramentAttendance"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/CucumberTestReport.xml",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class SacramentAttendanceRunnerAll extends BaseDriver {


}
