package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class SacramentAttendance extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    String pageSource;



    @Given("a {string} is on the Sacrament Attendance page")
    public void aMemberIsOnTheSacramentAttendancePage(String memberCalling) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(memberCalling);
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        if (!myBasePage.checkForElement(myReports.sacramentAttendanceReport)) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        myReports.sacramentAttendanceReport.click();
    }

    @When("{string} is entered in the {string}")
    public void isEnteredInThe(String valueToEnter, String fieldToEnter) throws Exception  {
        MobileElement sacToEnter;
        //Need to scroll down or iOS cannot see the elements.
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
        }
        clickElement(fieldToEnter);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            sacToEnter = getSunday(fieldToEnter);
            sacToEnter.clear();
            sacToEnter.setValue(valueToEnter);
            myBasePage.keyboardReturn.click();
        } else {
            myReports.sacramentAttendanceDialogEditField.setValue(valueToEnter);
            myReports.sacramentAttendanceDialogOk.click();
            Thread.sleep(2000);
        }
        iShouldSee(valueToEnter);
        myBasePage.backButton.click();
//        System.out.println(myBasePage.getSourceOfPage());
        Thread.sleep(5000);
        myReports.sacramentAttendanceReport.click();
        Thread.sleep(5000);
    }

    @Then("I should see {string}")
    public void iShouldSee(String searchItem) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains(searchItem));
    }

    @Then("I should see {string} in the {string}")
    public void iShouldSeeInThe(String textToCheck, String fieldToCheck) throws Exception {
        Thread.sleep(2000);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
        }
        String textFromElement = getTextFromElement(fieldToCheck);
        Assert.assertTrue(textToCheck.contains(textFromElement));
    }

    @Given("a {string} is on the Reports page")
    public void aIsOnTheReportsPage(String memberCalling) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(memberCalling);
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
    }

    @Then("I should not see {string}")
    public void iShouldNotSee(String searchItem) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(pageSource.contains(searchItem));
    }


    @When("a {string} is entered using the counter")
    public void aIsEnteredUsingTheCounter(String counterNumber) throws Exception {
        int counterTotal;
        counterTotal = Integer.parseInt(counterNumber);
        myReports.sacramentAttendanceCounterIcon.click();
        counterPressAdd(counterTotal);
        iShouldSee(counterNumber);
        myReports.sacramentAttendanceCounterSave.click();
        Thread.sleep(2000);
    }

    @When("a {string} is entered using the counter without saving")
    public void aIsEnteredUsingTheCounterWithoutSaving(String counterNumber) throws Exception{
        int counterTotal;
        counterTotal = Integer.parseInt(counterNumber);
        myReports.sacramentAttendanceCounterIcon.click();
        counterPressAdd(counterTotal);
    }

    @And("a {string} is entered in using the minus counter")
    public void aIsEnteredInUsingTheMinusCounter(String counterNumber) throws Exception{
        int counterTotal;
        counterTotal = Integer.parseInt(counterNumber);
//        myReports.sacramentAttendanceCounterIcon.click();
        counterPressMinus(counterTotal);
        iShouldSee(counterNumber);
        myReports.sacramentAttendanceCounterSave.click();
        Thread.sleep(2000);
    }

    @When("a {int} {int} {int} {int} is entered using the counter and next section")
    public void aIsEnteredUsingTheCounterAndNextSection(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) throws Exception {
        myReports.sacramentAttendanceCounterIcon.click();
        counterPressAdd(firstNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        counterPressAdd(secondNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        counterPressAdd(thirdNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        counterPressAdd(fourthNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        myReports.sacramentAttendanceCounterSave.click();
    }

    public void counterPressAdd(int myCounter) throws Exception {
        for (int x = 1; x <= myCounter; x++) {
            myReports.sacramentAttendanceAddButton.click();
        }
    }

    public void counterPressMinus(int myCounter) throws Exception {
        for (int x = 1; x <= myCounter; x++) {
            myReports.sacramentAttendanceMinusButton.click();
        }
    }

    public void clickElement(String elementName) throws Exception {
        MobileElement myElement = null;
        myElement = getSunday(elementName);
        myElement.click();
//        switch(elementName) {
//            case "First Date Field":
//                myReports.sacramentAttendanceFirstWeek.click();
//                break;
//            case "Second Date Field":
//                myReports.sacramentAttendanceSecondWeek.click();
//                break;
//            case "Third Date Field":
//                myReports.sacramentAttendanceThirdWeek.click();
//                break;
//            case "Fourth Date Field":
//                myReports.sacramentAttendanceFourthWeek.click();
//                break;
//            default:
//                System.out.println("Element not found!");
//        }
    }

    public String getTextFromElement(String elementName) throws Exception {
        String myText = null;
        MobileElement myElement = null;
        myElement = getSunday(elementName);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myText = myElement.getAttribute("value");
        } else {
            myText = myElement.getAttribute("Text");
        }

//        switch(elementName) {
//            case "First Date Field":
//                myText = myReports.sacramentAttendanceFirstWeek.getAttribute("Text");
//                break;
//            case "Second Date Field":
//                myText = myReports.sacramentAttendanceSecondWeek.getAttribute("Text");
//                break;
//            case "Third Date Field":
//                myText = myReports.sacramentAttendanceThirdWeek.getAttribute("Text");
//                break;
//            case "Fourth Date Field":
//                myText = myReports.sacramentAttendanceFourthWeek.getAttribute("Text");
//                break;
//            default:
//                System.out.println("Element not found!");
//        }

        return myText;
    }

    public MobileElement getSunday(String elementName) throws Exception {
        MobileElement returnElement = null;
        List<String> sundayNumber = getSundaysInCurrentMonth();
        switch(elementName) {
            case "First Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeTextField[@name='" + sundayNumber.get(0) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceFirstWeek;
                }
                break;
            case "Second Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeTextField[@name='" + sundayNumber.get(1) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceSecondWeek;
                }

                break;
            case "Third Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeTextField[@name='" + sundayNumber.get(2) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceThirdWeek;
                }

                break;
            case "Fourth Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeTextField[@name='" + sundayNumber.get(3) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceFourthWeek;
                }

                break;
            default:
                System.out.println("Element not found!");
        }

        return returnElement;
    }

    public List<String> getSundaysInCurrentMonth() {
        List<Date> disable = new ArrayList<>();
        List<String> sundayNumber = new ArrayList<>();
        String myDay;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int month = cal.get(Calendar.MONTH);
        do {
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY)
                disable.add(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
        } while (cal.get(Calendar.MONTH) == month);

        SimpleDateFormat fmt = new SimpleDateFormat("EEE M/d/yyyy");
        SimpleDateFormat justDay = new SimpleDateFormat("d");
        for (Date date : disable) {
//            System.out.println(fmt.format(date));
//            fmt.format(date).toString();
//            System.out.println(justDay.format(date));
            myDay = justDay.format(date);
//            System.out.println("Day: " + myDay);
            sundayNumber.add(myDay);
        }

        return sundayNumber;

    }

    public void sacramentAttendanceCleanUp() throws Exception {
        MobileElement myElement;
        List<String> fieldName = new ArrayList<>();
        fieldName.add("First Date Field");
        fieldName.add("Second Date Field");
        fieldName.add("Third Date Field");
        fieldName.add("Fourth Date Field");



        //Skipping ios for now
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//            myBasePage.backButton.click();
//            myMenu.selectMenu(myMenu.lists);
//            myMenu.selectMenu(myMenu.reports);
//            myReports.sacramentAttendanceReport.click();
//            myBasePage.scrollDownIOS();
//
//            for (String dayToClear : fieldName) {
//                myElement = getSunday(dayToClear);
//                if(checkForEnabled(myElement).equalsIgnoreCase("true")) {
//                    myElement.click();
//                    Thread.sleep(2000);
//                    myElement.click();
//                    myElement.clear();
//                    myElement.setValue("0");
//                    myBasePage.keyboardReturn.click();
//                }
//            }

        } else {
            if (checkForEnabled(myReports.sacramentAttendanceFirstWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceFirstWeek.click();
                myReports.sacramentAttendanceDialogEditField.setValue("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
            if (checkForEnabled(myReports.sacramentAttendanceSecondWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceSecondWeek.click();
                myReports.sacramentAttendanceDialogEditField.setValue("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
            if (checkForEnabled(myReports.sacramentAttendanceThirdWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceThirdWeek.click();
                myReports.sacramentAttendanceDialogEditField.setValue("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
            if (checkForEnabled(myReports.sacramentAttendanceFourthWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceFourthWeek.click();
                myReports.sacramentAttendanceDialogEditField.setValue("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
        }

    }

    public String checkForEnabled(MobileElement elementToCheck) throws Exception {
        String returnStatus;
        returnStatus = elementToCheck.getAttribute("enabled");
        return  returnStatus;
    }

    @After("@all and not @nonBishopric")
    public void cleanup() throws Exception {
        if(checkForEnabled(getSunday("First Date Field")).equalsIgnoreCase("true")) {
//        if (checkForEnabled(myReports.sacramentAttendanceFirstWeek).equalsIgnoreCase("true")) {
            sacramentAttendanceCleanUp();
            if (myBasePage.getOS().equalsIgnoreCase("android")) {
                myBasePage.scrollDownAndroidUIAutomator("1");
                Thread.sleep(4000);
            }
            myBasePage.backButton.click();
        }
    }



}
