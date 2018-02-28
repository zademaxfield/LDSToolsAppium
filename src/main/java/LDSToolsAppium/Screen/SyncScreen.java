package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class SyncScreen extends BasePage {

    public SyncScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    // ****************** Sync Main Screen ******************
    //Sync Button
    @AndroidFindBy(accessibility = "Sync")
    @iOSFindBy(accessibility = "Sync")
    public  MobileElement syncButton;

    //Update Button
    @AndroidFindBy(accessibility = "Update")
    @iOSFindBy(accessibility = "Update")
    public  MobileElement updateButton;

    //Sync Now Button
    @iOSFindBy(accessibility = "Sync Now")
    public  MobileElement syncNowButton;


}
