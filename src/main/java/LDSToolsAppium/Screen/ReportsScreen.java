package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class ReportsScreen extends BasePage {

    public ReportsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
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



    public void selectSort(MobileElement myElement) throws Exception {
        if (getOS().equals("mac")) {
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
