package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.CalendarsScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalendarScreenTest extends BaseDriver {

    @Test ( dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"})
    public void calendarSimple(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.calendar);

        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Calendar", pageSource, "Contains"));
        //Assert.assertTrue(myBasePage.checkNoCaseList("Edit", pageSource, "Contains"));

        //Todo: Check calendar items... not sure how to do this


    }


    @Test (groups = {"all", "all3", "jft"  })
    public void calenderDisplayType() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        //Login - need the sleep on slower devices
        Thread.sleep(20000);

        myHelper.loginProduction("imaxfield", "ldsM0b1l3");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Calendar
        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);


        //Scroll to Stake Presidency Interviews in case it is off the screen
        myBasePage.scrollToTextGeneral("Stake Presidency Interviews");

        //Check the page source to see Stake Presidency Interviews
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Stake Presidency Interviews", pageSource, "contains"));

        //Turn off West Jordan YSA Stake Calendar
        checkOrUncheckCalendarItem("West Jordan YSA Stake Calendar", "check");


        //Search for Stake Presidency Interviews - Should not be found.
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Stake Presidency Interviews", pageSource, "contains"));


        //Turn on West Jordan YSA Stake Calendar
        checkOrUncheckCalendarItem("West Jordan YSA Stake Calendar", "uncheck");


        //Search for Stake Presidency Interviews - make sure it is displayed
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Stake Presidency Interviews", pageSource, "contains"));


    }

    @Test (groups = {"all", "all4"})
    public void calenderSubscriptions() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        //Login - need the sleep on slower devices
        Thread.sleep(20000);

        myHelper.loginProduction("imaxfield", "ldsM0b1l3");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Calendar
        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);


        //Scroll to Stake Presidency Interviews in case it is off the screen
        myBasePage.scrollToTextGeneral("Stake Presidency Interviews");

        //Check the page source to see Stake Presidency Interviews
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Stake Presidency Interviews", pageSource, "contains"));

        editCalendar();

        Thread.sleep(1000);
        myCalendar.calendarSubscriptions.click();

        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay("West Jordan YSA Stake Calendar", "check");

        myCalendar.calendarsSubscriptionsDone.click();

        myBasePage.waitUnitlTextIsGone("Syncing");
        if (getRunningOS().equals("ios")) {
            myCalendar.calendarDone.click();
        } else {
            myBasePage.backButton.click();
        }

        //Check the page source for Stake Event
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Stake Presidency Interviews", pageSource, "contains"));


        //Clean up
        editCalendar();
        Thread.sleep(1000);
        myCalendar.calendarSubscriptions.click();

        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay("West Jordan YSA Stake Calendar", "uncheck");

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
        Assert.assertTrue(myBasePage.checkNoCaseList("Stake Presidency Interviews", pageSource, "contains"));



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




}
