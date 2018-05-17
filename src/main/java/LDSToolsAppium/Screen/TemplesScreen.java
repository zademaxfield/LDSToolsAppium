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
import java.util.concurrent.TimeUnit;


public class TemplesScreen extends BasePage {

    public TemplesScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Temple Main Screen ******************
    // Days till expiration
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='android:id/input']")
    @iOSFindBy(xpath ="//XCUIElementTypeTextField[@value='Days until expiration']")
    public MobileElement templeDaysExpiration;

    //Remind Me Later
    @AndroidFindBy(id = "remindMeLaterTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Remind me later'")
    public MobileElement remindMeLater;

    //Contact Bishopric
    @AndroidFindBy(id = "contactBishopricTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Contact bishopric'")
    public MobileElement contactBishopric;

    //Got It Thanks
    @AndroidFindBy(id = "gotItThanksTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Got it, thanks'")
    public MobileElement gotItThanks;



    //No Thanks
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'No thanks'")
    public MobileElement noThanks;

    //Yes, remind me
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Yes, remind me'")
    public MobileElement yesRemindMe;


    //Temple Tab Mine
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MINE']")
    public MobileElement mineTab;

    //Temple Tab Nearest
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEAREST']")
    public MobileElement nearestTab;

    //Temple Tab All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ALL']")
    public MobileElement allTab;

}
