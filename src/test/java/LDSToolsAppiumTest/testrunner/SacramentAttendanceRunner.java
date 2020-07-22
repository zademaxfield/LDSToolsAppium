package LDSToolsAppiumTest.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
//        glue = {"LDSToolsAppiumTest.steps"},
        plugin = {
                "com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin",
//                "com.qmetry.qaf.automation.step.client.text.BDDTestFactory2",
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"

        })
public class SacramentAttendanceRunner {

//        BaseDriver myBaseDriver = new BaseDriver();
//        @DataProvider(parallel = true)
//        @Override
//        public Object[][] scenarios() {
//                return super.scenarios();
//
//        }

//        @BeforeSuite
//        public void removeFiles() throws Exception {
//                System.out.println("Cucumber Before Suite");
//                myBaseDriver.removeFilesBeforeTest();
//        }
//
//        @BeforeClass(alwaysRun = true)
//        public void setup() throws Exception {
//                System.out.println("Cucumber Before Class");
//                String os =  Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("os");
//                String fileName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("fileName");
//                String testDevice = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("testDevice");
//                String startSleepTime = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("startSleepTime");
//                System.out.println(os + " " + fileName + " " + testDevice);
//                myBaseDriver.setUp(os, fileName, testDevice, 200);
//        }


//        @Test(groups = "jft", description = "Just a test")
//        public void runCukes() {
//                TestNGCucumberRunner testCucumberRunner;
//                testCucumberRunner.provideScenarios().
//        }

}
