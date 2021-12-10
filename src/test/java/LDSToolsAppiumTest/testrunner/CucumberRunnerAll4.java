package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        tags = "@all4",
        plugin = {
                "pretty",
                "html:src/test/java/Reports/cucumber-reports4/cucumber-pretty.html",
                "json:src/test/java/Reports/cucumber-reports4/CucumberTestReport.json",
                "junit:src/test/java/Reports/cucumber-reports4/CucumberTestReport.xml",
                "rerun:src/test/java/Reports/cucumber-reports4/rerun.txt"
        })
public class CucumberRunnerAll4 extends BaseDriver {


}
