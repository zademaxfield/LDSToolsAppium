package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.ListsScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class Lists extends BaseDriver  {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ListsScreen myLists = new ListsScreen(driver);
    String pageSource;
    String numberOfListMembers;


    @Given("a user is logged in and on the Lists page")
    public void aUserIsLoggedInAndOnTheListsPage() throws Exception {
        myHelper.proxyLogin("darthjohn");
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.lists);
        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();
    }


    @When("I add a New List")
    public void iAddANewList() throws Exception{
        myBasePage.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("New Automated List");
        myLists.listsOk.click();
    }


    @And("I add members to the list")
    public void iAddMembersToTheList() throws Exception {
        //Add a member to the list
        myLists.addMemberToList("lovell, heather", "Lovell, Heather");
        myBasePage.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);
    }

    @Then("the New List with the members should be displayed.")
    public void theNewListWithTheMembersShouldBeDisplayed() throws Exception {
        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers("New Automated List");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("1", numberOfListMembers);

        //Check the list members
        myLists.selectListName("New Automated List");
        Thread.sleep(4000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Lovell", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Heather", pageSource, "Contains"));
        myBasePage.backButton.click();
        Thread.sleep(2000);

        //Delete the List
        myLists.deleteList("New Automated List");

        //Make Sure the List is deleted
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("New Automated List", pageSource, "Contains"));
    }
}
