package LDSToolsAppium;

import LDSToolsAppium.API.MemberToolsAPI;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITest {

    List<String> memberList = new ArrayList<String>();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> reportNameToCheck = new ArrayList<>();

    String unitNumber = "21628";
    String proxyLogin = "kroqbandit";



    @Test
    public void ReportNameCheckBishop() throws Exception {
        reportNameToCheck.clear();

        reportNameToCheck.add("ACTION_INTERVIEW");
        reportNameToCheck.add("BIRTHDAY_LIST");
        reportNameToCheck.add("KEY_INDICATORS");
        reportNameToCheck.add("MEMBERS_MOVED_IN");
        reportNameToCheck.add("MEMBERS_MOVED_OUT");
        reportNameToCheck.add("MEMBERS_WITH_CALLINGS");
        reportNameToCheck.add("MEMBERS_WITHOUT_CALLINGS");
        reportNameToCheck.add("MINISTERING_BROTHERS");
        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS");
        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS_EDIT");
        reportNameToCheck.add("MINISTERING_SISTERS");
        reportNameToCheck.add("MINISTERING_SISTERS_INTERVIEWS");
        reportNameToCheck.add("MINISTERING_SISTERS_INTERVIEWS_EDIT");
        reportNameToCheck.add("NEW_MEMBERS");
        reportNameToCheck.add("QUARTERLY_REPORT");
        reportNameToCheck.add("SACRAMENT_ATTENDANCE");
        reportNameToCheck.add("CLASS_QUORUM_ATTENDANCE");
        reportNameToCheck.add("TEMPLE_RECOMMEND_STATUS");
        reportNameToCheck.add("UNIT_STATISTICS");
        reportNameToCheck.add("YOUTH_RECOMMEND_STATUS");
        reportNameToCheck.add("MISSIONARY_PROGRESS_RECORD");


        memberList = apiTest.getReportNames("kroqbandit", "21628");

        System.out.println("Report Name Check Bishop");
        for(String reportName: reportNameToCheck) {
            System.out.println("Checking: " + reportName);
            Assert.assertTrue(memberList.contains(reportName));
        }

    }

    @Test
    public void ReportNameCheckElders() throws Exception {
        reportNameToCheck.clear();

        reportNameToCheck.add("ACTION_INTERVIEW");
        reportNameToCheck.add("BIRTHDAY_LIST");
        reportNameToCheck.add("KEY_INDICATORS");
        reportNameToCheck.add("MEMBERS_MOVED_IN");
        reportNameToCheck.add("MEMBERS_MOVED_OUT");
        reportNameToCheck.add("MEMBERS_WITH_CALLINGS");
        reportNameToCheck.add("MEMBERS_WITHOUT_CALLINGS");
        reportNameToCheck.add("MINISTERING_BROTHERS");
        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS");
        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS_EDIT");
        reportNameToCheck.add("MINISTERING_SISTERS");
        reportNameToCheck.add("QUARTERLY_REPORT");
        reportNameToCheck.add("CLASS_QUORUM_ATTENDANCE");
        reportNameToCheck.add("UNIT_STATISTICS");



        memberList = apiTest.getReportNames("bradyduck", "111074");

        System.out.println("Report Name Check Elders");
        for(String reportName: reportNameToCheck) {
            System.out.println("Checking: " + reportName);
            Assert.assertTrue(memberList.contains(reportName));
        }

//        for (String listName: memberList) {
//            System.out.println(listName);
//        }

    }

}
