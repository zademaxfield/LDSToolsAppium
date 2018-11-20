package LDSToolsAppium.Screen;

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


    //Login Name
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/usernameEditText")
    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField")
    public  MobileElement loginName;

    //Password
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/passwordEditText")
    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    public  MobileElement passWord;

    //Sign In Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ldsAccountSignInButton")
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
    @iOSFindBy(xpath = "//XCUIElementTypeCell[8]")
    public  MobileElement enterDeveloperButton;

    //Developer Button Displayed
    @iOSFindBy(accessibility = "Developer Settings")
    public MobileElement developerButton;


    //Error Message Service
    @AndroidFindBy(xpath = "//*[@text='Error']")
    @iOSFindBy(xpath = "//*[value='Error']")
    public MobileElement errorMessageService;

    //Error Message
    @AndroidFindBy(xpath = "//*[@text='Sign-in failed. Verify your username or password.']")
    @iOSFindBy(xpath = "//*[@value='Sign-In Failed']")
    public MobileElement loginErrorMessage;

    //Trouble Signing In?
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ldsAccountLoginForgotCredentialsButton")
    @iOSFindBy(accessibility = "Having trouble signing in?")
    public  MobileElement troubleSigningIn;

    //Privacy Notice
    @AndroidFindBy(xpath = "//*[contains(@text, 'Privacy Policy (Updated 2018-09-01)')]")
    @iOSFindBy(accessibility = "Privacy Notice (Updated 2018-09-01)")
    public  MobileElement privacyNotice;

    //Terms of Use
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terms of Use (Updated 2018-09-01)')]")
    @iOSFindBy(accessibility = "Terms of Use (Updated 2018-09-01)")
    public  MobileElement termsOfUse;

    //Cancel Button
    @iOSFindBy(accessibility = "Cancel")
    public  MobileElement cancelButton;

    //Done Button
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSFindBy(accessibility = "Done")
    public  MobileElement doneButton;

    //Account Recovery
    @AndroidFindBy(xpath = "//*[contains(@text, 'Account Recovery')]")
    @iOSFindBy(xpath = "//*[contains(@name, 'Account Recovery')]")
    public  MobileElement accountRecoveryPage;


}
