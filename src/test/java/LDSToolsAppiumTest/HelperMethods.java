package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.LoginPageScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.SettingsScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class HelperMethods extends BasePage {

    public HelperMethods(AppiumDriver<MobileElement> driver) {
        super(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        //HelperMethods myHelper = new HelperMethods(driver);

    }


    public void loginUAT(String userName, String password) throws Exception {
        //Enable Developer Settings and set the Network Environment to UAT
        setupUAT();

        LoginPageScreen.loginName.sendKeys(userName);
        LoginPageScreen.passWord.sendKeys(password);
        LoginPageScreen.signInButton.click();
        Thread.sleep(3000);
        if (getOS().equals("mac")) {
            waitUnitlTextIsGone("Stop Sync");
        } else {
            waitUnitlTextIsGone("Sync Progress");
        }


        Thread.sleep(3000);
    }

    public void setupUAT() throws Exception {
        if (getOS().equals("mac")) {
            LoginPageScreen.overflowMenu.click();

            for (int x = 1; x <= 5; x++) {
                LoginPageScreen.enterDeveloperButton.click();
            }

            SettingsScreen.networkEnvironment.click();
            SettingsScreen.UAT.click();
            backButton.click();
            backButton.click();
            backButton.click();

        } else {
            LoginPageScreen.overflowMenu.click();
            LoginPageScreen.overflowSettings.click();
            scrollToText("About");
            SettingsScreen.about.click();
            for (int x = 1 ; x <= 7 ; x++ ) {
                SettingsScreen.aboutLogo.click();
            }
            backButton.click();
            scrollToText("Network Environment");

            SettingsScreen.networkEnvironment.click();
            SettingsScreen.UAT.click();

            backButton.click();
        }

    }

    public void enterPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);

        if (PinScreen.pinAlertDialogOK.isDisplayed()) {
            PinScreen.pinAlertDialogOK.click();
        }

        PinScreen.pinKey1.click();
        PinScreen.pinKey1.click();
        PinScreen.pinKey3.click();
        PinScreen.pinKey3.click();

        Thread.sleep(2000);

        PinScreen.pinKey1.click();
        PinScreen.pinKey1.click();
        PinScreen.pinKey3.click();
        PinScreen.pinKey3.click();

        Thread.sleep(2000);


    }


}
