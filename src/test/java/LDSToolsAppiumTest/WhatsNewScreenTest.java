package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;


public class WhatsNewScreenTest extends BaseDriver {

    @Test (groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void whatsNewSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);


        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPinKeepWhatsNew("1", "1", "3", "3");

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("What's New", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Version 3.4.1", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Caller ID", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ministering", pageSource, "Contains"));


        myWhatsNew.whatsNewDone.click();

    }




}
