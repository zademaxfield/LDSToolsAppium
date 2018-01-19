package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.Screen.PinScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PinScreenTest extends BaseDriver {

    @Test
    public void pinRepeatTest() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);

        myHelper.loginUAT("LDSTools2", "toolstester");


        if (PinScreen.pinAlertDialogOK.isDisplayed()) {
            PinScreen.pinAlertDialogOK.click();
        }

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

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", PinScreen.pinKeyErrorMessage.getText());

        } else {
            Assert.assertEquals("Passcode must not repeat a number three times.", PinScreen.pinAlertDialogMessage.getText());
            PinScreen.pinAlertDialogOK.click();
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

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", PinScreen.pinKeyErrorMessage.getText());

        } else {
            Assert.assertEquals("Passcode must not repeat a number three times.", PinScreen.pinAlertDialogMessage.getText());
            PinScreen.pinAlertDialogOK.click();
        }

    }

    @Test
    public void pinNoMatchTest() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);

        myHelper.loginUAT("LDSTools2", "toolstester");


        if (PinScreen.pinAlertDialogOK.isDisplayed()) {
            PinScreen.pinAlertDialogOK.click();
        }
        //All four of the same number
        myHelper.pressPinKeys("3");
        myHelper.pressPinKeys("5");
        myHelper.pressPinKeys("9");
        myHelper.pressPinKeys("1");


        myHelper.pressPinKeys("7");
        myHelper.pressPinKeys("5");
        myHelper.pressPinKeys("3");
        myHelper.pressPinKeys("1");

        if (getRunningOS().equals("android")) {
            Assert.assertEquals("PINs do not match.", PinScreen.pinKeyErrorMessage.getText());
        } else {
            Assert.assertEquals("Passcodes do not match.", PinScreen.pinAlertDialogMessage.getText());
            PinScreen.pinAlertDialogOK.click();
        }

    }

    @Test
    public void pinSequentialTest() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);

        myHelper.loginUAT("LDSTools2", "toolstester");


        if (PinScreen.pinAlertDialogOK.isDisplayed()) {
            PinScreen.pinAlertDialogOK.click();
        }

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

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", PinScreen.pinKeyErrorMessage.getText());

        } else {
            Assert.assertEquals("Passcode can't have sequential numbers.", PinScreen.pinAlertDialogMessage.getText());
            PinScreen.pinAlertDialogOK.click();
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

            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", PinScreen.pinKeyErrorMessage.getText());

        } else {
            Assert.assertEquals("Passcode can't have sequential numbers.", PinScreen.pinAlertDialogMessage.getText());
            PinScreen.pinAlertDialogOK.click();
        }


    }




}
