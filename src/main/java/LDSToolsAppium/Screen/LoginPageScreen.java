package LDSToolsAppium.Screen;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LoginPageScreen extends BasePage {

    public LoginPageScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }

    //Member Tools Heading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Member Tools']")
    public MobileElement titleMemberTools;



    //Login Name
//    @AndroidFindBy(id = "usernameEditText")
    @AndroidFindBy(id = "usernameEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField")
    public  MobileElement loginName;

    //Password
//    @AndroidFindBy(id = "passwordEditText")
    @AndroidFindBy(id = "passwordEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    public  MobileElement passWord;

    //Sign In Button
//    @AndroidFindBy(id = "ldsAccountSignInButton")
    @AndroidFindBy(id = "ldsAccountSignInButton")
    @iOSXCUITFindBy(accessibility = "Sign In")
    public  MobileElement signInButton;

    //Sync Message
    @AndroidFindBy(xpath = "//*[@text='Sync Progress']")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement syncMessage;

    //Menu
    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    @iOSXCUITFindBy(accessibility = "Help")
    public  MobileElement overflowMenu;

    //Overflow Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    public  MobileElement overflowSettings;

    //Enter Developer Button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[9]")
    public  MobileElement enterDeveloperButton;

    //Developer Button Displayed
    @iOSXCUITFindBy(accessibility = "Developer Settings")
    public MobileElement developerButton;


    //Error Message Service
    @AndroidFindBy(xpath = "//*[@text='Error']")
    @iOSXCUITFindBy(xpath = "//*[value='Error']")
    public MobileElement errorMessageService;

    //Error Message
    @AndroidFindBy(xpath = "//*[@text='Sign-in failed. Verify your username or password.']")
    @iOSXCUITFindBy(xpath = "//*[@value='Sign-In Failed']")
    public MobileElement loginErrorMessage;

    //Trouble Signing In?
    @AndroidFindBy(id = "ldsAccountLoginForgotCredentialsButton")
    @iOSXCUITFindBy(accessibility = "Having trouble signing in?")
    public  MobileElement troubleSigningIn;

    //Privacy Notice
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Privacy Policy (Updated 2018-09-01)')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Privacy Policy')]")
    @iOSXCUITFindBy(accessibility = "Privacy Notice (Updated 2018-09-01)")
    public  MobileElement privacyNotice;

    //Terms of Use
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terms of Use (Updated 2018-09-01)')]")
    @iOSXCUITFindBy(accessibility = "Terms of Use (Updated 2018-09-01)")
    public  MobileElement termsOfUse;

    //Cancel Button
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement cancelButton;

    //Done Button
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Done")
    public  MobileElement doneButton;

    //Account Recovery
    @AndroidFindBy(xpath = "//*[contains(@text, 'Account Recovery')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Account Recovery')]")
    public  MobileElement accountRecoveryPage;


}
