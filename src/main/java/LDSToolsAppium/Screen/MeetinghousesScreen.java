package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MeetinghousesScreen extends BasePage {

    public MeetinghousesScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }

    // ****************** Before Main Screen Loads ******************

    //Allow access to your location
    @AndroidFindBy(id = "md_buttonDefaultPositive")
    @iOSXCUITFindBy(accessibility = "Allow")
    public MobileElement meetinghousesAllow;


    //Deny access to your location
    @AndroidFindBy(id = "permission_deny_button")
    @iOSXCUITFindBy(accessibility = "Deny")
    public MobileElement meetinghousesDeny;

    //Allow access to your location - Android Permissions Dialog
    @AndroidFindBy(id = "permission_allow_button")
    public MobileElement meetinghousesAllowAndroidPermissions;


    // ****************** Meetinghouses Main Screen ******************


    // ****************** Meetinghouses Toolbar Screen ******************

    //Current Location
    @AndroidFindBy(id = "my_location_fab")
    @iOSXCUITFindBy(accessibility = "icon current location")
    public MobileElement meetinghousesCurrentLocation;


    //More Button - Android Only
    @AndroidFindBy(accessibility = "More options")
    public MobileElement meetinghousesMoreOptions;

    //Map Types
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Map Types']")
    @iOSXCUITFindBy(accessibility = "icon info")
    public MobileElement meetinghousesMapTypes;

        //Map Types - Road
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Road']/following-sibling::android.widget.RadioButton")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Road')]")
        public MobileElement meetinghousesMapTypesRoad;

        //Map Types - Satellite
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Satelite']/following-sibling::android.widget.RadioButton")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Satellite')]")
        public MobileElement meetinghousesMapTypesSatellite;

        //Map Types - Hybrid
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Hybrid')]")
        public MobileElement meetinghousesMapTypesHybrid;

        //Map Types - Satellite Flyover
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Satellite Flyover')]")
        public MobileElement meetinghousesMapTypesSatelliteFlyover;

        //Map Types - Hybrid Flyover
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Hybrid Flyover')]")
        public MobileElement meetinghousesMapTypesHybridFlyover;

        //Map Types - Cancel
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Cancel')]")
        public MobileElement meetinghousesMapTypesHybridCancel;


    //Search Button - Android only
    @AndroidFindBy(id = "menu_map_search")
    public MobileElement meetinghousesSeachButton;

    //Search Text Field
    @AndroidFindBy(id = "search_src_text")
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement meetinghousesSeachField;




}
