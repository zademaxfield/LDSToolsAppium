package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DirectoryScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling


/*    @Test(dataProvider = "Members", groups = {"smoke2", "smoke", "all2", "all"})
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

    }*/

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
        myDirectory.searchAndClick("Tulia, Faagalo");

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        myBasePage.rightsCheck("Fagamalo", 4, rights, pageSource);
//        myBasePage.rightsCheck("555-555-5555", 4, rights, pageSource);
//        myBasePage.rightsCheck("555-555-1234", 4, rights, pageSource);
//        myBasePage.rightsCheck("HOUSEHOLD", 4, rights, pageSource);
        myBasePage.rightsCheck("faagalotulia81@gmail.com", 4, rights, pageSource);

        //Membership Information
        myBasePage.rightsCheck("MEMBERSHIP INFORMATION", 2, rights, pageSource);
        myBasePage.rightsCheck("Tulia, Faagalo", 2, rights, pageSource);
        myBasePage.rightsCheck("FULL NAME", 2, rights, pageSource);
        myBasePage.rightsCheck("Temple Recommend", 1, rights, pageSource);
        myBasePage.rightsCheck("May 2019", 1, rights, pageSource);
        myBasePage.rightsCheck("Record Number", 1, rights, pageSource);
        myBasePage.rightsCheck("004-0221-4271", 1, rights, pageSource);

        //Birth Date
        myBasePage.rightsCheck("October 9, 1981", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Date", 2, rights, pageSource);
        myBasePage.rightsCheck("37", 2, rights, pageSource);

        //Ordinances
        myBasePage.rightsCheck("Baptism", 1, rights, pageSource);
        myBasePage.rightsCheck("May 25, 2002", 1, rights, pageSource);
        myBasePage.rightsCheck("Confirmation", 1, rights, pageSource);
        myBasePage.rightsCheck("May 26, 2002", 1, rights, pageSource);
        myBasePage.rightsCheck("Endowment", 1, rights, pageSource);
        myBasePage.rightsCheck("May 11, 2017", 1, rights, pageSource);


        //Marriage
        myBasePage.rightsCheck("MARRIAGE", 1, rights, pageSource);
        myBasePage.rightsCheck("Spouse", 1, rights, pageSource);
        myBasePage.rightsCheck("Tulia, Misi", 1, rights, pageSource);
        myBasePage.rightsCheck("Spouse Birth Date", 1, rights, pageSource);
        myBasePage.rightsCheck("August 7, 1981", 1, rights, pageSource);
        myBasePage.rightsCheck("Marriage Date", 1, rights, pageSource);
        myBasePage.rightsCheck("September 21, 2003", 1, rights, pageSource);
        myBasePage.rightsCheck("Marriage Place", 1, rights, pageSource);
        myBasePage.rightsCheck("Fagamalo, Savaii, Western Samoa", 1, rights, pageSource);
        myBasePage.rightsCheck("Maiden Name", 1, rights, pageSource);
        myBasePage.rightsCheck("Numia, Faagalo", 1, rights, pageSource);



        //Callings and Classes - New in 3.0.0
//        myBasePage.rightsCheck("Relief Society First Counselor", 4, rights, pageSource);
//        myBasePage.rightsCheck("Organization - Relief Society Presidency", 4, rights, pageSource);
        myBasePage.rightsCheck("Class Assignments", 2, rights, pageSource);
        myBasePage.rightsCheck("Gospel Doctrine", 2, rights, pageSource);
        myBasePage.rightsCheck("Relief Society", 4, rights, pageSource);
//        myBasePage.rightsCheck("Sustained", 2, rights, pageSource);
//        myBasePage.rightsCheck("Set Apart", 2, rights, pageSource);



        // myBasePage.rightsCheck("Ordinances", 2, rights, pageSource);
        myBasePage.rightsCheck("Gender", 2, rights, pageSource);
        myBasePage.rightsCheck("Female", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Country", 1, rights, pageSource);
        myBasePage.rightsCheck("Samoa", 1, rights, pageSource);
        myBasePage.rightsCheck("Father", 1, rights, pageSource);
        myBasePage.rightsCheck("Numia, Tavale", 1, rights, pageSource);
        myBasePage.rightsCheck("Mother", 1, rights, pageSource);
        myBasePage.rightsCheck("Maiava, Oleni", 1, rights, pageSource);
        myBasePage.rightsCheck("Prior Unit", 1, rights, pageSource);
        myBasePage.rightsCheck("Tafuna", 1, rights, pageSource);


    }

/*    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoHousehold() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        if (myBasePage.getOS().contains("ios")) {
            myDirectory.searchAndClickHousehold("Tools, LDS11 & LDS12");
            myBasePage.clickByTextContains("LDS11");
        } else {
            myDirectory.searchAndClickHousehold("Tools, LDS11");
        }

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS11", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("888-0028-7112", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("January 1, 1980", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("May 5, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("May 5, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("October 10, 2013", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS12", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("January 1, 1980", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("January 1, 2013", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("United States", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("LDS22", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS23", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS14", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS10", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("LDS13", pageSource, "Contains"));
    }*/


/*
    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoIndividual() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Tools, LDS11");


        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS11", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("888-0028-7112", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("January 1, 1980", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("May 5, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("May 5, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("October 10, 2013", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS12", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("January 1, 1980", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("January 1, 2013", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("United States", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("LDS22", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS23", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS14", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LDS10", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("LDS13", pageSource, "Contains"));
    }
*/


    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoHousehold() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        if (myBasePage.getOS().contains("ios")) {
            myDirectory.searchAndClickHousehold("Ami, Samu & Lealofi");
            myBasePage.clickByTextContains("Samu");
        } else {
            myDirectory.searchAndClickHousehold("Ami, Samu");
        }

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Samu", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("004-0253-3962", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("July 13, 1973", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 9, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 10, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("October 19, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 29, 2004", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Parents", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 6, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Endowment", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 6, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 6, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 22, 2013", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Pi, Lealofi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("July 26, 1971", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("October 27, 1997", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Place", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tuasivi Savaii", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Apia Samoa Temple", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthplace", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tuasivi Hospital", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Father", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Muagututia, Ami", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mother", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lalomato, Lesi", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priests Quorum President", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("High Priests Quorum", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Gospel Doctrine", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

//        Assert.assertTrue(myBasePage.checkNoCaseList("Ennie", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Polataia", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Lasi", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Masina", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Joe", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Tavale", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Misi", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ualesi", pageSource, "Contains"));
//
//        Assert.assertTrue(myBasePage.checkNoCaseList("Faleatafa", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ariel", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Christian", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Miracle", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Tanumaglynn", pageSource, "Contains"));


    }

    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoIndividual() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Ami, Samu");


        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Samu", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("004-0253-3962", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("July 13, 1973", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 9, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 10, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("October 19, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 29, 2004", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Parents", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 6, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Endowment", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 6, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 6, 2005", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 22, 2013", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Pi, Lealofi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("July 26, 1971", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("October 27, 1997", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Place", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tuasivi Savaii", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Apia Samoa Temple", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthplace", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tuasivi Hospital", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Father", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Muagututia, Ami", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mother", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lalomato, Lesi", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priests Quorum President", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("High Priests Quorum", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Gospel Doctrine", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

//        Assert.assertTrue(myBasePage.checkNoCaseList("Ennie", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Polataia", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Lasi", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Masina", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Joe", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Tavale", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Misi", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ualesi", pageSource, "Contains"));
//
//        Assert.assertTrue(myBasePage.checkNoCaseList("Faleatafa", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ariel", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Christian", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Miracle", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Tanumaglynn", pageSource, "Contains"));
    }


    @Test(groups = {"all3", "all", "jft"})
    public void directoryIndividualHousehold() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        //Should be Household view by default
        Assert.assertFalse(myBasePage.checkForElement(myDirectory.thumbNail));

        myDirectory.directorySort.click();
        myDirectory.sortIndividual.click();

        Assert.assertTrue(myBasePage.checkForElement(myDirectory.thumbNail));

        myDirectory.directorySort.click();
        myDirectory.sortHousehold.click();

        Assert.assertFalse(myBasePage.checkForElement(myDirectory.thumbNail));

    }


    @Test(dataProvider = "Members", groups = {"goat"})
    public void directoryScrollTest(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
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

        //myBasePage.scrollDownTEST(100);


        myBasePage.scrollDownAndroidUIAutomator("0");
        Thread.sleep(10000);
        myBasePage.scrollUpAndroidUIAutomator("0");


    }

}
