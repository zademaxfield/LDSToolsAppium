package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class PinScreen extends BasePage {

    public PinScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    // ****************** Alert Dialog Leader ******************
    //Alert Dialog
    @AndroidFindBy(id = "android:id/content")
    @iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeAlert'")
    public static MobileElement pinAlertDialog;

    //Alert Dialog Title
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/md_titleFrame")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeAlert'")
    public static MobileElement pinAlertDialogTitle;

    //Alert Dialog Message
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/md_content")
    @iOSFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
    public static MobileElement pinAlertDialogMessage;

    //Alert Dialog Not Now
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/md_buttonDefaultNegative")
    @iOSFindBy(accessibility = "Not Now")
    public static MobileElement pinAlertDialogNotNow;

    //Alert Dialog OK
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/md_buttonDefaultPositive")
    @iOSFindBy(accessibility = "OK")
    public static MobileElement pinAlertDialogOK;


    // ****************** PIN Page ******************
    //Splash Icon
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/splashIcon")
    @iOSFindBy(accessibility = "lt-icon-lg-iPhone")
    public static MobileElement pinSplashIcon;

    //When PIN dot is filled out the attribute will be selected = "true"
    //Pin Dot 1
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinDot1")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinDot1;

    //Pin Dot 2
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinDot2")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinDot2;

    //Pin Dot 3
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinDot3")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinDot3;

    //Pin Dot 4
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinDot4")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinDot4;


    //Pin Key 1
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey1")
    @iOSFindBy(accessibility = "1")
    public static MobileElement pinKey1;

    //Pin Key 2
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey2")
    @iOSFindBy(accessibility = "2")
    public static MobileElement pinKey2;

    //Pin Key 3
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey3")
    @iOSFindBy(accessibility = "3")
    public static MobileElement pinKey3;

    //Pin Key 4
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey4")
    @iOSFindBy(accessibility = "4")
    public static MobileElement pinKey4;

    //Pin Key 5
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey5")
    @iOSFindBy(accessibility = "5")
    public static MobileElement pinKey5;

    //Pin Key 6
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey6")
    @iOSFindBy(accessibility = "6")
    public static MobileElement pinKey6;

    //Pin Key 7
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey7")
    @iOSFindBy(accessibility = "7")
    public static MobileElement pinKey7;

    //Pin Key 8
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey8")
    @iOSFindBy(accessibility = "8")
    public static MobileElement pinKey8;

    //Pin Key 9
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey9")
    @iOSFindBy(accessibility = "9")
    public static MobileElement pinKey9;

    //Pin Key 0
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKey0")
    @iOSFindBy(accessibility = "0")
    public static MobileElement pinKey0;

    //Pin Key Visibility
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKeyVisibility")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinKeyVisibility;

    //Pin Key Delete
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinKeyVisibility")
    @iOSFindBy(accessibility = "DELETE")
    public static MobileElement pinKeyDelete;

    //Pin Key Message
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/pinHintTextView")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinKeyMessage;

    //Pin Key Error Message
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/attemptsTextView")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinKeyErrorMessage;


    //Pin Key Sign Out
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/signOutButton")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public static MobileElement pinKeySignOut;

}
