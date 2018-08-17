package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MissionaryScreen extends BasePage {

    public MissionaryScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }


    // ****************** Missionary Main Screen ******************

    //Send Referral Button
    @AndroidFindBy(id = "org.lds.ldstools.dev:id/fab")
    @iOSFindBy(accessibility = "Send Referral")
    public MobileElement sendReferralButton;

    //Cancel Referral
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSFindBy(accessibility = "Cancel")
    public MobileElement cancelReferralButton;









    //Android Only
    //Referrals Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"referrals\")]")
    public  MobileElement tabReferrals;

    //Tab Assigned
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"assigned\")]")
    public  MobileElement tabAssigned;

    //Tab Ward
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"ward\")]")
    public  MobileElement tabWard;

    //Tab Serving
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"serving\")]")
    public  MobileElement tabServing;





    public String getMissionaryPage() throws Exception {
        BasePage myBasePage = new BasePage(driver);

        String pageSource = null;
        if (getOS().equals("ios")) {
            pageSource = getSourceOfPage();
            scrollDownIOS();

            pageSource = pageSource + getSourceOfPage();
        } else {


            //Contact Tab
            Thread.sleep(1000);
            pageSource = getSourceOfPage();

            tabAssigned.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            tabWard.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            tabServing.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            tabReferrals.click();
        }

        return pageSource;

    }




}
