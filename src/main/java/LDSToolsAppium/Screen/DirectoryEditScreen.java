package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class DirectoryEditScreen extends BasePage {


    public DirectoryEditScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        //PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);

    }


    // ****************** Phone and Email ******************
    //Personal Edit Phone
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, \"individualPhoneEditText\")]//android.widget.EditText[contains(@resource-id, \"edit_phone\")]")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/individualPhoneEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeTextField")
    public MobileElement directoryEditPersonalPhone;

    //Household Edit Phone
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, \"householdPhoneEditText\")]//android.widget.EditText[contains(@resource-id, \"edit_phone\")]")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/householdPhoneEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeTextField")
    public  MobileElement directoryEditHouseholdPhone;

    //Personal Edit Email
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, \"individualEmailEditText\")]//android.widget.EditText[contains(@resource-id, \"edit_email\")]")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/individualEmailEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeTextField")
    public  MobileElement directoryEditPersonalEmail;

    //Household Edit Email
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, \"householdEmailEditText\")]//android.widget.EditText[contains(@resource-id, \"edit_email\")]")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/householdEmailEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[5]/XCUIElementTypeTextField")
    public  MobileElement directoryEditHouseholdEmail;


    // ****************** Visibility ******************
    //Household Visibility Limit
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"householdVisibilityEditView\"]//android.widget.TextView[@resource-id=\"visibility_text\"]")
    @iOSXCUITFindBy(accessibility = "HOUSEHOLD VISIBILITY LIMIT Stake Visibility")
    public  MobileElement directoryHouseholdVisibilityLimitAll;

    //Personal Visibility Limit
    @iOSXCUITFindBy(accessibility = "PERSONAL Stake Visibility")
    public  MobileElement directoryPersonalVisibilityLimit;

    //Household Visibility Limit
    @iOSXCUITFindBy(accessibility = "HOUSEHOLD Stake Visibility")
    public  MobileElement directoryHouseholdVisibilityLimit;


    // ****************** Android Only ******************
    //Contact Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"contact\")]")
    public  MobileElement directoryContactTab;

    //Photos Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"photos\")]")
    public  MobileElement directoryPhotosTab;

    //Privacy Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"privacy\")]")
    public  MobileElement directoryPrivacyTab;



    //Save Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_item_save")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Save'")
    public MobileElement menuSave;

    //Cancel Button
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement cancelButton;

    //Save Failed
    @AndroidFindBy(xpath = "//*[contains(@text, 'Failed to update data')]")
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Save failed')]")
    //@AndroidFindBy(xpath = "//*[contains(@text, 'provide a valid')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Warning'")
    public MobileElement saveFailedDialog;

    //Invalid email
    @AndroidFindBy(xpath = "//*[contains(@text, 'You must provide a valid email address.')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Warning'")
    public MobileElement invalidEmail;


    // **************************** Privacy Settings ****************************
    //Household Visibility Limit
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Household Visibility Limit']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'HOUSEHOLD VISIBILITY')]")
    public MobileElement householdVisibilityLimit;

    //Personal Visibility Limit
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name, 'PERSONAL')]")
    public MobileElement personalVisibility;

    //Household Visibility
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[8]/XCUIElementTypeStaticText")
    public MobileElement householdVisibility;

    // **************************** Limit visibility for household  ****************************
    //Stake Visibility
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/radio_visibility_stake")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Stake Visibility']")
    public MobileElement stakeVisibility;

    //Ward Visibility
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/radio_visibility_ward")
    @iOSXCUITFindBy(accessibility = "Ward Visibility")
    public MobileElement wardVisibility;

    //Private—Leadership Only
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/radio_visibility_leader")
    @iOSXCUITFindBy(accessibility = "Private—Leadership Only")
    public MobileElement privateLeadershipOnly;

    //Cancel - Neverming
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_buttonDefaultNegative")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement visiblityCancel;

    //Set Limit
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_button_positive")
    public MobileElement setLimit;

    // **************************** Personal Visibility ****************************
    //Set All to
    @iOSXCUITFindBy(accessibility = "Set All to")
    public MobileElement setAllToPersonal;

    //Image
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditIndPhoto")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/individualPhotoVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Image")
    public MobileElement imagePersonal;

    //Phone
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditIndPhone")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/individualPhoneVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Phone")
    public MobileElement phonePersonal;

    //Email
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditIndEmail")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/individualEmailVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Email")
    public MobileElement emailPersonal;

    // **************************** Household Visibility ****************************
    // SCROLL DOWN IN ANDROID to show on map
    //Set All to
    @iOSXCUITFindBy(accessibility = "Set All to")
    public MobileElement setAllToHousehold;

    //Image
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditHouseholdPhoto")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/householdPhotoVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Image")
    public MobileElement imageHousehold;

    //Phone
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditHouseholdPhone")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/householdPhoneVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Phone")
    public MobileElement phoneHousehold;

    //Email
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditHouseholdEmail")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/householdEmailVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Email")
    public MobileElement emailHousehold;

    //Address
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditHouseholdAddress")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/householdAddressVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Address")
    public MobileElement physicalAddress;

    //Show on Map
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/visibilityEditHouseholdMap")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/householdMapVisibilityLineItem")
    @iOSXCUITFindBy(accessibility = "Show on Map")
    public MobileElement showOnMap;





    // **************************** POP UP Visibility ****************************
    //Stake Visibility
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Visibility']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Stake Visibility')]")
    public MobileElement popUpStake;

    //Ward Visibility
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ward Visibilit']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Ward Visibility')]")
    public MobileElement popUpWard;

    //Private—Leadership Only Visibility
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Private—Leadership Only']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Leadership Only')]")
    public MobileElement popUpPrivateLeadershipOnly;




    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement doneButton;



    //*********** Tool Bar **************
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/drop_arrow")
    @iOSXCUITFindBy(accessibility = "Directory")
    public MobileElement unitSelector;


    public void clearPhoneAndEmail() throws Exception {
        DirectoryScreen myDirectory = new DirectoryScreen(driver);

        editUserOpen();
        Thread.sleep(2000);
//        System.out.println(getSourceOfPage());
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

    public void resetVisibility() throws Exception {
        BasePage myBase = new BasePage(driver);
        int myCheck;
        String textCheck;

        if (getOS().equals("ios")) {
            textCheck = householdVisibilityLimit.getText();
            if (!textCheck.contains("Stake")) {
                householdVisibilityLimit.click();
                Thread.sleep(2000);
                stakeVisibility.click();
                Thread.sleep(1000);
            }

            textCheck = personalVisibility.getText();
            System.out.println("TEXT: " + textCheck);
            if (!textCheck.contains("Stake")) {
                personalVisibility.click();
                Thread.sleep(2000);
                setAllToPersonal.click();
                Thread.sleep(2000);
                stakeVisibility.click();

                Thread.sleep(1000);
                doneButton.click();

            }

            textCheck = householdVisibility.getText();
            if (!textCheck.contains("Stake")) {
                householdVisibility.click();
                setAllToHousehold.click();
                stakeVisibility.click();
                Thread.sleep(1000);
                doneButton.click();
            }

        } else {
            directoryPrivacyTab.click();
            textCheck = householdVisibilityLimit.getText();

            if (!textCheck.contains("Stake")) {
                householdVisibilityLimit.click();
                stakeVisibility.click();
                setLimit.click();
                Thread.sleep(2000);

            }
            Thread.sleep(1000);

//            System.out.println(getSourceOfPage());
            imagePersonal.click();
            Thread.sleep(1000);
            popUpStake.click();

            phonePersonal.click();
            Thread.sleep(1000);
            popUpStake.click();

            emailPersonal.click();
            Thread.sleep(1000);
            popUpStake.click();

            Thread.sleep(1000);
//            myBase.scrollToText("Show on Map");
            myBase.scrollDownAndroidUIAutomator("0");

//            myBase.scrollToTextScollArea("Show on Map");
            //myBase.scrollToTextTopLayout("Show on Map");



            imageHousehold.click();
            Thread.sleep(1000);
            popUpStake.click();

            phoneHousehold.click();
            Thread.sleep(1000);
            popUpStake.click();

            emailHousehold.click();
            Thread.sleep(1000);
            popUpStake.click();

            physicalAddress.click();
            Thread.sleep(1000);
            popUpStake.click();

            showOnMap.click();
            Thread.sleep(1000);
            popUpStake.click();

        }

        Thread.sleep(4000);
        menuSave.click();
        Thread.sleep(4000);



    }


    public void setVisibilityHousehold(MobileElement elementVisiblity) throws Exception {

        if (getOS().equals("ios")) {
            householdVisibilityLimit.click();
            Thread.sleep(2000);
            elementVisiblity.click();
            Thread.sleep(1000);

        } else {
            directoryPrivacyTab.click();
            householdVisibilityLimit.click();
            elementVisiblity.click();
//            System.out.println(getSourceOfPage());
            setLimit.click();
            Thread.sleep(1000);

        }

        Thread.sleep(4000);
        menuSave.click();
        Thread.sleep(4000);



    }



}
