package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MissionLeaderDirectory extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    SettingsScreen mySettings = new SettingsScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
    String pageSource;

    @Given("a Mission President logs in")
    public void aMissionPresidentLogsIn() throws Exception {
        myHelper.proxyLogin("kumfy");
        myHelper.enterPin("1", "1", "3", "3");
    }

    @When("they check their Mission under Directory")
    public void theyCheckTheirMissionUnderDirectory() throws Exception {
        myDirectory.chooseUnit("Ukraine");
    }

    @Then("they should see a list of their missionaries")
    public void theyShouldSeeAListOfTheirMissionaries() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Gallafent"));
    }

    @When("they select a missionary under their mission")
    public void theySelectAMissionaryUnderTheirMission() throws Exception {
        myDirectory.chooseUnit("Ukraine");
        Thread.sleep(2000);
//        System.out.println(myBasePage.getSourceOfPage());
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myDirectory.clickDirectoryUser("Gallafent, Zachary ");
        } else {
            myDirectory.clickDirectoryUser("Gallafent, Zachary");
        }

    }

    @Then("they should have contact information")
    public void theyShouldHaveContactInformation() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Gallafent"));
        Assert.assertTrue(pageSource.contains("801-885-2556"));
        Assert.assertTrue(pageSource.contains("zachary@compguy.com"));
    }

    @Given("a returned missionary logs in")
    public void aReturnedMissionaryLogsIn() throws Exception {
        myHelper.proxyLogin("zsgallafent");
        myHelper.enterPin("1", "1", "3", "3");
    }

    @When("the Whats New Page is displayed")
    public void theWhatsNewPageIsDisplayed() throws Exception {
        myMenu.selectMenu(myMenu.help);
        myWhatsNew.helpWhatsNew.click();
    }

    @Then("the missionary opt in will be displayed")
    public void theMissionaryOptInWillBeDisplayed() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Former Mission Leader"));
        Assert.assertTrue(pageSource.contains("Ukraine"));
        Assert.assertTrue(pageSource.contains("Kumferman"));
    }

    @Given("a Mission President companion logs in")
    public void aMissionPresidentCompanionLogsIn() throws Exception {
        myHelper.proxyLogin("kumfyid");
        myHelper.enterPin("1", "1", "3", "3");
    }

    @When("the Settings page is selected")
    public void theSettingsPageIsSelected() throws Exception {
        myMenu.selectMenu(myMenu.settings);
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myBasePage.scrollToTextGeneral("Mission Leader Access");
        } else {
            //select ios menu but it doesn't always show up.

        }



    }
}
