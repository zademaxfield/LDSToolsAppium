package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class CalendarsScreen extends BasePage {

    public CalendarsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    // ****************** Calendars Main Screen ******************

    //Edit
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    @iOSFindBy(accessibility = "Edit")
    public MobileElement editCalendar;




}
