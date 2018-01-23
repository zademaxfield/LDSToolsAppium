package LDSToolsAppium;

import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }


    //Universal Elements
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backButton;

    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement drawerButton;

    @iOSFindBy(accessibility = "More")
    public MobileElement moreButton;





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


    public void scrollDownIOS() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);

    }

    public void scrollDownTEST(int scrollDistance ) throws Exception {
        if (getOS().equals("mac")) {
            scrollDownIOS();
        } else {
            Dimension dimensions = driver.manage().window().getSize();
            int screenWidth = dimensions.getWidth();
            int screenHeight = dimensions.getHeight();

            screenWidth = screenWidth / 4;
            screenHeight = screenHeight - 200;
            scrollDistance = screenHeight / 2;
            scrollDistance = -scrollDistance;

            TouchAction actions = new TouchAction(driver);
            actions.press(PointOption.point(screenWidth, screenHeight))
                    .moveTo(PointOption.point(screenWidth, scrollDistance))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .release()
                    .perform();

            Thread.sleep(5000);
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

    public boolean checkNoCaseList(String textToCheck, String pageSource, String containEqual){
        Document doc = Jsoup.parse(pageSource);
        Elements myTest = doc.getAllElements();
        String foundText;
        String myOs;
        textToCheck = textToCheck.toLowerCase();
        myOs = getOS();
        if (myOs.equals("mac")){
            for (Element myElement : myTest ) {
                //if (myElement.attributes().get("shown").equals("true")) {
                //System.out.println("Name: ");
                //System.out.println(myElement.attributes().get("name"));
                //System.out.println("Value: ");
                ///System.out.println(myElement.attributes().get("value"));
                foundText = myElement.attributes().get("name");
                foundText = foundText.toLowerCase();
                foundText = foundText.trim();
                //System.out.println("******************************");
                //System.out.println("   Found Text: " + foundText);
                //System.out.println("Text To Check: " + textToCheck);
                //System.out.println("******************************");
                if (containEqual.equals("Equals")) {
                    if (foundText.equals(textToCheck)) {
                        return true;
                    }
                } else {
                    if (foundText.contains(textToCheck)) {
                        return true;
                    }
                }

            }

        } else {
            for (Element myElement : myTest ) {
                //System.out.println(myElement.attributes().get("value"));
                if (!myElement.attributes().get("text").equals("")) {
                    //foundText = myElement.attributes().get("value");
                    foundText = myElement.attributes().get("text");
                    foundText = foundText.toLowerCase();
                    //System.out.println("******************************");
                    //System.out.println("Found Text:" + foundText);
                    //System.out.println("Text To Check: " + textToCheck);
                    //System.out.println("******************************");
                    if (containEqual.equals("Equals")) {
                        if (foundText.equals(textToCheck)) {
                            return true;
                        }
                    } else {
                        if (foundText.contains(textToCheck)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void rightsCheck(String myItem, int itemVisibility, int rights, String pageSource) {
        System.out.println("Checking: " + myItem);
        if (rights <= itemVisibility) {
            Assert.assertTrue(checkNoCaseList(myItem, pageSource, "Contains"));
        } else {
            Assert.assertFalse(checkNoCaseList(myItem, pageSource, "Contains"));
        }
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

    //TODO: Need a faster way to do this.
    public boolean checkForElement(MobileElement myElement ) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(myElement));
            return true;
        } catch (Exception e) {
            return false;
        }
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

    public String getSourceOfPage() {
        String myString;
        myString = driver.getPageSource();

        //System.out.println("****************************************************");
        //System.out.println("Page Source: " + myString);
        //System.out.println("****************************************************");

        return myString;
    }





}
