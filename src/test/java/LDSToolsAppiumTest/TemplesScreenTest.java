package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class TemplesScreenTest extends BaseDriver {

    @Test (groups = {"all2", "all", "smoke", "smoke2", "jft"})
    public void templeSimple() throws Exception {
        String pageSource;
        List<String> myList = new ArrayList<String>();

        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);


        myHelper.loginUAT("LDSTools21", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.temples);

        pageSource = myBasePage.getSourceOfPage();


        myWeb.MyTemplePageLogIn("https://uat.lds.org/mls/mbr/?lang=eng", "LDSTools21", "password1");
        //Check the Temple Name
        if (pageSource.contains(myWeb.TempleGetName())){
            Assert.assertTrue(true);
        } else {
            System.out.println("Not Found: " + myWeb.TempleGetName());
            Assert.fail();
        }

        myList = myWeb.TempleGetPhysicalAddress();
        myBasePage.checkSource(pageSource, myList);

        //myList = myWeb.TempleGetServices();
        //checkSource(mySource, myList);

        myList = myWeb.TempleGetMilestones();
        myBasePage.checkSource(pageSource, myList);

    }


    @Test (groups= { "smoke", "smoke3", "all", "all1"})
    public void templeRecommendReminder25Days() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);


        myHelper.loginUAT("ngibpc1", "password1");
        myHelper.enterPin("1", "1", "3", "3");


        myTemple.enableTempleRecommendReminder("25", mySettings.active, mySettings.temple4Weeks);

        //Check the temple reminder
        Thread.sleep(6000);
        Assert.assertTrue(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));

        myTemple.contactBishopric.click();


        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Samu", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }

    @Test (groups= { "all", "all2"})
    public void templeRecommendReminder5Days() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);


        myHelper.loginUAT("ngibpc1", "password1");
        myHelper.enterPin("1", "1", "3", "3");


        myTemple.enableTempleRecommendReminder("5", mySettings.active, mySettings.temple6Weeks);

        //Check the temple reminder
        Thread.sleep(6000);
        Assert.assertFalse(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));

        myTemple.contactBishopric.click();


        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Samu", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }

    @Test (groups= { "all", "all3"})
    public void templeRecommendReminderRemindLater() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);


        myHelper.loginUAT("ngibpc1", "password1");
        myHelper.enterPin("1", "1", "3", "3");


        myTemple.enableTempleRecommendReminder("25", mySettings.active, mySettings.temple6Weeks);

        //Check the temple reminder
        Thread.sleep(6000);
        Assert.assertTrue(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));

        myTemple.remindMeLater.click();


        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Apia", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Samu", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }

    @Test (groups= { "all", "all4"})
    public void templeRecommendReminderGoItThanks() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);


        myHelper.loginUAT("ngibpc1", "password1");
        myHelper.enterPin("1", "1", "3", "3");


        myTemple.enableTempleRecommendReminder("25", mySettings.active, mySettings.temple6Weeks);

        //Check the temple reminder
        Thread.sleep(6000);
        Assert.assertTrue(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));

        myTemple.gotItThanks.click();


        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Apia", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Samu", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }




}
