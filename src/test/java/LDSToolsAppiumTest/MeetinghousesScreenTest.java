package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MeetinghousesScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MeetinghousesScreenTest extends BaseDriver {



    @Test(groups = {"smoke3", "smoke", "all3", "all", "jft"})
    public void meetinghousesSimpleTest() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MeetinghousesScreen myMeetinghouses = new MeetinghousesScreen(driver);
        BasePage myBasePage = new BasePage(driver);



        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.meetinghouses);

        myMeetinghouses.meetinghousesAllow.click();
        Thread.sleep(5000);
        if (!getRunningOS().equals("ios")) {
            driver.switchTo().alert();
            myMeetinghouses.meetinghousesAllowAndroidPermissions.click();
        }


        Thread.sleep(15000);

        myMeetinghouses.meetinghousesCurrentLocation.click();

        Thread.sleep(5000);

//        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);

        myMeetinghouses.meetinghouseSearch("12691 South 3600 West Rivertion UT");


        Thread.sleep(3000);

//        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);

        myMeetinghouses.selectMeetinghouse();
        Thread.sleep(3000);

        myMeetinghouses.openMeetinghouseDetails("Meetinghouse, 12691 South 3600 West");


        Thread.sleep(2000);

        pageSource = myMeetinghouses.getMeetinghouseDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList("1 801-253-7085", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("12691 South 3600 West", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("RIVERTON, Utah", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Wards", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Riverton 24th Ward (Tongan)", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament meeting:", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("9:00 am", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Castlewood Ward", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("10:30 am", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Riverton 19th Ward", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("12:00 pm", pageSource, "Contains"));

        myBasePage.checkForElement(myMeetinghouses.directionIcon);

        //TODO: Select Each ward and check data



    }



}
