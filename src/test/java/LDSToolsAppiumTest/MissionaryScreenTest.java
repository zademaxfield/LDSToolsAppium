package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import io.appium.java_client.MobileElement;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class MissionaryScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling




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


        Assert.assertTrue(myBasePage.checkNoCaseList("Ariel", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
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
        myHelper.loginUAT("LDSTools20", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);

        myMissionary.sendReferralButton.click();


        Thread.sleep(2000);
        //Check to see if the Members info is correct
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("(385) 800-1234", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Test@gmail.com", pageSource, "Contains"));
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
       // myBasePage.alertOK.click();


        //There is something wrong with the Missionary progress in UAT
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Auto Test Name", pageSource, "Contains"));
//
//        //Check referral
//        myBasePage.clickByText("Auto Test Name");
//
//
//        pageSource = driver.getPageSource();
//        myBasePage.scrollDownTEST(400);
//        pageSource = pageSource + driver.getPageSource();
//
//        Assert.assertTrue(myBasePage.checkNoCaseList("Auto Test Name", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Hello this is a test", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("801-867-5309", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Test@gmail.com", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("autotest@gmail.com", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("920 Mocking Bird Ln", pageSource, "Contains"));


//
//        //Remove Referral
//        if (getRunningOS().equals("ios")) {
//            clickButton("MissRefRemove", "xpath", "pred");
//            clickButton("AddUnitOK", "xpath", "pred");
//        } else {
//            pressBackKey();
//            clickButton("//android.widget.TextView[@text='Auto Test Name']/following-sibling::android.widget.ImageButton[@resource-id='removeReferralImageButton']", "xpathCustom", "xpath");
//            clickButton("MissRefRemoveFromList", "xpath", "xpath");
//            clickButton("AlertOKid", "id", "id");
//        }
//



    }


    @Test(groups = {"all4", "all", "jft"})
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

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Please update your individual email or phone number in LDS Tools before sending a referral", pageSource, "Contains"));

//        System.out.println(pageSource);

        myMissionary.referralUpdateIndividualInformation.click();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("1(801)240-0104");

        myEditDirectory.menuSave.click();
        myBasePage.waitUnitlTextIsGone("Saving");
        Thread.sleep(6000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Please update your individual email or phone number in LDS Tools before sending a referral", pageSource, "Contains"));


        //Clean up
        myBasePage.backButton.click();
        myMenu.selectMenu(myMenu.directory);
        myDirectory.searchAndClick("Tools, LDS45");
        myEditDirectory.clearPhoneAndEmail();
        myBasePage.backButton.click();



    }



}
