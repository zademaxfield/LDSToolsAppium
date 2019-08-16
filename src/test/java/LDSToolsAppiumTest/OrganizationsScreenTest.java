package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;

import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.OrganizationsScreen;
import io.appium.java_client.MobileElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class OrganizationsScreenTest extends BaseDriver {

    @Test(dataProvider = "Members", groups = {"smoke1", "smoke", "all1", "all", "jft"})
    public void organizationTest(String userName, String passWord, String rightsString, String calling) throws Exception {
        //String pageSource;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.organizations);
        if (rights <= 3) {
            myWeb.openPageLogIn("https://lcr-uat.lds.org", userName, passWord);
        }


        getBishopricInfo(rights);

        getEldersQuorum(rights);

        getReliefSociety(rights);

        getYoungMenInfo(rights);

        getYoungWomenInfo(rights);

        getPrimaryInfo(rights);

        //Sunday School is flaky in UAT
        //getSundaySchoolInfo(rights);

//        getOtherInfo(rights);
        //getHighPriestsGroupInfo(rights);

    }



    @Test(dataProvider = "Members", groups = {"smoke2", "smoke", "all2", "all"})
    public void organizationStakeHighPriestQuorum(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        BasePage myBasePage = new BasePage(driver);


        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.organizations);
        myOrg.organizationsDropdown.click();
        myOrg.savaiiStake.click();
        myOrg.highPriestsQuorumOrg.click();
        if (getRunningOS().equals("ios")) {
            myOrg.highPriestsQuorumMembersOrg.click();
        }
        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Fata", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Rudy", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Jane", pageSource, "Contains"));

        myBasePage.backButton.click();

        if (getRunningOS().equals("ios")) {
            myBasePage.backButton.click();
        }

        myOrg.organizationsDropdown.click();
        myOrg.fagamalo1stWard.click();

    }

    private void getBishopricInfo(int rights) throws Exception {
//        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);

        //Data from Web page
        List<String> myList;

        //Data from android list
        ArrayList<String> androidList = new ArrayList<>();

        myOrg.bishopricOrg.click();

        if (rights <= 3) {
            //Go to web and get all users
            myList = myWeb.getAllMembersOnPage("OrganizationsMenu", "Bishopric", false);
            myBasePage.compareWebData(myList, androidList, true);

//            driver.rotate(ScreenOrientation.LANDSCAPE);
//            myBasePage.compareWebData(myList, androidList, true);
//
//            driver.rotate(ScreenOrientation.PORTRAIT);


        } else {
            Thread.sleep(2000);
            bishopricData();
//            driver.rotate(ScreenOrientation.LANDSCAPE);
//            bishopricData();
//            driver.rotate(ScreenOrientation.PORTRAIT);

        }

        myBasePage.backAltButton.click();
        Thread.sleep(1000);
    }

    private void bishopricData() {
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Oline", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vili", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishopric First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lesa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Anisi", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishopric Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Alisa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Fonoafi", pageSource, "Contains"));
    }


    private void getHighPriestsGroupInfo(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);


        //LDSWeb myWeb = new LDSWeb();
        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();


        myOrg.highPriestsOrg.click();


        if (rights <= 3) {
            myOrg.highPriestsLeadership.click();
            Thread.sleep(1000);
            //Check web data vs LDS Tools
            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "High Priests Group", "HighPriestGroupLeadership", false);
            myBasePage.compareWebData(myList, androidList, true);

            myBasePage.backAltButton.click();
            myOrg.highPriestsHTDistrictSuper.click();

            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "High Priests Group", "HighPriestGroupDistrictSupervisors", false);
            myBasePage.compareWebData(myList, androidList, true);

            myBasePage.backAltButton.click();
            myOrg.highPriestsAllMembers.click();


            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "High Priests Group", "HighPriestGroupMembers", false);
            myBasePage.compareWebData(myList, androidList, true);

        } else {
            myOrg.highPriestsLeadership.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Group Leader", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Faamoe", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Panapa", pageSource, "Contains"));

            Assert.assertTrue(myBasePage.checkNoCaseList("First Assistant", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Tools", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS17", pageSource, "Contains"));

            Assert.assertTrue(myBasePage.checkNoCaseList("Second Assistant", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS19", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS18", pageSource, "Contains"));

            myBasePage.backAltButton.click();
            myOrg.highPriestsHTDistrictSuper.click();
            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Home Teaching District Supervisor", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Tools", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS50", pageSource, "Contains"));
            myBasePage.backAltButton.click();
            Thread.sleep(1000);
        }


        if(getRunningOS().equals("ios")) {
            myBasePage.backAltButton.click();
            Thread.sleep(1000);
        }
        myBasePage.backAltButton.click();
        Thread.sleep(1000);

    }


    private void getEldersQuorum(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);

        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();


        myOrg.eldersQuorumOrg.click();


        if (rights <= 3) {
            myOrg.eldersQuorumPresidency.click();
            //Check web data vs LDS Tools
            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Elders Quorum", "EldersQuorumPresidency", false);
            myBasePage.compareWebData(myList, androidList, true);

            myBasePage.backAltButton.click();

            //myOrg.eldersHTDistrictSuper.click();
            //myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Elders Quorum", "EldersQuorumDistrictSupervisors", false);
            //myBasePage.compareWebData(myList, androidList, true);
            //myBasePage.backButton.click();

            myOrg.eldersAllMembers.click();


            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Elders Quorum", "EldersQuorumMembers", false);
            myBasePage.compareWebData(myList, androidList, true);

//            driver.rotate(ScreenOrientation.LANDSCAPE);
//            myBasePage.compareWebData(myList, androidList, true);
//
//            driver.rotate(ScreenOrientation.PORTRAIT);

        } else {
            myOrg.eldersQuorumPresidency.click();
            Thread.sleep(2000);
            eldersQuorumData();

//            driver.rotate(ScreenOrientation.LANDSCAPE);
//            eldersQuorumData();
//
//            driver.rotate(ScreenOrientation.PORTRAIT);

            myBasePage.backAltButton.click();

            Thread.sleep(1000);
        }

        if(getRunningOS().equals("ios")) {
            myBasePage.backAltButton.click();
            Thread.sleep(1000);
        }
        myBasePage.backAltButton.click();
        Thread.sleep(1000);

    }

    private void eldersQuorumData() throws Exception{
        String pageSource;
        BasePage myBasePage = new BasePage(driver);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Pipi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mafoe", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vaifale", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Atonio", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS23", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Secretary", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS24", pageSource, "Contains"));

    }


    private void getReliefSociety(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        //LDSWeb myWeb = new LDSWeb();
        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();

        myOrg.reliefSocietyOrg.click();

        if (rights <= 3) {
            myOrg.reliefSocietyPresidency.click();

            //Check web data vs LDS Tools
            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Relief Society", "ReliefSocietyPresidency", false);
            myBasePage.compareWebData(myList, androidList, true);
//
//            myBasePage.backAltButton.click();
//            myOrg.reliefSocietyVisitingTeaching.click();
//
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Relief Society", "VisitingTeachingSupervisors", false);
//            myBasePage.compareWebData(myList, androidList, true);

            myBasePage.backAltButton.click();
            myOrg.reliefSocietyAllMembers.click();

            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Relief Society", "ReliefSocietyMembers", false);
            myBasePage.compareWebData(myList, androidList, true);

//            driver.rotate(ScreenOrientation.LANDSCAPE);
//            myBasePage.compareWebData(myList, androidList, true);
//
//            driver.rotate(ScreenOrientation.PORTRAIT);


        } else {
            myOrg.reliefSocietyPresidency.click();
            reliefSocietyData();

//            driver.rotate(ScreenOrientation.LANDSCAPE);
//            reliefSocietyData();
//
//            driver.rotate(ScreenOrientation.PORTRAIT);


            myBasePage.backAltButton.click();
            Thread.sleep(1000);
        }

        if(getRunningOS().equals("ios")) {
            myBasePage.backAltButton.click();
            Thread.sleep(1000);
        }
        myBasePage.backAltButton.click();
        Thread.sleep(1000);

    }

    private void reliefSocietyData() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Young", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Fila", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Seuamuli", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Alofa", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Aumoto", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tusiga", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Secretary", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Leota", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Kamila", pageSource, "Contains"));
    }


    private void getYoungMenInfo(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        //LDSWeb myWeb = new LDSWeb();
        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();

        myOrg.youngMenOrg.click();
        myOrg.youngMenPresidency.click();

        if (rights <= 3) {
            //Check web data vs LDS Tools
            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Men", "YoungMenPresidency", false);
            myBasePage.compareWebData(myList, androidList, true);

            myBasePage.backAltButton.click();
            myOrg.priestsQuorum.click();
            if (getRunningOS().equals("ios")) {
                myOrg.priestsQuorumPresidency.click();
            }



            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Men", "PriestsQuorum", false);
            myBasePage.compareWebData(myList, androidList, true);

            if (getRunningOS().equals("ios")) {
                myBasePage.backAltButton.click();
            }
            myBasePage.backAltButton.click();

            //myOrg.teachersQuorum.click();
            //if (getRunningOS().equals("ios")) {
            //	clickButtonByXpathTitleName("Teachers Quorum Presidency");
            //}

            //myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Men", "TeachersQuorum", false);
            //compareWebData(myList, androidList, true);

            //if (getRunningOS().equals("ios")) {
            //	pressBackKey();
            //}
            //myBasePage.backButton.click();

            //myOrg.teachersQuorum.click();
            //if (getRunningOS().equals("ios")) {
            //    myOrg.teachersQuorumPresidency.click();

            //}

//            myOrg.deaconsQuorum.click();
//            if (getRunningOS().equals("ios")) {
//                myOrg.deaconsQuorumPresidency.click();
//            }
//
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Men", "DeaconsQuorum", false);
//            myBasePage.compareWebData(myList, androidList, true);
//
//            if (getRunningOS().equals("ios")) {
//                myBasePage.backAltButton.click();
//            }
//
//            myBasePage.backAltButton.click();
//            Thread.sleep(1000);


            
        } else {
            //Todo: Need more
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("President", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Young", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Wella", pageSource, "Contains"));
            myBasePage.backAltButton.click();
            Thread.sleep(1000);
            myBasePage.backAltButton.click();
            Thread.sleep(1000);
            
        }

        myBasePage.backAltButton.click();
        Thread.sleep(1000);


    }



    private void getYoungWomenInfo(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver );
        //LDSWeb myWeb = new LDSWeb();
        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();


        myOrg.youngWomenOrg.click();
        Thread.sleep(1000);
        myOrg.youngWomenPresidency.click();
        Thread.sleep(1000);

        if (rights <= 3) {
            //Check web data vs LDS Tools
            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Women", "YoungWomenPresidency", false);
            myBasePage.compareWebData(myList, androidList, true);

            myBasePage.backAltButton.click();


            //None of the young women have the presidency setup.

//            myList.clear();
//            //Test Laurel Presidency
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Women", "Laurel", false);
//
//            myOrg.laurel.click();
//
//            if (myList.isEmpty()) {
//                if (getRunningOS().equals("ios")) {
//                    myOrg.laurelPresidency.click();
//                }
//
//                myBasePage.compareWebData(myList, androidList, true);
//
//                if (getRunningOS().equals("ios")) {
//                    myBasePage.backAltButton.click();
//                }
//            }
//
//
//            myBasePage.backAltButton.click();
//
//            myList.clear();
//            //Test Mia Maid Presidency
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Women", "MiaMaid", false);
//
//            myOrg.miaMaid.click();
//
//            if (myList.isEmpty()) {
//                if (getRunningOS().equals("ios")) {
//                    myOrg.miaMaidPresidency.click();
//                }
//
//                myBasePage.compareWebData(myList, androidList, true);
//
//                if (getRunningOS().equals("ios")) {
//                    myBasePage.backAltButton.click();
//                }
//            }
//
//            myBasePage.backAltButton.click();
//
//            myList.clear();
//            //Test Bee Hive Presidency
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Young Women", "Beehive", false);
//
//            myOrg.beehive.click();
//
//            if (myList.isEmpty()) {
//                if (getRunningOS().equals("ios")) {
//                    myOrg.beehivePresidency.click();
//                }
//
//                myBasePage.compareWebData(myList, androidList, true);
//            }



        } else {
            //Todo: Need More
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("President", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Aumoto", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Vaifale", pageSource, "Contains"));
            myBasePage.backAltButton.click();
            Thread.sleep(1000);
            myBasePage.backAltButton.click();
            Thread.sleep(1000);

        }


        if (getRunningOS().equals("ios")) {
            myBasePage.backAltButton.click();
        }

//        myBasePage.backAltButton.click();
//        Thread.sleep(1000);
        myBasePage.backAltButton.click();
        Thread.sleep(1000);
    }




    private void getSundaySchoolInfo(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        //LDSWeb myWeb = new LDSWeb();
        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();

        myOrg.sundaySchoolOrg.click();
        myOrg.sundaySchoolPresidency.click();
        Thread.sleep(1000);

        if (rights <= 3) {
            //Check web data vs LDS Tools
            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Sunday School", "SundaySchoolPresidency", false);
            myBasePage.compareWebData(myList, androidList, true);


            myBasePage.backAltButton.click();
            sundaySchoolClassSub(myOrg.gospelDoctrine, "GospelDoctrine");
            //sundaySchoolClassSub("Course 17", "Course17");
            sundaySchoolClassSub(myOrg.course16, "Course16");
            sundaySchoolClassSub(myOrg.course15, "Course15");
            sundaySchoolClassSub(myOrg.course14, "Course14");
            sundaySchoolClassSub(myOrg.course13, "Course13");
            sundaySchoolClassSub(myOrg.course12, "Course12");

        } else {
            //Todo: need test for this.
        }


        Thread.sleep(1000);
        myBasePage.backAltButton.click();


    }



    private void sundaySchoolClassSub(MobileElement className, String subReport) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        List<String> myList = new ArrayList<String>();
        //Data from android list
        List<String> androidList = new ArrayList<String>();
        String macAllMembers = "All " + className + " Members";
        String classAllMembers = subReport + "Members";


        className.click();
        myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Sunday School", subReport, false);
        myBasePage.compareWebData(myList, androidList, true);

        //Select all members
        myOrg.generalAllMembers.click();
        myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Sunday School", classAllMembers, false);
        myBasePage.compareWebData(myList, androidList, true);

        //Back to Sunday School
        if (getRunningOS().equals("ios")) {
            myBasePage.backAltButton.click();
        }
        myBasePage.backAltButton.click();
    }


    private void getPrimaryInfo(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        //LDSWeb myWeb = new LDSWeb();
        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();


        myOrg.primaryOrg.click();
        Thread.sleep(1000);
        myOrg.primaryPresidency.click();
        Thread.sleep(1000);

        if (rights <= 3) {
            //Check web data vs LDS Tools
            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Primary", "PrimaryPresidency", true);
            myBasePage.compareWebData(myList, androidList, true);

            myBasePage.backAltButton.click();


        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("President", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Pipi", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Lalotoa", pageSource, "Contains"));

            myBasePage.backAltButton.click();

        }


        //Todo: Need to get info on each of the classes....
        //Right now iOS and Android are showing the data differently




        Thread.sleep(1000);
        myBasePage.backAltButton.click();

    }

    private void getOtherInfo(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);

        myOrg.otherCallingsOrg.click();
        myOrg.otherMusic.click();
        Thread.sleep(1000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Adviser", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Frost", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Maria", pageSource, "Contains"));

        myBasePage.backAltButton.click();


        Thread.sleep(1000);
        myBasePage.backAltButton.click();

    }


}
