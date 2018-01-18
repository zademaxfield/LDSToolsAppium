package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class MenuScreen extends BasePage {

    public MenuScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }

    //Directory
    @AndroidFindBy(xpath = "//*[@text='Directory']")
    @iOSFindBy(uiAutomator = "name == 'Directory'")
    public static MobileElement directory;

    //Organizations
    @AndroidFindBy(xpath = "//*[@text='Organizations']")
    @iOSFindBy(uiAutomator = "name == 'Organizations'")
    public static MobileElement organizations;

    //Calendar
    @AndroidFindBy(xpath = "//*[@text='Calendar']")
    @iOSFindBy(uiAutomator = "name == 'Calendar'")
    public static MobileElement calendar;

    //Reports
    @AndroidFindBy(xpath = "//*[@text='Reports']")
    @iOSFindBy(uiAutomator = "name == 'Reports'")
    public static MobileElement reports;

    //Lists
    @AndroidFindBy(xpath = "//*[@text='Lists']")
    @iOSFindBy(uiAutomator = "name == 'Lists'")
    public static MobileElement lists;

    //Missionary
    @AndroidFindBy(xpath = "//*[@text='Missionary']")
    @iOSFindBy(uiAutomator = "name == 'Missionary'")
    public static MobileElement missionary;

    //Meetinghouses
    @AndroidFindBy(xpath = "//*[@text='Meetinghouses']")
    @iOSFindBy(uiAutomator = "name == 'Meetinghouses'")
    public static MobileElement meetinghouses;

    //Temples
    @AndroidFindBy(xpath = "//*[@text='Temples']")
    @iOSFindBy(uiAutomator = "name == 'Temples'")
    public static MobileElement temples;

    //Sync
    @AndroidFindBy(xpath = "//*[@text='Sync']")
    @iOSFindBy(uiAutomator = "name == 'Sync'")
    public static MobileElement sync;

    //Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    @iOSFindBy(uiAutomator = "name == 'Settings'")
    public static MobileElement settings;

    //Help
    @AndroidFindBy(xpath = "//*[@text='Help']")
    @iOSFindBy(uiAutomator = "name == 'Help'")
    public static MobileElement help;






}
