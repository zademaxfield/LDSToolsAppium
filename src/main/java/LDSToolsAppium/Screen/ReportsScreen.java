package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.tools.ant.types.resources.Last;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class ReportsScreen extends BasePage {

    public ReportsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Reports Main Screen ******************

    //Action and Interview List
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Action and Interview List']")
    @iOSFindBy(accessibility = "Action and Interview List")
    public MobileElement actionAndInterviewListReport;

    //Birthday List
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Birthday List']")
    @iOSFindBy(accessibility = "Birthday List")
    public MobileElement birthdayListtReport;

    //Home Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching']")
    @iOSFindBy(accessibility = "Home Teaching")
    public MobileElement homeTeachingReport;

    //Members Moved In
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved In']")
    @iOSFindBy(accessibility = "Members Moved In")
    public MobileElement membersMovedInReport;

    //Members Moved Out
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved Out']")
    @iOSFindBy(accessibility = "Members Moved Out")
    public MobileElement membersMovedOutReport;

    //Members with Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members with Callings']")
    @iOSFindBy(accessibility = "Members with Callings")
    public MobileElement membersWithCallingsReport;

    //Members without Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members without Callings']")
    @iOSFindBy(accessibility = "Members without Callings")
    public MobileElement membersWithOutCallingsReport;

    //Missionary Progress Record
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Missionary Progress Record']")
    @iOSFindBy(accessibility = "Missionary Progress Record")
    public MobileElement missionaryProgressRecordReport;

    //New Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Members']")
    @iOSFindBy(accessibility = "New Members")
    public MobileElement newMembersReport;

    //Temple Recommend Status
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Temple Recommend Status']")
    @iOSFindBy(accessibility = "Temple Recommend Status")
    public MobileElement templeRecommendStatusReport;

    //Unit Statistics
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unit Statistics']")
    @iOSFindBy(accessibility = "Unit Statistics")
    public MobileElement unitStatisticsReport;

    //Quarterly Report
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quarterly Report']")
    @iOSFindBy(accessibility = "Quarterly Report")
    public MobileElement quarterlyReport;

    //Visiting Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Visiting Teaching']")
    @iOSFindBy(accessibility = "Visiting Teaching")
    public MobileElement visitingTeachingsReport;





    //Sort
    @iOSFindBy(accessibility = "Sort")
    public MobileElement sortReport;

    //Cancel
    @iOSFindBy(accessibility = "Cancel")
    public MobileElement cancelSort;

    //Name
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"name\")]")
    @iOSFindBy(accessibility = "Name")
    public  MobileElement nameSort;

    //Organization
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"organization\")]")
    @iOSFindBy(accessibility = "Organization")
    public  MobileElement organizationSort;

    //Duration
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"duration\")]")
    @iOSFindBy(accessibility = "Duration")
    public  MobileElement durationSort;

    //Not Set Apart
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"not set apart\")]")
    @iOSFindBy(accessibility = "Not Set Apart")
    public  MobileElement notSetApartSort;

    //All
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all\")]")
    @iOSFindBy(accessibility = "All")
    public  MobileElement allSort;

    //Male
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"male\")]")
    @iOSFindBy(accessibility = "Male")
    public  MobileElement maleSort;

    //Female
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"female\")]")
    @iOSFindBy(accessibility = "Female")
    public  MobileElement femaleSort;

    //Active
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"active\")]")
    @iOSFindBy(accessibility = "Active")
    public  MobileElement activeSort;

    //Expiring
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expiring\")]")
    @iOSFindBy(accessibility = "Expiring")
    public  MobileElement expiringSort;

    //Expired
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expired\")]")
    @iOSFindBy(accessibility = "Expired")
    public  MobileElement expiredSort;

    //Other
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"other\")]")
    @iOSFindBy(accessibility = "Other")
    public  MobileElement otherSort;

    //*************************************************************************************
    //********************* Missionary Progress Record ************************************
    //*************************************************************************************

    //Missionary Progress Filter
    @AndroidFindBy(accessibility = "Filters")
    @iOSFindBy(accessibility = "Filter")
    public  MobileElement missionaryProgressFilter;

    //Missionary Progress Investigators with Baptism Date
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterInvestigatorsWithBaptismDateSwitchCompat")
    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@label='Investigators with Baptism Date']")
    public  MobileElement mpInvestigatorsWithBaptismDate;

    //Missionary Progress Progressing Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterProgressingInvestigatorsSwitchCompat")
    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Progressing Investigators\"]")
    public  MobileElement mpProgressingInvestigators;

    //Missionary Progress New Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterNewInvestigatorsSwitchCompat")
    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"New Investigators\"]")
    public  MobileElement mpNewInvestigators;

    //Missionary Progress Other Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterOtherInvestigatorsSwitchCompat")
    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Other Investigators\"]")
    public  MobileElement mpOtherInvestigators;

    //Missionary Progress Potential Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterPotentialInvestigatorsSwitchCompat")
    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Potential Investigators\"]")
    public  MobileElement mpPotentialInvestigators;

    //Missionary Progress Recent Converts
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterRecentConvertsSwitchCompat")
    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Recent Converts\"]")
    public  MobileElement mpRecentConverts;


    //Missionary Progress Members Being Taught
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterMembersBeingTaughtSwitchCompat")
    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Members Being Taught\"]")
    public  MobileElement mpMembersBeingTaught;

    //Missionary Progress Save
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_item_save")
    public  MobileElement mpSave;

    //Missionary Progress Expand Filter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterHeaderArrow")
    public  MobileElement mpExpandFilter;


    //Missionary Progress Remove Filter Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/removeFiltersButton")
    @iOSFindBy(accessibility = "Remove")
    public  MobileElement mpRemoveFilterButton;

    //Missionary Progress Received a Visit
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterReceivedAVisitTextView")
    @iOSFindBy(accessibility = "Received a Visit")
    public  MobileElement mpReceivedAVisit;

    //Missionary Progress Attended Sacrament
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterSacramentAttendanceTextView")
    @iOSFindBy(accessibility = "Attended Sacrament")
    public  MobileElement mpAttendedSacrament;

    //Missionary Progress Assigned
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterFellowshippersTextView")
    @iOSFindBy(accessibility = "Assigned")
    public  MobileElement mpAssigned;

    //Missionary Progress Last Week
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last Week\"]")
    @iOSFindBy(accessibility = "Last Week")
    public  MobileElement mpLastWeek;

    //Missionary Progress Last 2 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 2 Weeks\"]")
    @iOSFindBy(accessibility = "Last 2 Weeks")
    public  MobileElement mpLast2Weeks;

    //Missionary Progress Last 3 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 3 Weeks\"]")
    @iOSFindBy(accessibility = "Last 3 Weeks")
    public  MobileElement mpLast3Weeks;

    //Missionary Progress Last 4 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 4 Weeks\"]")
    @iOSFindBy(accessibility = "Last 4 Weeks")
    public  MobileElement mpLast4Weeks;

    //Missionary Progress Last 5 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 5 Weeks\"]")
    @iOSFindBy(accessibility = "Last 5 Weeks")
    public  MobileElement mpLast5Weeks;

    //Missionary Progress All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"All\"]")
    @iOSFindBy(accessibility = "All")
    public  MobileElement mpAll;

    //Missionary Progress Cancel
    @AndroidFindBy(xpath = "//*[@text=\"Cancel\"]")
    @iOSFindBy(accessibility = "Cancel")
    public  MobileElement mpCancel;


    public void saveMissonaryProgressFilter() throws Exception {
        if (getOS().equals("ios")) {
            backButton.click();
        } else {
            mpSave.click();
            mpExpandFilter.click();
        }

    }


    public void selectSort(MobileElement myElement) throws Exception {
        if (getOS().equals("ios")) {
            sortReport.click();
            myElement.click();
        } else {
            myElement.click();
        }

    }








    //Calendar
    //@AndroidFindBy(xpath = "//*[@text='Calendar']")
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'Calendars'")
    //public  MobileElement calendar;


}
