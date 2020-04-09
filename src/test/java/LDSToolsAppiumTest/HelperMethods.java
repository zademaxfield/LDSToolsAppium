package LDSToolsAppiumTest;


import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.apache.commons.codec.binary.Base64;

import org.jsoup.nodes.Element;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;



public class HelperMethods extends BasePage {

    public HelperMethods(AppiumDriver<MobileElement> driver) {
        super(driver);

    }


    public void loginUAT(String userName, String password) throws Exception {
        //Enable Developer Settings and set the Network Environment to UAT
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        String myTemp = "";

        if (checkForElement(allowButton)) {
            allowButton.click();
        }

        setupUAT(myTemp);

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(1000);

        long startTime = System.nanoTime();

        System.out.println("Check for Sign In");
        waitUnitlTextIsGone("Sign In");
        System.out.println("Check for Sign In over ------ Check for Sync");

        Thread.sleep(2000);

        if (getOS().equals("ios")) {
            System.out.println("Wait for text to appear: UAT");
            waitForText("UAT");
            System.out.println("Text found: UAT");
            waitUnitlTextIsGone("UAT");
            Thread.sleep(1000);
            waitUnitlTextIsGone("UAT");
        } else {
            waitUnitlTextIsGone("Authenticating");
            waitForText("Updating");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Updating");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Updating");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(1000);
    }

    private void iosDeepLink(String proxyUserName) throws Exception {
//        String appName;

//        appName = driver.getCapabilities().getCapability("app").toString();
//        System.out.println("App: "  + appName);

        setupUAT(proxyUserName);

//        if (appName.contains(".ipa")) {
//            driver.executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//            //            //May need to replace -u with -U in 12.2
//            List args = new ArrayList();
////            args.add("-U");
//            args.add("https://www.google.com");
//
//            Map<String, Object> params = new HashMap<>();
//            params.put("bundleId", "com.apple.mobilesafari");
//            params.put("arguments", args);
//            driver.executeScript("mobile: launchApp", params);
//            Thread.sleep(10000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeOther[@label='Address']")).click();
//            Thread.sleep(6000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Clear text']")).click();
//            Thread.sleep(6000);
//
//            driver.findElement(By.xpath("//XCUIElementTypeTextField[@label='Address']")).setValue("membertools://user/" + proxyUserName);
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//*[@name='Go']")).click();
//            Thread.sleep(6000);
//            driver.findElement(By.xpath("//*[@name='Open']")).click();
//        } else {
//            driver.get("https://www.google.com");
//            Thread.sleep(2000);
//            driver.get("membertools://user/" + proxyUserName);
//            Thread.sleep(3000);
//        }



    }


    public void proxyLogin(String proxyUserName) throws Exception {
        // ********* Constructor **********
        BasePage myBasePage = new BasePage(driver);
        BaseDriver myBaseDriver = new BaseDriver();
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        String deviceName;
        String pageSource;


        if (checkForElement(allowButton)) {
            allowButton.click();
        }

        byte[] decodeBytes = Base64.decodeBase64("UDFrQFNwMTc=");
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {

            iosDeepLink(proxyUserName);

        } else {
            deviceName = driver.getCapabilities().getCapability("deviceName").toString();
            myBaseDriver.adbProxyStart(deviceName, proxyUserName);
            Thread.sleep(2000);
        }
        if (checkForElement(myLoginPage.cancelPass)){
            myLoginPage.cancelPass.click();
        }

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();


        myLoginPage.loginName.sendKeys("zmaxfield");
        myLoginPage.passWord.sendKeys(new String(decodeBytes));
        myLoginPage.signInButton.click();
        Thread.sleep(1000);

        long startTime = System.nanoTime();

        System.out.println("Check for Sign In");
        waitUnitlTextIsGone("Sign In");
        System.out.println("Check for Sign In over ------ Check for Sync");

        Thread.sleep(2000);

        if (getOS().equals("ios")) {
            //Check for Failed to download
            pageSource = getSourceOfPage();
            Assert.assertFalse(pageSource.contains("Failed to download."));

            System.out.println("Wait for text to appear: Update");

            waitForText("Update");
            System.out.println("Text found: Update");
//            waitUnitlTextIsGone("Update");
//            Thread.sleep(1000);
//            waitUnitlTextIsGone("Update");
//            System.out.println(getSourceOfPage());
            Thread.sleep(2000);
            waitForText("Passcode");
            System.out.println("Text found: Passcode");
        } else {
            waitUnitlTextIsGone("Authenticating");
            waitForText("Updating");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Updating");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Updating");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(1000);
    }







    public void loginProduction(String userName, String password) throws Exception {
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (checkForElement(allowButton)) {
            allowButton.click();
        }

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(1000);

        long startTime = System.nanoTime();

        System.out.println("Check for Sign In");
        waitUnitlTextIsGone("Sign In");
        System.out.println("Check for Sign In over ------ Check for Sync");

        Thread.sleep(2000);

        if (getOS().equals("ios")) {
//            Thread.sleep(5000);
            waitUnitlTextIsGone("Stop Sync");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Stop Sync");
        } else {
            waitUnitlTextIsGone("Authenticating");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Sync");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Sync");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(1000);
    }

    public void syncTools() throws Exception {
        SyncScreen mySync = new SyncScreen(driver);

        if (getOS().equals("ios")) {
            mySync.syncNowButton.click();
            Thread.sleep(1000);
            waitUnitlTextIsGone("Sync");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Sync");
        } else {
            mySync.syncOKButton.click();
            Thread.sleep(2000);
            waitUnitlTextIsGone("Stop Sync");
            Thread.sleep(1000);
            waitUnitlTextIsGone("Stop Sync");
        }

    }




    public void loginProxy(String myId, String myUnit, String myPosition) throws Exception {
        //Enable Developer Settings and set the Network Environment to Proxy
        String userName = "paigekrebs";
        String password = "sweets2005";
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (checkForElement(allowButton)) {
            allowButton.click();
        }
        setupProxy(myId, myUnit, myPosition);

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(10000);

        long startTime = System.nanoTime();


        if (getOS().equals("ios")) {
            waitUnitlTextIsGone("Stop Sync");
        } else {
            waitUnitlTextIsGone("Sync Progress");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(6000);
    }

    public void setupUAT(String proxyUserName) throws Exception {

        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);
//        BaseDriver myBaseDriver = new BaseDriver();
//        String os = "android";
//        String fileName = "android-mobile-dev-release.apk";
//        String testDeviceX = myBaseDriver.getTestngTestDevice();
//        String testDeviceX = driver.getCapabilities().getCapability("deviceName").toString();
//        int startSleepTime = 200;
//        SessionId toolsSessionId;


        if (getOS().equals("ios")) {
            myLoginPage.overflowMenu.click();

            if (myScanner.scannerCheckForText("Developer Settings") ) {
                myLoginPage.developerButton.click();
            } else {
                for (int x = 1; x <= 5; x++) {
                    myLoginPage.enterDeveloperButton.click();
                }
            }


            mySettings.networkEnvironment.click();
            mySettings.UAT.click();
            mySettings.proxyUsername.click();
            mySettings.proxyEditField.setValue(proxyUserName);
            mySettings.proxyDone.click();
            waitForElementThenClick(backButton);
            waitForElementThenClick(backButton);


        } else {

//            System.out.println("Helper Method: " + testDeviceX);
//            System.out.println("Session ID: " + driver.getSessionId());
//            String myAppPackage = driver.getCapabilities().getCapability("appPackage").toString();
//
//            MobileDevMain myMobileDevMain = new MobileDevMain(os, fileName, testDeviceX, startSleepTime, "UAT");
//            driver.navigate().back();
//            driver.closeApp();
//            driver.launchApp();
//            Thread.sleep(9000);
//
////            driver.activateApp(myAppPackage);
//            driver.runAppInBackground(Duration.ofSeconds(2));


//            TouchAction myTap = new TouchAction(driver);
//            myTap.press(PointOption.point(100, 100))
//                    .release()
//                    .perform();
//
//            myTap.press(PointOption.point(100, 100))
//                    .release()
//                    .perform();
//
//            Thread.sleep(1000);


//            myLoginPage.overflowMenu.click();
//            myLoginPage.overflowSettings.click();
//            scrollToTextRecyclerView("About");
//            mySettings.about.click();
//
//            for (int x = 1 ; x <= 7 ; x++ ) {
//                mySettings.aboutLogo.click();
//            }
//
//            backButton.click();
//            scrollUpAndroidUIAutomator("0");
////            scrollToTextRecyclerView("Network Environment");
//            scrollToTextSwipe("Network Environment");
//
//
//            mySettings.networkEnvironment.click();
//            mySettings.UAT.click();
//
//            backButton.click();

        }

    }


    private void setupProxy(String myId, String myUnit, String myPosition) throws Exception {
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);


        if (getOS().equals("ios")) {
            myLoginPage.overflowMenu.click();

            if (myScanner.scannerCheckForText("Developer Settings") ) {
                myLoginPage.developerButton.click();
            } else {
                for (int x = 1; x <= 5; x++) {
                    myLoginPage.enterDeveloperButton.click();
                }
            }

            mySettings.networkEnvironment.click();
            mySettings.proxy.click();
            Thread.sleep(1000);
            backButton.click();

            scrollDownIOS();
            mySettings.proxyId.click();
            mySettings.proxyEditField.setValue(myId);
            mySettings.proxyDone.click();

            scrollDownIOS();

            mySettings.proxyUnits.click();
            mySettings.proxyEditField.setValue(myUnit);
            mySettings.proxyDone.click();

            mySettings.proxyPositions.click();
            mySettings.proxyEditField.setValue(myPosition);
            mySettings.proxyDone.click();
            Thread.sleep(1000);

            backButton.click();
            Thread.sleep(1000);
            backButton.click();

        } else {
            myLoginPage.overflowMenu.click();
            myLoginPage.overflowSettings.click();
            scrollToTextRecyclerView("About");
            mySettings.about.click();
            for (int x = 1 ; x <= 7 ; x++ ) {
                mySettings.aboutLogo.click();
            }
            backButton.click();
            scrollToTextRecyclerView("Network Environment");
            //mySettings.resetWhatsNewPrompt.click();

            mySettings.networkEnvironment.click();
            mySettings.proxy.click();

            scrollToTextRecyclerView("px_i");
            //scrollToText("px_u");

            mySettings.proxyId.click();
            mySettings.proxyEditField.setValue(myId);
            mySettings.proxyDone.click();

            scrollToTextRecyclerView("px_u");

            mySettings.proxyUnits.click();
            mySettings.proxyEditField.setValue(myUnit);
            mySettings.proxyDone.click();

            scrollToTextRecyclerView("px_p");

            mySettings.proxyPositions.click();
            mySettings.proxyEditField.setValue(myPosition);
            mySettings.proxyDone.click();

            backButton.click();
        }

    }

    public void enterPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
//        PinScreen myPin = new PinScreen(driver);
        MenuScreen myMenuScreen = new MenuScreen(driver);
        BaseDriver myBaseDriver = new BaseDriver();

        String deviceName;


        Thread.sleep(4000);

        System.out.println("Check for non leader PIN prompt");
        nonLeaderPinCheck();
//        checkForAlertsBeforePin();

//        System.out.println("Dismiss Whats New Page");
//        dismissWhatsNewPage();

        //Android needs this.
//        System.out.println("Check for MORE Alerts after whats new page");
//        checkForAlertsAfterPin();



        if (getOS().equalsIgnoreCase("ios")) {
            Thread.sleep(2000);

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
        } else {
            Thread.sleep(4000);
            System.out.println("Enter PIN!!!");
            deviceName = driver.getCapabilities().getCapability("deviceName").toString();
            myBaseDriver.adbEnterPIN(deviceName);

//            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BUTTON_1));
//            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BUTTON_1));
//            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BUTTON_3));
//            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BUTTON_3));
//            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }



        //Sometimes there is a warning before the Whats new screen
        System.out.println("Check for Alerts AFTER PIN");
        if (!getOS().equalsIgnoreCase("ios")) {
            //Android needs this.
            checkForAlertsAfterPin();
            Thread.sleep(2000);

            //Android needs this.
            dismissWhatsNewPage();

            //Android needs this.
            checkForAlertsAfterPin();
        }

        //iOS may need this.
        dismissWhatsNewPage();





        // Click on Later then Directory
        if (!getOS().equals("ios")) {
            Thread.sleep(2000);
            checkForLater();
            Thread.sleep(2000);
            myMenuScreen.directory.click();
            Thread.sleep(2000);
        }

    }

    public void changePIN(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
//        PinScreen myPin = new PinScreen(driver);
//        MenuScreen myMenuScreen = new MenuScreen(driver);

        Thread.sleep(4000);
        checkForAlertsBeforePin();


        Thread.sleep(2000);

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



    public void nonLeaderNoPin() throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPin = new PinScreen(driver);
        MenuScreen myMenuScreen = new MenuScreen(driver);

        Thread.sleep(4000);
//        checkForAlertsBeforePin();

        //Android needs this.
        if (!getOS().equals("ios")) {
            checkForAlertsAfterPin();
        }

        dismissWhatsNewPage();

//        //Sometimes there is a warning before the Whats new screen
//        checkForAlertsAfterPin();


        Thread.sleep(2000);
        myPin.pinAlertDialogNotNow.click();


        Thread.sleep(2000);

        //Sometimes there is a warning before the Whats new screen
        checkForAlertsAfterPin();

        Thread.sleep(2000);

        dismissWhatsNewPage();

        checkForAlertsAfterPin();



        // Click on Later then Directory
        if (!getOS().equals("ios")) {
            Thread.sleep(2000);
            checkForLater();
            Thread.sleep(2000);
            myMenuScreen.directory.click();
            Thread.sleep(2000);
        }

    }

    public void enterPinKeepWhatsNew(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
//        PinScreen myPin = new PinScreen(driver);
        BaseDriver myBaseDriver = new BaseDriver();
        MenuScreen myMenuScreen = new MenuScreen(driver);

        String deviceName;


        Thread.sleep(4000);

        System.out.println("Check for Alerts Before PIN");
        checkForAlertsBeforePin();

        //Android needs this.
        System.out.println("Check for MORE Alerts after whats new page");
        checkForAlertsAfterPin();


        if (getOS().equalsIgnoreCase("ios")) {
            Thread.sleep(2000);

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
        } else {
            Thread.sleep(4000);
            System.out.println("Enter PIN!!!");
            deviceName = driver.getCapabilities().getCapability("deviceName").toString();
            myBaseDriver.adbEnterPIN(deviceName);


        }
    }

    private void checkForLater() {
        MenuScreen myMenuScreen = new MenuScreen(driver);
        if (checkForElement(myMenuScreen.laterButton)) {
            myMenuScreen.laterButton.click();
        }
    }

    public void enterCurrentPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {

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
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        SyncScreen mySyncScreen = new SyncScreen(driver);


        if (getOS().equals("ios")) {
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
            mySyncScreen.syncNowButton.click();
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
            myBasePage.scrollToTextNavMenu("Sync");

            Thread.sleep(4000);
            if (myBasePage.checkForElement(myBasePage.alertOK)) {
                myBasePage.alertOK.click();
            }


            Thread.sleep(4000);
            myBasePage.waitUnitlTextIsGone("UAT");
            Thread.sleep(4000);
        }

        if (myBasePage.checkForAlert()) {
            myBasePage.alertOK.click();
        }

    }

    public void dismissWhatsNewPage() throws Exception {
        // ********* Constructor **********
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        BasePage myBasePage = new BasePage(driver);
//        ScannerScreen myScanner = new ScannerScreen(driver);

        //Check for Whats New Page
//      if (myBasePage.checkForElement(myWhatsNew.whatsNewDone)) {
        if (myBasePage.checkElementExists("Done") || (myBasePage.checkElementExists("DONE")) ){
//            System.out.println(myBasePage.getSourceOfPage());
            myWhatsNew.whatsNewDone.click();
            if (!myBasePage.getOS().equals("ios")) {
                if (myBasePage.checkForElement(myBasePage.allowButton)) {
                    myBasePage.allowButton.click();
                    myBasePage.allowButton.click();
                    if (myBasePage.checkForElement(myBasePage.allowButton)) {
                        myBasePage.allowButton.click();
                    }

                }
            }
        }

    }


    private void checkForAlertsBeforePinTEST() throws Exception {
        ScannerScreen myScanner = new ScannerScreen(driver) ;
        PinScreen myPin = new PinScreen(driver);
//        BasePage myBase = new BasePage(driver);

        Boolean myCheck = false;


        List<Element> myUsableElements = new ArrayList<Element>();


        //System.out.println(myBase.getSourceOfPage());
        myUsableElements = myScanner.getClickableElements();
        //myCheck = myScanner.checkForElementsTEST("md_buttonDefaultPositive");
        myCheck = myScanner.quickCheckForElements(myUsableElements, "md_buttonDefaultPositive");
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            myUsableElements = myScanner.getClickableElements();
        }

        myCheck = myScanner.quickCheckForElements(myUsableElements, "OK");
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            myUsableElements = myScanner.getClickableElements();
        }

        myCheck = myScanner.quickCheckForElements(myUsableElements, "md_buttonDefaultPositive");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            myUsableElements = myScanner.getClickableElements();
        }

        myCheck = myScanner.quickCheckForElements(myUsableElements, "Yes");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            myUsableElements = myScanner.getClickableElements();
        }

        System.out.println("Checking for Face ID");
        myCheck = myScanner.quickCheckForElements(myUsableElements, "Face ID");
        if (myCheck) {
            System.out.println("Face ID found hitting disable");
            myPin.pinDisableFaceID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
            myUsableElements = myScanner.getClickableElements();
        }

        System.out.println("Checking for Touch ID");
        myCheck = myScanner.quickCheckForElements(myUsableElements, "Touch ID");
        if (myCheck) {
            System.out.println("Enable Touch ID Button found, hitting the button");
            myPin.pinDisableTouchID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
        }


    }

    public void nonLeaderPinCheck() throws Exception {
        PinScreen myPin = new PinScreen(driver);
        BasePage myBase = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);

        Boolean myCheck = false;
        String pageSource;

        pageSource = myBase.getSourceOfPage();

        Assert.assertFalse(pageSource.contains("Member Tools Services are unavailable."));

        myCheck = pageSource.contains("You can set up a Member Tools Passcode");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
        }
    }

    public void checkForAlertsBeforePin() throws Exception {
        PinScreen myPin = new PinScreen(driver);
        BasePage myBase = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);

        Boolean myCheck = false;
        String pageSource;

        pageSource = myBase.getSourceOfPage();

        Assert.assertFalse(pageSource.contains("Member Tools Services are unavailable."));

//        myCheck = myBase.checkElementExists("OK");
        myCheck = pageSource.contains("OK");
//        System.out.println(pageSource);
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            pageSource = myBase.getSourceOfPage();
        }

//        myCheck = myBase.checkElementExists("Yes");
        myCheck = pageSource.contains("Yes");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            pageSource = myBase.getSourceOfPage();
        }

        System.out.println("Checking for Face ID");
//        myCheck = myBase.checkElementExists("Disable Face ID");
        myCheck = pageSource.contains("Disable Face ID");
        if (myCheck) {
            System.out.println("Face ID found hitting disable");
            myPin.pinDisableFaceID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
            pageSource = myBase.getSourceOfPage();
        }

        System.out.println("Checking for Touch ID");
//        myCheck = myBase.checkElementExists("Disable Touch ID");
        myCheck = pageSource.contains("Disable Touch ID");
        if (checkForElement(myWhatsNew.usePassword)) //Samsung phones need this
            myWhatsNew.usePassword.click();

        if (myCheck) {
            System.out.println("Enable Touch ID Button found, hitting the button");
            myPin.pinDisableTouchID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
        }


    }


    public void checkForAlertsAfterPin() throws Exception {
        PinScreen myPin = new PinScreen(driver);
        BasePage myBase = new BasePage(driver);

        String pageSource;
        Boolean myCheck = false;

        pageSource = myBase.getSourceOfPage();

        myCheck = pageSource.contains("OK");
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            pageSource = myBase.getSourceOfPage();
        }

        myCheck = pageSource.contains("Yes");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            pageSource = myBase.getSourceOfPage();
        }

        if (!getOS().equalsIgnoreCase("ios")) {
            myCheck = pageSource.contains("Allow");
            if (myCheck) {
                myPin.pinAlertDialogAllow.click();
                pageSource = myBase.getSourceOfPage();
            }

            myCheck = pageSource.contains("Allow");
            if (myCheck) {
                myPin.pinAlertDialogAllow.click();
            }

        }

    }



    public void uatInvalidLogin(String userName, String password) throws Exception {
        //Enable Developer Settings and set the Network Environment to UAT
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        String myTemp = "";

        if (checkForElement(allowButton)) {
            allowButton.click();
        }

        setupUAT(myTemp);

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(1000);
    }

}
