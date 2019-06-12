package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.ListsScreen;
import LDSToolsAppium.Screen.MeetinghousesScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ListsScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling




    @Test(groups = {"smoke3", "smoke", "all3", "all"})
    public void listsSimpleTest() throws Exception {
        String pageSource;
        String numberOfListMembers;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("New Automated List");
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds32", "LDS32");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers("New Automated List");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("1", numberOfListMembers);

        //Check the list members
        myLists.selectListName("New Automated List");
        Thread.sleep(4000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList("Tools", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS32", pageSource, "Contains"));
        myBase.backButton.click();
        Thread.sleep(2000);

        //Delete the List
        myLists.deleteList("New Automated List");

        //Make Sure the List is deleted
        Thread.sleep(2000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList("New Automated List", pageSource, "Contains"));

    }


    @Test(groups = {"all3", "all", "jft"})
    public void listsMultipleSyncTest() throws Exception {
        String pageSource;
        String numberOfListMembers;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools25", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("Test List 1");
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds20", "LDS20");
        myLists.addMemberToList("lds21", "LDS21");
        myLists.addMemberToList("lds22", "LDS22");
        myLists.addMemberToList("lds23", "LDS23");
        myLists.addMemberToList("lds24", "LDS24");
        myLists.addMemberToList("lds25", "LDS25");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers("Test List 1");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("6", numberOfListMembers);

        //Check the list members
        checkListMembers();



        //Logout - Login
        myMenu.menuLogOut();
        myHelper.loginUAT("LDSTools25", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check the list members
        checkListMembers();

        //Delete the List
        myLists.deleteList("Test List 1");

        //Make Sure the List is deleted
        Thread.sleep(2000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList("Test List 1", pageSource, "Contains"));

    }



    private void checkListMembers() throws Exception {
        String pageSource;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);

        myLists.selectListName("Test List 1");
        Thread.sleep(4000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList("Tools", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS20", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS21", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS22", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS23", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS24", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS25", pageSource, "Contains"));
        myBase.backButton.click();
        Thread.sleep(2000);
    }






}
