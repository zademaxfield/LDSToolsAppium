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


public class MissionaryScreen extends BasePage {

    public MissionaryScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Missionary Main Screen ******************

    //Send Referral Button
    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "Send Referral")
    public MobileElement sendReferralButton;

    //Cancel Referral
//    @AndroidFindBy(accessibility = "Navigate up")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Back")
    public MobileElement cancelReferralButton;



    // ****************** Missionary Send Referral Screen ******************
    //Help Message
    @AndroidFindBy(id = "personalInformationExplanationTextView")
    @iOSXCUITFindBy(accessibility = "Helps the missionaries know how to contact you to discuss your friend's needs.")
    public MobileElement referralHelpMessage;

    //Member Phone Number
    @AndroidFindBy(id = "personalPhoneTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PHONE']/following-sibling::XCUIElementTypeStaticText")
    public MobileElement referralMemberPhoneNumber;

    //Member Email
    @AndroidFindBy(id = "personalEmailTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='EMAIL']/following-sibling::XCUIElementTypeStaticText")
    public MobileElement referralMemberEmail;

    //Update Individual Information
    @AndroidFindBy(id = "addContactInformationNoInfoButton")
    @iOSXCUITFindBy(accessibility = "Update Individual Information")
    public MobileElement referralUpdateIndividualInformation;

    //Referral Name
    @AndroidFindBy(id = "nameTextInputEditText")
    @iOSXCUITFindBy(accessibility = "Name")
    public MobileElement referralName;

    //Referral Phone
    @AndroidFindBy(id = "phoneTextInputEditText")
    @iOSXCUITFindBy(accessibility = "Phone")
    public MobileElement referralPhone;

    //Referral Email
    @AndroidFindBy(id = "emailTextInputEditText")
    @iOSXCUITFindBy(accessibility = "Email")
    public MobileElement referralEmail;


    //Referral Locate on Map
    @AndroidFindBy(id = "locateOnMapTextView")
    @iOSXCUITFindBy(accessibility = "Locate on Map")
    public MobileElement referralLocateOnMap;

    //Referral Map Search
    @AndroidFindBy(id = "filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement referralMapSearch;

    //Referral Add Preferred Language
    @AndroidFindBy(id = "languageTextView")
    @iOSXCUITFindBy(accessibility = "Add Preferred Language")
    public MobileElement referralAddPreferredLanguage;

    //Referral Add Message Button iOS only
    @iOSXCUITFindBy(accessibility = "Add a Message")
    public MobileElement referralAddMessageButton;

    //Referral Cancel Message Button iOS only
    //@iOSXCUITFindBy(accessibility = "minus")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Message']/following-sibling::XCUIElementTypeImage[@name='minus']")
    public MobileElement referralCancelMessage;




    //Referral Message field
    @AndroidFindBy(id = "helpfulMessageEditText")
    @iOSXCUITFindBy(accessibility = "Message")
    public MobileElement referralMessageField;

    //Referral Send Referral Button
    @AndroidFindBy(id = "sendReferralButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Send Referral']")
    public MobileElement referralSendReferral;

    //Overflow Button - Android only
    @AndroidFindBy(id = "removeReferralImageButton")
    public MobileElement referralOverflowButton;


    //Remove Referral
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove from list']")
    @iOSXCUITFindBy(accessibility = "Remove")
    public MobileElement referralRemove;

    //Remove from list?
    @AndroidFindBy(id = "md_buttonDefaultPositive")
    public MobileElement referralRemoveFromList;



    //Android Only
    //Referrals Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"referrals\")]")
    public  MobileElement tabReferrals;

    //Tab Assigned
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"assigned\")]")
    public  MobileElement tabAssigned;

    //Tab Ward
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"ward\")]")
    public  MobileElement tabWard;

    //Tab Serving
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"serving\")]")
    public  MobileElement tabServing;



    //Use This Location
    @AndroidFindBy(id = "useLocationFab")
    public  MobileElement referralUseThisLocation;


    //*********** Tool Bar **************
    @AndroidFindBy(id = "drop_arrow")
    @iOSXCUITFindBy(accessibility = "Missionary")
    public MobileElement unitSelector;







    public String getMissionaryPage() throws Exception {
        BasePage myBasePage = new BasePage(driver);

        String pageSource = null;
        if (getOS().equals("ios")) {
            pageSource = getSourceOfPage();
            scrollDownIOS();

            pageSource = pageSource + getSourceOfPage();
        } else {


            //Contact Tab
            Thread.sleep(3000);
            pageSource = getSourceOfPage();

            tabAssigned.click();
            Thread.sleep(3000);
            pageSource = pageSource + getSourceOfPage();

            tabWard.click();
            Thread.sleep(3000);
            pageSource = pageSource + getSourceOfPage();

            tabServing.click();
            Thread.sleep(3000);
            pageSource = pageSource + getSourceOfPage();

            tabReferrals.click();
        }

        return pageSource;

    }




}
