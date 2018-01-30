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


public class OrganizationsScreen extends BasePage {

    public OrganizationsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    // ****************** Organizations Main Screen ******************

    //Bishopric
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric']")
    @iOSFindBy(accessibility = "Bishopric")
    public MobileElement bishopricOrg;

    //High Priests Group
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Group']")
    @iOSFindBy(accessibility = "High Priests Group")
    public MobileElement highPriestsOrg;

    //Elders Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum']")
    @iOSFindBy(accessibility = "Elders Quorum")
    public MobileElement eldersQuorumOrg;

    //Relief Society
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society']")
    @iOSFindBy(accessibility = "Relief Society")
    public MobileElement reliefSocietyOrg;

    //Young Men
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Men']")
    @iOSFindBy(accessibility = "Young Men")
    public MobileElement youngMenOrg;

    //Young Women
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women']")
    @iOSFindBy(accessibility = "Young Women")
    public MobileElement youngWomenOrg;

    //Sunday School
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunday School']")
    @iOSFindBy(accessibility = "Sunday School")
    public MobileElement sundaySchoolOrg;

    //Primary
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary']")
    @iOSFindBy(accessibility = "Primary")
    public MobileElement primaryOrg;

    //Ward Missionaries
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ward Missionaries']")
    @iOSFindBy(accessibility = "Ward Missionaries")
    public MobileElement wardMissionariesOrg;

    //Other Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Other Callings']")
    @iOSFindBy(accessibility = "Other Callings")
    public MobileElement otherCallingsOrg;



    // ****************** High Priests ******************
    //High Priests Group Leadership
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Group Leadership']")
    @iOSFindBy(accessibility = "High Priests Group Leadership")
    public MobileElement highPriestsLeadership;

    //High Priests Home Teaching District Supervisors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching District Supervisors']")
    @iOSFindBy(accessibility = "Home Teaching District Supervisors")
    public MobileElement highPriestsHTDistrictSuper;

    //High Priests All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All High Priests Group Members")
    public MobileElement highPriestsAllMembers;

    // ****************** Elders Quorum ******************
    //Elders Quorum Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum Presidency']")
    @iOSFindBy(accessibility = "Elders Quorum Presidency")
    public MobileElement eldersQuorumPresidency;

    //Elders Quorum Home Teaching District Supervisors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching District Supervisors']")
    @iOSFindBy(accessibility = "Home Teaching District Supervisors")
    public MobileElement eldersHTDistrictSuper;

    //Elders Quorum All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Elders Quorum Members")
    public MobileElement eldersAllMembers;

    // ****************** Relief Society ******************
    //Relief Society Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society Presidency']")
    @iOSFindBy(accessibility = "Relief SocietyPresidency")
    public MobileElement reliefSocietyPresidency;

    //Relief Society Visiting Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Visiting Teaching']")
    @iOSFindBy(accessibility = "Visiting Teaching")
    public MobileElement reliefSocietyVisitingTeaching;

    //Relief Society Music
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    @iOSFindBy(accessibility = "Music")
    public MobileElement reliefSocietyMusic;

    //Relief Society All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Relief Society Members")
    public MobileElement reliefSocietyAllMembers;

    // ****************** Young Men ******************
    //Young Men Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Men Presidency']")
    @iOSFindBy(accessibility = "Young Men Presidency")
    public MobileElement youngMenPresidency;

    //Priests Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Priests Quorum']")
    @iOSFindBy(accessibility = "Priests Quorum")
    public MobileElement priestsQuorum;

    //Priests Quorum Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSFindBy(accessibility = "Priests Quorum Presidency")
    public MobileElement priestsQuorumPresidency;

    //All Priests Quorum Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Priests Quorum Members")
    public MobileElement priestsQuorumMembersAll;

    //Teachers Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Teachers Quorum']")
    @iOSFindBy(accessibility = "Teachers Quorum")
    public MobileElement teachersQuorum;

    //Teachers Quorum Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSFindBy(accessibility = "Teachers Quorum Presidency")
    public MobileElement teachersQuorumPresidency;

    //All Priests Quorum Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Teachers Quorum Members")
    public MobileElement teachersQuorumMembersAll;

    //Deacons Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deacons Quorum']")
    @iOSFindBy(accessibility = "Deacons Quorum")
    public MobileElement deaconsQuorum;

    //Deacons Quorum Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSFindBy(accessibility = "Deacons Quorum Presidency")
    public MobileElement deaconsQuorumPresidency;

    //All Deacons Quorum Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Deacons Quorum Members")
    public MobileElement deaconsQuorumMembersAll;

    //All Young Men Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Young Men Members")
    public MobileElement youngMenMembersAll;


    // ****************** Young Women ******************
    //Young Women Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women Presidency']")
    @iOSFindBy(accessibility = "Young Women Presidency")
    public MobileElement youngWomenPresidency;

    //Laurel
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Laurel']")
    @iOSFindBy(accessibility = "Laurel")
    public MobileElement laurel;

    //Laurel Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSFindBy(accessibility = "Laurel Presidency")
    public MobileElement laurelPresidency;

    //All Laurel Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Laurel Members")
    public MobileElement laurelMembersAll;

    //Mia Maid
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mia Maid']")
    @iOSFindBy(accessibility = "TMia Maid")
    public MobileElement miaMaid;

    //Mia Maid Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSFindBy(accessibility = "Mia Maid Presidency")
    public MobileElement miaMaidPresidency;

    //Mia Maid Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Mia Maid Members")
    public MobileElement miaMaidMembersAll;

    //Beehive
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Beehive']")
    @iOSFindBy(accessibility = "Beehive")
    public MobileElement beehive;

    //Beehive Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSFindBy(accessibility = "Beehive Presidency")
    public MobileElement beehivePresidency;

    //All Beehive Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Beehive Members")
    public MobileElement beehivemMembersAll;

    //All Young Women Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(accessibility = "All Young Women Members")
    public MobileElement youngWomenMembersAll;

    // ****************** Sunday School ******************

    //Sunday School Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunday School Presidency']")
    @iOSFindBy(accessibility = "Sunday School Presidency")
    public MobileElement sundaySchoolPresidency;

    //Gospel Doctrine
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gospel Doctrine']")
    @iOSFindBy(accessibility = "Gospel Doctrine")
    public MobileElement gospelDoctrine;

    //Course 17
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 17']")
    @iOSFindBy(accessibility = "Course 17")
    public MobileElement course17;

    //Course 16
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 16']")
    @iOSFindBy(accessibility = "Course 16")
    public MobileElement course16;

    //Course 15
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 15']")
    @iOSFindBy(accessibility = "Course 15")
    public MobileElement course15;

    //Course 14
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 14']")
    @iOSFindBy(accessibility = "Course 14")
    public MobileElement course14;

    //Course 13
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 13']")
    @iOSFindBy(accessibility = "Course 13")
    public MobileElement course13;

    //Course 12
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 12']")
    @iOSFindBy(accessibility = "Course 12")
    public MobileElement course12;








    //General All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    public MobileElement generalAllMembers;


}
