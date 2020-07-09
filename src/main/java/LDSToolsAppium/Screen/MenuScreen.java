package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class MenuScreen extends BasePage {

    public MenuScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }

    //Directory
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Directory'][contains(@resource-id, 'titleTextView')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Directory'")
    public  MobileElement directory;

    //Organizations
    @AndroidFindBy(xpath = "//*[@text='Organizations']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Organizations'")
    public  MobileElement organizations;

    //Calendar
    @AndroidFindBy(xpath = "//*[@text='Calendar']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Calendars'")
    public  MobileElement calendar;

    //Reports
    @AndroidFindBy(xpath = "//*[@text='Reports']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Reports'")
    public  MobileElement reports;

    //Lists
    @AndroidFindBy(xpath = "//*[@text='Lists']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Lists'")
    public  MobileElement lists;

    //Missionary
    @AndroidFindBy(xpath = "//*[@text='Missionary']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Missionary'")
    public  MobileElement missionary;

    //Meetinghouses
    @AndroidFindBy(xpath = "//*[@text='Meetinghouses']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Meetinghouses'")
    public  MobileElement meetinghouses;

    //Temples
    @AndroidFindBy(xpath = "//*[@text='Temples']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Temples'")
    public  MobileElement temples;

    //Sync
    @AndroidFindBy(xpath = "//*[@text='Sync']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Sync'")
    public  MobileElement sync;

    //Update
    @AndroidFindBy(xpath = "//*[@text='Update']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Update'")
    public  MobileElement update;

    //Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Settings'")
    public  MobileElement settings;

    //Help
    @AndroidFindBy(xpath = "//*[@text='Help']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Help'")
    public  MobileElement help;

    // ********** Android Only **********
    //Later Button
    @AndroidFindBy(id = "updateLaterButton")
    public  MobileElement laterButton;

    //Update My Info Button
    @AndroidFindBy(id = "drawer_update_info_button")
    public  MobileElement updateMyInfo;

    //Drawer Message
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='drawer_update_info_later_layout']/android.widget.TextView")
    public  MobileElement drawerMessage;

    // ********** iOs Only **********
    //More Button
//    @iOSXCUITFindBy(iOSNsPredicate = "name == 'More' AND type == 'XCUIElementTypeButton'")
    @iOSXCUITFindBy(accessibility = "More")
//    @iOSXCUITFindBy(iOSNsPredicate = "name == 'More'")
    public  MobileElement moreMenu;

    public void selectMenu(MobileElement myElement) throws Exception {
        BasePage myBase = new BasePage(driver);
        if (!getOS().equals("ios")) {
            drawerButton.click();
        }
        //Check for Element
        if (checkForElement(myElement)) {
            myElement.click();
        } else {
            if (getOS().equals("ios")) {
//                System.out.println("Clicking More....");
//                System.out.println(myBase.getSourceOfPage());
//                myBase.checkForElement(moreMenu);
                moreMenu.click();
            } else {
                scrollDownTEST(200);
            }
            myBase.waitForElementThenClick(myElement);
//            myElement.click();
        }
    }

    public void menuLogOut() throws Exception {
        SettingsScreen mySettings = new SettingsScreen(driver);

        Thread.sleep(1000);
        selectMenu(settings);

        mySettings.signOut.click();

        if (checkForElement(alertOK)) {
            alertOK.click();
        }


        if (getOS().equals("ios")) {
            driver.resetApp();
        }
    }


}
