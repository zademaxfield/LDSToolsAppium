package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryEditScreen;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;

import org.testng.annotations.Test;


public class HeaderTest extends BaseDriver {


    @Test (groups = {"all3", "all", "header", "smoke", "smoke3"}, enabled = false)
    public void simpleHeaderTest() throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);

        //Login and enter in PIN
        myHelper.loginProxy("20536583369",
                "/7u7110/5u505528/",
                "p1/5u505528/1u425303/:p1933/1316u1968068/:p1680/32u1326376/:p428/467u376892/28u381772/:p1887/14u1004816/467u376892/:p1711/59u1004603/22u388300/");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.checkAllWardDirectories();

    }


    @Test(dataProvider = "Header", groups = {"all2", "all", "header"}, enabled = false)
    public void headerSyncTest(String memberId, String memberUnit, String memberPositions, String memberName) throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);


        //Login and enter in PIN
        System.out.println("Header Name: " + memberName);
        myHelper.loginProxy(memberId,
                memberUnit,
                memberPositions);
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.checkAllWardDirectories();


    }



    @Test (groups = {"NotUsed","jft"}, enabled = false)
    public void headerJustForTesting() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();

        //Login and enter in PIN
        myHelper.loginProxy("1821320094",
                "/5u508381/1u508381/",
                " p726/5u508381/1u508381/:p1729/5u528781/1u528781/:p53/5u528781/1u528781/:p803/5u528781/1u528781/");
        myHelper.enterPin("1", "1", "3", "3");

        Thread.sleep(60000);


    }




}
