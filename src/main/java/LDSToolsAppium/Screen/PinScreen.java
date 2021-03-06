package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class PinScreen extends BasePage {

    public PinScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Alert Dialog Leader ******************
    //Alert Dialog
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/android:id/content")
    @iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeAlert'")
    public  MobileElement pinAlertDialog;

    //Alert Dialog Title
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_titleFrame")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeAlert'")
    public  MobileElement pinAlertDialogTitle;

    //Alert Dialog Message
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_content")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
    public  MobileElement pinAlertDialogMessage;

    //Alert Dialog Not Now
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_buttonDefaultNegative")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_button_negative")
    @iOSXCUITFindBy(accessibility = "Not Now")
    public  MobileElement pinAlertDialogNotNow;

    //Alert Dialog OK
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_buttonDefaultPositive")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_button_positive")
    @iOSXCUITFindBy(accessibility = "OK")
    public  MobileElement pinAlertDialogOK;

    //Alert Dialog Yes
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_buttonDefaultPositive")
    @iOSXCUITFindBy(accessibility = "Yes")
    public  MobileElement pinAlertDialogYes;

    //Alert Dialog Allow
    @AndroidFindBy(xpath = "//*[@text='Allow']")
    @iOSXCUITFindBy(accessibility = "Yes")
    public  MobileElement pinAlertDialogAllow;

    // ****************** Face and Touch ID ******************
    // Disable Face ID
    @iOSXCUITFindBy(accessibility = "Disable Face ID")
    public MobileElement pinDisableFaceID;

    // Disable Touch ID
//    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Disable Touch ID'")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Disable Security'")
    public MobileElement pinDisableTouchID;





    // ****************** PIN Page ******************
    //Splash Icon
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/splashIcon")
    @iOSXCUITFindBy(accessibility = "lt-icon-lg-iPhone")
    public  MobileElement pinSplashIcon;

    //When PIN dot is filled out the attribute will be selected = "true"
    //Pin Dot 1
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinDot1")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinDot1;

    //Pin Dot 2
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinDot2")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinDot2;

    //Pin Dot 3
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinDot3")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinDot3;

    //Pin Dot 4
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinDot4")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinDot4;


    //Pin Key 1
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/oneButton")
    @iOSXCUITFindBy(accessibility = "1")
    public  MobileElement pinKey1;

    //Pin Key 2
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/twoButton")
    @iOSXCUITFindBy(accessibility = "2")
    public  MobileElement pinKey2;

    //Pin Key 3
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/threeButton")
    @iOSXCUITFindBy(accessibility = "3")
    public  MobileElement pinKey3;

    //Pin Key 4
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fourButton")
    @iOSXCUITFindBy(accessibility = "4")
    public  MobileElement pinKey4;

    //Pin Key 5
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fiveButton")
    @iOSXCUITFindBy(accessibility = "5")
    public  MobileElement pinKey5;

    //Pin Key 6
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sixButton")
    @iOSXCUITFindBy(accessibility = "6")
    public  MobileElement pinKey6;

    //Pin Key 7
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sevenButton")
    @iOSXCUITFindBy(accessibility = "7")
    public  MobileElement pinKey7;

    //Pin Key 8
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/eightButton")
    @iOSXCUITFindBy(accessibility = "8")
    public  MobileElement pinKey8;

    //Pin Key 9
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/nineButton")
    @iOSXCUITFindBy(accessibility = "9")
    public  MobileElement pinKey9;

    //Pin Key 0
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/zeroButton")
    @iOSXCUITFindBy(accessibility = "0")
    public  MobileElement pinKey0;

    //Pin Key Visibility
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinKeyVisibility")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinKeyVisibility;

    //Pin Key Enter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/enterButton")
    public MobileElement pinKeyEnter;

    //Pin Key Delete
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/deleteButton")
    @iOSXCUITFindBy(accessibility = "DELETE")
    public  MobileElement pinKeyDelete;

    //Pin Key Message
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinHintTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinKeyMessage;

    //Pin Key Error Message
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinStatusTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinKeyErrorMessage;


    //Pin Key Sign Out
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/signOutButton")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement pinKeySignOut;


    //Pin Message
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/pinHintTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value, 'Passcode')]")
    public MobileElement pinMessage;



}
