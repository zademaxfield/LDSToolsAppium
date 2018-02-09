package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ReportsScreenTest extends BaseDriver {

    @Test (dataProvider = "Members", groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void reportsSimple(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");
        if (myBasePage.getOS().equals("mac")) {
            myWhatsNew.whatsNewDone.click();
        }


        if (rights <= 3) {
            myMenu.reports.click();

            pageSource = myBasePage.getSourceOfPage();

            if (getRunningOS().equals("mac")) {
                pageSource = myBasePage.getSourceOfPage();
            } else {
                pageSource = pageSource + myBasePage.getSourceOfPage();
                myBasePage.scrollDownTEST(800);
                pageSource = pageSource + myBasePage.getSourceOfPage();
            }


            myBasePage.rightsCheck("Action and Interview List", 2, rights, pageSource);
            myBasePage.rightsCheck("Birthday List", 2, rights, pageSource);
            myBasePage.rightsCheck("Home Teaching", 2, rights, pageSource);
            myBasePage.rightsCheck("Members Moved In", 2, rights, pageSource);
            myBasePage.rightsCheck("Members Moved Out", 2, rights, pageSource);
            myBasePage.rightsCheck("Members with Callings", 2, rights, pageSource);
            myBasePage.rightsCheck("Members without Callings", 2, rights, pageSource);
            myBasePage.rightsCheck("Missionary Progress Record", 2, rights, pageSource);
            myBasePage.rightsCheck("New Members", 2, rights, pageSource);
            myBasePage.rightsCheck("Temple Recommend Status", 1, rights, pageSource);
            myBasePage.rightsCheck("Unit Statistics", 2, rights, pageSource);
            myBasePage.rightsCheck("Visiting Teaching", 2, rights, pageSource);

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

    private void getMembersMovedInReport(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.membersMovedInReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
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
        myBasePage.rightsCheck("Wilson", 2, rights, pageSource);
        myBasePage.rightsCheck("New Unit", 1, rights, pageSource);
        myBasePage.rightsCheck("Saipipi", 1, rights, pageSource);

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
        Assert.assertTrue(myBasePage.checkNoCaseList("Kitara, Lafaele", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami, Samu", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi, Obi-Wan", pageSource, "Equals"));


        myReports.selectSort(myReports.durationSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Sunday School President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lealaiauloto, Uana Iosefa Sao", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Amidala, Padme", pageSource, "Contains"));


        myReports.selectSort(myReports.notSetApartSort);
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("High Priests Group First Assistant", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS17", pageSource, "Contains"));
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
        myBasePage.rightsCheck("April 16, 2017", 1, rights, pageSource);

        Thread.sleep(1000);
        myBasePage.backButton.click();
        Thread.sleep(1000);
    }

    //Todo: need more tests
    private void getUnitStats(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        ReportsScreen myReports = new ReportsScreen(driver);

        myReports.unitStatisticsReport.click();
        Thread.sleep(1000);
        pageSource = myBasePage.getSourceOfPage();
        myBasePage.rightsCheck("19", 2, rights, pageSource);


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
        Assert.assertTrue(myBasePage.checkNoCaseList("Kitara, Seigafo", pageSource, "Contains"));
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







}
