package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MissionaryScreen extends BasePage {

    public MissionaryScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Missionary Main Screen ******************

    //Send Referral Button
    @AndroidFindBy(id = "fab")
    @iOSFindBy(accessibility = "Send Referral")
    public MobileElement sendReferralButton;

    //Cancel Referral
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSFindBy(accessibility = "Back")
    public MobileElement cancelReferralButton;



    // ****************** Missionary Send Referral Screen ******************
    //Help Message
    @AndroidFindBy(id = "personalInformationExplanationTextView")
    @iOSFindBy(accessibility = "Helps the missionaries know how to contact you to discuss your friend's needs.")
    public MobileElement referralHelpMessage;

    //Member Phone Number
    @AndroidFindBy(id = "personalPhoneTextView")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='PHONE']/following-sibling::XCUIElementTypeStaticText")
    public MobileElement referralMemberPhoneNumber;

    //Member Email
    @AndroidFindBy(id = "personalEmailTextView")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='EMAIL']/following-sibling::XCUIElementTypeStaticText")
    public MobileElement referralMemberEmail;

    //Update Individual Information
    @AndroidFindBy(id = "addContactInformationButton")
    @iOSFindBy(accessibility = "Update Individual Information")
    public MobileElement referralUpdateIndividualInformation;

    //Referral Name
    @AndroidFindBy(id = "nameTextInputEditText")
    @iOSFindBy(accessibility = "Name")
    public MobileElement referralName;

    //Referral Phone
    @AndroidFindBy(id = "phoneTextInputEditText")
    @iOSFindBy(accessibility = "Phone")
    public MobileElement referralPhone;

    //Referral Email
    @AndroidFindBy(id = "emailTextInputEditText")
    @iOSFindBy(accessibility = "Email")
    public MobileElement referralEmail;


    //Referral Locate on Map
    @AndroidFindBy(id = "locateOnMapTextView")
    @iOSFindBy(accessibility = "Locate on Map")
    public MobileElement referralLocateOnMap;

    //Referral Map Search
    @AndroidFindBy(id = "filterEditText")
    @iOSFindBy(accessibility = "Search")
    public MobileElement referralMapSearch;

    //Referral Add Preferred Language
    @AndroidFindBy(id = "languageTextView")
    @iOSFindBy(accessibility = "Add Preferred Language")
    public MobileElement referralAddPreferredLanguage;

    //Referral Add Message Button iOS only
    @iOSFindBy(accessibility = "Add a Message")
    public MobileElement referralAddMessageButton;

    //Referral Cancel Message Button iOS only
    //@iOSFindBy(accessibility = "minus")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Message']/following-sibling::XCUIElementTypeImage[@name='minus']")
    public MobileElement referralCancelMessage;




    //Referral Message field
    @AndroidFindBy(id = "helpfulMessageEditText")
    @iOSFindBy(accessibility = "Message")
    public MobileElement referralMessageField;

    //Referral Send Referral Button
    @AndroidFindBy(id = "sendReferralButton")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Send Referral']")
    public MobileElement referralSendReferral;





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








    public String getMissionaryPage() throws Exception {
        BasePage myBasePage = new BasePage(driver);

        String pageSource = null;
        if (getOS().equals("ios")) {
            pageSource = getSourceOfPage();
            scrollDownIOS();

            pageSource = pageSource + getSourceOfPage();
        } else {


            //Contact Tab
            Thread.sleep(1000);
            pageSource = getSourceOfPage();

            tabAssigned.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            tabWard.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            tabServing.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            tabReferrals.click();
        }

        return pageSource;

    }




}
