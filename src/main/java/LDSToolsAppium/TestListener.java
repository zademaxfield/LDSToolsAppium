package LDSToolsAppium;

import java.util.Set;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

public class TestListener implements ITestListener {
	BaseDriver myLDSTools = new BaseDriver();
	String os;
	String fileName;
	String testDevice;

	private ThreadLocal testWatcher= new ThreadLocal();


    @Override
	public void onFinish(ITestContext context) {
		BaseDriver myBaseDriver = new BaseDriver();
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();


//		for (ITestResult temp : failedTests) {
//			ITestNGMethod method = temp.getMethod();
//			if (context.getFailedTests().getResults(method).size() > 1) {
//				failedTests.remove(temp);
//			} else {
//				if (context.getPassedTests().getResults(method).size() > 0) {
//					failedTests.remove(temp);
//				}
//			}
//		}
		
		for (ITestResult temp : skippedTests) {
			skippedTests.remove(temp);
		}

		
	}
  
    public void onTestStart(ITestResult result) {
//		testWatcher.set(result.getTestContext().getAttribute("testName").toString());
//		testWatcher.set(result.getTestContext().getName());
		BaseDriver myBaseDriver = new BaseDriver();
		System.out.println("On Start: " + result.getTestName());
//		System.out.println(myBaseDriver.getTestName());
//		result.setTestName(myBaseDriver.getTestName());
//		result.getTestContext().setAttribute("testName", result.getTestName());
	}
  
    public void onTestSuccess(ITestResult result) {   }
  
    public void onTestFailure(ITestResult result) {   }



    @Override
    @Parameters({"os", "fileName", "testDevice"})
    public void onTestSkipped(ITestResult result) {
    	//Changed skipped test to Failure!!!!!
    	result.setStatus(ITestResult.FAILURE);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  
