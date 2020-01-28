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

import java.util.ArrayList;
import java.util.List;


public class QuarterlyScreenTest extends BaseDriver {

    //TODO: Need to update user
    @Test(groups = {"needUpdate"})
//    @Test (dataProvider = "Members", groups = {"all1", "all", "smoke", "smoke1", "jft"} )
    public void quarterlyReportBasic(String userName, String passWord, String rightsString, String calling) throws Exception {
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
            myWeb.quarterlyReportLogIn( userName, passWord);

            myMenu.selectMenu(myMenu.reports);
            if (!myBasePage.checkForElement(myReport.quarterlyReport)) {
                myBasePage.scrollToTextRecyclerView("Quarterly Report");
            }
            myReport.quarterlyReport.click();

            //Quarterly Report Indicators
            myQuarterly.indicatorsOfConversionAndChurchGrowth.click();
            Thread.sleep(2000);
            checkQuarterlyReport("Indicators");
            myBasePage.backButton.click();

            //Quarterly Report Members
            myQuarterly.membersFamilies.click();
            Thread.sleep(2000);
            checkQuarterlyReport("Members");
            myBasePage.backButton.click();

            //Quarterly Report Adults
            myQuarterly.adults.click();
            Thread.sleep(2000);
            checkQuarterlyReport("Adults");
            myBasePage.backButton.click();

            //Quarterly Report Youth
            myQuarterly.youth.click();
            Thread.sleep(2000);
            checkQuarterlyReport("Youth");
            myBasePage.backButton.click();

            //Quarterly Report Children
            myQuarterly.children.click();
            Thread.sleep(2000);
            checkQuarterlyReport("Children");
            myBasePage.backButton.click();

            //Quarterly Report Converts
            myQuarterly.convertsPast12Months.click();
            Thread.sleep(2000);
            checkQuarterlyReport("Converts");
            myBasePage.backButton.click();


            myWeb.tearDown();

        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    public void checkQuarterlyReport(String myReport) throws Exception {
        String pageSource;
        List<String> myList;
        //ArrayList<String> androidList = new ArrayList<>();
        BasePage myBasePage = new BasePage(driver);

        pageSource = myBasePage.getSourceOfPage();
        myBasePage.scrollDownTEST(200);
        pageSource = pageSource + myBasePage.getSourceOfPage();

        myList = myWeb.getQuarterlyReportsDetails(myReport);

        for(String reportData : myList){
            System.out.println("Data to test: " + reportData);
            Assert.assertTrue(myBasePage.checkNoCaseList(reportData, pageSource, "Contains"));
        }


       // myBasePage.compareWebData(myList, androidList, true);
    }



}
