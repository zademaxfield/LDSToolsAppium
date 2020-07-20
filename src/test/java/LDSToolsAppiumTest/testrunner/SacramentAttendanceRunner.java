package LDSToolsAppiumTest.testrunner;

import LDSToolsAppium.BaseDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class SacramentAttendanceRunner extends AbstractTestNGCucumberTests {

//        @DataProvider(parallel = true)
//        @Override
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }


//        @Test(groups = "jft", description = "Just a test")
//        public void runCukes() {
//                TestNGCucumberRunner testCucumberRunner;
//                testCucumberRunner.provideScenarios().
//        }

}
