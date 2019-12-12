package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class OrganizationsScreen extends BasePage {

    public OrganizationsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Organizations Main Screen ******************


    //Organizations Dropdown
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Organizations']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Organizations']")
    public MobileElement organizationsDropdown;

    //Savaii Samoa Fagamalo Stake
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Savaii Samoa Fagamalo Stake']")
    @iOSXCUITFindBy(accessibility = "Savaii Samoa Fagamalo Stake")
    public MobileElement savaiiStake;

    //Inglewood California Stake
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inglewood California Stake']")
    @iOSXCUITFindBy(accessibility = "Inglewood California Stake")
    public MobileElement inglewoodStake;

    //Fagamalo 1st Ward
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fagamalo 1st Ward']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Fagamalo 1st Ward')]")
//    @iOSXCUITFindBy(accessibility = "//XCUIElementTypeStaticText[@name=\" Fagamalo 1st Ward\"]")
    public MobileElement fagamalo1stWard;

    //  ****************** Organizations Stake ******************
    //Stake Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Presidency']")
    @iOSXCUITFindBy(accessibility = "Stake Presidency")
    public MobileElement stakePresidencyOrg;

    //High Priests Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Quorum']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"High Priests Quorum\"]")
    public MobileElement highPriestsQuorumOrg;

    //High Priests Quorum Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Quorum Members']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"All High Priests Quorum Members\"]")
    public MobileElement highPriestsQuorumMembersOrg;


    //High Council
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Council']")
    @iOSXCUITFindBy(accessibility = "High Council")
    public MobileElement highCouncilOrg;

    //Patriarch
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Patriarch']")
    @iOSXCUITFindBy(accessibility = "Patriarch")
    public MobileElement patriarchOrg;

    //Stake Relief Society
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Relief Society']")
    @iOSXCUITFindBy(accessibility = "Stake Relief Society")
    public MobileElement stakeReliefSocietyOrg;

    //Stake Young Men
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Young Men']")
    @iOSXCUITFindBy(accessibility = "Stake Young Men")
    public MobileElement stakeYoungMenOrg;

    //Stake Young Women
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Young Women']")
    @iOSXCUITFindBy(accessibility = "Stake Young Women")
    public MobileElement stakeYoungWomenOrg;

    //Stake Sunday School
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Sunday School']")
    @iOSXCUITFindBy(accessibility = "Stake Sunday School")
    public MobileElement stakeSundaySchoolOrg;

    //Stake Primary
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Primary']")
    @iOSXCUITFindBy(accessibility = "Stake Primary")
    public MobileElement stakePrimaryOrg;

    //Stake Family History
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Family History']")
    @iOSXCUITFindBy(accessibility = "Stake Family History")
    public MobileElement stakeFamilyHistoryOrg;


    //  ****************** Organizations Ward ******************
    //Bishopric
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric']")
    @iOSXCUITFindBy(accessibility = "Bishopric")
    public MobileElement bishopricOrg;

    //High Priests Group
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Group']")
    @iOSXCUITFindBy(accessibility = "High Priests Group")
    public MobileElement highPriestsOrg;

    //Elders Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum']")
    @iOSXCUITFindBy(accessibility = "Elders Quorum")
    public MobileElement eldersQuorumOrg;

    //Relief Society
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society']")
    @iOSXCUITFindBy(accessibility = "Relief Society")
    public MobileElement reliefSocietyOrg;

    //Young Men
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Aaronic Priesthood Quorums']")
    @iOSXCUITFindBy(accessibility = "Aaronic Priesthood Quorums")
    public MobileElement youngMenOrg;

    //Young Women
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women']")
    @iOSXCUITFindBy(accessibility = "Young Women")
    public MobileElement youngWomenOrg;

    //Sunday School
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunday School']")
    @iOSXCUITFindBy(accessibility = "Sunday School")
    public MobileElement sundaySchoolOrg;

    //Primary
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary']")
    @iOSXCUITFindBy(accessibility = "Primary")
    public MobileElement primaryOrg;

    //Ward Missionaries
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ward Missionaries']")
    @iOSXCUITFindBy(accessibility = "Ward Missionaries")
    public MobileElement wardMissionariesOrg;

    //Other Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Other Callings']")
    @iOSXCUITFindBy(accessibility = "Other Callings")
    public MobileElement otherCallingsOrg;



    // ****************** High Priests ******************
    //High Priests Group Leadership
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Group Leadership']")
    @iOSXCUITFindBy(accessibility = "High Priests Group Leadership")
    public MobileElement highPriestsLeadership;

    //High Priests Home Teaching District Supervisors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching District Supervisors']")
    @iOSXCUITFindBy(accessibility = "Home Teaching District Supervisors")
    public MobileElement highPriestsHTDistrictSuper;

    //High Priests All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All High Priests Group Members")
    public MobileElement highPriestsAllMembers;

    // ****************** Elders Quorum ******************
    //Elders Quorum Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum Presidency']")
    @iOSXCUITFindBy(accessibility = "Elders Quorum Presidency")
    public MobileElement eldersQuorumPresidency;

    //Elders Quorum Home Teaching District Supervisors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching District Supervisors']")
    @iOSXCUITFindBy(accessibility = "Home Teaching District Supervisors")
    public MobileElement eldersHTDistrictSuper;

    //Elders Quorum All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Elders Quorum Members")
    public MobileElement eldersAllMembers;

    // ****************** Relief Society ******************
    //Relief Society Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society Presidency']")
    @iOSXCUITFindBy(accessibility = "Relief Society Presidency")
    public MobileElement reliefSocietyPresidency;

    //Relief Society Ministering
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ministering']")
    @iOSXCUITFindBy(accessibility = "Ministering")
    public MobileElement reliefSocietyVisitingTeaching;

    //Relief Society Music
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    @iOSXCUITFindBy(accessibility = "Music")
    public MobileElement reliefSocietyMusic;

    //Relief Society All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Relief Society Members")
    public MobileElement reliefSocietyAllMembers;

    // ****************** Young Men ******************
    //Young Men Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Men Presidency']")
    @iOSXCUITFindBy(accessibility = "Young Men Presidency")
    public MobileElement youngMenPresidency;

    //Priests Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Priests Quorum']")
    @iOSXCUITFindBy(accessibility = "Priests Quorum")
    public MobileElement priestsQuorum;

    //Priests Quorum Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Priests Quorum Presidency")
    public MobileElement priestsQuorumPresidency;

    //All Priests Quorum Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Priests Quorum Members")
    public MobileElement priestsQuorumMembersAll;

    //Teachers Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Teachers Quorum']")
    @iOSXCUITFindBy(accessibility = "Teachers Quorum")
    public MobileElement teachersQuorum;

    //Teachers Quorum Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Teachers Quorum Presidency")
    public MobileElement teachersQuorumPresidency;

    //All Priests Quorum Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Teachers Quorum Members")
    public MobileElement teachersQuorumMembersAll;

    //Deacons Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deacons Quorum']")
    @iOSXCUITFindBy(accessibility = "Deacons Quorum")
    public MobileElement deaconsQuorum;

    //Deacons Quorum Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Deacons Quorum Presidency")
    public MobileElement deaconsQuorumPresidency;

    //All Deacons Quorum Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Deacons Quorum Members")
    public MobileElement deaconsQuorumMembersAll;

    //All Young Men Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Young Men Members")
    public MobileElement youngMenMembersAll;


    // ****************** Young Women ******************
    //Young Women Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women Presidency']")
    @iOSXCUITFindBy(accessibility = "Young Women Presidency")
    public MobileElement youngWomenPresidency;

    //Laurel
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Laurel']")
    @iOSXCUITFindBy(accessibility = "Laurel")
    public MobileElement laurel;

    //Laurel Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Laurel Presidency")
    public MobileElement laurelPresidency;

    //All Laurel Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Laurel Members")
    public MobileElement laurelMembersAll;

    //Mia Maid
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mia Maid']")
    @iOSXCUITFindBy(accessibility = "Mia Maid")
    public MobileElement miaMaid;

    //Mia Maid Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Mia Maid Presidency")
    public MobileElement miaMaidPresidency;

    //Mia Maid Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Mia Maid Members")
    public MobileElement miaMaidMembersAll;

    //Beehive
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Beehive']")
    @iOSXCUITFindBy(accessibility = "Beehive")
    public MobileElement beehive;

    //Beehive Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Beehive Presidency")
    public MobileElement beehivePresidency;

    //All Beehive Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Beehive Members")
    public MobileElement beehivemMembersAll;

    //All Young Women Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Young Women Members")
    public MobileElement youngWomenMembersAll;

    // ****************** Sunday School ******************

    //Sunday School Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunday School Presidency']")
    @iOSXCUITFindBy(accessibility = "Sunday School Presidency")
    public MobileElement sundaySchoolPresidency;

    //Gospel Doctrine
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gospel Doctrine']")
    @iOSXCUITFindBy(accessibility = "Gospel Doctrine")
    public MobileElement gospelDoctrine;

    //Course 17
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 17']")
    @iOSXCUITFindBy(accessibility = "Course 17")
    public MobileElement course17;

    //Course 16
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 16']")
    @iOSXCUITFindBy(accessibility = "Course 16")
    public MobileElement course16;

    //Course 15
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 15']")
    @iOSXCUITFindBy(accessibility = "Course 15")
    public MobileElement course15;

    //Course 14
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 14']")
    @iOSXCUITFindBy(accessibility = "Course 14")
    public MobileElement course14;

    //Course 13
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 13']")
    @iOSXCUITFindBy(accessibility = "Course 13")
    public MobileElement course13;

    //Course 12
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 12']")
    @iOSXCUITFindBy(accessibility = "Course 12")
    public MobileElement course12;


    // ****************** Primary ******************
    //Primary Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary Presidency']")
    @iOSXCUITFindBy(accessibility = "Primary Presidency")
    public MobileElement primaryPresidency;

    //Music
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    @iOSXCUITFindBy(accessibility = "Gospel Doctrine")
    public MobileElement primaryMusic;

    //Valiant 10
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 10']")
    @iOSXCUITFindBy(accessibility = "Valiant 10")
    public MobileElement valiant10;

    //Valiant 11
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 11']")
    @iOSXCUITFindBy(accessibility = "Valiant 11")
    public MobileElement valiant11;

    //Valiant 9
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 9']")
    @iOSXCUITFindBy(accessibility = "Valiant 9")
    public MobileElement valiant9;

    //Valiant 8
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 8']")
    @iOSXCUITFindBy(accessibility = "Valiant 8")
    public MobileElement valiant8;

    //CTR 7
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 7']")
    @iOSXCUITFindBy(accessibility = "CTR 7")
    public MobileElement ctr7;

    //CTR 6
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 6']")
    @iOSXCUITFindBy(accessibility = "CTR 6")
    public MobileElement ctr6;

    //CTR 5
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 5']")
    @iOSXCUITFindBy(accessibility = "CTR 5")
    public MobileElement ctr5;

    //CTR 4
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 4']")
    @iOSXCUITFindBy(accessibility = "CTR 4")
    public MobileElement ctr4;

    //Sunbeam
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunbeam']")
    @iOSXCUITFindBy(accessibility = "Sunbeam")
    public MobileElement sunbeam;

    //Nursery
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nursery']")
    @iOSXCUITFindBy(accessibility = "Nursery")
    public MobileElement nursery;

    //Cub Scouts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cub Scouts']")
    @iOSXCUITFindBy(accessibility = "Cub Scouts")
    public MobileElement cubScouts;

    //Eleven-Year-Old Scouts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Eleven-Year-Old Scouts']")
    @iOSXCUITFindBy(accessibility = "Eleven-Year-Old Scouts")
    public MobileElement elevenYearOldScouts;

    //Activity Days
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Activity Days']")
    @iOSXCUITFindBy(accessibility = "Activity Days")
    public MobileElement activityDays;



    // ****************** Other ******************
    //Music
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    @iOSXCUITFindBy(accessibility = "Music")
    public MobileElement otherMusic;



    //General All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Members'")
    public MobileElement generalAllMembers;


}
