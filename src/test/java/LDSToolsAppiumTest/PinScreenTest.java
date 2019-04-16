package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.PinScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;


public class PinScreenTest extends BaseDriver {

    @Test (groups = {"all1", "all"})
    public void pinRepeatTest() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        myHelper.loginUAT("LDSTools3", "toolstester");

        myHelper.checkForAlertsBeforePin();

        if (myBasePage.checkForElement(myPinScreen.pinAlertDialogOK)) {
            myPinScreen.pinAlertDialogOK.click();
        }
//        if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
//            myPinScreen.pinAlertDialogOK.click();
//        }

        pinRepeatTestData();
    }

    @Test (groups = {"all1", "all"})
    public void pinRepeatTestNonLeader() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        myHelper.loginUAT("LDSTools5", "toolstester");


        myHelper.checkForAlertsBeforePin();
        myHelper.dismissWhatsNewPage();

        if (!getRunningOS().equals("ios")) {
            if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
                myPinScreen.pinAlertDialogOK.click();
            }
        }

        pinRepeatTestData();
    }

    @Test (groups = {"all2", "all"})
    public void pinNoMatchTest() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.loginUAT("LDSTools3", "toolstester");

//        if (!getRunningOS().equals("ios")) {
//            myHelper.checkForAlertsBeforePin();
//        }


        if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
            myPinScreen.pinAlertDialogOK.click();
        }

        pinNoMatchTestData();

    }

    @Test (groups = {"all2", "all"})
    public void pinNoMatchTestNonLeader() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.loginUAT("LDSTools5", "toolstester");

        myHelper.checkForAlertsBeforePin();
        myHelper.dismissWhatsNewPage();

        if (!getRunningOS().equals("ios")) {
            if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
                myPinScreen.pinAlertDialogOK.click();
            }
        }

        pinNoMatchTestData();

    }



    @Test (groups = {"all3", "all", "jft"})
    public void pinSequentialTest() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.loginUAT("LDSTools3", "toolstester");
//        myHelper.loginUAT("LDSTools5", "toolstester");

//        if (!getRunningOS().equals("ios")) {
//            myHelper.checkForAlertsBeforePin();
//        }


        if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
            myPinScreen.pinAlertDialogOK.click();
        }

        sequentialTestData();


    }


    @Test (groups = {"all3", "all"})
    public void pinSequentialTestNonLeader() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.loginUAT("LDSTools5", "toolstester");

        myHelper.checkForAlertsBeforePin();
        myHelper.dismissWhatsNewPage();

        if (!getRunningOS().equals("ios")) {


            if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
                myPinScreen.pinAlertDialogOK.click();
            }

        }


        sequentialTestData();


    }

    private void sequentialTestData() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        //Sequential Numbers
        myHelper.pressPinKeys("1");
        myHelper.pressPinKeys("2");
        myHelper.pressPinKeys("3");
        myHelper.pressPinKeys("4");


        //Should get an error on iOS .... Android needs to enter in the digits again to get an error
        if (getRunningOS().equals("android")) {
            myHelper.pressPinKeys("1");
            myHelper.pressPinKeys("2");
            myHelper.pressPinKeys("3");
            myHelper.pressPinKeys("4");

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());

        } else {
            Assert.assertEquals("Passcode can't have sequential numbers.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }

        //Sequential Numbers
        myHelper.pressPinKeys("9");
        myHelper.pressPinKeys("8");
        myHelper.pressPinKeys("7");
        myHelper.pressPinKeys("6");


        //Should get an error on iOS .... Android needs to enter in the digits again to get an error
        if (getRunningOS().equals("android")) {
            myHelper.pressPinKeys("9");
            myHelper.pressPinKeys("8");
            myHelper.pressPinKeys("7");
            myHelper.pressPinKeys("6");

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());

        } else {
            Assert.assertEquals("Passcode can't have sequential numbers.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }
    }

    private void pinNoMatchTestData() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);


        myHelper.pressPinKeys("3");
        myHelper.pressPinKeys("5");
        myHelper.pressPinKeys("9");
        myHelper.pressPinKeys("1");


        myHelper.pressPinKeys("7");
        myHelper.pressPinKeys("5");
        myHelper.pressPinKeys("3");
        myHelper.pressPinKeys("1");

        if (getRunningOS().equals("android")) {
            Assert.assertEquals("PINs do not match.", myPinScreen.pinKeyErrorMessage.getText());
        } else {
            Assert.assertEquals("Passcodes do not match.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }
    }

    private void pinRepeatTestData() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);


        //All four of the same number
        myHelper.pressPinKeys("1");
        myHelper.pressPinKeys("1");
        myHelper.pressPinKeys("1");
        myHelper.pressPinKeys("1");

        //Should get an error on iOS .... Android needs to enter in the digits again to get an error
        if (getRunningOS().equals("android")) {
            myHelper.pressPinKeys("1");
            myHelper.pressPinKeys("1");
            myHelper.pressPinKeys("1");
            myHelper.pressPinKeys("1");

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());

        } else {
            //System.out.println(myBasePage.getSourceOfPage());
            Assert.assertEquals("Passcode must not repeat a number three times.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }

        //3 of the same number in a row
        myHelper.pressPinKeys("5");
        myHelper.pressPinKeys("6");
        myHelper.pressPinKeys("6");
        myHelper.pressPinKeys("6");

        //Should get an error on iOS .... Android needs to enter in the digits again to get an error
        if (getRunningOS().equals("android")) {
            myHelper.pressPinKeys("5");
            myHelper.pressPinKeys("6");
            myHelper.pressPinKeys("6");
            myHelper.pressPinKeys("6");

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());

        } else {
            Assert.assertEquals("Passcode must not repeat a number three times.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }

    }




}
