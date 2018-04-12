package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.LoginPageScreen;
import org.testng.Assert;

import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseDriver {

//   @Test( groups = {"all1", "all", "login"})
//    public void loginPageSimple() throws Exception {
//        HelperMethods myHelper = new HelperMethods(driver);
//
//        myHelper.loginUAT("LDSTools2", "toolstester");
//        myHelper.enterPin("1", "1", "3", "3");
//
//    }


    @Test (dataProvider = "Members", groups = {"all2", "all", "login"})
    public void validateLoginPage(@NoInjection String userName) {
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

            //Have to do a case insensitive test for Android 5.0 doesn't handle case correctly
            Assert.assertTrue(myPageSource.toLowerCase().contains("sign in"));
            Assert.assertTrue(myPageSource.toLowerCase().contains("forgot username or password"));
            Assert.assertTrue(myPageSource.toLowerCase().contains("create an lds account"));
        }

        Assert.assertTrue(myPageSource.contains("Username"));
        Assert.assertTrue(myPageSource.contains("Password"));

    }

    // ******************* Invalid Password Tests *******************
    @Test (dataProvider = "Members", groups = {"all3", "all", "login"})
    public void invalidPasswordTest1(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", "<login>");
    }

    @Test (dataProvider = "Members", groups = {"all4", "all", "login"})
    public void invalidPasswordTest2(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Test (dataProvider = "Members", groups = {"all1", "all", "login"})
    public void invalidPasswordTest3(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "login"})
    public void invalidPasswordTest4(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", "/password/");
    }

    @Test (dataProvider = "Members", groups = {"all3", "all", "login"})
    public void invalidPasswordTest5(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", "!@#$%%^&**())__+_!@@!#!$%#@%^*&%&*(^*()(&(&*(%^&$#%@$!#$%$#^#$%^^&*(^%}|{|{|}{|}{|}{}|{|}{}|{|}{||||}|{}{|}{");
    }

    @Test (dataProvider = "Members", groups = {"all4", "all", "login"})
    public void invalidPasswordTest6(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", "select * from directory");
    }

    @Test (dataProvider = "Members", groups = {"all1", "all", "login"})
    public void invalidPasswordTest7(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", " toolstester");
    }


    // ******************* Invalid Username Tests *******************
    @Test (dataProvider = "Members", groups = {"all4", "all", "login"})
    public void invalidUsernameTest1(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools20", "toolstester");
    }

    @Test (dataProvider = "Members", groups = {"all1", "all", "login"})
    public void invalidUsernameTest2(@NoInjection String userName) throws Exception {
        invalidCheck("LDSTools2", "password1");
    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "login"})
    public void invalidUsernameTest3(@NoInjection String userName) throws Exception {
        invalidCheck("********", "isjlsdkj");
    }

    @Test (dataProvider = "Members", groups = {"all3", "all", "login"})
    public void invalidUsernameTest4(@NoInjection String userName) throws Exception {
        invalidCheck("select * from directory", "password1");
    }

    @Test (dataProvider = "Members", groups = {"all4", "all", "login"})
    public void invalidUsernameTest5(@NoInjection String userName) throws Exception {
        invalidCheck("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", "password1");
    }

    @Test (dataProvider = "Members", groups = {"all1", "all", "login"})
    public void invalidUsernameTest6(@NoInjection String userName) throws Exception {
        invalidCheck("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "password1");
    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "login"})
    public void invalidUsernameTest7(@NoInjection String userName) throws Exception {
        invalidCheck(" LDSTools2", "toolstester");
    }





    // ******************* Invalid Username and Password Tests *******************
    @Test (dataProvider = "Members", groups = {"all1", "all", "login"})
    public void invalidUsernameAndPasswordTest1(@NoInjection String userName) throws Exception {
        invalidCheck("sfjksdjissldjskldjslfjslfj", "toolste@#@$#^#$&%*%*&ster");
    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "login"})
    public void invalidUsernameAndPasswordTest2(@NoInjection String userName) throws Exception {
        invalidCheck("HanSolo", "<><><><><><><><><>");
    }

    @Test (dataProvider = "Members", groups = {"all3", "all", "login"})
    public void invalidUsernameAndPasswordTest3(@NoInjection String userName) throws Exception {
        invalidCheck("This is a bad username test", "This is a bad password test");
    }

    @Test (dataProvider = "Members", groups = {"all4", "all", "login"})
    public void invalidUsernameAndPasswordTest4(@NoInjection String userName) throws Exception {
        invalidCheck("select * from directory", "^^^^^^^^^^^^");
    }

    @Test (dataProvider = "Members", groups = {"all1", "all", "login"})
    public void invalidUsernameAndPasswordTest5(@NoInjection String userName) throws Exception {
        invalidCheck("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "login"})
    public void invalidUsernameAndPasswordTest6(@NoInjection String userName) throws Exception {
        invalidCheck("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
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

/*
    @Test (groups = { "jft"})
    public void loginPageJustForTesting() throws Exception {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        long startTime;
        long stopTime;
        long myTime;

        myPageSource = myBasePage.getSourceOfPage();
        Thread.sleep(2000);

        startTime = System.currentTimeMillis();
        myBasePage.checkForElement(myLoginPage.loginName);
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (BasePage): " + myTime);

        startTime = System.currentTimeMillis();
        myBasePage.checkForElement(myLoginPage.alertOK);
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (BasePage not found): " + myTime);

        startTime = System.currentTimeMillis();
        assert myLoginPage.loginName.isDisplayed();
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (isDisplayed): " + myTime);

        startTime = System.currentTimeMillis();
        myLoginPage.loginName.isDisplayed();
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element ( no assert isDisplayed): " + myTime);

        startTime = System.currentTimeMillis();
        assert myLoginPage.loginName.isEnabled();
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (isEnabled): " + myTime);
    }*/



}
