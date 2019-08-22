package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MissionaryScreenTest extends BaseDriver {


    @Test(dataProvider = "Members", groups = {"smoke3", "smoke", "all3", "all"})
    public void missionaryTest(String userName, String passWord, String rightsString, String calling) throws Exception {
        //String pageSource;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        String pageSource;

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);

        myMissionary.sendReferralButton.click();
        Thread.sleep(3000);
        myMissionary.cancelReferralButton.click();


        pageSource = myMissionary.getMissionaryPage();


        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lawrence", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Young Yen", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Longque", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));


    }


    @Test(groups = {"all4", "all", "jft"})
    public void missionaryOtherUnits() throws Exception {
        //String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);

        String pageSource;

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);

        myMissionary.sendReferralButton.click();
        Thread.sleep(3000);
        myMissionary.cancelReferralButton.click();


        pageSource = myMissionary.getMissionaryPage();

        //Assigned
        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lawrence", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Agalelei", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Puletua", pageSource, "Contains"));
        //Ward
        Assert.assertTrue(myBasePage.checkNoCaseList("Young Yen", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Longque", pageSource, "Contains"));
        //Serving
        Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Longque", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Atonio", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vaifale", pageSource, "Contains"));


        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));


        chooseUnit("Fagamalo 1st");
        pageSource = myMissionary.getMissionaryPage();

        //Assigned
        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lawrence", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Agalelei", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Puletua", pageSource, "Contains"));
        //Ward
        Assert.assertTrue(myBasePage.checkNoCaseList("Poai", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mikaele", pageSource, "Contains"));
        //Serving
        Assert.assertTrue(myBasePage.checkNoCaseList("Sister", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ariel", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Naomanu", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Numia", pageSource, "Contains"));


        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        chooseUnit("Fatuvalu");
        pageSource = myMissionary.getMissionaryPage();

        //Assigned
        Assert.assertTrue(myBasePage.checkNoCaseList("Josh", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Skabelund", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Suelaki", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Rodman", pageSource, "Contains"));
        //Ward
        Assert.assertFalse(myBasePage.checkNoCaseList("Poai", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Mikaele", pageSource, "Contains"));
        //Serving
        Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Eugene", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Faalupega", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mamea", pageSource, "Contains"));


        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        chooseUnit("Paia");
        pageSource = myMissionary.getMissionaryPage();

        //Assigned
        Assert.assertTrue(myBasePage.checkNoCaseList("Enekosi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Moleli", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Benjamin", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Petersen", pageSource, "Contains"));
        //Ward
        Assert.assertTrue(myBasePage.checkNoCaseList("Tanielu", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vailolo", pageSource, "Contains"));
        //Serving
        Assert.assertTrue(myBasePage.checkNoCaseList("Sister", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Osigafeagaiga", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Kirisimasi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Perth", pageSource, "Contains"));


        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        chooseUnit("Safotu");
        pageSource = myMissionary.getMissionaryPage();

        //Assigned
        Assert.assertTrue(myBasePage.checkNoCaseList("Enekosi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Moleli", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Benjamin", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Petersen", pageSource, "Contains"));
        //Ward
        Assert.assertTrue(myBasePage.checkNoCaseList("Tapusoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Pelasio", pageSource, "Contains"));
        //Serving
        Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lj", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Luse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tapusoa", pageSource, "Contains"));


        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        chooseUnit("Saleaula");
        pageSource = myMissionary.getMissionaryPage();

        //Assigned
        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lawrence", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Agalelei", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Puletua", pageSource, "Contains"));
        //Ward
        Assert.assertFalse(myBasePage.checkNoCaseList("Tapusoa", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Pelasio", pageSource, "Contains"));
        //Serving
        Assert.assertFalse(myBasePage.checkNoCaseList("Lj", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Luse", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Tapusoa", pageSource, "Contains"));


        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));


        chooseUnit("Lefagaoalii");
        pageSource = myMissionary.getMissionaryPage();

        //Assigned
        Assert.assertTrue(myBasePage.checkNoCaseList("Josh", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Skabelund", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Suelaki", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Rodman", pageSource, "Contains"));
        //Ward
        Assert.assertFalse(myBasePage.checkNoCaseList("Tapusoa", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Pelasio", pageSource, "Contains"));
        //Serving
        Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vagai", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vagai", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Samoa", pageSource, "Contains"));


        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));


    }










    @Test(groups = {"smoke4", "smoke", "all4", "all"})
    public void missionaryReferralTest() throws Exception {
        //String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        String pageSource;

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools30", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);

        myMissionary.sendReferralButton.click();


        Thread.sleep(2000);
        //Check to see if the Members info is correct
        pageSource = myBasePage.getSourceOfPage();

//        Assert.assertTrue(myBasePage.checkNoCaseList("(385) 800-1234", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Test@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("8018675309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("zademobile004@gmail.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("zmaxfield", pageSource, "Contains"));

        myMissionary.referralName.setValue("Auto Test Name");
        myMissionary.referralPhone.setValue("801-867-5309");

        //System.out.println(myBasePage.getSourceOfPage());
        myBasePage.scrollToTextGeneral("Email");

        myMissionary.referralEmail.setValue("autotest@gmail.com");

        myBasePage.scrollToTextGeneral("Locate on Map");

        myMissionary.referralLocateOnMap.click();

        Thread.sleep(4000);

        //printPageSource();


        //Check to see if locations services has been turned on.
        if (getRunningOS().equals("ios")) {
            driver.switchTo().alert().accept();

        } else {
            if (myBasePage.checkForElement(myBasePage.alertOK)) {
                myBasePage.alertOK.click();
                Thread.sleep(2000);
                myBasePage.allowButton.click();
            }
        }



        Thread.sleep(2000);
        myMissionary.referralMapSearch.setValue("920 Mocking Bird Ln, Sunnyvale");
        Thread.sleep(10000);

        myBasePage.clickByText("920 Mockingbird Ln, Sunnyvale, CA, USA");
        Thread.sleep(5000);


        if (getRunningOS().equals("ios")) {
            myBasePage.iosClickUseThisLocation();
        } else {
            myMissionary.referralUseThisLocation.click();
        }

        //Need a check for the text
        myBasePage.waitUnitlTextIsGone("Saving");


        //Need to finish this
        //clickButton("MissRefPreferredLang", "id", "pred");

        Thread.sleep(2000);

        if(getRunningOS().equals("ios")) {
            myBasePage.scrollDownIOS();
            myMissionary.referralAddMessageButton.click();
        } else {
            myBasePage.scrollToTextGeneral("SEND");
        }
        myMissionary.referralMessageField.setValue("Hello this is a test");

        if (getRunningOS().equals("ios")) {
            //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Message']/following-sibling::XCUIElementTypeImage[@name='minus']")).click();
            myMissionary.referralCancelMessage.click();
            Thread.sleep(2000);
            myBasePage.scrollDownIOS();
            //driver.hideKeyboard();
            //myBasePage.scrollToText("MESSAGE FOR THE MISSIONARIES");
        }

        //printPageSource();
        myMissionary.referralSendReferral.click();

        //Check for icon to disappear
        Thread.sleep(4000);
        if (getRunningOS().equals("ios")) {
            myBasePage.waitUnitlTextIsGone("Processing");
        } else {
            myBasePage.waitUnitlTextIsGone("Sending Referral");
        }


        //Check Nice message
        Thread.sleep(20000);
//        myBasePage.alertOK.click();


//        There is something wrong with the Missionary progress in UAT
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Auto Test Name", pageSource, "Contains"));

        //Check referral
        myBasePage.clickByTextContains("Auto Test Name");

        Thread.sleep(2000);
        pageSource = driver.getPageSource();
        if (myBasePage.getOS().equals("mac")) {
            myBasePage.scrollDownTEST(400);
        } else {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }

        Thread.sleep(2000);
        pageSource = pageSource + driver.getPageSource();

        if (myBasePage.getOS().equals("mac")) {
            myBasePage.scrollDownTEST(400);
        } else {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }

        Thread.sleep(2000);
        pageSource = pageSource + driver.getPageSource();

        Assert.assertTrue(myBasePage.checkNoCaseList("Status", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Assigned to California San Jose Mission", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("California San Jose Mission Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("408-578-9794", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Rodney B. Norling", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("408-733-8125", pageSource, "Contains"));

        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("408-614-3854", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("@missionary.org", pageSource, "Contains"));

        }


        //Remove Referral
        if (getRunningOS().equals("ios")) {
            myMissionary.referralRemove.click();
            myBasePage.alertOK.click();
        } else {
            myBasePage.backButton.click();
            myMissionary.referralOverflowButton.click();
            myMissionary.referralRemove.click();
//            myBasePage.alertOK.click();
            myMissionary.referralRemoveFromList.click();
        }




    }


    @Test(groups = {"all4", "all"})
    public void missionaryReferralNoContactInfo() throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);


        String pageSource;

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools45", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Make sure that the email and phone are blank
        myDirectory.searchAndClick("Tools, LDS45");
        myEditDirectory.clearPhoneAndEmail();
        myBasePage.backToDirectory();


        myMenu.selectMenu(myMenu.missionary);
        myMissionary.sendReferralButton.click();
        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Please update your individual email or phone number in Tools before sending a referral", pageSource, "Contains"));

//        System.out.println(pageSource);

        myMissionary.referralUpdateIndividualInformation.click();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("1(801)240-0104");

        myEditDirectory.menuSave.click();
        myBasePage.waitUnitlTextIsGone("Saving");
        Thread.sleep(6000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Please update your individual email or phone number in Tools before sending a referral", pageSource, "Contains"));


        //Clean up
        myBasePage.backButton.click();
        myMenu.selectMenu(myMenu.directory);
        myDirectory.searchAndClick("Tools, LDS45");
        myEditDirectory.clearPhoneAndEmail();
        myBasePage.backButton.click();



    }


    private void chooseUnit(String myUnit) throws Exception {
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        //Choose different Unit
        myMissionary.unitSelector.click();
        Thread.sleep(2000);
        if (getRunningOS().equalsIgnoreCase("ios")) {
            driver.findElement(By.xpath("//*[contains(@name,'" + myUnit + "')]")).click();
        } else {
            driver.findElement(By.xpath("//*[contains(@text,'" + myUnit + "')]")).click();
        }

    }



}
