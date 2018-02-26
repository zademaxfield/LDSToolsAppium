package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
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
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);

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


        if (checkForElement(myPin.pinAlertDialogOK)) {
            myPin.pinAlertDialogOK.click();
        }

        //This is for iOS on a non leader login
        if (checkForElement(myPin.pinAlertDialogYes)) {
            myPin.pinAlertDialogYes.click();
        }

        //Check for Face ID then Disable Face ID
        System.out.println("Checking for Face ID");
        if (checkTextOnPage("Face ID")) {
            System.out.println("Face ID found hitting disable");
            myPin.pinDisableFaceID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
        }

        //Check for Touch ID then press the ID
        System.out.println("Checking for Touch ID");
        if (checkTextOnPage("Touch ID")) {
            System.out.println("Enable Touch ID Button found, hitting the button");
            myPin.pinDisableTouchID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
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

    }

    public void enterCurrentPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        PinScreen myPin = new PinScreen(driver);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);

    }

    public void whatsNewPressDone() {
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        myWhatsNew.whatsNewDone.click();

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


    public void runSync() throws Exception {
        // ********* Constructor **********
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        SyncScreen mySyncScreen = new SyncScreen(driver);


        if (getOS().equals("mac")) {
            //clickButtonByXpath("DrawerMore");
            myMenu.moreButton.click();

            //Check to see if the sync page is displayed
            if (myBasePage.checkTextOnPage("Sync Now")) {
                myBasePage.backButton.click();
            }

            if (myBasePage.checkTextOnPage("Update")) {
                mySyncScreen.updateButton.click();
            } else {
                mySyncScreen.syncButton.click();
            }

            //This will probably change
            Thread.sleep(1000);
            mySyncScreen.syncButton.click();
            Thread.sleep(3000);

            //waitForTextToDisappear("DownloadingSync", 500 );
            //waitForTextToDisappear("connection", 500 );
            myBasePage.waitUnitlTextIsGone("UAT");

            Thread.sleep(4000);

            if (myBasePage.checkTextOnPage("Enter Current Passcode")) {

                System.out.println("Enter Current Passcode Found!");
                enterCurrentPin("1", "1", "3", "3");
            }


        } else {
            myMenu.drawerButton.click();
            if (myBasePage.checkTextOnPage("Later")) {
                myMenu.laterButton.click();
            }
            myBasePage.scrollToText("Sync");

            Thread.sleep(4000);
            myBasePage.alertOK.click();

            Thread.sleep(4000);
            myBasePage.waitUnitlTextIsGone("UAT");
            Thread.sleep(4000);
        }

        if (myBasePage.checkForAlert()) {
            myBasePage.alertOK.click();
        }
    }
}
