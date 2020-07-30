package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class WhatsNewScreenTest extends BaseDriver {

    @Test (groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void whatsNewSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        myHelper.proxyLogin("kroqbandit");
//        myHelper.loginProduction("tyler55", "Eternity55!");
        myHelper.enterPinKeepWhatsNew("1", "1", "3", "3");
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("What's New", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Version 4.0", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Automatic update", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament Attendance", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Prayer Roll", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Add names", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Version 4.1", pageSource, "Contains"));

        myWhatsNew.autoUpdate.click();

        Assert.assertTrue(myBasePage.checkNoCaseList("ON", pageSource, "Contains"));

        pageSource = myBasePage.getSourceOfPage();
        


        if (getRunningOS().equalsIgnoreCase("android")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("You're all set, we'll keep your ward and stake updated automatically!", pageSource, "Contains"));
        }


        myWhatsNew.wifiButton.click();
        pageSource = myBasePage.getSourceOfPage();
        if (getRunningOS().equalsIgnoreCase("ios")) {
            Assert.assertTrue(myWhatsNew.wifiButton.getAttribute("value").equalsIgnoreCase("0"));
        } else {
            Assert.assertTrue(myBasePage.checkNoCaseList("OFF", pageSource, "Contains"));
        }

        myWhatsNew.whatsNewDone.click();

        // Click on Later then Directory
        if (!myBasePage.getSourceOfPage().equals("ios")) {
            Thread.sleep(2000);
            myHelper.checkForLater();
            Thread.sleep(2000);
            myMenu.directory.click();
            Thread.sleep(2000);
        }



        myMenu.selectMenu(myMenu.help);
//        System.out.println(myBasePage.getSourceOfPage());
        myWhatsNew.helpWhatsNew.click();
        myWhatsNew.wifiButton.click();
        myWhatsNew.autoUpdate.click();
        myWhatsNew.whatsNewDone.click();
        Thread.sleep(2000);
    }

}
