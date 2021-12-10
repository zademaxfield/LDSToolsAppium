package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        tags = "@smoke2",
        plugin = {
                "pretty",
                "html:src/test/java/Reports/cucumber-reports2/cucumber-pretty.html",
                "json:src/test/java/Reports/cucumber-reports2/CucumberTestReport.json",
                "junit:src/test/java/Reports/cucumber-reports2/CucumberTestReport.xml",
                "rerun:src/test/java/Reports/cucumber-reports2/rerun.txt"
        })
public class CucumberRunnerSmoke2 extends BaseDriver {


}
