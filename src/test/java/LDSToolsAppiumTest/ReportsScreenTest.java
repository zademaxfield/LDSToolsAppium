package LDSToolsAppiumTest;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ReportsScreenTest extends BaseDriver {


    @Test (groups = {"all1", "all", "smoke", "smoke1", "report", "daily", "daily1"})
    public void reportsBasic_BISHOP() throws Exception {
        reportsBasicCheckSub("BISHOP");
    }

    @Test (groups = {"all2", "all"})
    public void missionaryTest_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        reportsBasicCheckSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void missionaryTest_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        reportsBasicCheckSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void missionaryTest_WARD_CLERK() throws Exception {
        reportsBasicCheckSub("WARD_CLERK");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_WARD_ASSISTANT_CLERK() throws Exception {
        reportsBasicCheckSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_WARD_EXECUTIVE_SECRETARY() throws Exception {
        reportsBasicCheckSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all3", "all"})
    public void missionaryTest_MEMBER1() throws Exception {
        reportsBasicCheckSub("MEMBER1");
    }

    @Test(groups = {"all4", "all"})
    public void missionaryTest_MEMBER2() throws Exception {
        reportsBasicCheckSub("MEMBER2");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_ELDERS_QUORUM_PRESIDENT() throws Exception {
        reportsBasicCheckSub("ELDERS_QUORUM_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        reportsBasicCheckSub("ELDERS_QUORUM_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void missionaryTest_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        reportsBasicCheckSub("ELDERS_QUORUM_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void missionaryTest_ELDERS_QUORUM_SECRETARY() throws Exception {
        reportsBasicCheckSub("ELDERS_QUORUM_SECRETARY");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        reportsBasicCheckSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        reportsBasicCheckSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void missionaryTest_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        reportsBasicCheckSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void missionaryTest_YOUNG_WOMEN_PRESIDENT() throws Exception {
        reportsBasicCheckSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_WOMEN_SECOND_COUNSELOR() throws Exception {
        reportsBasicCheckSub("WOMEN_SECOND_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        reportsBasicCheckSub("SUNDAY_SCHOOL_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void missionaryTest_WARD_MISSION_LEADER() throws Exception {
        reportsBasicCheckSub("WARD_MISSION_LEADER");
    }

    public void reportsBasicCheckSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        reportsBasicCheckSubCheckNewRights(Integer.parseInt(callingRights[2]), callingRights[1]);
    }

    public void reportsBasicCheckSubCheckNewRights(int rights, String userName) throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        String pageSource;

        if (rights >= 4) {
            myMenu.selectMenu(myMenu.reports);
            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();

            if (getRunningOS().equals("ios")) {
                //pageSource = myBasePage.getSourceOfPage();
            } else {
                //pageSource = pageSource + myBasePage.getSourceOfPage();
                //myBasePage.scrollDownTEST(800);
                myBasePage.scrollDownAndroidUIAutomator("0");
                pageSource = pageSource + myBasePage.getSourceOfPage();
                //myBasePage.scrollUp(300);
                myBasePage.scrollUpAndroidUIAutomator("0");

            }

            //Todo: change to an api call per user
            myBasePage.rightsCheckNewRights("Action and Interview List", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Birthday List", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Ministering", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Members Moved In", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Members Moved Out", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Members with Callings", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Members without Callings", 4, rights, pageSource);
            // myBasePage.rightsCheck("Missionary Progress Record", 2, rights, pageSource);
            myBasePage.rightsCheckNewRights("New Members", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Temple Recommend Status", 6, rights, pageSource);
            myBasePage.rightsCheckNewRights("Unit Statistics", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Quarterly Report", 4, rights, pageSource);
            myBasePage.rightsCheckNewRights("Youth Recommend Status", 6, rights, pageSource);


            getMembersMovedInReport(rights);
            getMembersMovedOutReport(rights);
            getMembersWithCallings(rights);
            getMembersWithOutCallings(rights);
            getNewMembers(rights);
            getUnitStats(rights);

            //Bishopric Only Reports
            //Todo: Add youth temple recommend reports
            if (rights >= 6 ) {
                if (!getRunningOS().equalsIgnoreCase("ios")) {
                    getTempleRecommendStatus(rights);
                }
            }



        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }

    }
    
    
    
    
    
    

//    @Test (dataProvider = "Members", groups = {"all1", "all", "smoke", "smoke1", "report"})
    public void reportsBasic(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);


//        myHelper.loginUAT(userName, passWord);
        myHelper.proxyLogin(userName);
        myHelper.enterPin("1", "1", "3", "3");


        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();

            if (getRunningOS().equals("ios")) {
                //pageSource = myBasePage.getSourceOfPage();
            } else {
                //pageSource = pageSource + myBasePage.getSourceOfPage();
                //myBasePage.scrollDownTEST(800);
                myBasePage.scrollDownAndroidUIAutomator("0");
                pageSource = pageSource + myBasePage.getSourceOfPage();
                //myBasePage.scrollUp(300);
                myBasePage.scrollUpAndroidUIAutomator("0");

            }

            //Todo: change to an api call per user
            myBasePage.rightsCheck("Action and Interview List", 3, rights, pageSource);
            myBasePage.rightsCheck("Birthday List", 3, rights, pageSource);
            myBasePage.rightsCheck("Ministering", 3, rights, pageSource);
            myBasePage.rightsCheck("Members Moved In", 3, rights, pageSource);
            myBasePage.rightsCheck("Members Moved Out", 3, rights, pageSource);
            myBasePage.rightsCheck("Members with Callings", 3, rights, pageSource);
            myBasePage.rightsCheck("Members without Callings", 3, rights, pageSource);
           // myBasePage.rightsCheck("Missionary Progress Record", 2, rights, pageSource);
            myBasePage.rightsCheck("New Members", 3, rights, pageSource);
            myBasePage.rightsCheck("Temple Recommend Status", 1, rights, pageSource);
            myBasePage.rightsCheck("Unit Statistics", 3, rights, pageSource);
            myBasePage.rightsCheck("Quarterly Report", 3, rights, pageSource);
            myBasePage.rightsCheck("Youth Recommend Status", 1, rights, pageSource);



            //This will need to be removed soon
            //Assert.assertFalse(myBasePage.checkNoCaseList("quarterly", pageSource, "Contains"));

            getMembersMovedInReport(rights);
            getMembersMovedOutReport(rights);
            getMembersWithCallings(rights);
            getMembersWithOutCallings(rights);
            getNewMembers(rights);
            getUnitStats(rights);

            //Bishopric Only Reports
            if (rights <= 1 ) {

                if (!getRunningOS().equalsIgnoreCase("ios")) {
                    getTempleRecommendStatus(rights);
                }
            }



        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }


    }


    @Test (groups = {"all4", "all", "report", "daily", "daily2"})
    public void reportsActionAndInterviewBugCheck() throws Exception {
        String pageSource;


        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.reports);
        myReports.actionAndInterviewListReport.click();
        myReports.childrenApproachingBaptismAgeReport.click();

        Thread.sleep(2000);
        myBasePage.backButton.click();
        Thread.sleep(2000);
        myBasePage.backButton.click();
        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Action and Interview List", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthday List", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Members Moved In", pageSource, "Contains"));



    }

    @Test (groups = {"all2", "all", "report", "daily", "daily3"})
    public void reportsActionAndInterviewReports() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.reports);
        myReports.actionAndInterviewListReport.click();

        //Children Approaching Baptism Age
        myReports.childrenApproachingBaptismAgeReport.click();
        Thread.sleep(2000);

        checkActionAndInterviewApi("Children Approaching Baptism Age","kroqbandit", "21628");
        myBasePage.backButton.click();

        //Unbaptized Members
        myReports.unbaptizedMembersReport.click();
        Thread.sleep(2000);
        checkActionAndInterviewApi("Unbaptized Members","kroqbandit", "21628");
        myBasePage.backButton.click();


        //Overdue Aaronic Priesthood Ordinations
//        myBasePage.scrollToText("Overdue Aaronic Priesthood Ordinations");
        myReports.overdueAaronicPriesthoodOrdinationsReport.click();
        Thread.sleep(2000);
        checkActionAndInterviewApi("Overdue Aaronic Priesthood Ordinations","kroqbandit", "21628");
        myBasePage.backButton.click();

        //Young Single Adult Interview
//        myBasePage.scrollToText("Young Single Adult Interview");
        Thread.sleep(2000);
        myBasePage.scrollToTextSwipe("Young Single Adult Interview");
//        myBasePage.scrollDownTEST(1000);
        myReports.youngSingleAdultInterviewsReport.click();
        Thread.sleep(2000);
        checkActionAndInterviewApi("Young Single Adult Interviews","kroqbandit", "21628");
        myBasePage.backButton.click();

        //Bishops Youth Interviews
        myReports.bishopsYouthInterviewsReport.click();
        Thread.sleep(2000);
        checkActionAndInterviewApi("Bishop’s Youth Interviews","kroqbandit", "21628");
        myBasePage.backButton.click();

        //Bishops Counselor Youth Interviews
        myReports.bishopricCounselorYouthInterviewsReport.click();
        Thread.sleep(2000);
        checkActionAndInterviewApi("Bishopric Counselor Youth Interviews","kroqbandit", "21628");
        myBasePage.backButton.click();

        //TODO: Need to check if the report exists
        //Young Men Approaching Mission Age
//        myReports.youngMenApproachingMissionAgeReport.click();
//        Thread.sleep(2000);
//        checkActionAndInterviewApi("Young Men Approaching Mission Age","kroqbandit", "21628");
//        myBasePage.backButton.click();

        //Men Who Have Not Served a Mission
        myReports.menWhoHaveNotServedaMissionReport.click();
        Thread.sleep(2000);
        checkActionAndInterviewApi("Men Who Have Not Served a Mission","kroqbandit", "21628");
        myBasePage.backButton.click();


        //Potential Missionary Couples
        myReports.potentialMissionaryCouplesReport.click();
        Thread.sleep(2000);
        checkActionAndInterviewApi("Potential Missionary Couples","kroqbandit", "21628");
        myBasePage.backButton.click();

    }

    private void checkActionAndInterviewApi(String reportToCheck, String proxyLogin, String unitNumber) throws Exception {
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();
        List<String> shortList = new ArrayList<>();
        List<String> isoList = new ArrayList<>();
        BasePage myBasePage = new BasePage(driver);

        memberList = apiTest.getNamesActionAndInterviewReports(reportToCheck,proxyLogin, unitNumber);
        //Check to see if the list is greater than 5
        if (memberList.size() > 5) {
            //Just take the first 5 members in the list
            for (int i = 0; i < 4; i++ ) {
                shortList.add(memberList.get(i));
            }
        } else {
            shortList = memberList;
        }

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            isoList = myBasePage.swapLastNameCommaFirstName(shortList);
            shortList = isoList;
        }

        myBasePage.apiCheckData(shortList);
    }





    //There is no API for this
    @Test (groups = {"all3", "all", "report", "daily", "daily4", "jft"})
    public void reportsYouthRecommendStatus() throws Exception {
        String pageSource;


        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.reports);
        Thread.sleep(2000);

        if (!getRunningOS().equals("ios")) {
//            System.out.println(myBasePage.getSourceOfPage());
            myBasePage.scrollToTextRecyclerView("Youth Recommend Status");
        } else {
            myBasePage.scrollToTextiOS("Youth Recommend Status");
        }

//        System.out.println(myBasePage.getSourceOfPage());
        Thread.sleep(2000);
        myReports.youthRecommendStatusReport.click();
        Thread.sleep(2000);


        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Andrews", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Arce", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("2021", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Limited-Use", pageSource, "Contains"));

        //TODO: Need a way to test this for iOS. iOS does this very different.
        if (!getRunningOS().equals("ios")) {
            youthRecommendStatusActive();
            youthRecommendStatusExpiring();
            youthRecommendStatusExpired();
            youthRecommendStatusNeverIssued();
            youthRecommendStatusUnordained();
            youthRecommendStatusNotBaptized();
        }


    }



    private void youthRecommendStatusActive() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.activeSort.click();

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Laeci", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Batimana", pageSource, "Contains"));

    }

    private void youthRecommendStatusExpiring() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.expiringSort.click();

        pageSource = myBasePage.getSourceOfPage();

//        Assert.assertTrue(myBasePage.checkNoCaseList("Lesa", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Sisilia", pageSource, "Contains"));

    }

    private void youthRecommendStatusExpired() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.expiredSort.click();

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Anny", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Manu", pageSource, "Contains"));

    }

    private void youthRecommendStatusNeverIssued() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.neverIssuedSort.click();

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Auton", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("James", pageSource, "Contains"));

    }

    private void youthRecommendStatusUnordained() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.unordainedSort.click();

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Jose", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Barba", pageSource, "Contains"));

    }

    private void youthRecommendStatusNotBaptized() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.notBaptizedSort.click();

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Auton", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("James", pageSource, "Contains"));

    }


/*    @Test (dataProvider = "Members", groups = {"all3", "all", "smoke", "smoke3"})
    public void reportsMissionaryProgressRecord(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");


        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);
        Assert.assertTrue(myBasePage.checkNoCaseList("Ahmanson", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ward Assistant Clerk", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker, Anakin", pageSource, "Equals"));

        myReports.selectSort(myReports.organizationSort);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Obi-Wan", pageSource, "Equals"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi", pageSource, "Equals"));


        myReports.selectSort(myReports.durationSort);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Assistant Librarian", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Talanoa", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Amidala, Padme", pageSource, "Contains"));


        myReports.selectSort(myReports.notSetApartSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Young Women First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ryan, Ken", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("P0, C3", pageSource, "Contains"));
        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            //myMenu.reports.click();

            checkMissionaryProgressRecord();
            checkMissionaryProgressRecordVisits();
            checkMissionaryProgressRecordSacMeeting();
            MissionaryProgressRecordDetails();

        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }


    }*/

    //No API test
    private void getMembersMovedInReport(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersMovedInReport.click();
        Thread.sleep(3000);
        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);
//        Assert.assertTrue(myBasePage.checkNoCaseList("Vega", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker, Luke", pageSource, "Equals"));

        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);

    }

    private void getMembersMovedOutReport(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();
        List<String> shortList = new ArrayList<>();


        myReports.membersMovedOutReport.click();
        Thread.sleep(2000);

        memberList = apiTest.getNamesFromMembersMovedOut("kroqbandit", "21628");

        //Just take the first 5 members in the list
        for (int i = 0; i < 4; i++ ) {
            shortList.add(memberList.get(i));
        }

        myBasePage.apiCheckData(shortList);


        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    //No API method for this.
    private void getMembersWithCallings(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersWithCallingsReport.click();
        Thread.sleep(3000);

//        myBasePage.waitForText("Ahmanson");

        //This is broken for iOS right now
        if (!getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);
            Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Greeter", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker, Anakin", pageSource, "Equals"));

            myReports.selectSort(myReports.organizationSort);
            Thread.sleep(3000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Obi-Wan", pageSource, "Equals"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi", pageSource, "Equals"));


            myReports.selectSort(myReports.durationSort);
            Thread.sleep(3000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Resource", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Talanoa", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Amidala, Padme", pageSource, "Contains"));


            myReports.selectSort(myReports.notSetApartSort);
            Thread.sleep(3000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Deacons", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Ryan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("P0, C3", pageSource, "Contains"));
        }



        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backButton);
//        myBasePage.backButton.click();
        Thread.sleep(2000);
    }

    //No api method for this
    private void getMembersWithOutCallings(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersWithOutCallingsReport.click();
        Thread.sleep(5000);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
        }


//        System.out.println(pageSource);

        //This is broken for iOS right now
        if (!getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Dewayne", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Britney", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("D2, R2", pageSource, "Contains"));


            myReports.selectSort(myReports.maleSort);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Adams, Dewayne", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Aleman, Hector", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Binks, Jarjar", pageSource, "Contains"));


            myReports.selectSort(myReports.femaleSort);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Adams, Ascencion", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Organa, Leia", pageSource, "Contains"));
        }



        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    private void getNewMembers(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();
        List<String> shortList = new ArrayList<>();

        myReports.newMembersReport.click();
        Thread.sleep(1000);

        pageSource = myBasePage.getSourceOfPage();
        memberList = apiTest.getNewMembers("kroqbandit", "21628");
        java.util.Collections.sort(memberList);
//        myBasePage.apiCheckDataPageSource(memberList, pageSource);

        //Just take the first 5 members in the list
        for (int i = 0; i < 3; i++ ) {
            shortList.add(memberList.get(i));
        }
        myBasePage.apiCheckData(shortList);



        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    private void getUnitStats(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();

        if (!getRunningOS().equals("ios")) {
            Thread.sleep(2000);
            myBasePage.scrollToTextRecyclerView("Unit Statistics");
            Thread.sleep(2000);
        } else {
            myBasePage.scrollToTextiOS("Unit Statistics");
            Thread.sleep(1000);
        }

        myReports.unitStatisticsReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();

        memberList = apiTest.getReportUnitStatsNumbers("kroqbandit", "21628");
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

//        myBasePage.rightsCheck("21", 3, rights, pageSource);


        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }


    //No api method for this
    private void getTempleRecommendStatus(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }


        myReports.templeRecommendStatusReport.click();
        Thread.sleep(1000);

        if (getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Alvaira"));
            Assert.assertFalse(pageSource.contains("Ahsoka, Tano"));
        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Alvaira", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ahsoka, Tano", pageSource, "Contains"));
        }

//        pageSource = myBasePage.getSourceOfPage();
////        System.out.println(pageSource);
//        Assert.assertTrue(myBasePage.checkNoCaseList("Alvaira", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Ahsoka, Tano", pageSource, "Contains"));


        myReports.selectFilters(myReports.activeSort);
        Thread.sleep(1000);

        if (getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Anderson"));
            Assert.assertFalse(pageSource.contains("Maul, Darth"));
        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Maul, Darth", pageSource, "Contains"));
        }

//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Maul, Darth", pageSource, "Contains"));

        myReports.selectFilters(myReports.expiringSort);
        Thread.sleep(1000);

        if (getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Expiring"));
            Assert.assertFalse(pageSource.contains("Windu, Mace"));
        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Expiring", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Windu, Mace", pageSource, "Contains"));
        }

//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Expiring", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Windu, Mace", pageSource, "Contains"));

        myReports.selectFilters(myReports.expiredSort);
        Thread.sleep(1000);

        if (getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Banuelos"));
            Assert.assertFalse(pageSource.contains("Jinn, Qui-Gon"));
        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Crego", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Jinn, Qui-Gon", pageSource, "Contains"));
        }


//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Alvaira", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Jinn, Qui-Gon", pageSource, "Contains"));

        myReports.selectFilters(myReports.otherSort);
        Thread.sleep(1000);

        if (getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Del Real Cortes"));
            Assert.assertFalse(pageSource.contains("Calrissian, Lando"));
        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Silva", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Calrissian, Lando", pageSource, "Contains"));
        }


//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Del Real Cortes", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Calrissian, Lando", pageSource, "Contains"));


        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }



    private void checkMissionaryProgressRecord() throws Exception {
        //*************************************************************************************
        //********************* Missionary Progress Record ************************************
        //*************************************************************************************
        List<String> myList = new ArrayList<String>();
        List<String> androidList = new ArrayList<String>();
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


        Thread.sleep(2000);
        myReports.missionaryProgressRecordReport.click();
        pageSource = myBasePage.getSourceOfPage();
        //Assert.assertTrue(checkNoCaseList("Potential Investigator", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Malcolm Reynolds", pageSource, "Contains"));

        myWeb.WPRopenPageLogIn("https://missionary-stage.lds.org/ward-missionary-tools", "ab253", "pa$$w0rd0");
        myList = myWeb.WPRgetUsers("none", false);
        myList = myBasePage.swapLastName(myList);


        myBasePage.compareWebData(myList, androidList, false);

        //Investigators with Baptism Date
        myReports.missionaryProgressFilter.click();
        myReports.mpInvestigatorsWithBaptismDate.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsers("Investigators with Baptism Date", false);
        myList = myBasePage.swapLastName(myList);

        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("People with Baptism Date", pageSource, "Contains"));

        myReports.mpRemoveFilterButton.click();


        //Progressing Investigators
        myReports.missionaryProgressFilter.click();
        myReports.mpProgressingInvestigators.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsers("Progressing Investigators", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("People being taught", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        myReports.mpRemoveFilterButton.click();


        //New Investigators
        myReports.missionaryProgressFilter.click();
        myReports.mpNewInvestigators.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsers("New Investigators", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("New Investigators", pageSource, "Contains"));

        myReports.mpRemoveFilterButton.click();

        //Other Investigators
        myReports.missionaryProgressFilter.click();
        myReports.mpOtherInvestigators.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsers("Other Investigators", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Other Investigators", pageSource, "Contains"));

        myReports.mpRemoveFilterButton.click();



        //Potential Investigators
        myReports.missionaryProgressFilter.click();
        myReports.mpPotentialInvestigators.click();

        myReports.saveMissonaryProgressFilter();


        myList = myWeb.WPRgetUsers("Potential Investigators", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Potential Investigators", pageSource, "Contains"));
        if (getRunningOS().equals("ios")) {
            myBasePage.scrollUpIOS();
        }

        myReports.mpRemoveFilterButton.click();

        //Recent Converts
        myReports.missionaryProgressFilter.click();
        myReports.mpRecentConverts.click();

        myReports.saveMissonaryProgressFilter();


        myList = myWeb.WPRgetUsers("Recent Converts", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Recent Converts", pageSource, "Contains"));

        myReports.mpRemoveFilterButton.click();

        //Members Being Taught
        myReports.missionaryProgressFilter.click();
        myReports.mpMembersBeingTaught.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsers("Members", true);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Members Being Taught", pageSource, "Contains"));

        myReports.mpRemoveFilterButton.click();


        Thread.sleep(1000);
        myBasePage.backButton.click();

        //*************************************************************************************
        //*************************************************************************************
        //*************************************************************************************
    }


    private void checkMissionaryProgressRecordVisits() throws Exception {

        String pageSource;
        List<String> myList = new ArrayList<String>();
        List<String> androidList = new ArrayList<String>();

        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


        Thread.sleep(2000);
        myReports.missionaryProgressRecordReport.click();

        pageSource = myBasePage.getSourceOfPage();

        myWeb.WPRopenPageLogIn("https://missionary-stage.lds.org/ward-missionary-tools", "ab253", "pa$$w0rd0");

        //******************
        //Visits - Last Week
        //******************
        myReports.missionaryProgressFilter.click();
        myReports.mpReceivedAVisit.click();
        myReports.mpLastWeek.click();

        myReports.saveMissonaryProgressFilter();


        myList = myWeb.WPRgetUsersVisits("WPRLastWeek", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);

        myReports.mpRemoveFilterButton.click();

        //******************
        //Visits - Last 2 weeks
        //******************
        myReports.missionaryProgressFilter.click();
        myReports.mpReceivedAVisit.click();
        myReports.mpLast2Weeks.click();

        myReports.saveMissonaryProgressFilter();


        myList = myWeb.WPRgetUsersVisits("WPRLast2Weeks", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);

        myReports.mpRemoveFilterButton.click();

        //******************
        //Visits - Last 3 weeks
        //******************
        myReports.missionaryProgressFilter.click();
        myReports.mpReceivedAVisit.click();
        myReports.mpLast3Weeks.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsersVisits("WPRLast3Weeks", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);

        myReports.mpRemoveFilterButton.click();

        //******************
        //Visits - Last 4 weeks
        //******************
        myReports.missionaryProgressFilter.click();
        myReports.mpReceivedAVisit.click();
        myReports.mpLast4Weeks.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsersVisits("WPRLast4Weeks", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);

        myReports.mpRemoveFilterButton.click();

        //******************
        //Visits - Last 5 weeks
        //******************
        myReports.missionaryProgressFilter.click();
        myReports.mpReceivedAVisit.click();
        myReports.mpLast5Weeks.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsersVisits("WPRLast5Weeks", true);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);

        myReports.mpRemoveFilterButton.click();

        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);

    }

    private void MissionaryProgressRecordDetails() throws Exception {
        String pageSource;
        List<String> myList = new ArrayList<String>();
        List<String> androidList = new ArrayList<String>();
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


        Thread.sleep(2000);
        myReports.missionaryProgressRecordReport.click();

        pageSource = myBasePage.getSourceOfPage();

        myWeb.WPRopenPageLogIn("https://missionary-stage.lds.org/ward-missionary-tools", "ab253", "pa$$w0rd0");
        myList = myWeb.WPRgetUsers("none", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);

        //Todo: need to check for record then select that record
        //Todo: Wait for Missionary Progress!
//        for(String oneUser : myList){
//            myBasePage.scrollDownTEST(400);
//            clickButton(oneUser, "text", "nameContains");
//
//            pageSource = myBasePage.getSourceOfPage();
//            if (getRunningOS().equals("ios")) {
//                //Assert.assertTrue(checkNoCaseList("Add to Contacts", pageSource, "Contains"));
//            } else {
//                //Assert.assertTrue(checkNoCaseList("Contact Information", pageSource, "Contains"));
//            }
//
//
//        }
        myBasePage.backButton.click();
    }



    private void scrollToSacMeetingAttendance() throws Exception {
        BasePage myBasePage = new BasePage(driver);
        if (!getRunningOS().equals("ios")) {
            //myBasePage.scrollToText("Attended Sacrament");
            myBasePage. scrollToTextTopLayout("Attended Sacrament");

        }
    }

    private void checkMissionaryProgressFilterVisitsSub(MobileElement appFilter, String webFitler) throws Exception {
        List<String> myList = new ArrayList<String>();
        List<String> androidList = new ArrayList<String>();
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.missionaryProgressFilter.click();
        Thread.sleep(2000);
        scrollToSacMeetingAttendance();
        myReports.mpAttendedSacrament.click();
        appFilter.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetSacMeeting(webFitler, false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);

        myReports.mpRemoveFilterButton.click();
    }



    private void checkMissionaryProgressRecordSacMeeting() throws Exception {
        String pageSource;
        List<String> myList = new ArrayList<String>();
        List<String> androidList = new ArrayList<String>();
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


        Thread.sleep(2000);
        myReports.missionaryProgressRecordReport.click();


        myWeb.WPRopenPageLogIn("https://missionary-stage.lds.org/ward-missionary-tools", "ab253", "pa$$w0rd0");

        //******************
        //Sacrament Meeting Attendance - Last Week
        //******************
        checkMissionaryProgressFilterVisitsSub(myReports.mpLastWeek, "WPRSacLastSunday");

        //******************
        //Sacrament Meeting Attendance - Last 2 weeks
        //******************
        checkMissionaryProgressFilterVisitsSub(myReports.mpLast2Weeks, "WPRSacLast2Weeks");

        //******************
        //Sacrament Meeting Attendance - Last 3 weeks
        //******************
        checkMissionaryProgressFilterVisitsSub(myReports.mpLast3Weeks, "WPRSacLast3Weeks");

        //******************
        //Sacrament Meeting Attendance - Last 4 weeks
        //******************
        checkMissionaryProgressFilterVisitsSub(myReports.mpLast4Weeks, "WPRSacLast4Weeks");

        //******************
        //Sacrament Meeting Attendance - Last 5 weeks
        //******************
        checkMissionaryProgressFilterVisitsSub(myReports.mpLast5Weeks, "WPRSacLast5Weeks");


        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);

    }





}
