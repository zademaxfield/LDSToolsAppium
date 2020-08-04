package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class SacramentAttendance extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    String pageSource;



    @Given("a {string} is on the Sacrament Attendance page")
    public void aMemberIsOnTheSacramentAttendancePage(String memberCalling) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(memberCalling);
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myReports.sacramentAttendanceReport.click();
    }

    @When("{string} is entered in the {string}")
    public void isEnteredInThe(String valueToEnter, String fieldToEnter) throws Exception  {
//        myReports.sacramentAttendanceFirstWeek.click();
        System.out.println(myBasePage.getSourceOfPage());
        clickElement(fieldToEnter);
        myReports.sacramentAttendanceDialogEditField.setValue(valueToEnter);
        myReports.sacramentAttendanceDialogOk.click();
        iShouldSee(valueToEnter);
        myBasePage.backButton.click();
//        System.out.println(myBasePage.getSourceOfPage());
        Thread.sleep(5000);
        myReports.sacramentAttendanceReport.click();
        Thread.sleep(5000);
    }

    @Then("I should see {string}")
    public void iShouldSee(String searchItem) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains(searchItem));
    }

    @Then("I should see {string} in the {string}")
    public void iShouldSeeInThe(String textToCheck, String fieldToCheck) throws Exception {
        String textFromElement = getTextFromElement(fieldToCheck);
        Assert.assertTrue(textToCheck.contains(textFromElement));
    }


    public void clickElement(String elementName) throws Exception {
        switch(elementName) {
            case "First Date Field":
                myReports.sacramentAttendanceFirstWeek.click();
                break;
            case "Second Date Field":
                myReports.sacramentAttendanceSecondWeek.click();
                break;
            case "Third Date Field":
                myReports.sacramentAttendanceThirdWeek.click();
                break;
            case "Fourth Date Field":
                myReports.sacramentAttendanceFourthWeek.click();
                break;
            default:
                System.out.println("Element not found!");
        }
    }

    public String getTextFromElement(String elementName) throws Exception {
        String myText = null;
        switch(elementName) {
            case "First Date Field":
                myText = myReports.sacramentAttendanceFirstWeek.getAttribute("Text");
                break;
            case "Second Date Field":
                myText = myReports.sacramentAttendanceSecondWeek.getAttribute("Text");
                break;
            case "Third Date Field":
                myText = myReports.sacramentAttendanceThirdWeek.getAttribute("Text");
                break;
            case "Fourth Date Field":
                myText = myReports.sacramentAttendanceFourthWeek.getAttribute("Text");
                break;
            default:
                System.out.println("Element not found!");
        }
        
        return myText;
    }



}
