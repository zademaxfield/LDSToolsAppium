package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MinisteringScreenTest extends BaseDriver {

    @Test (dataProvider = "Members", groups = {"all2", "all", "smoke", "smoke2"} )
    public void ministeringBasic(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();


            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Households", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Potential Ministering Brothers", pageSource, "Contains"));

            Assert.assertTrue(myBasePage.checkNoCaseList("Relief Society", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Sisters", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Sisters", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Potential Ministering Sisters", pageSource, "Contains"));


            Assert.assertFalse(myBasePage.checkNoCaseList("Home Teaching", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Visiting Teaching", pageSource, "Contains"));

        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }



    @Test (dataProvider = "Members", groups = {"all2", "all", "smoke", "smoke2", "jft"})
    public void ministeringUnassignedHouseholds(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();

            if (calling.equals("reliefsociety") || (calling.equals("wardcouncil"))) {
                if (getRunningOS().equals("mac")) {
                    myMinistering.unassignedHouseholds.click();
                    Thread.sleep(2000);
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertFalse(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                    Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
                } else {
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertFalse(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));
                }


            } else {
                myMinistering.unassignedHouseholds.click();

                Thread.sleep(2000);
                pageSource = myBasePage.getSourceOfPage();

                Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }

        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "smoke", "smoke2"})
    public void ministeringHouseholds(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();
            myMinistering.households.click();

            pageSource = myBasePage.getSourceOfPage();


            if (calling.equals("reliefsociety") || (calling.equals("wardcouncil"))) {
                Assert.assertFalse(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            } else {
                Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

                //Check Filters
                assignedMinisteringBrothers();
                notAssignedMinisteringBrothers();
                newAndMovedInMembers();
                ssAges18to30();
                ssAge32AndOlder();
                sbAges18to30();
                sbAge32AndOlder();
            }


        } else {
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
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();
            myMinistering.companionshipsBrothers.click();

            myMinistering.validateDistrict("District 1");
            myMinistering.validateDistrict("District 2");
            myMinistering.validateDistrict("District 3");


            //Select District 1
            myMinistering.selectDistrict("District 1");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS51", pageSource, "Contains"));

            if (getRunningOS().equals("mac")) {
                myBasePage.backButton.click();
            }

            //Select District 2
            myMinistering.selectDistrict("District 2");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS11", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS23", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));

            if (getRunningOS().equals("mac")) {
                myBasePage.backButton.click();
            }

            //Select District 3
            myMinistering.selectDistrict("District 3");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS21", pageSource, "Contains"));

            if (getRunningOS().equals("mac")) {
                myBasePage.backButton.click();
            }




        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"})
    public void potentialMinisteringBrothers(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();
            myMinistering.potentialMinisteringBrothers.click();

            pageSource = myBasePage.getSourceOfPage();


            if (calling.equals("reliefsociety") || (calling.equals("wardcouncil"))) {
                Assert.assertFalse(myBasePage.checkNoCaseList("AFPSix", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));
            } else {
                Assert.assertTrue(myBasePage.checkNoCaseList("AFPSix", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));
            }



        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (dataProvider = "Members", groups = {"all3", "all", "smoke", "smoke3"})
    public void unassignedSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();
            myMinistering.unassignedSisters.click();

            pageSource = myBasePage.getSourceOfPage();

            if (calling.equals("elders") || (calling.equals("wardcouncil"))) {
                Assert.assertFalse(myBasePage.checkNoCaseList("AFPFive", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            } else {
                Assert.assertTrue(myBasePage.checkNoCaseList("AFPFive", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (dataProvider = "Members", groups = {"all2", "all", "smoke", "smoke2"})
    public void ministeringSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();
            myMinistering.sisters.click();

            pageSource = myBasePage.getSourceOfPage();


            if (calling.equals("elders") || (calling.equals("wardcouncil"))) {
                Assert.assertFalse(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Binks", pageSource, "Contains"));
            } else {
                Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Binks", pageSource, "Contains"));

                //Check Filters
                assignedMinisteringSisters();
                notAssignedMinisteringSisters();
                newAndMovedInMembersSisters();
                ssAges18to30Sisters();
                ssAge32AndOlderSisters();
            }


        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    @Test (dataProvider = "Members", groups = {"all3", "all", "smoke", "smoke3"})
    public void companionshipsSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();
            myMinistering.companionshipsSisters.click();

            myMinistering.validateDistrict("District 1");
            myMinistering.validateDistrict("District 2");
            myMinistering.validateDistrict("Fagamalo Districts");


            //Select District 1
            myMinistering.selectDistrict("District 1");
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS12", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));

            if (getRunningOS().equals("mac")) {
                myBasePage.backButton.click();
            }

            //Select District 2
            myMinistering.selectDistrict("District 2");
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("LDS53", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));

            if (getRunningOS().equals("mac")) {
                myBasePage.backButton.click();
            }


        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    @Test (dataProvider = "Members", groups = {"all4", "all", "smoke", "smoke4"})
    public void potentialMinisteringSisters(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        HelperMethods myHelper = new HelperMethods(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);


        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringReport.click();
            myMinistering.potentialMinisteringSisters.click();

            pageSource = myBasePage.getSourceOfPage();

            if (calling.equals("elders") || (calling.equals("wardcouncil"))) {
                Assert.assertFalse(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            } else {
                Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }








    private void assignedMinisteringBrothers() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.assignedMinisteringBrothers.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPTen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.assignedMinisteringBrothers);

    }

    private void notAssignedMinisteringBrothers() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.notAssignedMinisteringBrothers.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Han Solo", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.notAssignedMinisteringBrothers);

    }

    private void newAndMovedInMembers() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.newAndMovedInMembers.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Faapili", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.newAndMovedInMembers);

    }

    private void ssAges18to30() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Fagaesea", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Yoda", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAges18to30);

    }

    private void ssAge32AndOlder() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Mace", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAge31AndOver);

    }

    private void sbAges18to30() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleBrothersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleBrothersAges18to30);

    }

    private void sbAge32AndOlder() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleBrothersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEleven", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleBrothersAge31AndOver);

    }



    //******************* SISTERS **************************


    private void assignedMinisteringSisters() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.assignedMinisteringSisters.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Bond", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.assignedMinisteringSisters);

    }

    private void notAssignedMinisteringSisters() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.notAssignedMinisteringSisters.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.notAssignedMinisteringSisters);

    }

    private void newAndMovedInMembersSisters() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.newAndMovedInMembers.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Faauma", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.newAndMovedInMembers);

    }

    private void ssAges18to30Sisters() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAges18to30.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAges18to30);

    }

    private void ssAge32AndOlderSisters() {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMinistering.filters.click();
        myMinistering.singleSistersAge31AndOver.click();
        myMinistering.saveMissonaryProgressFilter();

        //Check Data
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));

        //Clear Filter
        clearFilter(myMinistering.singleSistersAge31AndOver);

    }




    private void clearFilter(MobileElement myElement)  {
        MinisteringScreen myMinistering = new MinisteringScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        if (getRunningOS().equals("mac")) {
            myMinistering.filters.click();
            myElement.click();
            myBasePage.backButton.click();
        } else {
            myMinistering.ministeringExpandFilter.click();
            myMinistering.ministeringRemoveFilter.click();
        }
    }






}
