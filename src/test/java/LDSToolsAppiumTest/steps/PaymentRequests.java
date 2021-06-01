package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.FinanceScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import com.google.common.collect.ImmutableMap;
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
        myFinance.financePaymentRequests.click();
    }

    @When("a payment request is filled out for {string} {string} {string} {string} {string} {string}")
    public void a_payment_request_is_filled_out_for(String payee, String purpose, String account, String addReceipt, String category, String categoryAmount) throws Exception {
        LOGGER.info("a payment request is filled out for " + payee + " " + purpose + " " + account + " " + addReceipt + " " + category + " " + categoryAmount);
        myFinance.paymentRequestsAdd.click();
//        System.out.println(myBasePage.getSourceOfPage());
        choosePayee(payee);
        choosePurpose(purpose, account);
        addReceiptToPaymentRequest(addReceipt);
        categorySub(category);
        categoryAmountSub(categoryAmount);
        myFinance.paymentRequestsSaveButton.click();
    }


    @Then("the payment request should be processed with information of {string} {string} {string} {string} {string} {string} {string}")
    public void the_payment_request_should_be_processed_with_information_of(String member, String payee, String purpose, String account, String addReceipt, String category, String categoryAmount) throws Exception {
        LOGGER.info("the payment request should be processed with information of " + payee + " " + purpose + " " + account + " " + addReceipt + " " + category + " " + categoryAmount);
        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList(member, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(payee, pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList(purpose, pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList(account, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(addReceipt, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(category, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList(categoryAmount, pageSource, "Contains"));

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
            myFinance.paymentRequestsAddPurpose.click();
        }

        myFinance.paymentRequestsPurpose.setValue(purpose);

        myFinance.paymentRequestsPurposeAddButton.click();
    }

    public void addReceiptToPaymentRequest(String addReceipt) throws Exception {
        myFinance.paymentRequestsAddReceipt.click();

        if (addReceipt.equalsIgnoreCase("picture")) {
            //ios crashes when you try to take a picture
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//                myFinance.paymentRequestsTakeAPicture.click();
                myFinance.paymentRequestsPhotoGallery.click();
                Thread.sleep(5000);
                driver.get().findElement(By.xpath("//XCUIElementTypeImage[3]")).click();

            } else {
                myFinance.paymentRequestsTakeAPicture.click();
                //Need to hit the button twice
                myFinance.paymentRequestsCameraButton.click();
                myFinance.paymentRequestsCameraButton.click();
            }
        } else {
            //TODO: need a way to upload files to the device then choose the file here.

        }

    }


    public void categorySub(String category) throws Exception {
        int x;
        int y;

        myFinance.paymentRequestsCategoryGroup1Spinner.click();

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myFinance.paymentRequestsCategoryiOS.click();
            driver.get().findElement(By.id(category)).click();
        } else {
            x = myFinance.paymentRequestsCategoryGroup1Spinner.getLocation().getX();
            y = myFinance.paymentRequestsCategoryGroup1Spinner.getLocation().getY();

            TouchAction action = new TouchAction(driver.get())
                    .press(PointOption.point(x + 60, y + 350))
                    .release();
            action.perform();
        }
    }

    public void categoryAmountSub(String categoryAmount) throws Exception {
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
