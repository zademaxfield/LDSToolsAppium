package LDSToolsAppiumTest.testrunner;


import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/test/java/LDSToolsAppiumTest/features",
        glue = {"LDSToolsAppiumTest.steps", "LDSToolsAppium.BaseDriver"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"

        })
public class SacramentAttendanceRunner extends AbstractTestNGCucumberTests {
        TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true)
        public void setUpClass() {
                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @Test(groups = "Cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
        public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
                testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
        }

        @DataProvider
        public Object[][] scenarios() {
                return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass()  {
                testNGCucumberRunner.finish();
        }

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
