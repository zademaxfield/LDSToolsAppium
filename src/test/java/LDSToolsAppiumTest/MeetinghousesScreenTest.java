package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MeetinghousesScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.OrganizationsScreen;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class MeetinghousesScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling




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
        myMeetinghouses.meetinghousesAllowAndroidPermissions.click();

        Thread.sleep(7000);


    }



}
