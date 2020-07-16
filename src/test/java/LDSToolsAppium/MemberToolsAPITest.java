package LDSToolsAppium;

import LDSToolsAppium.API.MemberToolsAPI;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MemberToolsAPITest {

    public MemberToolsAPITest() {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s [%3$s] %5$s %6$s%n");
    }

    @Test
    public void testToolsService() throws Exception {
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();

        //Get report list
        memberList = apiTest.getReportNames("kroqbandit", "21628");
        //Get members from Action and Interview Reports
//        memberList = apiTest.getNamesFromActionInterviewReports("Unbaptized Members", "kroqbandit", "21628");
        //Get Members from Members Moved Out
//        memberList = apiTest.getNamesFromMembersMovedOut("kroqbandit", "21628");
        //Unit Stats
//        memberList = apiTest.getReportUnitStatsNumbers("kroqbandit", "21628");


        //Get Assigned Missionaries
//        memberList = apiTest.getAssignedMissionaries("kroqbandit", "21628");
        //Get Service Missionaries
//        memberList = apiTest.getServingMissionaries("kroqbandit", "21628");
        //Get Ward Missionaries
//        memberList = apiTest.getOrganizationMembers("Ward Missionaries", "kroqbandit", "21628");
        //Get Bishopric
//        memberList = apiTest.getOrganizationMembers("Bishopric", "kroqbandit", "21628");

        //Get Members from New Members
//        memberList = apiTest.getNamesFromNewMembers("kroqbandit", "21628");

        //Get Ministering Brother info
        //TODO: needs work
//        memberList = apiTest.getInfoFromMinisteringBrothers("kroqbandit", "21628");




//        memberList = apiTest.getChildOrganizationMembers("Unassigned Teachers", "kroqbandit", "21628");
//        memberList = apiTest.getChildOrganizationClasses("Other Callings", "kroqbandit", "21628");


//        memberList = apiTest.getOrganizationMembers("Bishopric", "kroqbandit", "21628");
//        new MemberToolsAPI().getOrganizationMembers("Elders Quorum Presidency", "kroqbandit", "21628");

        System.out.println("LIST!");
        for (String memberName : memberList) {
            System.out.println(memberName);
        }
    }
}