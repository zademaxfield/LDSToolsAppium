package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;


public class DirectoryScreen extends BasePage {

    public DirectoryScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Directory Main Screen ******************

    // ****************** Directory Dropdown ******************
    //Directory Dropdown
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Directory']")
    @iOSFindBy(accessibility = "Directory")
    public  MobileElement directoryDropdown;

    //Unit Selected
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resouce-id='org.lds.ldstools.dev:id/ab_toolbar']/android.widget.TextView[2]")
    @iOSFindBy(xpath = "//*[@name='LDS_Tools.DirectoryView']//XCUIElementTypeStaticText[2]")
    public MobileElement unitSelected;


    // ****************** Search ******************
    //Search Directory
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/filterEditText")
    @iOSFindBy(accessibility = "Search")
    public  MobileElement searchBar;

    //Clear Search
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/clearTextImageButton")
    @iOSFindBy(accessibility = "Cancel")
    public  MobileElement searchCancel;



    // ****************** Sort ******************
    //Sort Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/filterMenuImageButton")
    //@AndroidFindBy(xpath = "//*[@resource-id='org.lds.ldstools.dev:id/filterMenuImageButton']")
    @iOSFindBy(accessibility = "Sort Options")
    public  MobileElement directorySort;

    //Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Households']")
    @iOSFindBy(xpath = "//*[contains(@name, \"Household\")]")
    public  MobileElement sortHousehold;

    //Individuals
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Individuals']")
    @iOSFindBy(xpath = "//*[contains(@name, \"Individual\")]")
    public  MobileElement sortIndividual;


    // ****************** Edit ******************
    //Edit Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/edit_fab")
    @iOSFindBy(accessibility = "Edit")
    public  MobileElement directoryEdit;



    // ********** iOS Expand Buttons **********
    //Household Members
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'HOUSEHOLD MEMBERSOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public  MobileElement householdMembers;

    //Home Teaching Visiting Teaching
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'HOME AND VISITING TEACHINGOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public  MobileElement htvt;

    //Callings and Classes
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'CALLINGS AND CLASSESOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public  MobileElement callingsAndClasses;

    //Membership Information
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'MEMBERSHIP INFORMATIONOpen Drawer' AND type == 'XCUIElementTypeButton'")
    public  MobileElement memebershipInformation;


    // ********** Android Elements **********
    //Tab Contact
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"contact\")]")
    public  MobileElement tabContact;

    //Tab Household
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"household\")]")
    public  MobileElement tabHousehold;

    //Tab Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"callings and classes\")]")
    public  MobileElement tabCallings;

    //Tab Home and Visiting Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"home and visiting teaching\")]")
    public  MobileElement tabHTVT;

    //Tab Membership
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"membership information\")]")
    public  MobileElement tabMembership;


    public void clickDirectoryUser(String myUser) throws Exception {
        if (getOS().equals("ios")) {
            driver.findElement(MobileBy.AccessibilityId(myUser)).click();
            //driver.findElement(By.xpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@value, '" + myUser + "')]"));
        } else {
            driver.findElement(By.xpath("//android.widget.TextView[@resource-id='org.lds.ldstools.dev:id/name'][@text='" + myUser + "']")).click();
        }
    }

    public void sortToHousehold() throws Exception {
        directorySort.click();
        sortHousehold.click();
    }

    public void searchAndClick(String myUser) throws Exception {
        String tempMyUser = myUser.toLowerCase();

        directorySort.click();
        sortIndividual.click();

        //
        if (tempMyUser.contains("tools")) {
            String[] parts = myUser.split(", ");
            String part1 = parts[0];
            String part2 = parts[1];
            searchBar.sendKeys(part2);
        } else {
            searchBar.sendKeys(myUser);
        }

        clickDirectoryUser(myUser);

    }

    public Boolean searchForMemberCheckResults(String myUser) {
        String tempMyUser = myUser.toLowerCase();
        Boolean myReturnStatus;
        List<MobileElement> options;

        directorySort.click();
        sortIndividual.click();

        if (tempMyUser.contains("tools")) {
            String[] parts = myUser.split(", ");
            String part1 = parts[0];
            String part2 = parts[1];
            searchBar.sendKeys(part2);
        } else {
            searchBar.sendKeys(myUser);
        }



        if (getOS().equals("ios")) {
            options= driver.findElements(By.xpath("//*[@value='" + myUser + "']"));
        } else {
            options= driver.findElements(By.xpath("//*[@text='" + myUser + "']"));
        }

        myReturnStatus = !options.isEmpty();

        return myReturnStatus;

    }


    public String getDirectoryUserData() throws Exception {
        BasePage myBasePage = new BasePage(driver);

        String pageSource = null;
        if (getOS().equals("ios")) {
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

            myBasePage.scrollDownAndroidUIAutomator("1");
            //scrollDownTEST(200);

            tabHousehold.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            myCheck = checkForElement(tabMembership);
            if (myCheck == true) {
                tabMembership.click();
                Thread.sleep(1000);
                pageSource = pageSource + getSourceOfPage();
                //scrollDownTEST(800);
                myBasePage.scrollDownAndroidUIAutomator("1");
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


    public void checkAllWardDirectories() throws Exception {
        List<String> StakeWard = new ArrayList<String>();
        List<MobileElement> options;
        String myUnit;
        BasePage myBasePage = new BasePage(driver);
        
        
        int pageSize;
        int myCounter = 1;
        Thread.sleep(2000);

        if (myBasePage.getOS().equals("ios")) {
            //directoryDropdown.click();
            unitSelected.click();

            //Get Stake and all Wards
            //options= driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell/UIAStaticText"));
            options= driver.findElements(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText"));

            for (int i = 0 ; i < options.size(); i++ ) {
                System.out.println(options.get(i).getText());
                myUnit = options.get(i).getText();
                myUnit = myUnit.trim();
                System.out.println(myUnit);
                StakeWard.add(myUnit);
            }

            searchCancel.click();
            Thread.sleep(2000);


            //Go through each Stake and Ward to make sure it isn't blank
            for(String StakeWardItem : StakeWard){

                if (!StakeWardItem.contains("Stake")) {
                    Thread.sleep(2000);
                    //directoryDropdown.click();
                    unitSelected.click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[contains(@name,'" + StakeWardItem + "')]")).click();
                    //displayAllTextViewElements();
                    Thread.sleep(6000);
                    //This will check to see if the first user has text.
                    Assert.assertTrue(checkFirstDirectoryUser());
                }

                if(myCounter == 5){
                    break; // Don't like this need a better solution. 
                }

                myCounter++;
            }

        } else {
            directoryDropdown.click();

            //Get Stake and all Wards
            //options = driver.findElements(By.xpath("//*[@id='list_item']/*[@id='text1']"));
            options = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id='org.lds.ldstools.dev:id/list_item']/android.widget.TextView[@resource-id='org.lds.ldstools.dev:id/unitNameTextView']"));
            //options = driver.findElements(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView"));
            for (int i = 0 ; i < options.size(); i++ ) {
                System.out.println(options.get(i).getText());
                StakeWard.add(options.get(i).getText());
            }
            Thread.sleep(1000);
            directoryDropdown.click();

            //Thread.sleep(1000);
            //pressBackKey();
            Thread.sleep(1000);

            //Go through each Stake and Ward to make sure it isn't blank
            for(String StakeWardItem : StakeWard){

                if (!StakeWardItem.contains("Stake")) {
                    directoryDropdown.click();

                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@text='" + StakeWardItem + "']")).click();

                    Assert.assertTrue(checkFirstDirectoryUser());
                }

            }


        }

    }


    public Boolean checkFirstDirectoryUser() throws Exception{
        Boolean myReturnStatus;
        String myString;

        BasePage myBasePage = new BasePage(driver);

        Thread.sleep(6000);

        //String myString = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]")).getText();
        if (myBasePage.getOS().equals("ios")) {
            //myString = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).getText();
            myString = driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")).getText();
            //XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]
        } else {
            //myString = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='org.lds.ldstools.dev:id/text1'][1]")).getText();
            myString = driver.findElement(By.xpath("//*[@resource-id='org.lds.ldstools.dev:id/recycler_view']/android.widget.FrameLayout/android.widget.TextView[@resource-id='org.lds.ldstools.dev:id/name']")).getText();
        }



        if (myString.isEmpty()) {
            myReturnStatus = false;
        } else {
            myReturnStatus = true;
            //System.out.println("FOUND USER: " + myString);
        }

        return myReturnStatus;
    }






}
