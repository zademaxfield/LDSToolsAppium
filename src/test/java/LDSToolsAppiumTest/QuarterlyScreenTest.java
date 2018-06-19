package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.MinisteringScreen;
import LDSToolsAppium.Screen.QuarterlyReportScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class QuarterlyScreenTest extends BaseDriver {

    @Test (dataProvider = "Members", groups = {"all3", "all", "smoke", "smoke3", "jft"} )
    public void ministeringBasic(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReport = new ReportsScreen(driver);
        QuarterlyReportScreen myQuarterly = new QuarterlyReportScreen(driver);



        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myReport.quarterlyReport.click();

            myQuarterly.indicatorsOfConversionAndChurchGrowth.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Individuals who are sealed to a spouse in the temple", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("35 / 73", pageSource, "Contains"));
            //Assert.assertTrue(myBasePage.checkNoCaseList("48", pageSource, "Contains"));




        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }




}
