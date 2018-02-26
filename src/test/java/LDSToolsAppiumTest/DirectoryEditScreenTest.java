package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryEditScreen;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;


public class DirectoryEditScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling


    @Test(dataProvider = "Members", groups = {"smoke2", "smoke", "all2", "all", "jft"})
    public void editCurrentUser(@NoInjection String userName, String passWord, String rightsString, String callingGroup) throws Exception {
        String pageSource;
        int myCounter = 0;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools44", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Tools, LDS44");


        myEditDirectory.clearPhoneAndEmail();

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalPhone.sendKeys("1(801)240-0104");
        myEditDirectory.directoryEditHouseholdPhone.sendKeys("(801) 867-5309");
        myEditDirectory.directoryEditPersonalEmail.sendKeys("personal@gmail.com");
        myEditDirectory.directoryEditHouseholdEmail.sendKeys("home@gmail.com");

        savingMemberInfo();

        if (getRunningOS().equals("mac")) {
            myDirectory.clickDirectoryUser("LDS44 Tools (38)");
        }
        pageSource = myDirectory.getDirectoryUserData();

        //pageSource = getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


        myBasePage.backToDirectory();


        myHelper.runSync();

        //Search for logged in user
        myDirectory.searchAndClick("Tools, LDS44");

        if (getRunningOS().equals("mac")) {
            myDirectory.clickDirectoryUser("LDS44 Tools (38)");
        }
        pageSource = myDirectory.getDirectoryUserData();

        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS44", pageSource, "Contains"));

        //Check the users name, address membership number etc...
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));

        Thread.sleep(2000);
        myEditDirectory.clearPhoneAndEmail();


        Thread.sleep(2000);
        myBasePage.scrollDownTEST(-400);
        Thread.sleep(1000);
        myBasePage.backToDirectory();

        //Search for logged in user
        myDirectory.searchAndClick("Tools, LDS44");

        if (getRunningOS().equals("mac")) {
            myDirectory.clickDirectoryUser("LDS44 Tools (38)");
        }
        pageSource = myDirectory.getDirectoryUserData();
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS44", pageSource, "Contains"));


        Thread.sleep(3000);
        Assert.assertFalse(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


    }


    private void savingMemberInfo() throws Exception{
        int myCounter = 0;

        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        do {
            myEditDirectory.menuSave.click();
            myBasePage.waitUnitlTextIsGone("Saving");
            Thread.sleep(6000);

            if (myBasePage.checkForAlert()) {
                myBasePage.alertOK.click();
                myCounter++;
                System.out.println("Alert Found: " + myCounter);
            } else {
                myCounter = 6;
            }

        } while (myCounter < 4);

        if (myBasePage.checkForAlert()) {
            myBasePage.alertOK.click();
            myDirectory.directoryEdit.click();
            myBasePage.waitUnitlTextIsGone("Downloading");
            Thread.sleep(6000);
        }
    }

}
