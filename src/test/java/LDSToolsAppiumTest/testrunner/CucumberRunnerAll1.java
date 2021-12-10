package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        tags = "@all1",
        plugin = {
                "pretty",
                "html:src/test/java/Reports/cucumber-reports1/cucumber-pretty.html",
                "json:src/test/java/Reports/cucumber-reports1/CucumberTestReport.json",
                "junit:src/test/java/Reports/cucumber-reports1/CucumberTestReport.xml",
                "rerun:src/test/java/Reports/cucumber-reports1/rerun.txt"
        })
public class CucumberRunnerAll1 extends BaseDriver {


}
