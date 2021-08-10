package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        tags = {"@jft and @API"},
        plugin = {
                "pretty",
                "html:src/test/java/Reports/cucumber-reports/cucumber-pretty",
                "json:src/test/java/Reports/cucumber-reports/CucumberTestReport.json",
                "junit:src/test/java/Reports/cucumber-reports/CucumberTestReport.xml",
                "rerun:src/test/java/Reports/cucumber-reports/rerun.txt"
        })
public class APIRunner extends MemberToolsAPI {


}
