package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalendarScreenTest extends BaseDriver {

    @Test ( groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void calendarSimple(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
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


        myMenu.calendar.click();

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Calendar", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Edit", pageSource, "Contains"));

        //Todo: Check calendar items... not sure how to do this


    }




}
