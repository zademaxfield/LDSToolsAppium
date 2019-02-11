package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class WhatsNewScreen extends BasePage {

    public WhatsNewScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Whats New Screen ******************

    //Title
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric']")  //NEED TO CHANGE
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText[1]")
    public MobileElement whatsNewTitle;

    //Title Sub
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric']")  //NEED TO CHANGE
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText[2]")
    public MobileElement whatsNewTitleSub;

    //Done Button
    @AndroidFindBy(id = "done")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement whatsNewDone;


}
