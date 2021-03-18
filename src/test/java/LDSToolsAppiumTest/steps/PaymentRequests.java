package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.FinanceScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

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

    @When("a payment request is filled out for {string} {string} {string} {string} {string} {string} {string}")
    public void a_payment_request_is_filled_out_for(String payee, String purpose, String account, String addReceipt, String salesTaxAmount, String category, String categoryAmount) throws Exception {
        myFinance.paymentRequestsAdd.click();
        choosePayee(payee);
        choosePurpose(purpose, account);
//        addReceiptToPaymentRequest(addReceipt);
        categorySub(salesTaxAmount);
    }

    @Then("the payment request should be processed with information of {string} {string} {string} {string} {string} {string} {string} {string}")
    public void the_payment_request_should_be_processed_with_information_of(String payee, String purpose, String account, String addReceipt, String salesTaxAmount, String category, String categoryAmount) {
        LOGGER.info("MORE TO COME HERE!!!!");
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
    }

    public void choosePurpose(String purpose, String account) throws Exception {
        myFinance.paymentRequestsPurpose.setValue(purpose);
        //TODO: Account I cannot change the account for some reason

        myFinance.paymentRequestsPurposeAddButton.click();
    }

    public void addReceiptToPaymentRequest(String addReceipt) throws Exception {
        myFinance.paymentRequestsAddReceipt.click();

        if (addReceipt.equalsIgnoreCase("picture")) {
            myFinance.paymentRequestsTakeAPicture.click();
            //Need to hit the button twice
            myFinance.paymentRequestsCameraButton.click();
            myFinance.paymentRequestsCameraButton.click();
        } else {
            //TODO: need a way to upload files to the device then choose the file here.

        }

    }


    public void categorySub(String salesTaxAmount) throws Exception {
        myFinance.paymentRequestsCategoryGroup1Spinner.click();
        System.out.println(myBasePage.getSourceOfPage());
        myBasePage.androidSpinnerList();
        driver.get().findElement(By.name("Category_1")).click();
        Thread.sleep(5000);
    }


}
