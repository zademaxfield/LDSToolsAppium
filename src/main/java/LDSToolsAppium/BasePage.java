package LDSToolsAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }




    //Scrolling Methods

    public void scrollToText(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            MobileElement list = (MobileElement) driver.findElement(By.id("org.lds.ldstools.dev:id/list"));
            MobileElement radioGroup = (MobileElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                    + "new UiSelector().text(\"" + myElement + "\"));"));

            while (myLoopStatus == 0) {
                System.out.println("OVERFLOW SCROLL: " + myCounter);
                radioGroup = (MobileElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + myElement + "\"));"));


                if (radioGroup.isDisplayed()) {
                    myLoopStatus = 1;
                }

                if (myCounter > 5) {
                    myLoopStatus = 1;
                }

                myCounter++;
            }
            Assert.assertNotNull(radioGroup.getLocation());
        }
    }

    public boolean checkTextOnPage(String myElement) {
        boolean myReturnStatus;
        List<MobileElement> options = null;
        options = driver.findElements(By.xpath("//*[contains(text(), '" + myElement + "')]"));

        if (options.isEmpty()) {
            myReturnStatus = false;
        } else {
            myReturnStatus = true;
        }

        return myReturnStatus;
    }

    public void waitForTextToDisappear(MobileElement myElement) {
        System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.invisibilityOf(myElement));
        System.out.println("Stop Checking for Element");
    }


    public void waitUnitlTextIsGone(String myText) {
        //System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver, 300);
        if(getOS().equals("mac")) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@value='" + myText + "']")));
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + myText + "']")));
        }

        //System.out.println("Stop Checking for Element");
    }

    public String getOS() {
        String osName = "test";
        //System.out.println("Context: " + driver.getContext());
        //System.out.println("OS: " + osName);
        osName = driver.getCapabilities().getCapability("platformName").toString();
        osName = osName.toLowerCase();
        //System.out.println("OS: " + osName);
        return osName;
    }




    //Universal Elements
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backButton;

    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement drawerButton;

    @iOSFindBy(accessibility = "More")
    public MobileElement moreButton;




}
