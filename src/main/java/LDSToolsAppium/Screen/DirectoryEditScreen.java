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

    //Cancel Button
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement cancelButton;

    //Save Failed
    //@AndroidFindBy(xpath = "//*[contains(@text, 'Save failed')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'provide a valid')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Warning'")
    public MobileElement saveFailedDialog;


    // **************************** Privacy Settings ****************************
    //Household Visibility Limit
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Household Visibility Limit']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[[contains(@name, 'HOUSEHOLD VISIBILITY')]")
    public MobileElement householdVisibilityLimit;

    //Personal Visibility Limit
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'PERSONAL')]")
    public MobileElement personalVisibility;

    //Household Visibility
    @iOSFindBy(xpath = "//XCUIElementTypeCell[8]")
    public MobileElement householdVisibility;

    // **************************** Limit visibility for household  ****************************
    //Stake Visibility
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/radio_visibility_stake")
    @iOSFindBy(accessibility = "Stake Visibility")
    public MobileElement stakeVisibility;

    //Ward Visibility
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/radio_visibility_ward")
    @iOSFindBy(accessibility = "Ward Visibility")
    public MobileElement wardVisibility;

    //Private—Leadership Only
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/radio_visibility_leader")
    @iOSFindBy(accessibility = "Private—Leadership Only")
    public MobileElement privateLeadershipOnly;

    //Cancel - Neverming
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/md_buttonDefaultNegative")
    @iOSFindBy(accessibility = "Cancel")
    public MobileElement visiblityCancel;

    //Set Limit
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/md_buttonDefaultPositive")
    public MobileElement setLimit;

    // **************************** Personal Visibility ****************************
    //Set All to
    @iOSFindBy(accessibility = "Set All to")
    public MobileElement setAllToPersonal;

    //Image
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_ind_photo")
    @iOSFindBy(accessibility = "Image")
    public MobileElement imagePersonal;

    //Phone
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_ind_phone")
    @iOSFindBy(accessibility = "Phone")
    public MobileElement phonePersonal;

    //Email
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_ind_email")
    @iOSFindBy(accessibility = "Email")
    public MobileElement emailPersonal;

    // **************************** Household Visibility ****************************
    // SCROLL DOWN IN ANDROID to show on map
    //Set All to
    @iOSFindBy(accessibility = "Set All to")
    public MobileElement setAllToHousehold;

    //Image
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_hh_photo")
    @iOSFindBy(accessibility = "Image")
    public MobileElement imageHousehold;

    //Phone
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_hh_phone")
    @iOSFindBy(accessibility = "Phone")
    public MobileElement phoneHousehold;

    //Email
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_hh_email")
    @iOSFindBy(accessibility = "Email")
    public MobileElement emailHousehold;

    //Address
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_hh_address")
    @iOSFindBy(accessibility = "Address")
    public MobileElement emailAddress;

    //Show on Map
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/visibility_edit_hh_map")
    @iOSFindBy(accessibility = "Show on Map")
    public MobileElement emailShowOnMap;





    // **************************** POP UP Visibility ****************************
    //Stake Visibility
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Visibility'")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Stake Visibility')]")
    public MobileElement popUpStake;

    //Ward Visibility
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ward Visibility'")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Ward Visibility')]")
    public MobileElement popUpWard;

    //Private—Leadership Only Visibility
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Private—Leadership Only'")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Private—Leadership Only')]")
    public MobileElement popUpPrivatLeadershipOnly;




    @iOSFindBy(accessibility = "Done")
    public MobileElement doneButton;


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
