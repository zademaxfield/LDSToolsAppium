package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.Screen.MeetinghousesScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.annotations.Test;


public class MeetinghousesScreenTest extends BaseDriver {



    @Test(groups = {"smoke3", "smoke", "all3", "all", "jft"})
    public void meetinghousesSimpleTest() throws Exception {
        //String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MeetinghousesScreen myMeetinghouses = new MeetinghousesScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.meetinghouses);

        myMeetinghouses.meetinghousesAllow.click();
        Thread.sleep(5000);
        driver.switchTo().alert();
        myMeetinghouses.meetinghousesAllowAndroidPermissions.click();

        Thread.sleep(7000);


    }



}
