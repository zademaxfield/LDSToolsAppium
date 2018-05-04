package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class CalendarsScreen extends BasePage {

    public CalendarsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Calendars Main Screen ******************

    //Edit
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    @iOSFindBy(accessibility = "Edit")
    public MobileElement editCalendar;

    //Calendars to display
    //Select None
    //This is broken for iOS appium cannot see select none or subscriptions
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    @iOSFindBy(accessibility = "Edit")
    public MobileElement selectNoneCalendar;






}
