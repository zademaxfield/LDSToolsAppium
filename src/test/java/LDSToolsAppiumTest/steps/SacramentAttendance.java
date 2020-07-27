package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class SacramentAttendance extends BaseDriver {
    HelperMethods myHelper = new HelperMethods(driver);
    BasePage myBasePage = new BasePage(driver);
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    String pageSource;


    @Given("a {string} is on the Sacrament Attendance page")
    public void aMemberIsOnTheSacramentAttendancePage(String memberCalling) throws Exception {
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myReports.sacramentAttendanceReport.click();
    }

    @When("{string} is entered in the {string}")
    public void isEnteredInThe(String valueToEnter, String fieldToEnter) throws Exception  {
        myReports.sacramentAttendanceFirstWeek.click();
        myReports.sacramentAttendanceDialogEditField.setValue(valueToEnter);
        myReports.sacramentAttendanceDialogOk.click();
        myBasePage.backButton.click();
        myReports.sacramentAttendanceReport.click();
    }

    @Then("I should see {string}")
    public void iShouldSee(String searchItem) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains(searchItem));
    }


}
