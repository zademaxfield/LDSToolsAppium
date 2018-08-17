package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.MissionaryScreen;
import LDSToolsAppium.Screen.OrganizationsScreen;
import io.appium.java_client.MobileElement;
import org.jsoup.Connection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class MissionaryScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling




    @Test(dataProvider = "Members", groups = {"smoke3", "smoke", "all3", "all", "jft"})
    public void missionaryTest(String userName, String passWord, String rightsString, String calling) throws Exception {
        //String pageSource;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        String pageSource;

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);

        myMissionary.sendReferralButton.click();
        Thread.sleep(3000);
        myMissionary.cancelReferralButton.click();


        pageSource = myMissionary.getMissionaryPage();


        Assert.assertTrue(myBasePage.checkNoCaseList("Amata", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));


    }


}
