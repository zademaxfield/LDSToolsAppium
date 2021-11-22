package LDSToolsAppium;

import LDSToolsAppium.API.MemberToolsAPI;
//import LDSToolsAppium.API.ApiFinance;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;
//import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.TypeKey;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import java.awt.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITest {

    List<String> memberList = new ArrayList<String>();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> reportNameToCheck = new ArrayList<>();
    String rawData;

    String unitNumber = "21628";
    String proxyLogin = "mbthomas74";

    String accessToken;
    String idToken;
    HashMap<String, String> listMap = new HashMap<>();



    @Test
    public void apiInfoTestStuff() throws Exception {
        int codeTest = 0;
        int responseCode = 0;
//
        Map<String, Object> myMap = new HashMap<>();
//        myMap = apiTest.getExpenses("mbthomas74", "21628", "Qqqqqqqqqqqqq");
//
//        for (String mapKey: myMap.keySet()) {
//            String key = mapKey.toString();
//            String value = myMap.get(mapKey).toString();
//            System.out.println(key + " - " + value);
//        }

        //Ordiance Stuff
//        memberList = apiTest.getPersonalInfoFromName( "Adams, Dewayne", "21628", "mbthomas74");
//        System.out.println(memberList);
//        apiTest.ordinanceDelete("Austin, Joseph", "21628", "mbthomas74");

//        apiTest.ordinanceDelete("Barba, Cristian Jesus", "21628", "mbthomas74");


//        apiTest.getUserAccountsJson("21628", "4");
        myMap = apiTest.getAccounts("21628", "4");
        System.out.println(myMap);
        System.out.println("Username: " + myMap.get("username"));



//        memberList = apiTest.getReportNames("mbthomas74", "21628");
//        rawData = apiTest.getApiInfoTEST(unitNumber, proxyLogin);

//        apiTest.getApiResponseCode("reports?units=21628", "mbthomas74");

//        //List Tests
//        responseCode = apiTest.postListTest("ee4a2b31-a913-442a-9cef-70722cb55f3c", "TEST API",51, "50eff3b6-10c2-4caf-9c18-f070e41fc1ca");
//        Assert.assertEquals(responseCode, 200);
//
//        listMap = apiTest.getListNames("mbthomas74");
//        Assert.assertTrue(listMap.containsKey("TEST API"));
//
//        responseCode = apiTest.listDelete("TEST API", "mbthomas74");
//        Assert.assertEquals(responseCode, 200);
//
//        listMap = apiTest.getListNames("mbthomas74");
//        Assert.assertFalse(listMap.containsKey("TEST API"));





//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports/access", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/user", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/units", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/subscriptions", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/referrals", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/temples", "21628", "mbthomas74");
//        System.out.println("Code: " + codeTest);

//        memberList = apiTest.getReportNames("bradyduck", "111074");


    }



//    @Test
//    public void ReportNameCheckBishop() throws Exception {
//        reportNameToCheck.clear();
//
//        reportNameToCheck.add("ACTION_INTERVIEW");
//        reportNameToCheck.add("BIRTHDAY_LIST");
//        reportNameToCheck.add("KEY_INDICATORS");
//        reportNameToCheck.add("MEMBERS_MOVED_IN");
//        reportNameToCheck.add("MEMBERS_MOVED_OUT");
//        reportNameToCheck.add("MEMBERS_WITH_CALLINGS");
//        reportNameToCheck.add("MEMBERS_WITHOUT_CALLINGS");
//        reportNameToCheck.add("MINISTERING_BROTHERS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS_EDIT");
//        reportNameToCheck.add("MINISTERING_SISTERS");
//        reportNameToCheck.add("MINISTERING_SISTERS_INTERVIEWS");
//        reportNameToCheck.add("MINISTERING_SISTERS_INTERVIEWS_EDIT");
//        reportNameToCheck.add("NEW_MEMBERS");
//        reportNameToCheck.add("QUARTERLY_REPORT");
//        reportNameToCheck.add("SACRAMENT_ATTENDANCE");
//        reportNameToCheck.add("CLASS_QUORUM_ATTENDANCE");
//        reportNameToCheck.add("TEMPLE_RECOMMEND_STATUS");
//        reportNameToCheck.add("UNIT_STATISTICS");
//        reportNameToCheck.add("YOUTH_RECOMMEND_STATUS");
//        reportNameToCheck.add("MISSIONARY_PROGRESS_RECORD");
//
//
//        memberList = apiTest.getReportNames("mbthomas74", "21628");
//
//        System.out.println("Report Name Check Bishop");
//        for(String reportName: reportNameToCheck) {
//            System.out.println("Checking: " + reportName);
//            Assert.assertTrue(memberList.contains(reportName));
//        }
//
//    }

//    @Test
//    public void ReportNameCheckElders() throws Exception {
//        reportNameToCheck.clear();
//
//        reportNameToCheck.add("ACTION_INTERVIEW");
//        reportNameToCheck.add("BIRTHDAY_LIST");
//        reportNameToCheck.add("KEY_INDICATORS");
//        reportNameToCheck.add("MEMBERS_MOVED_IN");
//        reportNameToCheck.add("MEMBERS_MOVED_OUT");
//        reportNameToCheck.add("MEMBERS_WITH_CALLINGS");
//        reportNameToCheck.add("MEMBERS_WITHOUT_CALLINGS");
//        reportNameToCheck.add("MINISTERING_BROTHERS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS_EDIT");
//        reportNameToCheck.add("MINISTERING_SISTERS");
//        reportNameToCheck.add("QUARTERLY_REPORT");
//        reportNameToCheck.add("CLASS_QUORUM_ATTENDANCE");
//        reportNameToCheck.add("UNIT_STATISTICS");
//
//
//
//        memberList = apiTest.getReportNames("bradyduck", "111074");
//
//        System.out.println("Report Name Check Elders");
//        for(String reportName: reportNameToCheck) {
//            System.out.println("Checking: " + reportName);
//            Assert.assertTrue(memberList.contains(reportName));
//        }
//
////        for (String listName: memberList) {
////            System.out.println(listName);
////        }
//
//    }









    //    final private String charset = StandardCharsets.UTF_8.name();
//    final private MediaType applicationJson = MediaType.get("application/json;charset=" + charset);






//    @Test
//    public void apiAuth() {
//        Response resp = RestAssured.given()
//                .formParam("client_id", "ZIUuB0qsmr8Kasdt")
//                .formParam("client_secret", "GZ7ohMinlb5QoN0v0zHgXmUFKOKLcMkC")
//                .formParam("grant_type", "client_credentials")
//                .formParam("scope", "openid")
//                .post("https://ident-int.churchofjesuschrist.org/sso/oauth2/access_token");
//
//        System.out.println("****************************");
//        System.out.println(resp.jsonPath().prettify());
//        System.out.println("****************************");
//        accessToken = resp.jsonPath().get("access_token");
//        idToken = resp.jsonPath().get("id_token");
//
//        Response resp1 = RestAssured.given()
//                .auth()
//                .oauth2(accessToken)
//                .log()
//                .all()
//                .header("Authorization" , "Bearer " + idToken)
//                .header("User-Agent", "Member Tools API Testing")
//                .get("https://mobileauth-int.churchofjesuschrist.org/v1/mobile/login");
////                .get("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units=" + unitNumber);
//
//        System.out.println(resp1.getBody().asString());
//        System.out.println(resp1.jsonPath().prettify());
//    }


}
