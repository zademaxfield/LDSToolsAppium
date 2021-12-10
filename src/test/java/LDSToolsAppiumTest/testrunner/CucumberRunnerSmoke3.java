package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        tags = "@smoke3",
        plugin = {
                "pretty",
                "html:src/test/java/Reports/cucumber-reports3/cucumber-pretty.html",
                "json:src/test/java/Reports/cucumber-reports3/CucumberTestReport.json",
                "junit:src/test/java/Reports/cucumber-reports3/CucumberTestReport.xml",
                "rerun:src/test/java/Reports/cucumber-reports3/rerun.txt"
        })
public class CucumberRunnerSmoke3 extends BaseDriver {


}
