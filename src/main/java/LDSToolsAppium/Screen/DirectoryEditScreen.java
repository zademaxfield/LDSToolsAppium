package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class DirectoryEditScreen extends BasePage {

    public DirectoryEditScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    // ****************** Phone and Email ******************
    //Personal Edit Phone
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
    @iOSFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeTextField")
    public  MobileElement directoryEditPersonalPhone;

    //Household Edit Phone
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"org.lds.ldstools.dev:id/edit_household_phone\"]//android.widget.EditText[@resource-id=\"org.lds.ldstools.dev:id/edit_phone\"]")
    @iOSFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeTextField")
    public  MobileElement directoryEditHouseholdPhone;

    //Personal Edit Email
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"org.lds.ldstools.dev:id/edit_individual_email\"]//android.widget.EditText[@resource-id=\"org.lds.ldstools.dev:id/edit_email\"]")
    @iOSFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeTextField")
    public  MobileElement directoryEditPersonalEmail;

    //Personal Edit Email
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"org.lds.ldstools.dev:id/edit_household_email\"]//android.widget.EditText[@resource-id=\"org.lds.ldstools.dev:id/edit_email\"]")
    @iOSFindBy(xpath = "//XCUIElementTypeCell[5]/XCUIElementTypeTextField")
    public  MobileElement directoryEditHouseholdEmail;


    // ****************** Visibility ******************
    //Household Visibility Limit
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"org.lds.ldstools.dev:id/householdVisibilityEditView\"]//android.widget.TextView[@resource-id=\"org.lds.ldstools.dev:id/visibility_text\"]")
    @iOSFindBy(accessibility = "HOUSEHOLD VISIBILITY LIMIT Stake Visibility")
    public  MobileElement directoryHouseholdVisibilityLimitAll;

    //Personal Visibility Limit
    @iOSFindBy(accessibility = "PERSONAL Stake Visibility")
    public  MobileElement directoryPersonalVisibilityLimit;

    //Household Visibility Limit
    @iOSFindBy(accessibility = "HOUSEHOLD Stake Visibility")
    public  MobileElement directoryHouseholdVisibilityLimit;


    // ****************** Android Only ******************
    //Contact Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"contact\")]")
    public  MobileElement directoryContactTab;

    //Photos Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"photos\")]")
    public  MobileElement directoryPhotosTab;

    //Privacy Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"photos\")]")
    public  MobileElement directoryPrivacyTab;



    //Save Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/menu_item_save")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Save'")
    public MobileElement menuSave;



    public void clearPhoneAndEmail() throws Exception {
        DirectoryScreen myDirectory = new DirectoryScreen(driver);

        editUserOpen();
        Thread.sleep(2000);

        directoryEditHouseholdPhone.clear();
        directoryEditPersonalPhone.clear();
        directoryEditPersonalEmail.clear();
        directoryEditHouseholdEmail.clear();

        menuSave.click();
        Thread.sleep(6000);
    }

    public void editUserOpen() throws Exception {
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        Boolean myErrorTest;
        int myCounter = 1;
        myDirectory.directoryEdit.click();
        Thread.sleep(2000);

        waitUnitlTextIsGone("Downloading");
        myErrorTest = checkTextOnPage("Please connect to the Internet");

        while ((myErrorTest) && (myCounter < 4)) {
            System.out.println("Not connected to the Internet: " + myErrorTest + " Count: "+ myCounter);
            alertOK.click();
            myDirectory.directoryEdit.click();
            waitUnitlTextIsGone("Downloading");
            myErrorTest = checkTextOnPage("Not Connected");
            myCounter++;
        }

    }






}
