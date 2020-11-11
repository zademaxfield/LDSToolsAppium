package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class HelpScreen extends BasePage {

    public HelpScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }

    //Send Feedback
    @AndroidFindBy(id = "feedback_submit")
    public  MobileElement helpSendFeedback;




    //What's New
    @AndroidFindBy(xpath = "//*[contains(@text, 'What's New')]")
    public  MobileElement helpWhatsNew;

    //Release Notes
    @AndroidFindBy(xpath = "//*[contains(@text, 'Release Notes')]")
    public  MobileElement helpReleaseNotes;

    //Frequently Asked Questions
    @AndroidFindBy(xpath = "//*[contains(@text, 'Frequently Asked Questions')]")
    public  MobileElement helpFrequentlyAskedQuestions;

    //Contact Us
    @AndroidFindBy(xpath = "//*[contains(@text, 'Contact Us')]")
    public  MobileElement helpContactUs;

        //Name
        @AndroidFindBy(id = "feedbackNameTextInputEditText")
        public  MobileElement contactUsName;

        //Email
        @AndroidFindBy(id = "feedbackEmailTextInputEditText")
        public  MobileElement contactUsEmail;

        //Category
        @AndroidFindBy(id = "feedbackCategoryDropdownTextView")
        public  MobileElement contactUsCategory;

            //Other
            @AndroidFindBy(xpath = "//*[contains(@text, 'Other')]")
            public  MobileElement contactUsOther;


        //Category
        @AndroidFindBy(id = "feedbackDescriptionEditText")
        public  MobileElement contactUsDescription;
}
