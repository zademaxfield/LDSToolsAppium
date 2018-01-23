package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class DirectoryScreen extends BasePage {

    public DirectoryScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    // ****************** Directory Main Screen ******************

    // ****************** Search ******************
    //Search Directory
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/filterEditText")
    @iOSFindBy(accessibility = "Search")
    public static MobileElement searchBar;

    //Clear Search
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/clearTextImageButton")
    @iOSFindBy(accessibility = "Cancel")
    public static MobileElement searchCancel;



    // ****************** Sort ******************
    //Sort Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/menu_item_default_directory")
    @iOSFindBy(accessibility = "Sort Options")
    public static MobileElement directorySort;

    //Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Households']")
    @iOSFindBy(accessibility = "Household")
    public static MobileElement sortHousehold;

    //Individuals
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Individuals']")
    @iOSFindBy(accessibility = "Individual")
    public static MobileElement sortIndividual;



    // ********** iOS Expand Buttons **********
    //Household Members
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'HOUSEHOLD MEMBERSOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public static MobileElement householdMembers;

    //Home Teaching Visiting Teaching
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'HOME AND VISITING TEACHINGOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public static MobileElement htvt;

    //Callings and Classes
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'CALLINGS AND CLASSESOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public static MobileElement callingsAndClasses;

    //Membership Information
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'MEMBERSHIP INFORMATIONOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public static MobileElement memebershipInformation;


    // ********** Android Elements **********
    //Tab Contact
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"contact\")]")
    public static MobileElement tabContact;

    //Tab Household
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"household\")]")
    public static MobileElement tabHousehold;

    //Tab Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"callings and classes\")]")
    public static MobileElement tabCallings;

    //Tab Home and Visiting Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"home and visiting teaching\")]")
    public static MobileElement tabHTVT;

    //Tab Membership
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"membership information\")]")
    public static MobileElement tabMembership;


    public void clickDirectoryUser(String myUser) throws Exception {
        if (getOS().equals("mac")) {
            driver.findElement(MobileBy.AccessibilityId(myUser)).click();
        } else {
            driver.findElement(By.xpath("//android.widget.TextView[@resource-id='org.lds.ldstools.dev:id/name'][@text='" + myUser + "']")).click();
        }
    }

    public void searchAndClick(String myUser) throws Exception {
        directorySort.click();
        sortIndividual.click();
        searchBar.sendKeys(myUser);
        clickDirectoryUser(myUser);

    }


    public String getDirectoryUserData() throws Exception {
        String pageSource = null;
        if (getOS().equals("mac")) {
            scrollDownIOS();
            boolean checkForLabel;

            checkForLabel = checkForElement(householdMembers);
            if (checkForLabel) {
               householdMembers.click();
                checkForLabel = false;
            }

            checkForLabel = checkForElement(htvt);
            if (checkForLabel) {
                htvt.click();
                checkForLabel = false;
            }

            checkForLabel = checkForElement(callingsAndClasses);
            if (checkForLabel) {
                callingsAndClasses.click();
                checkForLabel = false;
            }

            checkForLabel = checkForElement(memebershipInformation);
            if (checkForLabel) {
                memebershipInformation.click();
                checkForLabel = false;
            }

            //Contact Tab
            Thread.sleep(1000);
            pageSource = getSourceOfPage();
            scrollDownIOS();

            pageSource = pageSource + getSourceOfPage();
        } else {
            boolean myCheck;

            //Contact Tab
            Thread.sleep(1000);
            pageSource = getSourceOfPage();

            scrollDownTEST(200);

            tabHousehold.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            myCheck = checkForElement(tabMembership);
            if (myCheck == true) {
                tabMembership.click();
                Thread.sleep(1000);
                pageSource = pageSource + getSourceOfPage();
                scrollDownTEST(800);
                pageSource = pageSource + getSourceOfPage();
            }

            myCheck = checkForElement(tabCallings);
            if (myCheck == true) {
                tabCallings.click();
                Thread.sleep(1000);
                pageSource = pageSource + getSourceOfPage();
            }

            myCheck = checkForElement(tabHTVT);
            if (myCheck == true) {
                tabHTVT.click();
                Thread.sleep(1000);
                pageSource = pageSource + getSourceOfPage();
            }

            myCheck = checkForElement(tabHTVT);
            if (myCheck == true) {
                tabHTVT.click();
                Thread.sleep(1000);
            }

            myCheck = checkForElement(tabCallings);
            if (myCheck == true) {
                tabCallings.click();
                Thread.sleep(1000);
            }

            myCheck = checkForElement(tabMembership);
            if (myCheck == true) {
                tabMembership.click();
            }

            tabHousehold.click();
            tabContact.click();

        }

        return pageSource;

    }






}
