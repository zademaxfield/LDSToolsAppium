package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
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

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClassAndQuorum extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    String pageSource;

    @Given("a {string} logs in and is on the Class and Quorum Attendance page")
    public void aLeaderLogsInAndIsOnTheClassAndQuorumAttendancePage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " logs in and is on the Class and Quorum Attendance page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myReports.classAndQuorumAttendanceReport.click();
    }

    @When("a {string} is searched for")
    public void aMemberRecordIsSearchedFor(String memberRecord) throws Exception {
        LOGGER.info("a " + memberRecord + " is searched for");
        searchClassAndQuorum(memberRecord);
    }


    @Then("the class and quorum attendance {string} will be displayed")
    public void theRecordWillBeDisplayed(String memberRecord) throws Exception {
        LOGGER.info("the record will be displayed");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList(memberRecord, pageSource, "Contains"));
    }


    @And("the attendance {string} be edited")
    public void theAttendanceCanBeEdited(String editRights) throws Exception{
        LOGGER.info("the attendance " + editRights + " be edited");
        System.out.println("Not sure if needed?");
    }



    public void searchClassAndQuorum(String memberToSearch) throws Exception {
        myReports.classAndQuorumSearch.setValue(memberToSearch);
        //Done button?
    }



}
