package LDSToolsAppium.Screen;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;



public class ReportsScreen extends BasePage {
    public ThreadLocal<AppiumDriver> driver;
    public ReportsScreen(ThreadLocal<AppiumDriver> driver) {
        super(BaseDriver.driver );
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Reports Main Screen ******************

    //Action and Interview List
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Action and Interview List']")
    @iOSXCUITFindBy(accessibility = "Action and Interview List")
    public MobileElement actionAndInterviewListReport;

    //Birthday List
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Birthday List']")
    @iOSXCUITFindBy(accessibility = "Birthday List")
    public MobileElement birthdayListtReport;

    //Home Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching']")
    @iOSXCUITFindBy(accessibility = "Home Teaching")
    public MobileElement homeTeachingReport;

    //Members Moved In
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved In']")
    @iOSXCUITFindBy(accessibility = "Members Moved In")
    public MobileElement membersMovedInReport;

    //Members Moved Out
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved Out']")
    @iOSXCUITFindBy(accessibility = "Members Moved Out")
    public MobileElement membersMovedOutReport;

    //Members with Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members with Callings']")
    @iOSXCUITFindBy(accessibility = "Members with Callings")
    public MobileElement membersWithCallingsReport;

    //Members without Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members without Callings']")
    @iOSXCUITFindBy(accessibility = "Members without Callings")
    public MobileElement membersWithOutCallingsReport;

    //Missionary Progress Record
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Missionary Progress Record']")
    @iOSXCUITFindBy(accessibility = "Missionary Progress Record")
    public MobileElement missionaryProgressRecordReport;

    //New Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Members']")
    @iOSXCUITFindBy(accessibility = "New Members")
    public MobileElement newMembersReport;

    //Temple Recommend Status
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Temple Recommend Status']")
    @iOSXCUITFindBy(accessibility = "Temple Recommend Status")
    public MobileElement templeRecommendStatusReport;

    //Unit Statistics
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unit Statistics']")
    @iOSXCUITFindBy(accessibility = "Unit Statistics")
    public MobileElement unitStatisticsReport;

    //Quarterly Report
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quarterly Report']")
    @iOSXCUITFindBy(accessibility = "Quarterly Report")
    public MobileElement quarterlyReport;


    //Youth Recommend Status
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Youth Recommend Status']")
    @iOSXCUITFindBy(accessibility = "Youth Recommend Status")
    public MobileElement youthRecommendStatusReport;

    //Visiting Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Visiting Teaching']")
    @iOSXCUITFindBy(accessibility = "Visiting Teaching")
    public MobileElement visitingTeachingsReport;

    //Sacrament Attendance
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sacrament Attendance']")
    @iOSXCUITFindBy(accessibility = "Sacrament Attendance")
    public MobileElement sacramentAttendanceReport;




    //Sort
    @iOSXCUITFindBy(accessibility = "Sort")
    public MobileElement sortReport;

    //Filters
    @iOSXCUITFindBy(accessibility = "Filters")
    public MobileElement sortFilters;


    //Cancel
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement cancelSort;

    //Name
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"name\")]")
    @iOSXCUITFindBy(accessibility = "Name")
    public  MobileElement nameSort;

    //Organization
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"organization\")]")
    @iOSXCUITFindBy(accessibility = "Organization")
    public  MobileElement organizationSort;

    //Duration
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"duration\")]")
    @iOSXCUITFindBy(accessibility = "Duration")
    public  MobileElement durationSort;

    //Not Set Apart
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"not set apart\")]")
    @iOSXCUITFindBy(accessibility = "Not Set Apart")
    public  MobileElement notSetApartSort;

    //All
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all\")]")
    @iOSXCUITFindBy(accessibility = "All")
    public  MobileElement allSort;

    //Male
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"male\")]")
    @iOSXCUITFindBy(accessibility = "Male")
    public  MobileElement maleSort;

    //Female
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"female\")]")
    @iOSXCUITFindBy(accessibility = "Female")
    public  MobileElement femaleSort;

    //Active
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"active\")]")
    @iOSXCUITFindBy(accessibility = "Active")
    public  MobileElement activeSort;

    //Expiring
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expiring\")]")
    @iOSXCUITFindBy(accessibility = "Expiring")
    public  MobileElement expiringSort;

    //Expired
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expired\")]")
    @iOSXCUITFindBy(accessibility = "Expired")
    public  MobileElement expiredSort;

    //Other
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"other\")]")
    @iOSXCUITFindBy(accessibility = "Other")
    public  MobileElement otherSort;

    //Never Issued
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"never issued\")]")
    @iOSXCUITFindBy(accessibility = "Never Issued")
    public  MobileElement neverIssuedSort;

    //Unordained
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"unordained\")]")
    @iOSXCUITFindBy(accessibility = "Unordained")
    public  MobileElement unordainedSort;

    //Not Baptized
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"not baptized\")]")
    @iOSXCUITFindBy(accessibility = "Not Baptized")
    public  MobileElement notBaptizedSort;


    //*************************************************************************************
    //********************* Action and Interview List *************************************
    //*************************************************************************************


    //Children Approaching Baptism Age
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Children Approaching Baptism Age']")
    @iOSXCUITFindBy(accessibility = "Children Approaching Baptism Age")
    public MobileElement childrenApproachingBaptismAgeReport;

    //Unbaptized Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unbaptized Members']")
    @iOSXCUITFindBy(accessibility = "Unbaptized Members")
    public MobileElement unbaptizedMembersReport;

    //Overdue Aaronic Priesthood Ordinations
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations'][@resource-id='org.lds.ldstools:id/reportTextView']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations'][contains(@resource-id, 'reportTextView')]")
    @iOSXCUITFindBy(xpath = "//*[@name='Overdue Aaronic Priesthood Ordinations'][2]")
    public MobileElement overdueAaronicPriesthoodOrdinationsReport;

    //Young Single Adult Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Single Adult Interviews']")
    @iOSXCUITFindBy(accessibility = "Young Single Adult Interviews")
    public MobileElement youngSingleAdultInterviewsReport;

    //Bishop's Youth Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishop’s Youth Interviews']")
    @iOSXCUITFindBy(accessibility = "Bishop’s Youth Interviews")
    public MobileElement bishopsYouthInterviewsReport;

    //Bishopric Counselor Youth Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric Counselor Youth Interviews']")
    @iOSXCUITFindBy(accessibility = "Bishopric Counselor Youth Interviews")
    public MobileElement bishopricCounselorYouthInterviewsReport;

    //Young Men Approaching Mission Age
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Men Approaching Mission Age']")
    @iOSXCUITFindBy(accessibility = "Young Men Approaching Mission Age")
    public MobileElement youngMenApproachingMissionAgeReport;

    //Men Who Have Not Served a Mission
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Men Who Have Not Served a Mission']")
    @iOSXCUITFindBy(accessibility = "Men Who Have Not Served a Mission")
    public MobileElement menWhoHaveNotServedaMissionReport;

    //Potential Missionary Couples
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Potential Missionary Couples']")
    @iOSXCUITFindBy(accessibility = "Potential Missionary Couples")
    public MobileElement potentialMissionaryCouplesReport;




    //*************************************************************************************
    //********************* Missionary Progress Record ************************************
    //*************************************************************************************

    //Missionary Progress Filter
    @AndroidFindBy(accessibility = "Filters")
    @iOSXCUITFindBy(accessibility = "Filter")
    public  MobileElement missionaryProgressFilter;

    //Missionary Progress Investigators with Baptism Date
    @AndroidFindBy(id = "mpFilterInvestigatorsWithBaptismDateSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label='Investigators with Baptism Date']")
    public  MobileElement mpInvestigatorsWithBaptismDate;

    //Missionary Progress Progressing Investigators
    @AndroidFindBy(id = "mpFilterProgressingInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Progressing Investigators\"]")
    public  MobileElement mpProgressingInvestigators;

    //Missionary Progress New Investigators
    @AndroidFindBy(id = "mpFilterNewInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"New Investigators\"]")
    public  MobileElement mpNewInvestigators;

    //Missionary Progress Other Investigators
    @AndroidFindBy(id = "mpFilterOtherInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Other Investigators\"]")
    public  MobileElement mpOtherInvestigators;

    //Missionary Progress Potential Investigators
    @AndroidFindBy(id = "mpFilterPotentialInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Potential Investigators\"]")
    public  MobileElement mpPotentialInvestigators;

    //Missionary Progress Recent Converts
    @AndroidFindBy(id = "mpFilterRecentConvertsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Recent Converts\"]")
    public  MobileElement mpRecentConverts;


    //Missionary Progress Members Being Taught
    @AndroidFindBy(id = "mpFilterMembersBeingTaughtSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Members Being Taught\"]")
    public  MobileElement mpMembersBeingTaught;

    //Missionary Progress Save
    @AndroidFindBy(id = "menu_item_save")
    public  MobileElement mpSave;

    //Missionary Progress Expand Filter
    @AndroidFindBy(id = "filterHeaderArrow")
    public  MobileElement mpExpandFilter;


    //Missionary Progress Remove Filter Button
    @AndroidFindBy(id = "removeFiltersButton")
    @iOSXCUITFindBy(accessibility = "Remove")
    public  MobileElement mpRemoveFilterButton;

    //Missionary Progress Received a Visit
    @AndroidFindBy(id = "mpFilterReceivedAVisitTextView")
    @iOSXCUITFindBy(accessibility = "Received a Visit")
    public  MobileElement mpReceivedAVisit;

    //Missionary Progress Attended Sacrament
    @AndroidFindBy(id = "mpFilterSacramentAttendanceTextView")
    @iOSXCUITFindBy(accessibility = "Attended Sacrament")
    public  MobileElement mpAttendedSacrament;

    //Missionary Progress Assigned
    @AndroidFindBy(id = "mpFilterFellowshippersTextView")
    @iOSXCUITFindBy(accessibility = "Assigned")
    public  MobileElement mpAssigned;

    //Missionary Progress Last Week
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last Week\"]")
    @iOSXCUITFindBy(accessibility = "Last Week")
    public  MobileElement mpLastWeek;

    //Missionary Progress Last 2 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 2 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 2 Weeks")
    public  MobileElement mpLast2Weeks;

    //Missionary Progress Last 3 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 3 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 3 Weeks")
    public  MobileElement mpLast3Weeks;

    //Missionary Progress Last 4 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 4 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 4 Weeks")
    public  MobileElement mpLast4Weeks;

    //Missionary Progress Last 5 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 5 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 5 Weeks")
    public  MobileElement mpLast5Weeks;

    //Missionary Progress All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"All\"]")
    @iOSXCUITFindBy(accessibility = "All")
    public  MobileElement mpAll;

    //Missionary Progress Cancel
    @AndroidFindBy(xpath = "//*[@text=\"Cancel\"]")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement mpCancel;

    // ************ Sacrament Attendance Page
    //Todo: need to add ios
    //Sacrament Attendance First Week
    @AndroidFindBy(id = "week1EditText")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceFirstWeek;

    //Todo: need to add ios
    //Sacrament Attendance Second Week
    @AndroidFindBy(id = "week2EditText")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceSecondWeek;

    //Todo: need to add ios
    //Sacrament Attendance Third Week
    @AndroidFindBy(id = "week3EditText")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceThirdWeek;

    //Todo: need to add ios
    //Sacrament Attendance Fourth Week
    @AndroidFindBy(id = "week4EditText")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceFourthWeek;

    //Todo: need to add ios
    //Sacrament Attendance Dialog Edit Field
    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceDialogEditField;

    //Todo: need to add ios
    //Sacrament Attendance Cancel
    @AndroidFindBy(id = "button2")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceDialogCancel;

    //Todo: need to add ios
    //Sacrament Attendance Ok
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceDialogOk;

    //Todo: need to add ios
    //Sacrament Attendance Counter Icon
    @AndroidFindBy(id = "text_input_end_icon")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceCounterIcon;



    //Todo: need to add ios
    //Sacrament Attendance Add Button
    @AndroidFindBy(id = "counterTextView")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement sacramentAttendanceAddButton;



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

    public void selectFilters(MobileElement myElement) throws Exception {
        if (getOS().equals("ios")) {
            sortFilters.click();
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
