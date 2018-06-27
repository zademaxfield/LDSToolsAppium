package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ReportsScreenTest extends BaseDriver {

    @Test (dataProvider = "Members", groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void reportsBasic(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");


        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);

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


            myBasePage.rightsCheck("Action and Interview List", 2, rights, pageSource);
            myBasePage.rightsCheck("Birthday List", 2, rights, pageSource);
            myBasePage.rightsCheck("Ministering", 2, rights, pageSource);
            myBasePage.rightsCheck("Members Moved In", 2, rights, pageSource);
            myBasePage.rightsCheck("Members Moved Out", 2, rights, pageSource);
            myBasePage.rightsCheck("Members with Callings", 2, rights, pageSource);
            myBasePage.rightsCheck("Members without Callings", 2, rights, pageSource);
            myBasePage.rightsCheck("Missionary Progress Record", 2, rights, pageSource);
            myBasePage.rightsCheck("New Members", 2, rights, pageSource);
            myBasePage.rightsCheck("Temple Recommend Status", 1, rights, pageSource);
            myBasePage.rightsCheck("Unit Statistics", 2, rights, pageSource);
            myBasePage.rightsCheck("Quarterly Report", 2, rights, pageSource);

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
                getTempleRecommendStatus(rights);
            }



        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }


    }

    @Test (dataProvider = "Members", groups = {"all3", "all", "smoke", "smoke3"})
    public void reportsMissionaryProgressRecord(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



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


    }

    private void getMembersMovedInReport(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersMovedInReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Young", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker, Luke", pageSource, "Equals"));

        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);

    }

    private void getMembersMovedOutReport(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersMovedOutReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        myBasePage.rightsCheck("Patiole", 2, rights, pageSource);
        myBasePage.rightsCheck("New Unit", 1, rights, pageSource);
        myBasePage.rightsCheck("Venasio", 1, rights, pageSource);

        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    private void getMembersWithCallings(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersWithCallingsReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron, Jane", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Relief Society", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker, Anakin", pageSource, "Equals"));

        myReports.selectSort(myReports.organizationSort);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Ward Clerk", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tutunoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami, Samu", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi, Obi-Wan", pageSource, "Equals"));


        myReports.selectSort(myReports.durationSort);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Sunday School President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lealaiauloto, Uana Iosefa Sao", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Amidala, Padme", pageSource, "Contains"));


        myReports.selectSort(myReports.notSetApartSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS22", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("P0, C3", pageSource, "Contains"));


        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    private void getMembersWithOutCallings(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersWithOutCallingsReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEleven, Member", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("D2, R2", pageSource, "Contains"));


        myReports.selectSort(myReports.maleSort);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEleven, Member", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPMisc, Member1", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Binks, Jarjar", pageSource, "Contains"));


        myReports.selectSort(myReports.femaleSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Organa, Leia", pageSource, "Contains"));


        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    private void getNewMembers(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.newMembersReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        myBasePage.rightsCheck("Manumalo, Siui", 2, rights, pageSource);
        myBasePage.rightsCheck("32", 2, rights, pageSource);
        myBasePage.rightsCheck("April 15, 2018", 1, rights, pageSource);

        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    //Todo: need more tests
    private void getUnitStats(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        if (!getRunningOS().equals("ios")) {
            myBasePage.scrollToTextRecyclerView("Unit Statistics");
        }


        myReports.unitStatisticsReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        myBasePage.rightsCheck("17", 2, rights, pageSource);


        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    private void getTempleRecommendStatus(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.templeRecommendStatusReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPSix, Husband", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Ahsoka, Tano", pageSource, "Contains"));


        myReports.selectSort(myReports.activeSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami, Faleatafa", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Maul, Darth", pageSource, "Contains"));

        myReports.selectSort(myReports.expiringSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Windu, Mace", pageSource, "Contains"));

        myReports.selectSort(myReports.expiredSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Sitivi", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Jinn, Qui-Gon", pageSource, "Contains"));

        myReports.selectSort(myReports.otherSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Kitara, June", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Calrissian, Lando", pageSource, "Contains"));


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
        Assert.assertTrue(myBasePage.checkNoCaseList("Investigators with Baptism Date", pageSource, "Contains"));

        myReports.mpRemoveFilterButton.click();


        //Progressing Investigators
        myReports.missionaryProgressFilter.click();
        myReports.mpProgressingInvestigators.click();

        myReports.saveMissonaryProgressFilter();

        myList = myWeb.WPRgetUsers("Progressing Investigators", false);
        myList = myBasePage.swapLastName(myList);
        myBasePage.compareWebData(myList, androidList, false);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Progressing Investigators", pageSource, "Contains"));
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
