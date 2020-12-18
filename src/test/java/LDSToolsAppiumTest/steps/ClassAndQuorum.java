package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppium.Screen.TemplesScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.appium.java_client.MobileElement;
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
    List<String> visibleDates = new ArrayList<String>();
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






    @Given("a {string} account checks the Class and Quorum Attendance for the API")
    public void aLeaderAccountChecksTheClassAndQuorumAttendanceForTheAPI(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " account checks the Class and Quorum Attendance for the API");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        memberList = apiTest.getClassAndQuorumRights(callingRights[1], "21628");
    }


    @Then("the editable field is {string}")
    public void theEditableFieldIsStatus(String status) {
        LOGGER.info("the editable field is " + status);
        for (String memberStatus : memberList) {
            System.out.println("Member Status: " + memberStatus + " Should be: " + status);
            Assert.assertTrue(memberStatus.equalsIgnoreCase(status));
        }
    }

    @Given("a member of the bishopric logs in and is on the Class and Quorum Attendance page")
    public void aMemberOfTheBishopricLogsInAndIsOnTheClassAndQuorumAttendancePage() throws Exception {
        LOGGER.info("a member of the bishopric logs in and is on the Class and Quorum Attendance page");
        visibleDates.clear();
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList("BISHOP", "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myReports.classAndQuorumAttendanceReport.click();
    }

    @When("week one is marked attended")
    public void weekOneIsMarkedAttended() throws Exception {
        LOGGER.info("week one is marked attended");
        clearAllAttendance("Mara, Alma Vida");
        searchClassAndQuorum("Mara, Alma Vida");
        getWeekElement("week1").click();
    }


    @Then("week one will have a check mark")
    public void weekOneWillHaveACheckMark() throws Exception {
        LOGGER.info("week one will have a check mark");
        myBasePage.backButton.click();
        myReports.classAndQuorumAttendanceReport.click();
        searchClassAndQuorum("Mara, Alma Vida");
        Assert.assertTrue(getWeekAttendanceStatus("week1").equalsIgnoreCase("attended"));
        //Clean Up
        getWeekElement("week1").click();
        myBasePage.backButton.click();
    }

    public void clearAllAttendance(String memberRecord) throws Exception {
        searchClassAndQuorum(memberRecord);
        visibleDates = getVisibleDates();
        if (getWeekAttendanceStatus("week1").equalsIgnoreCase("attended")) {
            getWeekElement("week1").click();
            Thread.sleep(2000);
        }

        if (getWeekAttendanceStatus("week2").equalsIgnoreCase("attended")) {
            getWeekElement("week2").click();
            Thread.sleep(2000);
        }

        if (getWeekAttendanceStatus("week3").equalsIgnoreCase("attended")) {
            getWeekElement("week3").click();
            Thread.sleep(2000);
        }

        if (getWeekAttendanceStatus("week4").equalsIgnoreCase("attended")) {
            getWeekElement("week4").click();
            Thread.sleep(2000);
        }


        myBasePage.backButton.click();
        myReports.classAndQuorumAttendanceReport.click();
    }

    public List<String> getVisibleDates() throws Exception {
        String tempDate;
        String shortDate;
        String attendedStatus;
        String[] dateArray = new String[0];
        if (visibleDates.isEmpty()) {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                for (int x = 2; x <= 5; x++) {
                    tempDate = (driver.get().findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[" + x + "]")).getAttribute("value"));
                    dateArray = tempDate.split(":");
                    shortDate = dateArray[0];
                    attendedStatus = dateArray[1];
                    visibleDates.add(shortDate);
                }
            } else {
                for (int y = 1; y <= 5 ; y++) {
                    visibleDates.add(driver.get().findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'week" + y + "')]//android.widget.TextView")).getAttribute("text"));
                }
            }

            for (String dateToDisplay : visibleDates) {
                System.out.println("DATE: " + dateToDisplay);
            }
        }

        return visibleDates;
    }

    public String getWeekAttendanceStatus(String weekName) throws Exception {
        String returnStatus = null;
        MobileElement weekCheckBox;

        weekCheckBox = getWeekElement(weekName);
        if (myBasePage.getOS().contains("ios")) {
            returnStatus = weekCheckBox.getAttribute("name");
            if (returnStatus.contains("not")) {
                returnStatus = "not attended";
            } else {
                returnStatus = "attended";
            }
        } else {
            returnStatus = weekCheckBox.getAttribute("selected");
            if (returnStatus.equalsIgnoreCase("false")) {
                returnStatus = "not attended";
            } else {
                returnStatus = "attended";
            }
        }

        return returnStatus;
    }

    public MobileElement getWeekElement(String weekName) throws Exception{
        MobileElement returnElement = null;
        List<String> dateToCheck;
        dateToCheck = getVisibleDates();
        switch(weekName) {
            case "week1":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(0) +"')]"));
                } else {
                    returnElement = myReports.classAndQuorumFirstWeek;
                }
                break;
            case "week2":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(1) +"')]"));
                } else {
                    returnElement = myReports.classAndQuorumSecondWeek;
                }

                break;
            case "week3":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(2) +"')]"));
                } else {
                    returnElement = myReports.classAndQuorumThirdWeek;
                }

                break;
            case "week4":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(3) +"')]"));
                } else {
                    returnElement = myReports.classAndQuorumFourthWeek;
                }

                break;

            case "week5":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(4) +"')]"));
                } else {
                    returnElement = myReports.classAndQuorumFifthWeek;
                }

                break;
            default:
                System.out.println("Element not found!");
        }
        return returnElement;
    }



    public void searchClassAndQuorum(String memberToSearch) throws Exception {
        myReports.classAndQuorumSearch.setValue(memberToSearch);
        //Done button?
    }


}
