package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class CalendarsScreen extends BasePage {

    public CalendarsScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Calendars Main Screen ******************

    //Edit Button
    @iOSXCUITFindBy(accessibility = "Edit")
    public MobileElement calendarEdit;

    //Done Button
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement calendarDone;


    //Overflow Menu
    @AndroidFindBy(accessibility = "More options")
    public MobileElement calendarMoreOptions;


    //Calendars to display
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendars to display']")
    public MobileElement calendarsToDisplay;



    //Subscriptions Button
    @AndroidFindBy(id ="menu_calendar_subscriptions")
    @iOSXCUITFindBy(accessibility = "Subscriptions")
    public MobileElement calendarSubscriptions;

    //Select None Button
    @AndroidFindBy(id ="menu_calendars_select_all")
    @iOSXCUITFindBy(accessibility = "Select None")
    public MobileElement calendarsSelectNone;



    //Subscriptions Done
    @AndroidFindBy(id = "menu_item_save")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement calendarsSubscriptionsDone;

    //Subscriptions Cancel
    @AndroidFindBy(id = "menu_item_cancel")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement calendarsSubscriptionsCancel;










    //Check Calendar to display
    public void checkCalendarToDisplay(String calendarItem, String checkOrUncheck) throws Exception {
        String checkBox = "";
        if (checkOrUncheck.equals("check")) {
            checkBox = "green_check";
        } else {
            checkBox = "no_teach";
        }

        if (getOS().contains("ios")) {
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ calendarItem + "']/preceding-sibling::XCUIElementTypeImage[@name='" + checkBox +"']")).click();
        } else {
            driver.get().findElement(By.xpath("//android.widget.TextView[@text='"+ calendarItem + "']/following-sibling::android.widget.CheckBox")).click();
        }
    }




}
