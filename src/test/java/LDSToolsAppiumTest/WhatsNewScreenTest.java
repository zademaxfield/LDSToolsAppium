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

    //TODO: iOS
//    @Test(groups = {"needUpdate"})
    @Test (groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void whatsNewSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);

//        myHelper.proxyLogin("kroqbandit");
        myHelper.loginProduction("tyler55", "Eternity55!");
        myHelper.enterPinKeepWhatsNew("1", "1", "3", "3");

        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();
//        myBasePage.scrollDownTEST(500);
//        pageSource = pageSource + myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("What's New", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Version 4.0", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Automatic update", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Weekly Sacrament Attendance", pageSource, "Contains"));

        myWhatsNew.autoUpdate.click();

        Assert.assertTrue(myBasePage.checkNoCaseList("ON", pageSource, "Contains"));

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("You're all set, we'll keep your ward and stake updated automatically!", pageSource, "Contains"));

        myWhatsNew.wifiButton.click();

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("OFF", pageSource, "Contains"));


        myWhatsNew.whatsNewDone.click();

        myMenu.help.click();

        myWhatsNew.helpWhatsNew.click();

        myWhatsNew.wifiButton.click();

        myWhatsNew.autoUpdate.click();

        myWhatsNew.whatsNewDone.click();

        Thread.sleep(2000);
    }

    }
