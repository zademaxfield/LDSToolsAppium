package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DirectoryScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling


    @Test(dataProvider = "Members", groups = {"smoke2", "smoke", "all2", "all"})
    public void directoryScreenTest(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Aaron, Jane");

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        myBasePage.rightsCheck("Fagamalo", 4, rights, pageSource);
        myBasePage.rightsCheck("555-555-5555", 4, rights, pageSource);
        myBasePage.rightsCheck("555-555-1234", 4, rights, pageSource);
        myBasePage.rightsCheck("HOUSEHOLD", 4, rights, pageSource);
        myBasePage.rightsCheck("no-reply@ldschurch.org", 4, rights, pageSource);

        //Membership Information
        myBasePage.rightsCheck("MEMBERSHIP INFORMATION", 2, rights, pageSource);
        myBasePage.rightsCheck("AFPMisc, Member2", 2, rights, pageSource);
        myBasePage.rightsCheck("FULL NAME", 2, rights, pageSource);

        //Callings and Classes - New in 3.0.0
        myBasePage.rightsCheck("Relief Society Pianist", 4, rights, pageSource);
        myBasePage.rightsCheck("Organization - Music", 4, rights, pageSource);
        myBasePage.rightsCheck("Class Assignments", 2, rights, pageSource);
        myBasePage.rightsCheck("Gospel Doctrine", 2, rights, pageSource);
        myBasePage.rightsCheck("Relief Society", 4, rights, pageSource);
        myBasePage.rightsCheck("Sustained", 2, rights, pageSource);
        myBasePage.rightsCheck("Set Apart", 2, rights, pageSource);

        //Birth Date
        myBasePage.rightsCheck("November 11, 1960", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Date", 2, rights, pageSource);
        myBasePage.rightsCheck("57", 2, rights, pageSource);

        //Ordinances
        myBasePage.rightsCheck("Baptism", 1, rights, pageSource);
        myBasePage.rightsCheck("Confirmation", 1, rights, pageSource);
        myBasePage.rightsCheck("November 11, 1970", 1, rights, pageSource);
        // myBasePage.rightsCheck("Ordinances", 2, rights, pageSource);
        myBasePage.rightsCheck("Gender", 2, rights, pageSource);
        myBasePage.rightsCheck("Female", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Country", 1, rights, pageSource);
        myBasePage.rightsCheck("United States", 1, rights, pageSource);

    }

}
