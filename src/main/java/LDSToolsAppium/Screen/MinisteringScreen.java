package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class MinisteringScreen extends BasePage {

    public MinisteringScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    // ****************** Ministering Main Screen ******************

    //Ministering
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ministering']")
    @iOSFindBy(accessibility = "Ministering")
    public MobileElement ministeringReport;

    // ****************** Elders Quorum ******************
    //Unassigned Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unassigned Households']")
    @iOSFindBy(accessibility = "Unassigned Households")
    public MobileElement unassignedHouseholds;

    //Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Households']")
    @iOSFindBy(accessibility = "Households")
    public MobileElement households;

    //Companionships Brothers
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum']/../following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='Companionships']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Elders Quorum']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText[@name='Companionships']")
    public MobileElement companionshipsBrothers;

    //Potential Ministering Brothers
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Potential Ministering Brothers']")
    @iOSFindBy(accessibility = "Potential Ministering Brothers")
    public MobileElement potentialMinisteringBrothers;

    // ****************** Relief Society ******************
    //Unassigned Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unassigned Sisters']")
    @iOSFindBy(accessibility = "Unassigned Sisters")
    public MobileElement unassignedSisters;

    //Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sisters']")
    @iOSFindBy(accessibility = "Sisters")
    public MobileElement sisters;

    //Companionships Relief Society
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society']/../following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='Companionships']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Relief Society']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText[@name='Companionships']")
    public MobileElement companionshipsSisters;

    //Potential Ministering Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Potential Ministering Sisters']")
    @iOSFindBy(accessibility = "Potential Ministering Sisters")
    public MobileElement potentialMinisteringSisters;



    // ****************** Ministering Buttons ******************
    //Share Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/menu_share")
    @iOSFindBy(accessibility = "Share")
    public MobileElement share;

    //Map Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/menu_show_on_map")
    @iOSFindBy(accessibility = "Map")
    public MobileElement map;

    //Filters Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/menu_item_htvt_filter")
    @iOSFindBy(accessibility = "Filters")
    public MobileElement filters;


    // ****************** Filters ******************
    //Assigned Ministering Brothers
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/htvt_filter_assigned")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Assigned Ministering Brothers' AND type == 'XCUIElementTypeSwitch'")
    public MobileElement assignedMinisteringBrothers;

    //Not Assigned Ministering Brothers
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/htvt_filter_not_assigned")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Not Assigned Ministering Brothers' AND type == 'XCUIElementTypeSwitch'")
    public MobileElement notAssignedMinisteringBrothers;

    //New & Moved-In Members
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/htvt_filter_new_and_moved_in")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'New & Moved-In Members' AND type == 'XCUIElementTypeSwitch'")
    public MobileElement newAndMovedInMembers;


    //Single Sisters
    //Ages 18 to 30
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/htvt_filter_single_sisters_eighteen_thirty_years_old")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Sisters']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='Ages 18 to 30']")
    public MobileElement singleSistersAges18to30;

    //Ages 31 and older
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/htvt_filter_single_sisters_thirty_and_over")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Sisters']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='Age 31 and older']")
    public MobileElement singleSistersAge31AndOver;

    //Single Brothers
    //Ages 18 to 30
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/htvt_filter_single_brothers_eighteen_thirty_years_old")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Brothers']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='Ages 18 to 30']")
    public MobileElement singleBrothersAges18to30;

    //Ages 31 and older
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/htvt_filter_single_brothers_thirty_and_over")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Brothers']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='31 and over']")
    public MobileElement singleBrothersAge31AndOver;



    //Save Button for Filter
    @AndroidFindBy(id ="\torg.lds.ldstools.dev:id/menu_item_save")
    public MobileElement ministeringFilterSave;

    //Expand filter button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/filterHeaderArrow")
    public MobileElement ministeringExpandFilter;


    public boolean validateDistrict( String districtToCheck ) {
        boolean myCheck;
        String myPageSource;

        //Todo: Need a way to swipe to the end of the Android list.
        myPageSource = getSourceOfPage();


        myCheck = myPageSource.contains(districtToCheck);

        return myCheck;
    }

    public void selectDistrict(String districtToSelect ) {
        if (getOS().equals("mac")) {
            driver.findElementByAccessibilityId(districtToSelect).click();
        } else {
            driver.findElement(By.xpath("//android.widget.TextView[@text='" + districtToSelect + "']")).click();
        }
    }


    public void saveMissonaryProgressFilter() throws Exception {
        if (getOS().equals("mac")) {
            backButton.click();
        } else {
            ministeringFilterSave.click();
            ministeringExpandFilter.click();
        }

    }
    


}
