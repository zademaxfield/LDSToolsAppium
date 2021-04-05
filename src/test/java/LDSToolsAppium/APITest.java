package LDSToolsAppium;

import LDSToolsAppium.API.MemberToolsAPI;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITest {

    List<String> memberList = new ArrayList<String>();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    String unitNumber = "21628";
    String proxyLogin = "kroqbandit";



    @Test
    public void test1() throws Exception {
        memberList = apiTest.getReportNames("kroqbandit", "21628");
        for(String reportName: memberList) {
            System.out.println(reportName);
        }

    }

}
