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


    @Test (groups = {"all2", "all", "login"})
    public void validateLoginPage() throws Exception {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }
        Thread.sleep(2000);

        myPageSource = myBasePage.getSourceOfPage();

        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(myPageSource.contains("LDS Account"));
            Assert.assertTrue(myPageSource.contains("Help"));
            Assert.assertTrue(myPageSource.contains("Sign In"));
        } else {
            Assert.assertTrue(myPageSource.contains("LDS Tools"));
//            Assert.assertTrue(myPageSource.contains("Sign in to your LDS Account"));

            //Have to do a case insensitive test for Android 5.0 doesn't handle case correctly
            Assert.assertTrue(myPageSource.toLowerCase().contains("sign in"));
//            Assert.assertTrue(myPageSource.toLowerCase().contains("forgot username or password"));
            Assert.assertTrue(myPageSource.toLowerCase().contains("having trouble signing in"));
            Assert.assertTrue(myPageSource.toLowerCase().contains("create an lds account"));
        }

        Assert.assertTrue(myPageSource.contains("Username"));
        Assert.assertTrue(myPageSource.contains("Password"));

    }

    @Test (groups = {"all3", "all", "login", "smoke", "smoke3", "jft"})
    public void validateLoginPageLinks() throws Exception {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }
        Thread.sleep(2000);

        myLoginPage.troubleSigningIn.click();
        myBasePage.waitForText("LDS Account");
        myLoginPage.accountRecoveryPage.isDisplayed();
        myPageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myPageSource.contains("LDS Account"));
        Assert.assertTrue(myPageSource.contains("Account Recovery"));

        if (getRunningOS().equals("ios")) {
            Assert.assertTrue(myPageSource.contains("Recover my Username and Password"));
            Assert.assertTrue(myPageSource.contains("Recover my Password"));
            myLoginPage.doneButton.click();
        } else {
            Assert.assertTrue(myPageSource.contains("I don't know my username"));
            Assert.assertTrue(myPageSource.contains("I don't know my password"));
            driver.navigate().back();
        }

        //Appium cannot select the links on Android
        if (getRunningOS().equals("ios")) {
            myLoginPage.privacyNotice.click();
            Thread.sleep(9000);
//        myBasePage.waitForText("Privacy Notice");
            myPageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myPageSource.contains("Privacy Notice"));
            Assert.assertTrue(myPageSource.contains("Updated 2018-09-01"));
//        Assert.assertTrue(myPageSource.contains("In this Notice"));

            if (myBasePage.getOS().equals("ios")) {
                myLoginPage.doneButton.click();
            } else {
                driver.navigate().back();
            }

            myLoginPage.termsOfUse.click();
            Thread.sleep(3000);
            myBasePage.waitForText("Terms of Use");
            myPageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myPageSource.contains("Terms of Use"));
            Assert.assertTrue(myPageSource.contains("Updated 2018-09-01"));
            Assert.assertTrue(myPageSource.contains("By using this site"));


            if (myBasePage.getOS().equals("ios")) {
                myLoginPage.doneButton.click();
            } else {
                driver.navigate().back();
            }
        }



    }

    // ******************* Invalid Password Tests *******************
    @Test (groups = {"all3", "all", "login"})
    public void invalidPasswordTest1() throws Exception {
        invalidCheck("LDSTools2", "<login>");
    }

    @Test ( groups = {"all4", "all", "login"})
    public void invalidPasswordTest2() throws Exception {
        invalidCheck("LDSTools2", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Test ( groups = {"all1", "all", "login"})
    public void invalidPasswordTest3() throws Exception {
        invalidCheck("LDSTools2", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    @Test ( groups = {"all2", "all", "login"})
    public void invalidPasswordTest4() throws Exception {
        invalidCheck("LDSTools2", "/password/");
    }

    @Test ( groups = {"all3", "all", "login"})
    public void invalidPasswordTest5() throws Exception {
        invalidCheck("LDSTools2", "!@#$%%^&**())__+_!@@!#!$%#@%^*&%&*(^*()(&(&*(%^&$#%@$!#$%$#^#$%^^&*(^%}|{|{|}{|}{|}{}|{|}{}|{|}{||||}|{}{|}{");
    }

    @Test ( groups = {"all4", "all", "login"})
    public void invalidPasswordTest6() throws Exception {
        invalidCheck("LDSTools2", "select * from directory");
    }

    @Test ( groups = {"all1", "all", "login"})
    public void invalidPasswordTest7() throws Exception {
        invalidCheck("LDSTools2", " toolstester");
    }


    // ******************* Invalid Username Tests *******************
    @Test ( groups = {"all4", "all", "login"})
    public void invalidUsernameTest1() throws Exception {
        invalidCheck("LDSTools20", "toolstester");
    }

    @Test ( groups = {"all1", "all", "login"})
    public void invalidUsernameTest2() throws Exception {
        invalidCheck("LDSTools2", "password1");
    }

    @Test ( groups = {"all2", "all", "login"})
    public void invalidUsernameTest3() throws Exception {
        invalidCheck("********", "isjlsdkj");
    }

    @Test ( groups = {"all3", "all", "login"})
    public void invalidUsernameTest4() throws Exception {
        invalidCheck("select * from directory", "password1");
    }

    @Test ( groups = {"all4", "all", "login"})
    public void invalidUsernameTest5() throws Exception {
        invalidCheck("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", "password1");
    }

    @Test ( groups = {"all1", "all", "login"})
    public void invalidUsernameTest6() throws Exception {
        invalidCheck("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "password1");
    }

    @Test ( groups = {"all2", "all", "login"})
    public void invalidUsernameTest7() throws Exception {
        invalidCheck(" LDSTools2", "toolstester");
    }





    // ******************* Invalid Username and Password Tests *******************
    @Test ( groups = {"all1", "all", "login"})
    public void invalidUsernameAndPasswordTest1() throws Exception {
        invalidCheck("sfjksdjissldjskldjslfjslfj", "toolste@#@$#^#$&%*%*&ster");
    }

    @Test ( groups = {"all2", "all", "login"})
    public void invalidUsernameAndPasswordTest2() throws Exception {
        invalidCheck("HanSolo", "<><><><><><><><><>");
    }

    @Test ( groups = {"all3", "all", "login"})
    public void invalidUsernameAndPasswordTest3() throws Exception {
        invalidCheck("This is a bad username test", "This is a bad password test");
    }

    @Test ( groups = {"all4", "all", "login"})
    public void invalidUsernameAndPasswordTest4() throws Exception {
        invalidCheck("select * from directory", "^^^^^^^^^^^^");
    }

    @Test ( groups = {"all1", "all", "login"})
    public void invalidUsernameAndPasswordTest5() throws Exception {
        invalidCheck("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Test ( groups = {"all2", "all", "login"})
    public void invalidUsernameAndPasswordTest6() throws Exception {
        invalidCheck("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }



    private void invalidCheck(String userName, String passWord) throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }
        clearLoginPassword();

        myHelper.loginUAT(userName, passWord);
        Thread.sleep(6000);
        checkInvalidAlert();
    }


    private void checkInvalidAlert() {
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        if (myBasePage.checkForElement(myLoginPage.errorMessageService)) {
            Assert.assertTrue(myBasePage.checkForElement(myLoginPage.loginErrorMessage));
        }

        if (myBasePage.checkForElement(myBasePage.alertOK)) {
            myBasePage.alertOK.click();
        }

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
