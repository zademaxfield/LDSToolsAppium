package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.ListsScreen;
import LDSToolsAppium.Screen.MeetinghousesScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.annotations.Test;


public class ListsScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling




    @Test(groups = {"smoke3", "smoke", "all3", "all", "jft"})
    public void listsSimpleTest() throws Exception {
        String pageSource;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.lists);

        myLists.listsAddList.click();

        myLists.listsName.sendKeys("New Automated List");
        myLists.listsOk.click();

        myLists.addMemberToList("lds32", "LDS32");

        Thread.sleep(2000);

        myLists.listsBackButton.click();

//        pageSource = myBase.getSourceOfPage();
//        System.out.println(pageSource);
        System.out.println(myLists.getNumberOfListMembers("New Automated List"));


        Thread.sleep(10000);


    }



}
