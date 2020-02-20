package LDSToolsAppium;

import LDSToolsAppium.API.MemberToolsAPI;
import org.testng.annotations.Test;

public class MemberToolsAPITest {

    public MemberToolsAPITest() {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s [%3$s] %5$s %6$s%n");
    }

    @Test
    public void testToolsService() throws Exception {
        new MemberToolsAPI().getOrganizationMembers("Elders Quorum Presidency", "kroqbandit", "21628");
    }
}