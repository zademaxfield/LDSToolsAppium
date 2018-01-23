package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DirectoryScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Speical?
    //4 = No Calling

    @DataProvider(name = "Members")
    public static Object[][] credentials() {
        return new Object[][] { { "LDSTools2", "toolstester", 1},
                {"LDSTools5", "toolstester", 4},
                {"LDSTools16", "password1", 2} };
    }

    @Test(dataProvider = "Members")
    public void directoryScreenTest(String userName, String passWord, int rights) throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");
        if(getRunningOS().equals("android")) {
            myMenu.laterButton.click();
        }
        myMenu.directory.click();
        myDirectory.searchAndClick("Aaron, Jane");

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
        myBasePage.rightsCheck("Relief Society Pianist", 2, rights, pageSource);
        myBasePage.rightsCheck("Organization - Music", 2, rights, pageSource);
        myBasePage.rightsCheck("Class Assignments", 2, rights, pageSource);
        myBasePage.rightsCheck("Gospel Doctrine", 2, rights, pageSource);
        myBasePage.rightsCheck("Relief Society", 2, rights, pageSource);
        myBasePage.rightsCheck("Sustained", 2, rights, pageSource);
        myBasePage.rightsCheck("Set Apart", 2, rights, pageSource);

        //Birth Date
        myBasePage.rightsCheck("November 11, 1960", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Date", 2, rights, pageSource);
        myBasePage.rightsCheck("55", 2, rights, pageSource);

        //Ordinances
        myBasePage.rightsCheck("Baptism", 1, rights, pageSource);
        myBasePage.rightsCheck("Confirmation", 1, rights, pageSource);
        myBasePage.rightsCheck("November 11, 1970", 1, rights, pageSource);
        myBasePage.rightsCheck("Ordinances", 2, rights, pageSource);
        myBasePage.rightsCheck("Gender", 2, rights, pageSource);
        myBasePage.rightsCheck("Female", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Country", 1, rights, pageSource);
        myBasePage.rightsCheck("United States", 1, rights, pageSource);

    }

}
