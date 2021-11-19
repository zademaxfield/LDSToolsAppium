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
        memberList = apiTest.getReportNames("mbthomas74", "21628");
        //Get members from Action and Interview Reports
//        memberList = apiTest.getNamesFromActionInterviewReports("Unbaptized Members", "mbthomas74", "21628");
        //Get Members from Members Moved Out

        //Unit Stats
//        memberList = apiTest.getReportUnitStatsNumbers("mbthomas74", "21628");
        memberList = apiTest.getReportUnitStatsNumbers("mbthomas74", "21628");

        //Temple Recommend Status - Sort of works this is looking a the unit stats.
//        memberList = apiTest.getNamesTempleRecommendStatusActive("mbthomas74", "21628");
//        memberList = apiTest.getNamesTempleRecommendStatusAll("mbthomas74", "21628");

        //Reports New Members
//        memberList = apiTest.getNewMembers("mbthomas74", "21628");
//        memberList = apiTest.getNewMembers("mbthomas74", "21628");


        //One Work - Covenant Path
//        memberList = apiTest.getCovenantPathNames("extractor", "111074", "new member");
//        memberList = apiTest.getCovenantPathNames("extractor", "111074", "People being taught");


//        memberList = apiTest.getCovenantPathUserDetails("extractor", "111074", "Ivey, Delores");
//        memberList = apiTest.getCovenantPathUserDetails("extractor", "111074", "White, Koty Lucas");
//        int sacMissed = apiTest.getCovenantPathUserSacramentMissed("extractor", "111074", "Doramus, Barbara");

        //Class and Quorum
//        memberList = apiTest.getClassAndQuorum("mbthomas74", "21628", "2020-12-06");
//        memberList = apiTest.getClassAndQuorumRights("mbthomas74", "21628");


        //Action and Interview Tests
//        memberList = apiTest.getNamesActionAndInterviewReports("Children Approaching Baptism Age","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Unbaptized Members","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Overdue Aaronic Priesthood Ordinations","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Young Single Adult Interviews","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Bishop’s Youth Interviews","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Bishopric Counselor Youth Interviews","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Young Men Approaching Mission Age","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Men Who Have Not Served a Mission","mbthomas74", "21628");
//        memberList = apiTest.getNamesActionAndInterviewReports("Potential Missionary Couples","mbthomas74", "21628");


        //Get Assigned Missionaries
//        memberList = apiTest.getAssignedMissionaries("mbthomas74", "21628");
        //Get Service Missionaries
//        memberList = apiTest.getServingMissionaries("mbthomas74", "21628");
        //Get Ward Missionaries
//        memberList = apiTest.getOrganizationMembers("Ward Missionaries", "mbthomas74", "21628");
        //Get Bishopric
//        memberList = apiTest.getOrganizationMembers("Bishopric", "mbthomas74", "21628");

        //Get Members from New Members
//        memberList = apiTest.getNamesFromNewMembers("mbthomas74", "21628");

        //Get Ministering Brother info
        //TODO: needs work
//        memberList = apiTest.getInfoFromMinisteringBrothers("mbthomas74", "21628");




//        memberList = apiTest.getChildOrganizationMembers("Unassigned Teachers", "mbthomas74", "21628");
//        memberList = apiTest.getChildOrganizationClasses("Other Callings", "mbthomas74", "21628");

//        memberList = apiTest.getChildOrganizationClasses("Young Women" , "mbthomas74", "21628");
//        memberList = apiTest.getChildOrganizationMembers("Elders Quorum", "mbthomas74", "21628"); //Doesn't give member list
//        memberList = apiTest.getOrganizationMembers("Elders Quorum", "mbthomas74", "21628"); //Doesn't give member list


//        memberList = apiTest.getOrganizationMembers("Bishopric", "mbthomas74", "21628");
//        new MemberToolsAPI().getOrganizationMembers("Elders Quorum Presidency", "mbthomas74", "21628");

        System.out.println("LIST!");
        for (String memberName : memberList) {
            System.out.println(memberName);
        }
    }
}