package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.LoginPageScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.SettingsScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.PerformsTouchID;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FingerprintFaceTest extends BaseDriver {

    @Test (groups = {"finger", "jft"})
    public void fingerprintSimpleTest() throws Exception {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        HelperMethods myHelper = new HelperMethods();

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        myBasePage.waitForElement(myLoginPage.loginName);


        myHelper.setupUAT("");

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys("LDSTools3");
        myLoginPage.passWord.sendKeys("toolstester");
        myLoginPage.signInButton.click();
        Thread.sleep(1000);

        long startTime = System.nanoTime();

        System.out.println("Check for Sign In");
        myBasePage.waitUnitlTextIsGone("Sign In");
        System.out.println("Check for Sign In over ------ Check for Sync");

        Thread.sleep(2000);

        if (myBasePage.getOS().equals("ios")) {
            System.out.println("Wait for text to appear: UAT");
            myBasePage.waitForText("UAT");
            System.out.println("Text found: UAT");
            myBasePage.waitUnitlTextIsGone("UAT");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("UAT");
        } else {
            myBasePage.waitUnitlTextIsGone("Authenticating");
            myBasePage.waitForText("Updating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Updating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Updating");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(1000);

        myHelper.checkForAlertsBeforePin();
        myHelper.dismissWhatsNewPage();
        //Android needs this.
        myHelper.checkForAlertsAfterPin();
        Thread.sleep(2000);

//        if (getRunningOS().equalsIgnoreCase("ios")) {
//            ((IOSDriver)driver).toggleTouchIDEnrollment(true);
//            ((IOSDriver)driver).performTouchID(true);
//        } else {
//            ((AndroidDriver)driver).fingerPrint(1);
//        }

        Thread.sleep(10000);



    }

}
