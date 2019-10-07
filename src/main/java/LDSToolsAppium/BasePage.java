package LDSToolsAppium;


import io.appium.java_client.*;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);

    }


    //Universal Elements
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    //@iOSXCUITFindBy(accessibility = "Back")
    public MobileElement backButton;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backAltButton;

    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement drawerButton;

    @AndroidFindBy(id = "clearTextImageButton")
    public MobileElement searchCollapse;

    @iOSXCUITFindBy(accessibility = "More")
    public MobileElement moreButton;

    //OK
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"OK\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'OK'")
    public MobileElement alertOK;

    //Cancel
    @AndroidFindBy(accessibility = "Cancel")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement cancel;

    //Allow button
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]")
    @iOSXCUITFindBy(accessibility = "Allow")
    public MobileElement allowButton;

    //Alert check
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//UIAAlert")
    public MobileElement alertCheck;

    //Menu Title
    @AndroidFindBy(xpath = "//*[@resource-id=\"ab_toolbar\"]//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText")
    public MobileElement menuTitle;





    //Scrolling Methods

    public void scrollToTextiOS(String myElement) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", "up");
        scrollObject.put("xpath", "//XCUIElementTypeStaticText[@name='" + myElement + "']");
        js.executeScript("mobile: swipe", scrollObject);
    }

    public void scrollToTextGeneral(String myElement) throws Exception {
        flingUp();


        if (getOS().contains("ios")) {
            scrollToTextiOS(myElement);
        } else {
            List<String> scrollArea = new ArrayList<String>();
            String pageSource;
            pageSource = driver.getPageSource();
            Document doc = Jsoup.parse(pageSource);
            Elements myElements = doc.getElementsByAttributeValueStarting("scrollable", "true");
            List<Attribute> elementAttributes = new ArrayList<Attribute>();

            for (Element foundElement : myElements ) {
                elementAttributes = foundElement.attributes().asList();
                for (Attribute myAttribute : elementAttributes ) {


                    if (myAttribute.getKey().equals("resource-id")) {
                        if (myAttribute.getValue().isEmpty()) {
                            System.out.println("Resource ID is blank skipping");
                        } else {
                            scrollArea.add(myAttribute.getValue());
                        }
                    }
                }

            }

            if (!scrollArea.isEmpty()) {
                for (String areaToScroll : scrollArea ) {
                    MobileElement list = (MobileElement) driver.findElement(By.id(areaToScroll));
                    MobileElement radioGroup = (MobileElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                            + "new UiSelector().text(\"" + myElement + "\"));"));
                    if (radioGroup.getLocation().toString().isEmpty()) {
                        System.out.println("Text not found in: " + areaToScroll);
                    }
                }
            }
        }

    }

    public void scrollToText(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;
        flingUp();

        if (getOS().contains("ios")) {
            scrollToTextiOS(myElement);

        } else {
            if (!checkTextOnPage(myElement)) {
                MobileElement list = (MobileElement) driver.findElement(By.id("list"));
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


    }

    public void flingUp() throws Exception {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingBackward();"));
        } catch (Exception ignored) {

        }
    }

    public void scrollToTextScollArea(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            MobileElement list = (MobileElement) driver.findElement(By.id("scroll_area"));
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

    public void scrollToTextTopLayout(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            MobileElement list = (MobileElement) driver.findElement(By.id("top_layout"));
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

    public void scrollToTextRecyclerView(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            MobileElement list = (MobileElement) driver.findElement(By.id("recycler_view"));
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

    public void scrollToTextNavMenu(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            MobileElement list = (MobileElement) driver.findElement(By.id("navigation_menu"));
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

    public void scrollDownAndroidUIAutomator(String myInstance) throws Exception {
        if (getOS().equals("ios")) {
            scrollDownIOS();
        } else {
            try {
                driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + myInstance + ")).scrollForward(45);"));
            } catch (Exception ignored) {

            }
        }



    }

    public void scrollUpAndroidUIAutomator(String myInstance) throws Exception {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + myInstance + ")).flingBackward();"));
        } catch (Exception ignored) {

        }

    }


    public void scrollDownIOS() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);

    }

    public void scrollDownToTextIOS(String myText) throws Exception {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("predicateString", "value == '" + myText + "'");
        js.executeScript("mobile: scroll", scrollObject);

    }

    public void scrollDownTEST(int scrollDistance ) throws Exception {
        if (getOS().equals("ios")) {
            scrollDownIOS();
        } else {
            Dimension dimensions = driver.manage().window().getSize();
            int screenWidth = dimensions.getWidth();
            int screenHeight = dimensions.getHeight();

            screenWidth = screenWidth / 3;
            screenHeight = screenHeight - 100;
            scrollDistance = screenHeight / 2;
            scrollDistance = scrollDistance / 2;
            //scrollDistance = -scrollDistance;
            //scrollDistance = 0;

            System.out.println("Width: " + screenWidth);
            System.out.println("Height: " + screenHeight);
            System.out.println("Distance: " + scrollDistance);


            TouchAction actions = new TouchAction(driver);
            actions.press(PointOption.point(screenWidth, screenHeight))
                    .moveTo(PointOption.point(screenWidth, scrollDistance))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .release()
                    .perform();

            Thread.sleep(5000);
        }
    }

    public void scrollUp(int scrollDistance ) throws Exception {
        if (getOS().equals("ios")) {
            scrollUpIOS();
        } else {
            Dimension dimensions = driver.manage().window().getSize();
            int screenWidth = dimensions.getWidth();
            int screenHeight = dimensions.getHeight();

            screenWidth = screenWidth / 2;
            scrollDistance = screenHeight - 20;
            screenHeight = screenHeight / 2;

            //scrollDistance = -scrollDistance;

            TouchAction actions = new TouchAction(driver);
            actions.press(PointOption.point(screenWidth, screenHeight))
                    .moveTo(PointOption.point(screenWidth, scrollDistance))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .release()
                    .perform();

            Thread.sleep(5000);
        }
    }

    public void scrollToTextSwipe(String myText) throws Exception {
        String pageSource;
        boolean textCheck = false;
        int myCounter = 1;

        do {
            pageSource = getSourceOfPage();
            textCheck = pageSource.contains(myText);
//            textCheck = checkTextOnPage(myText);
//            System.out.println("Check: " + textCheck);
            if (!textCheck) {
                scrollDownSlow(1500);
            }
            if (myCounter > 5) {
                textCheck = true;
                System.out.println("TEXT: " + myText + " Not Found!");
            }
            myCounter++;

        } while (!textCheck) ;


    }

    public void scrollDownSlow(int scrollDistance) throws Exception {
        Dimension dimensions = driver.manage().window().getSize();
        int screenWidth = dimensions.getWidth();
        int screenHeight = dimensions.getHeight();


        screenWidth = screenWidth / 3;
        screenHeight = screenHeight - 70;
//        scrollDistance = screenHeight - scrollDistance;
        scrollDistance = screenHeight / 2;

//        System.out.println("Width: " + screenWidth);
//        System.out.println("Height: " + screenHeight);
//        System.out.println("Distance: " + scrollDistance);

        TouchAction mySwipe = new TouchAction(driver);
        //mySwipe.tap(screenWidth,screenHeight).moveTo(screenWidth, scrollDistance).waitAction(Duration.ofMillis(2000)).release().perform();
        //mySwipe.press(screenWidth,screenHeight).moveTo(screenWidth, scrollDistance).release().perform();

        mySwipe.press(PointOption.point(screenWidth, screenHeight))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(screenWidth, scrollDistance))
                .release()
                .perform();

        //driver.swipe(screenWidth, screenHeight, screenWidth, scrollDistance, 2000);

        Thread.sleep(2000);

    }


    public void scrollUpIOS() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: scroll", scrollObject);

    }





    public boolean checkTextOnPage(String myElement) {
        boolean myReturnStatus;
        List<MobileElement> options = null;
        options = driver.findElements(By.xpath("//*[contains(text(), '" + myElement + "')]"));

        if (options.isEmpty()) {
            myReturnStatus = false;
            //Sometimes iOS doesn't have text but has text under value
            options = driver.findElements(By.xpath("//*[contains(@value, '" + myElement + "')]"));
            if (!options.isEmpty()) {
                myReturnStatus = true;
            }
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
        if (myOs.equals("ios")){
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


    public Elements getAllElementsOnPage(String myPageSource ) {
        Document doc = Jsoup.parse(myPageSource);
        Elements myTest = doc.getAllElements();
        List<Attribute> elementAttributes = new ArrayList<Attribute>();

//        for (Element myElement : myTest ) {
//
//            System.out.println("*********************************************************************");
//            elementAttributes = myElement.attributes().asList();
//            for (Attribute myAttribute : elementAttributes ) {
//                System.out.println("To String: " + myAttribute.toString());
//                System.out.println("Get Key: " + myAttribute.getKey());
//                System.out.println("Get Value: " + myAttribute.getValue());
//                System.out.println("Get HTML: " + myAttribute.html());
//                System.out.println("Get Class: " + myAttribute.getClass());
//            }
//
//            System.out.println("*********************************************************************");
//
//        }

        return myTest;
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

        if(getOS().equals("ios")) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@value, '" + myText + "')]")));
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@text, '" + myText + "')]")));
        }

        //System.out.println("Stop Checking for Element");
    }

    public void waitForText(String myText) {
        //System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver, 300);
        if(getOS().equals("ios")) {
//            WebElement iosElement = driver.findElement(By.xpath("//*[contains(@value, '" + myText + "')]"));
//            wait.until(ExpectedConditions.textToBePresentInElement(iosElement, myText));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@value, '" + myText + "')]")));
        } else {
//            WebElement androidElement = driver.findElement(By.xpath("//*[contains(@text, '" + myText + "')]"));
//            wait.until(ExpectedConditions.textToBePresentInElement(androidElement, myText));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '" + myText + "')]")));
        }

        //System.out.println("Stop Checking for Element");
    }

    public void waitForElementThenClick(MobileElement myElement) {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.elementToBeClickable(myElement));
        myElement.click();
    }

    public void clickByText(String myText) {
        if(getOS().equals("ios")) {
            driver.findElement(By.xpath("//*[@label='" + myText + "']")).click();
        } else {
            driver.findElement(By.xpath("//*[@text='" + myText + "']")).click();
        }

    }

    public void clickByTextContains(String myText) {
        if(getOS().equals("ios")) {
            driver.findElement(By.xpath("//*[contains(@name, '" + myText + "')]")).click();
        } else {
            driver.findElement(By.xpath("//*[contains(@text, '" + myText + "')]")).click();
        }

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

    public Boolean checkElementExists(String textElement) {
        Boolean myReturnStatus;
        List<MobileElement> options = null;
        if (getOS().equals("ios")) {
            //options = driver.findElements(By.xpath("//*[@value='" + textElement + "']"));
            options = driver.findElements(MobileBy.AccessibilityId(textElement));
        } else {
            options = driver.findElements(By.xpath("//*[@text='" + textElement + "']"));
        }



        if (options != null) {
            if (options.isEmpty()) {
                myReturnStatus = false;
            } else {
                myReturnStatus = true;
            }
        } else {
            myReturnStatus = false;
        }

        //System.out.println("Searching for " + textElement + " Found: " + myReturnStatus);

        return myReturnStatus;
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

    public String getSourceOfPage() throws Exception {
//        System.out.println("Start Get Source of Page");
        String myString;
        Thread.sleep(2000);
        myString = driver.getPageSource();

//        System.out.println("****************************************************");
//        System.out.println("Page Source: " + myString);
//        System.out.println("****************************************************");
//        System.out.println("End Get Source of Page");

        return myString;
    }

    public void checkSourceString(String pageSource, String textToCheck) throws Exception {
        if (pageSource.contains(textToCheck)){
            Assert.assertTrue(true);
        } else {
            System.out.println("Not Found: " + textToCheck);
            Assert.assertTrue(false);
        }
    }

    public void checkSource(String pageSource, List<String> myList) throws Exception {
        for(String oneLine : myList){
            //System.out.println("TEXT: " + oneLine);
            checkSourceString(pageSource, oneLine);
        }
    }

    public void compareWebData(List<String> myList, List<String> androidList, Boolean onePage) throws Exception {
        String pageSource = null;
        int pageSize;
        String lastMember;
        String lastMemberCheck;

        String memberToSelect;

        if (getOS().equals("ios")){
            pageSource = getSourceOfPage();
            scrollDownIOS();
            pageSource = pageSource + getSourceOfPage();
            //System.out.println("*************************************");
            //System.out.println(pageSource);
            //System.out.println("*************************************");
            for(String oneUser : myList){
                System.out.println("USER: " + oneUser);
                //TODO: When "Out of Unit" bug is fixed remove the check
                if ((oneUser.contains("Jr")) || (oneUser.contains("Salvador")) || (oneUser.contains("Junior") || (oneUser.contains("Farley")
                        || (oneUser.contains("Raymundo") || (oneUser.contains("Sarwar") ||(oneUser.contains("Dylan") || (oneUser.contains("Siteni")
                        || (oneUser.contains("Ah Kam") || (oneUser.contains("Peterson") || (oneUser.contains("Latu") ||(oneUser.contains("Morgan")
                        || (oneUser.contains("Nouata") || (oneUser.contains("Lili") || (oneUser.contains("Hyppolito") || (oneUser.contains("Wilson, Tina")))))))))))))))){
                    System.out.println("Skipping: " + oneUser);
                } else {
                    Assert.assertTrue(checkNoCaseList(oneUser, pageSource, "Contains"));
                }

            }

        } else {

            if (onePage == false ) {
                pageSize = driver.manage().window().getSize().getHeight();
                //System.out.println("Page Size: " + pageSize);
                //pageSize = pageSize - 20;
                //System.out.println("Orig Page Size: " + pageSize);
                //pageSize = pageSize / 2;
                pageSize = pageSize / 2;
                //System.out.println("Page Size: " + pageSize);
                //pageSize = (pageSize / 2 ) + pageSize;
                //System.out.println("3/4 Page Size: " + pageSize);
                //pageSize = -pageSize;



                //This will scroll through the android pages and get all of the data.
                do {
                    pageSource = getSourceOfPage();
                    androidList = createUserList(androidList, pageSource);
                    if (androidList.size() == 0) {
                        lastMember = "none";
                        lastMemberCheck = "none";
                    } else {
                        lastMember = androidList.get(androidList.size() - 1 );

                        scrollDownSlow(pageSize);
                        Thread.sleep(1000);
                        pageSource = pageSource + getSourceOfPage();
                        androidList = createUserList(androidList, pageSource);
                        lastMemberCheck = androidList.get(androidList.size() - 1 );
                        //System.out.println("Last Member: " + lastMember);
                        //System.out.println("Last Member Check: " + lastMemberCheck);
                    }

                } while (!lastMember.equals(lastMemberCheck));


                //System.out.println("***************************");
                //pageSource = getSourceOfPage();
                //androidList = createUserList(androidList, pageSource);
                //System.out.println("***************************");

                for(String oneUser : myList) {
                    System.out.println("USER: " + oneUser);
                    if ((oneUser.contains("Jr")) || (oneUser.contains("Salvador")) || (oneUser.contains("Junior") || (oneUser.contains("Farley")
                            || (oneUser.contains("Raymundo") || (oneUser.contains("Dylan") || (oneUser.contains("Siteni")
                            || (oneUser.contains("Morgan") || (oneUser.contains("Lott")|| (oneUser.contains("Wilson, Tina")))))))))){
                        System.out.println("Skipping: " + oneUser);
                    } else {
                        Assert.assertTrue(androidList.contains(oneUser));
                    }
                }
            } else {
                //driver.getPageSource();
                pageSource = getSourceOfPage();
                androidList.clear();
                androidList = createUserList(androidList, pageSource);
                //androidList = getAllText();
				/*
				for(String oneUser : androidList) {
					System.out.println("USER: " + oneUser);
					if ((oneUser.contains("Jr")) || (oneUser.contains("Salvador")) || (oneUser.contains("Junior"))){
						System.out.println("Skipping: " + oneUser);
					} else {
						Assert.assertTrue(myList.contains(oneUser));
					}
				}
				*/
                //System.out.println("###### Printing List #######");
                //for (int x = 0 ; x < myList.size() ; x++ )	{
                //	System.out.println(myList.get(x));
                //}
                //System.out.println("###### Done Printing List #######");
                System.out.println("****** Android Users ******");
                if(!myList.isEmpty()) {
                    for(int myCounter = 0 ; myCounter < androidList.size() ; myCounter++) {
                        if ((myList.get(myCounter).contains("Jr")) || (myList.get(myCounter).contains("Salvador"))
                                || (myList.get(myCounter).contains("Joseph")) || (myList.get(myCounter).contains("Junior"))) {
                            System.out.println("Skipping: " + myList.get(myCounter));
                        } else {
                            System.out.println("Android USER: " + androidList.get(myCounter));
                            Assert.assertTrue(myList.contains(androidList.get(myCounter)));
                        }
                    }
                }
                System.out.println("****** Done Android Users ******");
            }


        }
    }

    public List<String> createUserList(List<String> userList, String pageSource){
        Document doc = Jsoup.parse(pageSource);
        Elements myTest = doc.getAllElements();
        String foundText;

        for (Element myElement : myTest ) {
            //System.out.println("Searching for user: ");
            //System.out.println(myElement.attributes().get("value"));
            if (!myElement.attributes().get("text").equals("")) {
                foundText = myElement.attributes().get("text");
                //foundText = foundText.toLowerCase();
                if ((!foundText.isEmpty()) && (foundText.contains(","))){
                    if ((foundText.contains("2015")) || (foundText.contains("2016"))){
                        //System.out.println("Date? :" + foundText);
                    } else {
                        userList.add(foundText);
                        System.out.println("Adding User: " + foundText);
                    }

                }


                //System.out.println("******************************");
                //System.out.println("Found Text:" + foundText);
                //System.out.println("Text To Check: " + textToCheck);
                //System.out.println("******************************");
            }
        }
        return userList;
    }

    public List<String> swapLastName(List<String> listToSwitch) throws Exception {
        String userSwitch;

        for (int myCounter = 0; myCounter < listToSwitch.size(); myCounter++) {
            String[] parts = listToSwitch.get(myCounter).split(" ");
            if (parts.length == 1) {
                listToSwitch.set(myCounter, parts[0]);
            } else {
                String part1 = parts[0];
                //part1 = part1.replace(",", "");
                String part2 = parts[1];
                userSwitch = part2 + ", " + part1;
                System.out.println("SWITCH: " + userSwitch);
                listToSwitch.set(myCounter, userSwitch);
            }

        }

        return listToSwitch;

    }

    public boolean checkForAlert() throws Exception {
        //Check to see if we are getting a warning
        if (checkForElement(alertCheck)) {
            return true;
        }
        return false;
    }

    public void backToDirectory() throws Exception {
        Thread.sleep(2000);
        if (getOS().equals("ios")) {
            System.out.println("BACK TO DIRECTORY!");
            pressBackToRoot();
            Thread.sleep(2000);
            System.out.println("Try to clear text");
            clickByCords("Clear text");
//            clickByCords("Cancel");
            Thread.sleep(2000);
            cancel.click();

        } else {
            //System.out.println("Start of Back To Root");
            pressBackToRoot();
            //System.out.println("End of Back To Root");
            Thread.sleep(3000);
            //System.out.println("Start of Search Collapse");
            searchCollapse.click();
            //System.out.println("End of Search Collapse");
        }
        Thread.sleep(2000);
    }

    public void pressBackToRoot() throws Exception {
        Boolean backButtonCheck;
        String myMenuTitle;
        int myCounter = 1;
        //backButtonCheck = checkElementExistsByXpath("TopBack");
        backButtonCheck = checkForElement(backButton);
        System.out.println("Back Button Check - before loop: " + backButtonCheck);

        while ((backButtonCheck) && (myCounter < 9 ))  {
            Thread.sleep(1000);
            System.out.println("Pressing Back Key " + myCounter);
//            if (getOS().equals("ios")) {
//                backButton.click();
//            } else {
//                driver.navigate().back();
//            }

            backButton.click();

            Thread.sleep(2000);
            System.out.println("Back Key pressed");
            //System.out.println("Checking for back key....");
            //backButtonCheck = checkElementExistsByXpath("TopBack");
            //backButtonCheck = checkElementExistsByXpath("NewBackButton");
            //printPageSource();
            if (checkForElement(menuTitle)) {
                myMenuTitle = menuTitle.getText();
            } else {
                myMenuTitle = "No Title";
            }

            System.out.println("MENU TITLE: " + myMenuTitle);

            switch (myMenuTitle) {
                case "Directory" :
                    backButtonCheck = false;
                    break;
                case "Organizations" :
                    backButtonCheck = false;
                    break;
                case "Calendar" :
                    backButtonCheck = false;
                    break;
                case "Reports" :
                    backButtonCheck = false;
                    break;
                case "Lists" :
                    backButtonCheck = false;
                    break;
                case "Missionary" :
                    backButtonCheck = false;
                    break;
                case "Meetinghouses" :
                    backButtonCheck = false;
                    break;
                case "Temples" :
                    backButtonCheck = false;
                    break;
                default :
                    backButtonCheck = true;
            }

            if (checkForElement(searchCollapse)) {
                backButtonCheck = false;
            }

            Thread.sleep(2000);
            System.out.println("Back Button Check in loop: "+ myCounter + " Check: " + backButtonCheck);
            myCounter++;
        }

        //System.out.println("Press Back Key Done");

    }

    public void clickByCords(String elementName) throws Exception {
        MobileElement myElement = null;
        TouchAction myAction = new TouchAction(driver);

        System.out.println("Start Click by Cords");
        myElement = driver.findElement(By.name(elementName));
        Point myPoint = myElement.getLocation();
        myAction.press(PointOption.point(myPoint.x, myPoint.y)).release();
        driver.performTouchAction(myAction);
        System.out.println("End Click by Cords");
    }


    public void  iosClickUseThisLocation() throws Exception {
        int useThisLocationX;
        int useThisLocationY;
        int useThisLocationWidth;
        int useThisLocationHeight;
        //useThisLocationX = driver.findElement(MobileBy.iOSNsPredicateString("name == 'Legal'")).getLocation().getX();
        //useThisLocationY = driver.findElement(MobileBy.iOSNsPredicateString("name == 'Legal'")).getLocation().getY();
        //useThisLocationWidth = driver.findElement(MobileBy.iOSNsPredicateString("name == 'Legal'")).getSize().getWidth();

        useThisLocationX = driver.findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getLocation().getX();
        useThisLocationY = driver.findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getLocation().getY();
        useThisLocationWidth = driver.findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getSize().getWidth();
        useThisLocationHeight = driver.findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getSize().getHeight();

        //System.out.println("X: " + useThisLocationX);
        //System.out.println("Y: " + useThisLocationY);
        //System.out.println("W: " + useThisLocationWidth);

        //new TouchAction(driver).tap(useThisLocationX+ useThisLocationWidth + 20, useThisLocationY ).release().perform();
        //new TouchAction(driver).tap(useThisLocationX, useThisLocationY - 50 ).release().perform();
        new TouchAction(driver).press(PointOption.point(useThisLocationX, useThisLocationY - 50)).release().perform();
    }

    public void clickAboveElement(MobileElement myElement) throws Exception {
        int useThisLocationX;
        int useThisLocationY;

        useThisLocationX = myElement.getLocation().getX();
        useThisLocationY = myElement.getLocation().getY();

        new TouchAction(driver).press(PointOption.point(useThisLocationX, useThisLocationY - 50)).release().perform();
    }




}
