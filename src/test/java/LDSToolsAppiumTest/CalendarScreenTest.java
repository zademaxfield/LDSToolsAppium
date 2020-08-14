package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.CalendarsScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalendarScreenTest extends BaseDriver {



    @Test (groups = {"all4", "all", "smoke", "smoke4", "jft"})
    public void calendarSimple_BISHOP() throws Exception {
        calendarSimpleSub("BISHOP");
    }



    @Test (groups = {"all4", "all"})
    public void calendarSimple_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_WARD_CLERK() throws Exception {
        calendarSimpleSub("WARD_CLERK");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_WARD_ASSISTANT_CLERK() throws Exception {
        calendarSimpleSub("WARD_ASSISTANT_CLERK");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_WARD_EXECUTIVE_SECRETARY() throws Exception {
        calendarSimpleSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_MEMBER1() throws Exception {
        calendarSimpleSub("MEMBER1");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_ELDERS_QUORUM_PRESIDENT() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_PRESIDENT");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_FIRST_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_SECOND_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_ELDERS_QUORUM_SECRETARY() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_SECRETARY");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        calendarSimpleSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_YOUNG_WOMEN_PRESIDENT() throws Exception {
        calendarSimpleSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_YOUNG_WOMEN_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("YOUNG_WOMEN_SECOND_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("SUNDAY_SCHOOL_FIRST_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_WARD_MISSION_LEADER() throws Exception {
        calendarSimpleSub("WARD_MISSION_LEADER");
    }

    public void calendarCheck() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);

//        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);

        //TODO: Need to find out why iOS cannot see calendar items.
        if (getRunningOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPageIDB();
            Assert.assertTrue(pageSource.contains("Calendar"));
        } else {
            pageSource = myBasePage.getSourceOfPage();
            System.out.println(pageSource);
            Assert.assertTrue(myBasePage.checkNoCaseList("Calendar", pageSource, "Contains"));
        }
    }


    @Test (groups = {"all", "all3"})
    public void calenderDisplayType() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        //Login - need the sleep on slower devices
        Thread.sleep(20000);

        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Calendar
        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);


        //Scroll to Stake Presidency Interviews in case it is off the screen
        myBasePage.scrollToTextGeneral("FHE");

        //Check the page source to see Stake Presidency Interviews
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("FHE", pageSource, "contains"));

        //Turn off West Jordan YSA Stake Calendar
        checkOrUncheckCalendarItem("Stake Calendar", "check");


        //Search for Stake Presidency Interviews - Should not be found.
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("FHE", pageSource, "contains"));


        //Turn on West Jordan YSA Stake Calendar
        checkOrUncheckCalendarItem("Stake Calendar", "uncheck");


        //Search for Stake Presidency Interviews - make sure it is displayed
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("FHE", pageSource, "contains"));


    }

    @Test (groups = {"all", "all4", })
    public void calenderSubscriptions() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        //Login - need the sleep on slower devices
        Thread.sleep(20000);

        myHelper.proxyLogin("Christian9");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Calendar
        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);


        //Scroll to Stake Presidency Interviews in case it is off the screen
        myBasePage.scrollToTextGeneral("FHE");

        //Check the page source to see Stake Presidency Interviews
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("YM", pageSource, "contains"));

        editCalendar();

        Thread.sleep(1000);
        myCalendar.calendarSubscriptions.click();

        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay("Stake Calendar", "check");

        myCalendar.calendarsSubscriptionsDone.click();

        myBasePage.waitUnitlTextIsGone("Syncing");
        if (getRunningOS().equals("ios")) {
            myCalendar.calendarDone.click();
        } else {
            myBasePage.backButton.click();
        }

        //Check the page source for Stake Event
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("FHE", pageSource, "contains"));


        //Clean up
        editCalendar();
        Thread.sleep(1000);
        myCalendar.calendarSubscriptions.click();

        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay("Stake Calendar", "uncheck");

        myCalendar.calendarsSubscriptionsDone.click();

        myBasePage.waitUnitlTextIsGone("Syncing");
        if (getRunningOS().equals("ios")) {
            myCalendar.calendarDone.click();
        } else {
            myBasePage.backButton.click();
        }

        Thread.sleep(2000);
        //Check the page source to see Stake Presidency Interviews
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("FHE", pageSource, "contains"));



    }


    private void editCalendar() throws Exception {
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        if (getRunningOS().contains("ios")) {
            myCalendar.calendarEdit.click();
        } else {
            myCalendar.calendarMoreOptions.click();
            myCalendar.calendarsToDisplay.click();
        }
    }





    private void checkOrUncheckCalendarItem(String calendarItem, String checkOrUncheck) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        editCalendar();


        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay(calendarItem, checkOrUncheck);

        if (getRunningOS().contains("ios")) {
            myCalendar.calendarDone.click();
        } else {
            myBasePage.backButton.click();
        }

        Thread.sleep(2000);
    }

    public void calendarSimpleSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember);
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        calendarCheck();
    }

    //    @Test (groups = {"all4", "all", "smoke", "smoke4"})
//    public void calendarSimple_BISHOP() throws Exception {
//        HelperMethods myHelper = new HelperMethods();
//        myHelper.proxyLogin("kroqbandit");
//        myHelper.enterPin("1", "1", "3", "3");
//        calendarCheck();
//    }


}
