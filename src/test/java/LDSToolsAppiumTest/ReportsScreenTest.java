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

    @Test (dataProvider = "Members", groups = {"all1", "all", "smoke", "smoke1", "report", "jft"})
    public void reportsBasic(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
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


            myBasePage.rightsCheck("Action and Interview List", 3, rights, pageSource);
            myBasePage.rightsCheck("Birthday List", 3, rights, pageSource);
            myBasePage.rightsCheck("Ministering", 2, rights, pageSource);
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

                //TODO: iOS getting the source of page isn't working
                if (!getRunningOS().equalsIgnoreCase("ios")) {
                    getTempleRecommendStatus(rights);
                }
            }



        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }


    }


    @Test (groups = {"all4", "all", "report"})
    public void reportsActionAndInterviewBugCheck() throws Exception {
        String pageSource;


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.reports);
        myReports.actionAndInterviewListReport.click();
        myReports.childrenApproachingBaptismAgeReport.click();

        myBasePage.backButton.click();
        myBasePage.backButton.click();
        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Action and Interview List", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthday List", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Members Moved In", pageSource, "Contains"));



    }


    @Test (groups = {"all4", "all", "report"})
    public void reportsActionAndInterviewReports() throws Exception {
        String pageSource;


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.reports);
        myReports.actionAndInterviewListReport.click();

        //Children Approaching Baptism Age
        myReports.childrenApproachingBaptismAgeReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Guadalope", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Viveros", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 26", pageSource, "Contains"));
        myBasePage.backButton.click();

        //Unbaptized Members
        myReports.unbaptizedMembersReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("James", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Auton", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("May 16", pageSource, "Contains"));
        myBasePage.backButton.click();


        //Overdue Aaronic Priesthood Ordinations
//        myBasePage.scrollToText("Overdue Aaronic Priesthood Ordinations");
        myReports.overdueAaronicPriesthoodOrdinationsReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Camryn", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Estrada", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 21", pageSource, "Contains"));
        myBasePage.backButton.click();

        //Young Single Adult Interview
//        myBasePage.scrollToText("Young Single Adult Interview");
        Thread.sleep(2000);
        myBasePage.scrollToTextSwipe("Young Single Adult Interview");
//        myBasePage.scrollDownTEST(1000);
        myReports.youngSingleAdultInterviewsReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Cortrell", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Clayton", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("January 22", pageSource, "Contains"));
        myBasePage.backButton.click();

        //Bishops Youth Interviews
        myReports.bishopsYouthInterviewsReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Tyson", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Crumby", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("February 1", pageSource, "Contains"));
        myBasePage.backButton.click();

        //Bishops Counselor Youth Interviews
        myReports.bishopricCounselorYouthInterviewsReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Joseph", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Dedman", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("July 10", pageSource, "Contains"));
        myBasePage.backButton.click();

        //Young Men Approaching Mission Age
        myReports.youngMenApproachingMissionAgeReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Christopher", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Viveros", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("June 2", pageSource, "Contains"));
        myBasePage.backButton.click();

        //Men Who Have Not Served a Mission
        myReports.menWhoHaveNotServedaMissionReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Max", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Wedekind", pageSource, "Contains"));
        myBasePage.backButton.click();


        //Potential Missionary Couples
        myReports.potentialMissionaryCouplesReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Nick", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Pamela", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Bridgeman", pageSource, "Contains"));
        myBasePage.backButton.click();


    }






    @Test (groups = {"all3", "all", "report"})
    public void reportsYouthRecommendStatus() throws Exception {
        String pageSource;


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReports = new ReportsScreen(driver);


//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.reports);
        Thread.sleep(2000);

        if (!getRunningOS().equals("ios")) {
            myBasePage.scrollToTextRecyclerView("Youth Recommend Status");
        } else {
            myBasePage.scrollToTextiOS("Youth Recommend Status");
        }

        myReports.youthRecommendStatusReport.click();
        Thread.sleep(2000);


        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Arce", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Malakhi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("May 2020", pageSource, "Contains"));
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

        Assert.assertTrue(myBasePage.checkNoCaseList("Arce", pageSource, "Contains"));
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

        Assert.assertTrue(myBasePage.checkNoCaseList("Dedman", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ammon", pageSource, "Contains"));

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

        Assert.assertTrue(myBasePage.checkNoCaseList("Cayetamo", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Crumby", pageSource, "Contains"));

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


        HelperMethods myHelper = new HelperMethods(driver);
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

        myReports.membersMovedOutReport.click();
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        myBasePage.rightsCheck("Smith", 3, rights, pageSource);
//        myBasePage.rightsCheck("New Unit", 1, rights, pageSource);
//        myBasePage.rightsCheck("Pesega", 1, rights, pageSource);

        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

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
            Assert.assertTrue(myBasePage.checkNoCaseList("Deacons", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Smith", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("P0, C3", pageSource, "Contains"));
        }



        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backButton);
//        myBasePage.backButton.click();
        Thread.sleep(2000);
    }

    private void getMembersWithOutCallings(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersWithOutCallingsReport.click();
        pageSource = myBasePage.getSourceOfPage();

//        System.out.println(pageSource);

        //This is broken for iOS right now
        if (!getRunningOS().equalsIgnoreCase("ios")) {

            Assert.assertTrue(myBasePage.checkNoCaseList("Abah", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("John", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Fredrick", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("D2, R2", pageSource, "Contains"));


            myReports.selectSort(myReports.maleSort);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Adams, Dewayne", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Abah, John Fredrick", pageSource, "Contains"));
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

        myReports.newMembersReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
//        myBasePage.rightsCheck("Casas, Sarai", 3, rights, pageSource);
//        myBasePage.rightsCheck("19", 3, rights, pageSource);

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
        } else {
            myBasePage.scrollToTextiOS("Unit Statistics");
        }


        myReports.unitStatisticsReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        myBasePage.rightsCheck("21", 3, rights, pageSource);


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
//        System.out.println(pageSource);
        Assert.assertTrue(myBasePage.checkNoCaseList("Alvaira", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Ahsoka, Tano", pageSource, "Contains"));


        myReports.selectFilters(myReports.activeSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Maul, Darth", pageSource, "Contains"));

        myReports.selectFilters(myReports.expiringSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Expiring", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Windu, Mace", pageSource, "Contains"));

        myReports.selectFilters(myReports.expiredSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Alvaira", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Jinn, Qui-Gon", pageSource, "Contains"));

        myReports.selectFilters(myReports.otherSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Del Real Cortes", pageSource, "Contains"));
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
