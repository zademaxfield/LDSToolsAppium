package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class MenuScreen extends BasePage {

    public MenuScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }

    //Directory
    @AndroidFindBy(xpath = "//*[@resource-id='org.lds.ldstools.dev:id/design_menu_item_text'][@text='Directory']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Directory'")
    public static MobileElement directory;

    //Organizations
    @AndroidFindBy(xpath = "//*[@text='Organizations']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Organizations'")
    public static MobileElement organizations;

    //Calendar
    @AndroidFindBy(xpath = "//*[@text='Calendar']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Calendar'")
    public static MobileElement calendar;

    //Reports
    @AndroidFindBy(xpath = "//*[@text='Reports']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Reports'")
    public static MobileElement reports;

    //Lists
    @AndroidFindBy(xpath = "//*[@text='Lists']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Lists'")
    public static MobileElement lists;

    //Missionary
    @AndroidFindBy(xpath = "//*[@text='Missionary']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Missionary'")
    public static MobileElement missionary;

    //Meetinghouses
    @AndroidFindBy(xpath = "//*[@text='Meetinghouses']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Meetinghouses'")
    public static MobileElement meetinghouses;

    //Temples
    @AndroidFindBy(xpath = "//*[@text='Temples']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Temples'")
    public static MobileElement temples;

    //Sync
    @AndroidFindBy(xpath = "//*[@text='Sync']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Sync'")
    public static MobileElement sync;

    //Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Settings'")
    public static MobileElement settings;

    //Help
    @AndroidFindBy(xpath = "//*[@text='Help']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Help'")
    public static MobileElement help;

    // ********** Android Only **********
    //Later Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/drawer_update_info_later_button")
    public static MobileElement laterButton;

    //Update My Info Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/drawer_update_info_button")
    public static MobileElement updateMyInfo;

    //Drawer Message
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='org.lds.ldstools.dev:id/drawer_update_info_later_layout']/android.widget.TextView")
    public static MobileElement drawerMessage;

    // ********** iOs Only **********
    //More Button
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'More'")
    public static MobileElement moreMenu;

    public void selectMenu(MobileElement myElement) throws Exception {
        //Check for Element
        if (checkForElement(myElement)) {
            myElement.click();
        } else {
            if (getOS().equals("mac")) {
                moreMenu.click();
            } else {
                scrollDownTEST(200);
            }
            myElement.click();
        }
    }

}
