package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;


public class ListsScreen extends BasePage {

    public ListsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }

    // ****************** Lists Screen ******************

    //Edit List - iOS Only
    @iOSXCUITFindBy(accessibility = "Edit")
    public MobileElement listsEdit;

    //Done List - iOS Only
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement listsDone;


    //Add List
    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "Add List")
    public MobileElement listsAddList;




    // ****************** Lists Screen ******************

    //New List Dialog - Name
    @AndroidFindBy(id = "editText")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @iOSXCUITFindBy(iOSNsPredicate =  "type == 'XCUIElementTypeTextField'")
    public MobileElement listsName;

    //New List Dialog - Cancel
    @AndroidFindBy(id = "md_button_negative")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement listsCancel;

    //New List Dialog - OK or Done
//    @AndroidFindBy(id = "button1")
    @AndroidFindBy(xpath = "//*[@text='OK']")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement listsOk;






    //Into Lists - Android and iOS does this differently

    //Android - Edit List Name
    @AndroidFindBy(id = "menu_item_edit_name")
    public MobileElement listsEditName;

    //Android - Add member name text field
    @AndroidFindBy(id = "individualLookupAutoCompleteTextView")
    public MobileElement listsAddMemberName;


    //iOS - Add Member Button
    @iOSXCUITFindBy(accessibility = "Add to List")
    public MobileElement listsAddToListButton;

    //iOS - Search Field
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement listsSearch;

    //Back button after adding user
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement listsBackButton;




    //Share - Map - Text

    //Share - Email button
    @AndroidFindBy(id = "menu_send_email")
    public MobileElement listsSendEmail;

    //Show On Map
    @AndroidFindBy(id = "menu_show_on_map")
    public MobileElement listsShowOnMap;

    //Send Text to List
    @AndroidFindBy(id = "menu_show_on_map")
    public MobileElement listsSendText;

    //More Options
    @AndroidFindBy(accessibility = "More options")
    public MobileElement listsMoreOptions;


    //More Options - Share
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share']")
    public MobileElement listsMoreOptionsShare;

    //More Options - Edit
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit']")
    public MobileElement listsMoreOptionsEdit;

    //More Options - Delete
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
    public MobileElement listsMoreOptionsDelete;


    //Top List Element
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    public MobileElement listTopList;


    public String findTopListName() throws Exception {
        String topListName = "";

        if (checkForElement(listTopList)) {
            topListName = listTopList.getText();
        }

        return topListName;
    }

    public void deleteAllLists() throws Exception {
        String listName;
        listName = findTopListName();
        while (listName != null && !listName.isEmpty()) {
            deleteList(listName);
            Thread.sleep(2000);
            listName = findTopListName();
        }

    }


    public void deleteList(String myListName) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        if (getOS().equals("ios")) {
//            listsEdit.click();

            myBasePage.waitForElementThenClick(listsEdit);
            System.out.println(myBasePage.getSourceOfPage());
            myBasePage.waitForElementThenClick(driver.findElement(By.xpath("//*[contains(@name, 'Delete " + myListName + "')]")));
//            driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name, 'Delete " + myListName + "')]")).click();

            Thread.sleep(1000);

//            myBasePage.waitForElementThenClick(driver.findElement(MobileBy.iOSNsPredicateString("name == 'Delete' ")));
            myBasePage.waitForElementThenClick(driver.findElement(By.name("Delete")));
            Thread.sleep(8000);

//            driver.findElement(MobileBy.iOSNsPredicateString("name == 'Delete' ")).click();

            //If there more than one list this "Done" button will still be displayed
            if (checkForElement(listsDone)) {
                listsDone.click();
            }

        } else {
            selectListName(myListName);
            listsMoreOptions.click();
            listsMoreOptionsDelete.click();

//            System.out.println(getSourceOfPage());
            myBasePage.waitForElementThenClick(listsOk);
//            listsOk.click();
        }
    }

    public void deleteMemberFromList(String memberName) throws Exception {
        if (getOS().equals("ios")) {
            listsEdit.click();
            driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name, 'Delete " + memberName + "')]")).click();
            driver.findElement(MobileBy.iOSNsPredicateString("name == 'Delete' ")).click();

            //If there more than one list this "Done" button will still be displayed
            if (checkForElement(listsDone)) {
                listsDone.click();
            }

        } else {
            listsMoreOptions.click();
            listsMoreOptionsEdit.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.TextView[@text='" + memberName + "']/../../../../android.widget.ImageView")).click();

        }

    }




    public String getLastListMember() throws Exception {
        String lastListMember;
        lastListMember = driver.findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'individualView')][last()]//android.widget.TextView[contains(@resource-id, 'name')]")).getText();
        System.out.println("Last Member: " + lastListMember);
        return lastListMember;

    }





    public void selectListName(String myListName) throws Exception{
        if (getOS().equals("ios")) {
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + myListName + "']")).click();
        } else {
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+ myListName + "']")).click();
        }
    }

    public String getNumberOfListMembers(String myListName) throws Exception{
        String listNumber;
        if (getOS().equals("ios")) {
            listNumber = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + myListName + "']/following-sibling::XCUIElementTypeStaticText")).getAttribute("name").toString();
        } else {
            listNumber = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ myListName + "']/following-sibling::android.widget.TextView")).getAttribute("text").toString();
            if (listNumber.contains("people")) {
                listNumber = listNumber.replace(" people", "");
            } else {
                listNumber = listNumber.replace( " person", "");
            }
        }

        return listNumber;
    }





    public void addMemberToList(String memberToAdd, String memberToClickOn) throws Exception {
        int elementX;
        int elementY;

        if (getOS().equals("ios")) {
            listsAddToListButton.click();
            Thread.sleep(2000);
            listsSearch.sendKeys(memberToAdd);
            Thread.sleep(2000);
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + memberToClickOn + "']")).click();
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name, '" + memberToClickOn + "')]")).click();
            backButton.click();


        } else {
            listsAddMemberName.sendKeys(memberToAdd);
//            driver.findElement(By.xpath("//*[@text='" + memberToClickOn + "']"));
            elementX = listsAddMemberName.getLocation().getX();
            elementY = listsAddMemberName.getLocation().getY();

            TouchAction clickElement = new TouchAction(driver).press(PointOption.point(elementX + 60, elementY + 200)).release();
            clickElement.perform();
        }
    }






}
