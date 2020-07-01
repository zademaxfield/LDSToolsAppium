package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MinisteringScreenTest extends BaseDriver {

    @Test (groups = {"all2", "all", "smoke", "smoke2"})
    public void ministeringBasic_BISHOP() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(1);
    }

    @Test (groups = {"all2", "all"})
    public void ministeringBasic_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Camerado65");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("soldiercloudstrife");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_WARD_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("luke.ravitch");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_WARD_ASSISTANT_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("jdahmanson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_WARD_EXECUTIVE_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("iansalas");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_MEMBER1() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_MEMBER2() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_ELDERS_QUORUM_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("gabrielsmith");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Aloeb1013");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_ELDERS_QUORUM_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("murillodavid");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("bridgemp");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("blairlolohea");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_WOMEN_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_WARD_MISSION_LEADER() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheck(3);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public void ministeringBasicCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));


            myMinistering.ministeringBrothersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Households", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));

            myBasePage.backButton.click();

            myMinistering.ministeringSistersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Sisters", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Sisters", pageSource, "Contains"));

            myBasePage.backButton.click();

        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }




    @Test (groups = {"all4", "all"})
    public void ministeringUnassignedHouseholds_BISHOP() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(1);
    }

    @Test (groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Camerado65");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("soldiercloudstrife");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_WARD_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("luke.ravitch");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_WARD_ASSISTANT_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("jdahmanson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_WARD_EXECUTIVE_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("iansalas");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_MEMBER1() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_MEMBER2() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("gabrielsmith");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Aloeb1013");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("murillodavid");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("bridgemp");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("blairlolohea");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_WOMEN_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_WARD_MISSION_LEADER() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheck(3);
    }

    public void ministeringUnassignedHouseholdsCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedHouseholds.click();
            Thread.sleep(2000);

            //For some reason the pageSource is broken for this page in iOS.
            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPageIDB();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


            myBasePage.waitForElementThenClick(myBasePage.backButton);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backButton);


            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedSisters.click();
            Thread.sleep(4000);


            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPageIDB();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


            myBasePage.waitForElementThenClick(myBasePage.backButton);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backButton);
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    @Test (groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_BISHOP() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(1);
    }

    @Test (groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("fiti");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Camerado65");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_WARD_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("luke.ravitch");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_WARD_ASSISTANT_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("jdahmanson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_WARD_EXECUTIVE_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("iansalas");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_MEMBER1() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_MEMBER2() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_ELDERS_QUORUM_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("gabrielsmith");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Aloeb1013");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_ELDERS_QUORUM_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("murillodavid");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("bridgemp");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("blairlolohea");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_WOMEN_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_WARD_MISSION_LEADER() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheck(3);
    }

    public void ministeringAssignedHouseholdsCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();
            myMinistering.assignedHouseholds.click();

            Thread.sleep(2000);

            //For some reason the pageSource is broken for this page in iOS.
            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPageIDB();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }

        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (groups = {"all3", "all", "smoke", "smoke3"})
    public void companionshipsElders_BISHOP() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(1);
    }

    @Test (groups = {"all2", "all"})
    public void companionshipsElders_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Camerado65");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("soldiercloudstrife");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_WARD_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("luke.ravitch");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_WARD_ASSISTANT_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("jdahmanson");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_WARD_EXECUTIVE_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("iansalas");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_MEMBER1() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_MEMBER2() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_ELDERS_QUORUM_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("gabrielsmith");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Aloeb1013");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_ELDERS_QUORUM_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("murillodavid");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("bridgemp");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("blairlolohea");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_WOMEN_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_WARD_MISSION_LEADER() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheck(3);
    }


    public void companionshipsEldersCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();


            myMinistering.validateDistrict("EQ President");
            myMinistering.validateDistrict("First Counselor");
            myMinistering.validateDistrict("Second Counselor");

            //Select District 1
            myMinistering.selectDistrict("EQ President");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Bryson", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Darth", pageSource, "Contains"));

            myBasePage.backButton.click();

            //Select District 2
            myMinistering.selectDistrict("First Counselor");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Lambson", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Smith", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));

            myBasePage.backButton.click();

            //Select District 3
            myMinistering.selectDistrict("Second Counselor");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Ryan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Solo", pageSource, "Contains"));

            myBasePage.backButton.click();
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    @Test (groups = {"all1", "all"})
    public void unassignedSisters_BISHOP() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(1, "bishopric");
    }

    @Test (groups = {"all2", "all"})
    public void unassignedSisters_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("fiti");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(1, "bishopric");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Camerado65");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(1, "bishopric");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_WARD_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("luke.ravitch");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(1, "bishopric");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_WARD_ASSISTANT_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("jdahmanson");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(1, "bishopric");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_WARD_EXECUTIVE_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("iansalas");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(1, "bishopric");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_MEMBER1() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(4, "member");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_MEMBER2() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(4, "member");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_ELDERS_QUORUM_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(2, "elders");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("gabrielsmith");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(2, "elders");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Aloeb1013");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(2, "elders");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_ELDERS_QUORUM_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("murillodavid");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(2, "elders");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("bridgemp");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(2, "relief");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("blairlolohea");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(2, "relief");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(2, "relief");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(3, "wardcouncil");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_WOMEN_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(3, "wardcouncil");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(3, "wardcouncil");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_WARD_MISSION_LEADER() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheck(3, "wardcouncil");
    }

    public void unassignedSistersCheck(int rights, String calling) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);

            if (calling.equals("elders") || (calling.equals("wardcouncil"))) {
                if (getRunningOS().equals("ios")) {
                    myMinistering.unassignedSisters.click();
                    Thread.sleep(2000);
                    pageSource = myBasePage.getSourceOfPageIDB();
                    Assert.assertTrue(pageSource.contains("Adams"));
                    Assert.assertFalse(pageSource.contains("Skywalker"));
                } else {
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertFalse(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));
                }
            } else {
                myMinistering.unassignedSisters.click();
                Thread.sleep(2000);
                //For some reason the pageSource is broken for this page in iOS.
                if (getRunningOS().equalsIgnoreCase("ios")) {
                    pageSource = myBasePage.getSourceOfPageIDB();
                    Assert.assertTrue(pageSource.contains("Adams"));
                    Assert.assertFalse(pageSource.contains("Skywalker"));
                } else {
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                    Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
                }

            }
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    @Test (groups = {"all4", "all", "smoke", "smoke4", "jft"})
    public void ministeringAssignedSisters_BISHOP() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(1);
    }

    @Test (groups = {"all2", "all"})
    public void ministeringAssignedSisters_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("fiti");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Camerado65");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_WARD_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("luke.ravitch");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_WARD_ASSISTANT_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("jdahmanson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_WARD_EXECUTIVE_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("iansalas");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_MEMBER1() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_MEMBER2() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_ELDERS_QUORUM_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("gabrielsmith");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Aloeb1013");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_ELDERS_QUORUM_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("murillodavid");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("bridgemp");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("blairlolohea");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_WOMEN_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_WARD_MISSION_LEADER() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheck(3);
    }

    public void ministeringAssignedSistersCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.assignedSisters.click();

            Thread.sleep(2000);

            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPageIDB();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Binks", pageSource, "Contains"));
            }


        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (groups = {"all4", "all"})
    public void companionshipsSisters_BISHOP() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(1);
    }

    @Test (groups = {"all2", "all"})
    public void companionshipsSisters_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Camerado65");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("soldiercloudstrife");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_WARD_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("luke.ravitch");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_WARD_ASSISTANT_CLERK() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("jdahmanson");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_WARD_EXECUTIVE_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("iansalas");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(1);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_MEMBER1() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_MEMBER2() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(4);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_ELDERS_QUORUM_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("gabrielsmith");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Aloeb1013");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_ELDERS_QUORUM_SECRETARY() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("murillodavid");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("bridgemp");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("blairlolohea");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(2);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_WOMEN_SECOND_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(3);
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_WARD_MISSION_LEADER() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);
        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(3);
    }

    public void companionshipsSistersCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();

            myMinistering.validateDistrict("RS - 1st Counselor");
            myMinistering.validateDistrict("RS - 2nd Counselor");

            //Select District 1
            myMinistering.selectDistrict("RS - 1st Counselor");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            myBasePage.backButton.click();

            //Select District 2
            myMinistering.selectDistrict("RS - 2nd Counselor");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            myBasePage.backButton.click();
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }

    }




    private void assignedMinisteringBrothers() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.assignedMinisteringBrothers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPTen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.assignedMinisteringBrothers);

    }

    private void notAssignedMinisteringBrothers() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.notAssignedMinisteringBrothers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Han Solo", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.notAssignedMinisteringBrothers);

    }

    private void newAndMovedInMembers() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.newAndMovedInMembers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Mene", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.newAndMovedInMembers);

    }

    private void ssAges18to30() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Fagaesea", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Yoda", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAges18to30);

    }

    private void ssAge32AndOlder() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);
        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Mace", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAge31AndOver);

    }

    private void sbAges18to30() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleBrothersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleBrothersAges18to30);

    }

    private void sbAge32AndOlder() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleBrothersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEleven", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleBrothersAge31AndOver);

    }



    //******************* SISTERS **************************


    private void assignedMinisteringSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.assignedMinisteringSisters.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Bond", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.assignedMinisteringSisters);

    }

    private void notAssignedMinisteringSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.notAssignedMinisteringSisters.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.notAssignedMinisteringSisters);

    }

    private void newAndMovedInMembersSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.newAndMovedInMembers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Mene", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.newAndMovedInMembers);

    }

    private void ssAges18to30Sisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);


        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAges18to30);

    }

    private void ssAge32AndOlderSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAge31AndOver);

    }




    private void clearFilter(MobileElement myElement) throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        if (getRunningOS().equals("ios")) {
            myMinistering.filters.click();
            myElement.click();
            myBasePage.backButton.click();
        } else {
            Thread.sleep(1000);
            //myMinistering.ministeringExpandFilter.click();
            //Thread.sleep(9000);
            myMinistering.ministeringRemoveFilter.click();
        }
    }






}
