package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;


public class FinanceScreen extends BasePage {

    public FinanceScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Finance Main Screen ******************
    //Payment Requests
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Payment Requests']")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement financePaymentRequests;

    //Add Payment Requests
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/newPaymentRequestFab")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAdd;

    //Add Myself
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addMyselfButton")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAddMyself;

    //Add Other Payee
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addOtherButton")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAddOther;

    //Search
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsSearch;

    //Add Payee Fab
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAddPayeeFab;

    //Purpose
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/purposeEditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsPurpose;

    //Account
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/accountAutoCompleteTextView")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAccount;

    //Purpose page add button
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsPurposeAddButton;



    //Payment Information

    //Add Receipt
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addReceiptTopButton")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAddReceipt;

    //Take a Picture
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/takePhotoTextView")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsTakeAPicture;

    //Choose a file
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/chooseFileTextView")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsChooseAFile;

    //Camera Button
    //TODO: iOS code
    @AndroidFindBy(id = "com.google.android.GoogleCamera:id/shutter_button")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCameraButton;


    //Category Top View Group
    //Category
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup1Spinner;

    //Amount
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup1Amount;

    //Category2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup2Spinner;

    //Amount2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup2Amount;

}
