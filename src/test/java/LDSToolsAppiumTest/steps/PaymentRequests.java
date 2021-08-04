package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.FinanceScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import io.appium.java_client.InteractsWithFiles.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PaymentRequests extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    FinanceScreen myFinance = new FinanceScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    String pageSource;


    @Given("a {string} is on the Finance page")
    public void a_is_on_the_Finance_page(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " is on the Finance page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.finance);
        Thread.sleep(1000);
        myFinance.financePaymentRequests.click();
    }

    @When("a payment request is filled out for {string} {string} {string} {string} {string} {string}")
    public void a_payment_request_is_filled_out_for(String payee, String purpose, String account, String addReceipt, String category, String categoryAmount) throws Exception {
        LOGGER.info("a payment request is filled out for " + payee + " " + purpose + " " + account + " " + addReceipt + " " + category + " " + categoryAmount);
        Thread.sleep(1000);
//        System.out.println(myBasePage.getSourceOfPage());
        myFinance.paymentRequestsAdd.click();
//        System.out.println(myBasePage.getSourceOfPage());
        choosePayee(payee);
        choosePurpose(purpose, account);
        addReceiptToPaymentRequest(addReceipt);
        categorySub(category);
        categoryAmountSub(categoryAmount);
        Thread.sleep(2000);
        myFinance.paymentRequestsSaveButton.click();
    }


    @Then("the payment request should be processed with information of {string} {string} {string} {string} {string} {string} {string}")
    public void the_payment_request_should_be_processed_with_information_of(String member, String payee, String purpose, String account, String addReceipt, String category, String categoryAmount) throws Exception {
        LOGGER.info("the payment request should be processed with information of " + payee + " " + purpose + " " + account + " " + addReceipt + " " + category + " " + categoryAmount);
        Thread.sleep(5000);
        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);
//        Assert.assertTrue(myBasePage.checkNoCaseList(member, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(payee, pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList(purpose, pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList(account, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(addReceipt, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(category, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(categoryAmount, pageSource, "Contains"));

    }


    @When("a payment request is filled out with the categories and amounts of {string} {string} {string} {string} {string} {string}")
    public void aPaymentRequestIsFilledOutWithTheCategoriesAndAmountsOf(String cat1, String amount1, String cat2, String amount2, String cat3, String amount3) throws Exception {
        LOGGER.info("a payment request is filled out with the categories and amounts of " + cat1 + " " + amount1 + " " + cat2 + " " + amount2 + " " + cat3 + " " + amount3);
        myFinance.paymentRequestsAdd.click();
        choosePayee("myself");
        choosePurpose("Multiple Cats", "test");
        addReceiptToPaymentRequest("picture");

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            categorySub(cat1);
            categoryAmountSub(amount1);

            myFinance.paymentRequestsAddCategory.click();

            categorySub(cat2);
            categoryAmountSub(amount2);

            myFinance.paymentRequestsAddCategory.click();

            categorySub(cat3);
            categoryAmountSub(amount3);
        } else {
            categorySub(cat1);
            categoryAmountSub(amount1);

            myFinance.paymentRequestsAddCategory.click();

            categorySub2(cat2);
            Thread.sleep(2000);
            categoryAmountSub2(amount2);

            myFinance.paymentRequestsAddCategory.click();

            myBasePage.scrollUp(500);
            Thread.sleep(2000);
            categorySub3(cat3);
            categoryAmountSub3(amount3);
        }


    }

    @Then("the payment request will show the multiple categories")
    public void thePaymentRequestWillShowTheMultipleCategories() throws Exception {
        LOGGER.info("the payment request will show the multiple categories");
        Thread.sleep(3000);
        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("Activities", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Primary", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Sunday School", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkTextOnPage("$12.34"));
            Assert.assertTrue(myBasePage.checkTextOnPage("$43.21"));
            Assert.assertTrue(myBasePage.checkTextOnPage("$458.93"));


        } else {
            Assert.assertTrue(myBasePage.checkNoCaseList("12", pageSource, "Contains"));

        }
    }


    @Given("a {string} is on the Finance page and has a payment request that is not finished")
    public void aIsOnTheFinancePageAndHasAPaymentRequestThatIsNotFinished(String member) throws Exception {
        LOGGER.info("a " + member + " is on the Finance page and has a payment request that is not finished");
        a_is_on_the_Finance_page(member);
        a_payment_request_is_filled_out_for("myself", "Test One", "test", "picture", "Activities", "7792");
        Thread.sleep(2000);
        myBasePage.backButton.click();
        Thread.sleep(2000);
        myBasePage.backButton.click();
        Thread.sleep(2000);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myFinance.paymentRequestsYesButton.click();
            Thread.sleep(1000);
            myBasePage.backButton.click();
        }
        myMenu.selectMenu(myMenu.directory);

    }

    @When("an unfinished payment request is selected")
    public void anUnfinishedPaymentRequestIsSelected() throws Exception {
        LOGGER.info("an unfinished payment request is selected");
        myMenu.selectMenu(myMenu.finance);
        myFinance.financePaymentRequests.click();
        System.out.println(myBasePage.getSourceOfPage());
        //Select payment
    }

    @Then("the member will finish the payment request")
    public void theMemberWillFinishThePaymentRequest() throws Exception {
        LOGGER.info("the member will finish the payment request");
        //Finish payment


    }


    @When("{string} is entered in the purpose")
    public void isEnteredInThePurpose(String purpose) throws Exception {
        LOGGER.info(purpose + " is entered in the purpose");
        myFinance.paymentRequestsAdd.click();

        choosePayee("myself");
//        choosePurpose(purpose, "TEST 1234");
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForElement(myFinance.paymentRequestsAddPurpose);
            Thread.sleep(1000);
            myFinance.paymentRequestsAddPurpose.click();
        }

        myFinance.paymentRequestsPurpose.setValue(purpose);
        Thread.sleep(2000);
//        System.out.println(myBasePage.getSourceOfPage());
//        Thread.sleep(2000);
//        addReceiptToPaymentRequest("picture");
//        categorySub("Activities");
//        categoryAmountSub("4567");
//        myFinance.paymentRequestsSaveButton.click();

    }

    @Then("Some purpose error should happen")
    public void someErrorShouldHappen() throws Exception {
        LOGGER.info("Some purpose error should happen");
        //This may be android only stuff
//        Assert.assertTrue(myFinance.paymentRequestsPurposeSubmit.getAttribute("enabled").equalsIgnoreCase("false"));
        Assert.assertTrue(myFinance.paymentRequestsCounter.getText().contains("445"));
    }


    public void choosePayee(String payee) throws Exception {
        switch(payee) {
            case "myself":
                myFinance.paymentRequestsAddMyself.click();
                break;
            case "add other payee":
                myFinance.paymentRequestsAddOther.click();
                //TODO: Need more code here....
                break;
            default:
                myFinance.paymentRequestsSearch.setValue(payee);
                if (myBasePage.getRunningOS().equalsIgnoreCase("ios")) {
                    //TODO: iOS code
                } else {
                    driver.get().findElement(By.xpath("//android.widget.TextView[@text='" + payee + "']")).click();
                    myFinance.paymentRequestsAddPayeeFab.click();
                }
        }
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myFinance.paymentRequestsSelectThisPayee.click();
        }
    }

    public void choosePurpose(String purpose, String account) throws Exception {

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForElement(myFinance.paymentRequestsAddPurpose);
            Thread.sleep(1000);
            myFinance.paymentRequestsAddPurpose.click();
        }

        myFinance.paymentRequestsPurpose.setValue(purpose);

        myFinance.paymentRequestsPurposeAddButton.click();
    }

    public void addReceiptToPaymentRequest(String addReceipt) throws Exception {
        Thread.sleep(2000);
        myFinance.paymentRequestsAddReceipt.click();

        if (addReceipt.equalsIgnoreCase("picture")) {
            //ios crashes when you try to take a picture
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//                myFinance.paymentRequestsTakeAPicture.click();
                Thread.sleep(5000);
                myFinance.paymentRequestsPhotoGallery.click();
                Thread.sleep(12000);
                driver.get().findElement(By.xpath("//XCUIElementTypeImage[3]")).click();

            } else {
                myFinance.paymentRequestsTakeAPicture.click();
                //Need to hit the button twice
                Thread.sleep(500);

//                System.out.println(myBasePage.getSourceOfPage());
                myBasePage.waitForElement(myFinance.paymentRequestsCameraButton);
                myFinance.paymentRequestsCameraButton.click();
                Thread.sleep(500);
//                System.out.println(myBasePage.getSourceOfPage());
//                myFinance.paymentRequestsCameraButton.click();
                myBasePage.waitForElement(myFinance.paymentRequestsCameraButtonOK);
                myFinance.paymentRequestsCameraButtonOK.click();

            }
        } else {
            //TODO: need a way to upload files to the device then choose the file here.

        }

    }


    public void categorySub(String category) throws Exception {
        int x;
        int y;

        if (myBasePage.checkForElement(myFinance.paymentRequestsCategoryGroup1Spinner)) {
            myFinance.paymentRequestsCategoryGroup1Spinner.click();
        }


        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Thread.sleep(2000);
            myFinance.paymentRequestsCategoryiOS.click();
            Thread.sleep(2000);
            driver.get().findElement(By.id(category)).click();
        } else {
            x = myFinance.paymentRequestsCategoryGroup1Spinner.getLocation().getX();
            y = myFinance.paymentRequestsCategoryGroup1Spinner.getLocation().getY();

            TouchAction action = new TouchAction(driver.get())
                    .press(PointOption.point(x + 60, y + 250))
                    .release();
            action.perform();
        }
    }

    public void categorySub2(String category) throws Exception {
        int x;
        int y;

        myFinance.paymentRequestsCategoryGroup2Spinner.click();
        x = myFinance.paymentRequestsCategoryGroup2Spinner.getLocation().getX();
        y = myFinance.paymentRequestsCategoryGroup2Spinner.getLocation().getY();

        TouchAction action = new TouchAction(driver.get())
                .press(PointOption.point(x + 60, y + 350))
                .release();
        action.perform();
    }

    public void categorySub3(String category) throws Exception {
        int x;
        int y;

        myFinance.paymentRequestsCategoryGroup3Spinner.click();
        x = myFinance.paymentRequestsCategoryGroup3Spinner.getLocation().getX();
        y = myFinance.paymentRequestsCategoryGroup3Spinner.getLocation().getY();

        TouchAction action = new TouchAction(driver.get())
                .press(PointOption.point(x + 60, y + 350))
                .release();
        action.perform();
    }

    public void categoryAmountSub(String categoryAmount) throws Exception {
        Thread.sleep(2000);
        myFinance.paymentRequestsCategoryGroup1Amount.click();

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myFinance.paymentRequestsAmountiOS.sendKeys(categoryAmount);
            myFinance.paymentRequestsSaveButton.click();
        } else {
            for (int i = 0; i < categoryAmount.length(); i++ ) {
                enterInAmount(categoryAmount.charAt(i));
            }
            myFinance.paymentRequestsKeyEnter.click();
        }
    }

    public void categoryAmountSub2(String categoryAmount) throws Exception {
        myFinance.paymentRequestsCategoryGroup2Amount.click();
        for (int i = 0; i < categoryAmount.length(); i++ ) {
            enterInAmount(categoryAmount.charAt(i));
        }
        myFinance.paymentRequestsKeyEnter.click();
    }

    public void categoryAmountSub3(String categoryAmount) throws Exception {
        myFinance.paymentRequestsCategoryGroup3Amount.click();
        for (int i = 0; i < categoryAmount.length(); i++ ) {
            enterInAmount(categoryAmount.charAt(i));
        }
        myFinance.paymentRequestsKeyEnter.click();
    }


    public void enterInAmount(Character categoryAmount) throws Exception {
        switch(categoryAmount) {
            case '1':
                myFinance.paymentRequestsKey1.click();
                break;
            case '2':
                myFinance.paymentRequestsKey2.click();
                break;
            case '3':
                myFinance.paymentRequestsKey3.click();
                break;
            case '4':
                myFinance.paymentRequestsKey4.click();
                break;
            case '5':
                myFinance.paymentRequestsKey5.click();
                break;
            case '6':
                myFinance.paymentRequestsKey6.click();
                break;
            case '7':
                myFinance.paymentRequestsKey7.click();
                break;
            case '8':
                myFinance.paymentRequestsKey8.click();
                break;
            case '9':
                myFinance.paymentRequestsKey9.click();
                break;
            case '0':
                myFinance.paymentRequestsKey0.click();
                break;
            default:
                System.out.println("Invalid Digit");

        }

    }



}
