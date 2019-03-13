package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MinisteringScreenTest extends BaseDriver {

    @Test (dataProvider = "Members", groups = {"all2", "all", "smoke", "smoke2"})
    public void ministeringBasic(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));


            myMinistering.ministeringBrothersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Households", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));

            myBasePage.backButton.click();

            myMinistering.ministeringSistersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Sisters", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Sisters", pageSource, "Contains"));

            myBasePage.backButton.click();

        }


        if (rights == 3) {
            myMenu.selectMenu(myMenu.reports);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));
        }


        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }


    }



    @Test (dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"})
    public void ministeringUnassignedHouseholds(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedHouseholds.click();
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Aiono", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            myBasePage.backButton.click();
            myBasePage.backButton.click();


            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedSisters.click();
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Apulu", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            myBasePage.backButton.click();
            myBasePage.backButton.click();


        }


        if (rights == 3) {
            myMenu.selectMenu(myMenu.reports);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));
        }


        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }


    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "smoke", "smoke2", "jft"})
    public void ministeringAssignedHouseholds(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();
            myMinistering.assignedHouseholds.click();

            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("Apolo", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));



        }


        if (rights == 3) {
            myMenu.selectMenu(myMenu.reports);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));
        }


        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }



    }

    @Test (dataProvider = "Members", groups = {"all3", "all", "smoke", "smoke3"})
    public void companionshipsElders(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();


            myMinistering.validateDistrict("District 11");
            myMinistering.validateDistrict("District 12");
            myMinistering.validateDistrict("District 13");


            //Select District 1
            myMinistering.selectDistrict("District 11");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS51", pageSource, "Contains"));

            myBasePage.backButton.click();

            //Select District 2
            myMinistering.selectDistrict("District 12");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS11", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS23", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));

            myBasePage.backButton.click();

            //Select District 3
            myMinistering.selectDistrict("District 13");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));

            myBasePage.backButton.click();


        }

        if (rights == 3) {
            myMenu.selectMenu(myMenu.reports);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));
        }


        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

//    @Test (dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"}, enabled = false)
//    public void potentialMinisteringBrothers(String userName, String passWord, String rightsString, String calling) throws Exception {
//        String pageSource;
//        int rights = Integer.parseInt(rightsString);
//
//
//        HelperMethods myHelper = new HelperMethods(driver);
//        BasePage myBasePage = new BasePage(driver);
//        MenuScreen myMenu = new MenuScreen(driver);
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//
//
//        myHelper.loginUAT(userName, passWord);
//        myHelper.enterPin("1", "1", "3", "3");
//
//
//
//        if (rights <= 3) {
//            myMenu.selectMenu(myMenu.reports);
//            myMinistering.ministeringReport.click();
//            myMinistering.potentialMinisteringBrothers.click();
//            Thread.sleep(2000);
//
//            pageSource = myBasePage.getSourceOfPage();
//
//
//            if (calling.equals("reliefsociety") || (calling.equals("wardcouncil"))) {
//                Assert.assertFalse(myBasePage.checkNoCaseList("AFPSix", pageSource, "Contains"));
//                Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));
//            } else {
//                Assert.assertTrue(myBasePage.checkNoCaseList("AFPSix", pageSource, "Contains"));
//                Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));
//            }
//
//
//
//        } else {
//            pageSource = myBasePage.getSourceOfPage();
//            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
//        }
//    }

    @Test (dataProvider = "Members", groups = {"all1", "all", "smoke", "smoke1"})
    public void unassignedSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            //myMinistering.ministeringReport.click();
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);

            if (calling.equals("elders") || (calling.equals("wardcouncil"))) {
                if (getRunningOS().equals("ios")) {
                    myMinistering.unassignedSisters.click();
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertFalse(myBasePage.checkNoCaseList("Alafoni", pageSource, "Contains"));
                    Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
                } else {
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertFalse(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));
                }
            } else {
                myMinistering.unassignedSisters.click();
                Thread.sleep(2000);
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Alafoni", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


        }

        if (rights == 3) {
            myMenu.selectMenu(myMenu.reports);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));
        }


        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"})
    public void ministeringAssignedSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");
        Thread.sleep(2000);



        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.assignedSisters.click();

            //myMinistering.sisters.click();
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Alafoni", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Binks", pageSource, "Contains"));


        }

        if (rights == 3) {
            myMenu.selectMenu(myMenu.reports);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));
        }


        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }

    }

    @Test (dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"})
    public void companionshipsSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 2) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();


            myMinistering.validateDistrict("District 11");
            myMinistering.validateDistrict("District 12");
           // myMinistering.validateDistrict("Fagamalo Districts");


            //Select District 1
            myMinistering.selectDistrict("District 11");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS12", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));


            myBasePage.backButton.click();


            //Select District 2
            myMinistering.selectDistrict("District 12");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS35", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));


            myBasePage.backButton.click();



        }


        if (rights == 3) {
            myMenu.selectMenu(myMenu.reports);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));
        }


        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }


    }


//    @Test (dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"}, enabled = false)
//    public void potentialMinisteringSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
//        String pageSource;
//        int rights = Integer.parseInt(rightsString);
//
//
//        HelperMethods myHelper = new HelperMethods(driver);
//        BasePage myBasePage = new BasePage(driver);
//        MenuScreen myMenu = new MenuScreen(driver);
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//
//
//        myHelper.loginUAT(userName, passWord);
//        myHelper.enterPin("1", "1", "3", "3");
//
//
//
//        if (rights <= 3) {
//            myMenu.selectMenu(myMenu.reports);
//            myMinistering.ministeringReport.click();
//            myMinistering.potentialMinisteringSisters.click();
//
//            Thread.sleep(1000);
//
//            pageSource = myBasePage.getSourceOfPage();
//
//            if (calling.equals("elders") || (calling.equals("wardcouncil"))) {
//                Assert.assertFalse(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
//                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
//            } else {
//                Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
//                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
//            }
//
//
//        } else {
//            pageSource = myBasePage.getSourceOfPage();
//            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
//        }
//    }








    private void assignedMinisteringBrothers() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.assignedMinisteringBrothers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPTen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.assignedMinisteringBrothers);

    }

    private void notAssignedMinisteringBrothers() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.notAssignedMinisteringBrothers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Han Solo", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.notAssignedMinisteringBrothers);

    }

    private void newAndMovedInMembers() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.newAndMovedInMembers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Mene", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.newAndMovedInMembers);

    }

    private void ssAges18to30() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Fagaesea", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Yoda", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAges18to30);

    }

    private void ssAge32AndOlder() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);
        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Mace", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAge31AndOver);

    }

    private void sbAges18to30() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleBrothersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleBrothersAges18to30);

    }

    private void sbAge32AndOlder() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleBrothersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEleven", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleBrothersAge31AndOver);

    }



    //******************* SISTERS **************************


    private void assignedMinisteringSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.assignedMinisteringSisters.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Bond", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.assignedMinisteringSisters);

    }

    private void notAssignedMinisteringSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.notAssignedMinisteringSisters.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.notAssignedMinisteringSisters);

    }

    private void newAndMovedInMembersSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.newAndMovedInMembers.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Mene", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.newAndMovedInMembers);

    }

    private void ssAges18to30Sisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);


        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAges18to30);

    }

    private void ssAge32AndOlderSisters() throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        Thread.sleep(1000);

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAge31AndOver);

    }




    private void clearFilter(MobileElement myElement) throws Exception {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        if (getRunningOS().equals("ios")) {
            myMinistering.filters.click();
            myElement.click();
            myBasePage.backButton.click();
        } else {
            Thread.sleep(1000);
            //myMinistering.ministeringExpandFilter.click();
            //Thread.sleep(9000);
            myMinistering.ministeringRemoveFilter.click();
        }
    }






}
