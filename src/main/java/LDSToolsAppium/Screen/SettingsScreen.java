package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class SettingsScreen extends BasePage {

    public SettingsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }

    // ********* Calendar *********
    //Months to Show
    @AndroidFindBy(xpath = "//*[contains(@text, 'Months to Show')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement monthsToShow;

    // ********* Caller ID *********
    //Enable Simple Caller ID
    @AndroidFindBy(xpath = "//*[contains(@text, 'Enable Simple Caller ID')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement enableSimpleCallerID;

    //Ignore Personal Contacts
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore Personal Contacts')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement ignorePersonalContacts;

    //Caller ID Check Digits
    @AndroidFindBy(xpath = "//*[contains(@text, 'Caller ID Check Digits')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement callerIDCheckDigits;

        //Digits
        @AndroidFindBy(xpath = "//*[@text='4']")
        public  MobileElement callerID4;

        @AndroidFindBy(xpath = "//*[@text='5']")
        public  MobileElement callerID5;

        @AndroidFindBy(xpath = "//*[@text='6']")
        public  MobileElement callerID6;

        @AndroidFindBy(xpath = "//*[@text='7']")
        public  MobileElement callerID7;

        @AndroidFindBy(xpath = "//*[@text='8']")
        public  MobileElement callerID8;

        @AndroidFindBy(xpath = "//*[@text='9']")
        public  MobileElement callerID9;

        @AndroidFindBy(xpath = "//*[@text='10']")
        public  MobileElement callerID10;

        @AndroidFindBy(xpath = "//*[@text='11']")
        public  MobileElement callerID11;

        @AndroidFindBy(xpath = "//*[@text='12']")
        public  MobileElement callerID12;

        @AndroidFindBy(xpath = "//*[@text='13']")
        public  MobileElement callerID13;

        @AndroidFindBy(xpath = "//*[@text='14']")
        public  MobileElement callerID14;

        @AndroidFindBy(xpath = "//*[@text='15']")
        public  MobileElement callerID15;


    // ********* Other *********
    //Download Thumbnails
    @AndroidFindBy(xpath = "//*[contains(@text, 'Download Thumbnails')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement downloadThumbnails;

    // ********* Additional Settings *********
    //Featured Apps
    @AndroidFindBy(xpath = "//*[contains(@text, 'Featured Apps')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement featuredApps;

    //About
    @AndroidFindBy(xpath = "//*[@text='About']")
    @iOSFindBy(uiAutomator = "name == 'Help'")//NEED TO CHANGE!!!
    public  MobileElement about;

    //Rights and Use Information
    @AndroidFindBy(xpath = "//*[@text='Rights and Use Information']")
    @iOSFindBy(uiAutomator = "name == 'Help'")//NEED TO CHANGE!!!
    public  MobileElement rightsAndUseInformation;

    //Privacy Policy
    @AndroidFindBy(xpath = "//*[@text='Privacy Policy']")
    @iOSFindBy(uiAutomator = "name == 'Help'")//NEED TO CHANGE!!!
    public  MobileElement privacyPolicy;

    //Acknowledgements
    @AndroidFindBy(xpath = "//*[@text='Acknowledgements']")
    @iOSFindBy(uiAutomator = "name == 'Help'")//NEED TO CHANGE!!!
    public  MobileElement acknowledgements;

    //About Logo
    @AndroidFindBy(id = "aboutLogo")
    @iOSFindBy(uiAutomator = "name == 'Help'")//NEED TO CHANGE!!!
    public  MobileElement aboutLogo;

    // ********* Development *********
    //Ignore Maintenance Mode
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore Maintenance Mode')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement ignoreMaintenanceMode;

    //HTTP Log Level
    @AndroidFindBy(xpath = "//*[contains(@text, 'HTTP Log Level')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement HTTPLogLevel;

        //NONE
        @AndroidFindBy(xpath = "//*[contains(@text, 'NONE')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement HTTPLogLevelNONE;

        //BASIC (Default)
        @AndroidFindBy(xpath = "//*[contains(@text, 'BASIC (Default)')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement HTTPLogLevelBASIC;

        //HEADERS
        @AndroidFindBy(xpath = "//*[contains(@text, 'HEADERS')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement HTTPLogLevelHEADERS;

        //BODY (Includes Headers)
        @AndroidFindBy(xpath = "//*[contains(@text, 'BODY (Includes Headers)')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement HTTPLogLevelBODY;


    //Log Analytics
    @AndroidFindBy(xpath = "//*[contains(@text, 'Log Analytics')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement logAnalytics;

    //Log Analytics - Display Time
    @AndroidFindBy(xpath = "//*[contains(@text, 'Log Analytics - Display Time')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement logAnalyticsDisplayTime;

    //Convert to Fake Data
    @AndroidFindBy(xpath = "//*[contains(@text, 'Convert to Fake Data')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement convertToFakeData;

    //Sync Fake Data
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sync Fake Data')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement syncFakeData;

    //Sync Threads
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sync Threads')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement syncThreads;

    //Home/Visiting Teaching Months
    @AndroidFindBy(xpath = "//*[contains(@text, 'Home/Visiting Teaching Months')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement homeVisitingTeachingMonths;

    //Minutes Between Profile Prompts
    @AndroidFindBy(xpath = "//*[contains(@text, 'Minutes Between Profile Prompts')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement minutesBetweenProfilePrompts;

    //Network Environment
    @AndroidFindBy(xpath = "//*[contains(@text, 'Network Environment')]")
    @iOSFindBy(xpath = "//*[contains(@name, 'Environment')]")
    public  MobileElement networkEnvironment;

        //Production
        @AndroidFindBy(xpath = "//*[contains(@text, 'Production')]")
        @iOSFindBy(accessibility = "Prod")
        public  MobileElement production;

        //UAT
        @AndroidFindBy(xpath = "//*[contains(@text, 'UAT')]")
        @iOSFindBy(accessibility = "UAT")
        public  MobileElement UAT;

        //Proxy
        @AndroidFindBy(xpath = "//*[contains(@text, 'Proxy')]")
        @iOSFindBy(accessibility = "Proxy")
        public  MobileElement proxy;

    //Select Proxy
    @AndroidFindBy(xpath = "//*[contains(@text, 'Select Proxy')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement selectProxy;

    //px_i
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_i')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement px_i;

    //px_u
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_u')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement px_u;

    //px_p
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_p')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement px_p;

    //Prototypes
    @AndroidFindBy(xpath = "//*[contains(@text, 'Prototypes')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement prototypes;

    // ********* Development - Additional Units *********
    //Role Based Sync Rights
    @AndroidFindBy(xpath = "//*[contains(@text, 'Role Based Sync Rights')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement roleBasedSyncRights;

    //Fingerprint Required
    @AndroidFindBy(xpath = "//*[contains(@text, 'Fingerprint Required')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement fingerprintRequired;

    //Additional Unit Role
    @AndroidFindBy(xpath = "//*[contains(@text, 'Additional Unit Role')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement additionalUnitRole;

    // ********* Development - Temple *********
    //Reset All Temple Preferences
    @AndroidFindBy(xpath = "//*[contains(@text, 'Reset All Temple Preferences')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement resetAllTempelPreferences;

    //Override temple recommend expiration
    @AndroidFindBy(xpath = "//*[contains(@text, 'Override temple recommend expiration')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement overrideTempleRecommendExpiration;

    //Temple Recommend Status
    @AndroidFindBy(xpath = "//*[contains(@text, 'Temple Recommend Status')]")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement templeRecommendStatus;

        //UNKNOWN
        @AndroidFindBy(xpath = "//*[contains(@text, 'UNKNOWN')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement unknown;

        //ACTIVE
        @AndroidFindBy(xpath = "//*[contains(@text, 'ACTIVE')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement active;

        //LOST_OR_STOLEN
        @AndroidFindBy(xpath = "//*[contains(@text, 'LOST_OR_STOLEN')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement lostOrStolen;

        //CANCELED
        @AndroidFindBy(xpath = "//*[contains(@text, 'CANCELED')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement canceled;

        //EXPIRED
        @AndroidFindBy(xpath = "//*[contains(@text, 'EXPIRED')]")
        @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
        public  MobileElement expired;


    //Cancel
    @AndroidFindBy(id = "button2")
    @iOSFindBy(uiAutomator = "name == 'Help'") //NEED TO CHANGE!!!
    public  MobileElement dialogCancel;
}
