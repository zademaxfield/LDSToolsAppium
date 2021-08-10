package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class API {

    HelperMethods myHelper = new HelperMethods();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    int urlStatus;


    @Given("a {string} account checks the Class and Quorum Attendance right")
    public void aMemberAccountChecksTheClassAndQuorumAttendanceRight(String memberCalling) throws Exception {
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        memberList = apiTest.getClassAndQuorumRights(callingRights[1], "21628");
    }


    @Then("the Class and Quorum editable field is {string}")
    public void theClassAndQuorumEditableFieldIsStatus(String status) throws Exception {
        for (String memberStatus : memberList) {
            System.out.println("Member Status: " + memberStatus + " Should be: " + status);
            Assert.assertTrue(memberStatus.equalsIgnoreCase(status));
        }
    }

    @Given("a {string} goes to the {string}")
    public void aMemberGoesToTheUrl(String member, String url) throws Exception {
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(member, "Centinela 1st");
        urlStatus = apiTest.getApiResponseCode( url, callingRights[1] );
    }

    @Then("the status should be {string}")
    public void theStatusShouldBeStatus(String status) throws Exception {
        if (status.equalsIgnoreCase("Success")) {
            Assert.assertTrue(urlStatus >= 200 && urlStatus <= 299);
        }
        if (status.equalsIgnoreCase("Error")) {
            Assert.assertTrue(urlStatus >= 400);
        }
    }


//    public API() {
//        Given("^a <member> account checks the Class and Quorum Attendance right$", () -> {
//        });
//    }
}
