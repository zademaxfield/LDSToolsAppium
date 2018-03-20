package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;


public class LoginPageScreen extends BasePage {

    public LoginPageScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    //Login Name
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/login_username")
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeTextField")
    public  MobileElement loginName;

    //Password
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/login_password")
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeSecureTextField")
    public  MobileElement passWord;

    //Sign In Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/login_signin")
    @iOSFindBy(accessibility = "Sign In")
    public  MobileElement signInButton;

    //Sync Message
    @AndroidFindBy(xpath = "//*[@text='Sync Progress']")
    @iOSFindBy(uiAutomator = "label CONTAINS 'Stop Sync'")
    public  MobileElement syncMessage;

    //Menu
    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    @iOSFindBy(accessibility = "Help")
    public  MobileElement overflowMenu;

    //Overflow Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    public  MobileElement overflowSettings;

    //Enter Developer Button
    @iOSFindBy(xpath = "//XCUIElementTypeCell[9]")
    public  MobileElement enterDeveloperButton;

    //Developer Button Displayed
    @iOSFindBy(accessibility = "Developer Settings")
    public MobileElement developerButton;


    //Error Message Service
    @AndroidFindBy(xpath = "//*[@text='Error']")
    @iOSFindBy(xpath = "//*[value='Error']")
    public MobileElement errorMessageService;

    //Error Message
    @AndroidFindBy(xpath = "//*[@text='Incorrect username or password']")
    @iOSFindBy(xpath = "//*[@value='Sign-In Failed']")
    public MobileElement loginErrorMessage;



}
