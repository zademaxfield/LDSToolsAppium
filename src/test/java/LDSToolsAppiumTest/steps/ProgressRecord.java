package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppium.Screen.TemplesScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProgressRecord extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    String pageSource;


    @Given("a {string} logs in and is on the Progress Record Page")
    public void aLeaderLogsInAndIsOnTheProgressRecordPage(String memberCalling) throws Exception {
       LOGGER.info("a " + memberCalling + " logs in and is on the Progress Record Page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Auburn Hills");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        if (!myBasePage.checkForElement(myReports.progressRecordReport)) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        myReports.progressRecordReport.click();
    }


    @When("a {string} is selected under the New Members tab")
    public void aMemberRecordIsSelectedUnderTheNewMembersTab(String memberRecord) throws Exception {
        LOGGER.info("a " + memberRecord + " is selected under the New Members tab");
        myBasePage.waitForElement(myReports.prNewMembers);
        myReports.prNewMembers.click();
        searchForMemberAndClick(memberRecord);
//        selectProgressRecordMember(memberRecord);
    }



    //Todo: add api call to get the info to check
    @Then("the {string} will be displayed")
    public void theMemberRecordWillBeDisplayed(String memberRecord) throws Exception {
        LOGGER.info("the members record will be displayed");
        pageSource = getProgressRecordDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList(memberRecord, pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Member for", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament Attendance", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("View All", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Calling", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Assignment", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple Ordinances", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Principles Taught", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Other Commitments", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Self-Reliance Class", pageSource, "Contains"));

    }

    //Todo: add api call for this
    @And("the members record {string} be edited")
    public void theMembersRecordCanBeEdited(String editable) throws Exception {
        LOGGER.info("the members record " + editable + " be edited");
//        pageSource = getProgressRecordDetails();

        if (editable.equalsIgnoreCase("true")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("Add Friend", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Principles Taught", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("View All", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("OPT OUT", pageSource, "Contains"));
        } else {
            Assert.assertFalse(myBasePage.checkNoCaseList("Add Friend", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Update Principles Taught", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("OPT OUT", pageSource, "Contains"));
        }
    }

    public void searchForMemberAndClick(String memberRecord) throws Exception {
        myReports.prSearchField.sendKeys(memberRecord);
        Thread.sleep(2000);
        selectProgressRecordMember(memberRecord);

    }



    public void selectProgressRecordMember(String memberRecord) throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + memberRecord +"']/.." +
                    "/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[@name='View Details']")).click();
        } else {
            driver.get().findElement(By.xpath("//android.widget.TextView[@text='"+ memberRecord +"']")).click();
        }
    }

    public String getProgressRecordDetails() throws Exception {
        String pageSource;
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myBasePage.scrollDownAndroidUIAutomator("0");
            pageSource = pageSource + myBasePage.getSourceOfPage();
            myBasePage.scrollDownAndroidUIAutomator("0");
            pageSource = pageSource + myBasePage.getSourceOfPage();
        }

        return pageSource;
    }



}
