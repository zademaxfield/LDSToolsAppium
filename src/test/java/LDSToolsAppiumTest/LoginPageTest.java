package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.LoginPageScreen;
import org.testng.Assert;

import org.testng.annotations.Test;


public class LoginPageTest extends BaseDriver {

   @Test( groups = {"all1", "all"})
    public void loginPageSimple() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);

        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

    }

    @Test (groups = {"all2", "all"})
    public void validateLoginPage() {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);

        myPageSource = myBasePage.getSourceOfPage();

        if (myBasePage.getOS().equals("mac")) {
            Assert.assertTrue(myPageSource.contains("LDS Account"));
            Assert.assertTrue(myPageSource.contains("Help"));
            Assert.assertTrue(myPageSource.contains("Sign In"));
        } else {
            Assert.assertTrue(myPageSource.contains("LDS Tools"));
            Assert.assertTrue(myPageSource.contains("Sign in to your LDS Account"));
            Assert.assertTrue(myPageSource.contains("SIGN IN"));
            Assert.assertTrue(myPageSource.contains("FORGOT USERNAME OR PASSWORD"));
            Assert.assertTrue(myPageSource.contains("CREATE AN LDS ACCOUNT"));
        }

        Assert.assertTrue(myPageSource.contains("Username"));
        Assert.assertTrue(myPageSource.contains("Password"));

    }

    @Test (groups = {"all3", "all"})
    public void invalidPasswordTest() throws Exception {
        invalidCheck("LDSTools2", "<login>");
        invalidCheck("LDSTools2", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        invalidCheck("LDSTools2", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        invalidCheck("LDSTools2", "/password/");
        invalidCheck("LDSTools2", "!@#$%%^&**())__+_!@@!#!$%#@%^*&%&*(^*()(&(&*(%^&$#%@$!#$%$#^#$%^^&*(^%}|{|{|}{|}{|}{}|{|}{}|{|}{||||}|{}{|}{");
        invalidCheck("LDSTools2", "select * from directory");
    }

    @Test (groups = {"all4", "all", "jft"})
    public void invalidUsernameTest() throws Exception {
        invalidCheck("LDSTools20", "toolstester");
        invalidCheck("LDSTools2", "password1");
        invalidCheck("********", "isjlsdkj");
        invalidCheck("select * from directory", "password1");
        invalidCheck("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", "password1");
        invalidCheck("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "password1");
    }

    private void invalidCheck(String userName, String passWord) throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        clearLoginPassword();

        myHelper.loginUAT(userName, passWord);
        Thread.sleep(2000);
        checkInvalidAlert();
    }


    private void checkInvalidAlert() {
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.checkForElement(myLoginPage.errorMessageService)) {
            Assert.assertTrue(myBasePage.checkForElement(myLoginPage.loginErrorMessage));
        }

        myBasePage.alertOK.click();

    }

    private void clearLoginPassword() throws Exception {
        //Clear the login and password fields

        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        Thread.sleep(2000);
        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();
        Thread.sleep(2000);
    }



}
