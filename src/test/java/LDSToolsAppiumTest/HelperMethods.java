package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.LoginPageScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.SettingsScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.awt.*;


public class HelperMethods extends BasePage {

    public HelperMethods(AppiumDriver<MobileElement> driver) {
        super(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        MenuScreen myMenuScreen = new MenuScreen(driver);

    }


    public void loginUAT(String userName, String password) throws Exception {
        //Enable Developer Settings and set the Network Environment to UAT
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        setupUAT();


        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(3000);
        if (getOS().equals("mac")) {
            waitUnitlTextIsGone("Stop Sync");
        } else {
            waitUnitlTextIsGone("Sync Progress");
        }


        Thread.sleep(3000);
    }

    public void setupUAT() throws Exception {
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        if (getOS().equals("mac")) {
            myLoginPage.overflowMenu.click();

            for (int x = 1; x <= 5; x++) {
                myLoginPage.enterDeveloperButton.click();
            }

            mySettings.networkEnvironment.click();
            mySettings.UAT.click();
            backButton.click();
            backButton.click();
            backButton.click();

        } else {
            myLoginPage.overflowMenu.click();
            myLoginPage.overflowSettings.click();
            scrollToText("About");
            mySettings.about.click();
            for (int x = 1 ; x <= 7 ; x++ ) {
                mySettings.aboutLogo.click();
            }
            backButton.click();
            scrollToText("Network Environment");

            mySettings.networkEnvironment.click();
            mySettings.UAT.click();

            backButton.click();
        }

    }

    public void enterPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPin = new PinScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        if (checkForElement(myPin.pinAlertDialogOK)) {
            myPin.pinAlertDialogOK.click();
        }

        //This is for iOS on a non leader login
        if (checkForElement(myPin.pinAlertDialogYes)) {
            myPin.pinAlertDialogYes.click();
        }

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);

        if(getOS().equals("android")) {
            myMenu.laterButton.click();
        }
        myMenu.directory.click();


    }


    public void pressPinKeys(String keyNumber) {
        PinScreen myPin = new PinScreen(driver);
        switch (keyNumber) {
            case "1" :
                myPin.pinKey1.click();
                break;
            case "2" :
                myPin.pinKey2.click();
                break;
            case "3" :
                myPin.pinKey3.click();
                break;
            case "4" :
                myPin.pinKey4.click();
                break;
            case "5" :
                myPin.pinKey5.click();
                break;
            case "6" :
                myPin.pinKey6.click();
                break;
            case "7" :
                myPin.pinKey7.click();
                break;
            case "8" :
                myPin.pinKey8.click();
                break;
            case "9" :
                myPin.pinKey9.click();
                break;
            case "0" :
                myPin.pinKey0.click();
                break;
            case "Delete" :
                myPin.pinKeyDelete.click();
                break;
        }
    }


}
