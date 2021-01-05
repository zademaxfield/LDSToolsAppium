package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class SyncScreen extends BasePage {

    public SyncScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Sync Main Screen ******************
    //Sync Button
    @AndroidFindBy(accessibility = "Sync")
    @iOSXCUITFindBy(accessibility = "Sync")
    public  MobileElement syncButton;

    //Update Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/manuallyUpdateButton")
    @iOSXCUITFindBy(accessibility = "Update")
    public  MobileElement updateButton;

    //Sync Now Button
    @iOSXCUITFindBy(accessibility = "Sync Now")
    public  MobileElement syncNowButton;

    //OK Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_buttonDefaultPositive")
    public  MobileElement syncOKButton;

    //Cancel Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_buttonDefaultNegative")
    public  MobileElement syncCancelButton;


    public void manualUpdate() throws Exception {
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        myMenu.selectMenu(myMenu.update);
        updateButton.click();
        myBasePage.waitUnitlTextIsGone("Updating");
        myBasePage.waitForElementThenClick(myBasePage.backButton);
    }


}
