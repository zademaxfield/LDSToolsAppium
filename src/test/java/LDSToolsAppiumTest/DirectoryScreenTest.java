package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.OkHttpClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.auth.AuthScope;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;


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


    @Test(groups = {"all3", "all"})
    public void directoryIndividualHousehold() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

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
        //myDirectory.searchBar.sendKeys("Aaron");

//        Thread.sleep(3000);
//        System.out.println(myBasePage.getSourceOfPage());
        //The thumbNail is showing up a visible=false
        if (myBasePage.getOS().equals("ios")) {
            thumbNailDim = myDirectory.thumbNail.getSize();
//            System.out.println("Height: " + thumbNailDim.getHeight());
//            System.out.println("Width: " + thumbNailDim.getWidth());
            Assert.assertTrue(thumbNailDim.getHeight() != 0);
        } else {
            Assert.assertTrue(myBasePage.checkForElement(myDirectory.thumbNail));
        }


        myDirectory.directorySort.click();
        myDirectory.sortHousehold.click();
        //myDirectory.searchBar.sendKeys("Aaron");

        Assert.assertFalse(myBasePage.checkForElement(myDirectory.thumbNail));

    }


    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoNonLeaderNoPassword() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools5", "toolstester");
        myHelper.nonLeaderNoPin();

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Tools, LDS5");

//        System.out.println(myBasePage.getOS());

        if (myBasePage.getOS().equals("ios")) {
            myBasePage.scrollToTextiOS("Membership Information");
            myDirectory.memebershipInformation.click();
        } else {
            myDirectory.tabMembership.click();
        }



    }

    @Test(groups = {"all2", "all"})
    public void directoryLatLongNoGPS() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Tools, LDS29");

        Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

//        System.out.println(pageSource);

        Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("We're unable to geo-locate your household.", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Use your GPS to locate it.", pageSource, "Contains"));
    }

    @Test(groups = {"all3", "all"})
    public void directoryLatLongNoGPSNoCalling() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools5", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Aaron, Jane");

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        if (myBasePage.getOS().contains("ios")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
        } else {
            Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
        }

        Assert.assertFalse(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("We're unable to geo-locate your household. Use your GPS to locate it.", pageSource, "Contains"));



    }


    @Test(groups = {"all3", "all"})
    public void directoryLatLongCheckLocation() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Ami, Samu");

        Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsAdjustHouseholdLocation));
//        Assert.assertFalse(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));


    }


    @Test(groups = {"all4", "all", "jft"})
    public void directoryLatLongNoGPSChooseLocation() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        resetLatLong();

        myDirectory.searchAndClick("Tools, LDS24");

//        System.out.println(myBasePage.getSourceOfPage());
        Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));

        myDirectory.gpsAdjustHouseholdLocation.click();
        myDirectory.gpsAllowOK.click();

        Thread.sleep(2000);

        if (getRunningOS().equals("ios")) {
            myDirectory.gpsAdjustLocationButton.click();
        } else {
            myBasePage.allowButton.click();
        }

        myDirectory.gpsSearch.setValue("3732 Bryce Canyon Dr, Riverton, Utah");

        Thread.sleep(10000);

        myBasePage.clickByText("3732 Bryce Canyon Dr, Riverton, Utah, USA");
        Thread.sleep(5000);


        
        if (getRunningOS().equals("ios")) {
            myBasePage.iosClickUseThisLocation();
        } else {
            myDirectory.gpsUseThisLocation.click();
        }

        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();


        Assert.assertTrue(myBasePage.checkNoCaseList("40.5152", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("-111.9800", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));






    }

    public void resetLatLong() {
        OkHttpClient client = new OkHttpClient();

        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n  \"householdLocations\": [\n    {\n      \"headOfHouseIndividualId\": 8999999998895108,\n      \"unitNbr\": 56030\n    }\n  ]\n}\n");
            Request request = new Request.Builder()
                    .url("https://ws-int.ldschurch.org/MLU-Services/v1.9/Services/rest/member/householdLocation?headOfHouseMemberId=%228999999998895108%22&latitude=null&longitude=null&locallyVerifiedCode=null&unitNbr=56030")
                    .post(body)
                    .addHeader("authorization", "Basic ZGlyZWN0b3J5OnNlZWtBbmRGaW5k")
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b82ed705-20f4-ef63-9575-b3b091ffc0bb")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Response Code: " + response.code());



        } catch (IOException e) {
            e.printStackTrace();
        }





//        CredentialsProvider provider = new BasicCredentialsProvider();
//        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("directory", "seekAndFind");
//        provider.setCredentials(AuthScope.ANY, credentials);
//        HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
//        HttpPost request = new HttpPost("https://ws-int.ldschurch.org/MLU-Services/v1.9/Services/rest/member/householdLocation");
//
//        System.out.println("Start Post");
//
//        try {
//            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//            nameValuePairs.add(new BasicNameValuePair("headOfHouseMemberId","8999999998895108"));
////            nameValuePairs.add(new BasicNameValuePair("latitude",null));
////            nameValuePairs.add(new BasicNameValuePair("longitude",null));
////            nameValuePairs.add(new BasicNameValuePair("locallyVerifiedCode",null));
//            nameValuePairs.add(new BasicNameValuePair("unitNbr","56030"));
//            request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
////            StringEntity params =new StringEntity("details={\"headOfHouseMemberId\":\"8999999998895108\",\"latitude\":\"\",\"longitude\":\"\",\"locallyVerifiedCode\":\"\",\"unitNbr\":\"7u56030\"} ");
////            request.addHeader("content-type", "application/x-www-form-urlencoded");
////            request.setEntity(params);
//            HttpResponse response = httpClient.execute(request);
//
//            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//            String line = "";
//            while ((line = rd.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        }catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//
//        System.out.println("End Post");



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
