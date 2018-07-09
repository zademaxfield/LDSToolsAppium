package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryEditScreen;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DirectoryEditScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling


    @Test(groups = {"smoke4", "smoke", "all2", "all", "jft"})
    public void editCurrentUser() throws Exception {
        String pageSource;


        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);

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

        Thread.sleep(4000);

        pageSource = myDirectory.getDirectoryUserData();

        //pageSource = getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


        myBasePage.backToDirectory();


        //myHelper.runSync();
        myMenu.menuLogOut();
        myHelper.loginUAT("LDSTools44", "password1");
        myHelper.enterPin("1", "1", "3", "3");


        //Search for logged in user
        myDirectory.searchAndClick("Tools, LDS44");

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

        pageSource = myDirectory.getDirectoryUserData();
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS44", pageSource, "Contains"));


        Thread.sleep(3000);
        Assert.assertFalse(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


    }

    @Test(groups = {"smoke3", "smoke", "all3", "all"})
    public void editCurrentUserCancel() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
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

        myEditDirectory.cancelButton.click();
        if (!getRunningOS().equals("ios")) {
            myBasePage.alertOK.click();
        }

        Thread.sleep(3000);
        pageSource = myDirectory.getDirectoryUserData();

        Assert.assertFalse(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


    }

    @Test(groups = {"smoke4", "smoke", "all4", "all"})
    public void editOtherUser() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
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

        pageSource = myDirectory.getDirectoryUserData();

        //pageSource = getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


        myBasePage.backToDirectory();

        myDirectory.sortToHousehold();

        //myHelper.runSync();


        myMenu.menuLogOut();
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");


        //Search for logged in user
        myDirectory.searchAndClick("Tools, LDS44");

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

        pageSource = myDirectory.getDirectoryUserData();
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS44", pageSource, "Contains"));


        Thread.sleep(3000);
        Assert.assertFalse(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


    }


    @Test(groups = {"smoke1", "smoke", "all1", "all"})
    public void editPhoneInvalid() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools43", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Tools, LDS43");


        myEditDirectory.clearPhoneAndEmail();

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalPhone.sendKeys("123456789012345678901234567890123456789012345678901234567890badbadleroybrown");
        saveInvalid("phone");
        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("##################$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&*************())()()()(()())(()()(@!@@");
        saveInvalid("phone");
        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("     801     867             5309$");
        saveInvalid("phone");
        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("phone");
        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("123456789012345678901234567890123456789012345678901234567890badbadleroybrown");
        saveInvalid("phone");
        myEditDirectory.directoryEditHouseholdPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("##################$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&*************())()()()(()())(()()(@!@@");
        saveInvalid("phone");
        myEditDirectory.directoryEditHouseholdPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("     801     867             5309$");
        saveInvalid("phone");
        myEditDirectory.directoryEditHouseholdPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("phone");
        myEditDirectory.directoryEditHouseholdPhone.clear();

        savingMemberInfo();

    }

    @Test(groups = {"smoke1", "smoke", "all1", "all"})
    public void editEmailInvalid() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools43", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Tools, LDS43");


        myEditDirectory.clearPhoneAndEmail();

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalEmail.sendKeys("hello there");
        saveInvalid("email");
        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditPersonalEmail.sendKeys("notatsign.com");
        saveInvalid("email");
        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditPersonalEmail.sendKeys("nodotafterthe@sign");
        saveInvalid("email");
        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditPersonalEmail.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("email");
        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("hello there");
        saveInvalid("email");
        myEditDirectory.directoryEditHouseholdEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("notatsign.com");
        saveInvalid("email");
        myEditDirectory.directoryEditHouseholdEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("nodotafterthe@sign");
        saveInvalid("email");
        myEditDirectory.directoryEditHouseholdEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("email");
        myEditDirectory.directoryEditHouseholdEmail.clear();

        savingMemberInfo();

    }

    //Todo: needs more work
    @Test(groups = {"smoke1", "smoke", "all1", "all"})
    public void editVisibility() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBase = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        Boolean foundMember;


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools5", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Tools, LDS5");

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        //Reset Visibility
        myEditDirectory.resetVisibility();
        myEditDirectory.editUserOpen();

        myEditDirectory.setVisibilityHousehold(myEditDirectory.privateLeadershipOnly);

        //myEditDirectory.menuSave.click();

        myBase.backToDirectory();

        myMenu.menuLogOut();


        //Make sure members without callings cannot see the members info
        myHelper.loginUAT("LDSTools6", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        foundMember = myDirectory.searchForMemberCheckResults("Tools, LDS5");
        Assert.assertFalse(foundMember);
        Thread.sleep(2000);
        myBase.backToDirectory();
        myMenu.menuLogOut();

        //Check Ward Council Access
        myHelper.loginUAT("LDSTools25", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        foundMember = myDirectory.searchForMemberCheckResults("Tools, LDS5");
        Assert.assertTrue(foundMember);
        Thread.sleep(2000);
        myBase.backToDirectory();
        myMenu.menuLogOut();

        //Reset visibility settings back to normal
        myHelper.loginUAT("LDSTools5", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Tools, LDS5");

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        //Reset Visibility
        myEditDirectory.resetVisibility();
        //myEditDirectory.menuSave.click();
        myBase.backToDirectory();

        myMenu.menuLogOut();

        //Make sure members without callings cannot see the members info
        myHelper.loginUAT("LDSTools6", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        foundMember = myDirectory.searchForMemberCheckResults("Tools, LDS5");
        Assert.assertTrue(foundMember);


    }







    private void saveInvalid(String myType) throws Exception {
        boolean failedFound;
        String pageSource;

        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBasePage = new BasePage(driver);

//        if (getRunningOS().equals("ios")) {
//            myEditDirectory.menuSave.click();
//        }

        Thread.sleep(2000);

        if (myType.equals("phone")) {
            myEditDirectory.menuSave.click();
            failedFound = myBasePage.checkForElement(myEditDirectory.saveFailedDialog);
            Assert.assertTrue(failedFound);
            myBasePage.alertOK.click();
        } else {
            if (getRunningOS().equals("ios")) {
                myEditDirectory.menuSave.click();
                failedFound = myBasePage.checkForElement(myEditDirectory.invalidEmail);
            } else {
                pageSource = myBasePage.getSourceOfPage();
                failedFound = myBasePage.checkNoCaseList("you must provide a valid email address", pageSource, "Contains");
            }
            Assert.assertTrue(failedFound);
            if (getRunningOS().equals("ios")) {
                myBasePage.alertOK.click();
            }
        }


    }



    private void savingMemberInfo() throws Exception{
        int myCounter = 0;

        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
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
