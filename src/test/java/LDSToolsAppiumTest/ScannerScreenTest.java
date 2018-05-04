package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.ScannerScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ScannerScreenTest extends BaseDriver {

    @Test ( groups = {"jft"})
    public void scannerSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);

        String userName = "LDSTools2";
        String passWord = "toolstester";
        Boolean myCheck;

        Elements allElements;
        List<Element> myUsableElements = new ArrayList<Element>();

        Thread.sleep(4000);

        myUsableElements = myScanner.getClickableElements();
        myCheck = myScanner.quickCheckForElements(myUsableElements, "Wookies");

        System.out.println("Check: " + myCheck);


        //myHelper.loginUAT(userName, passWord);
        //myHelper.enterPin("1", "1", "3", "3");



    }




}
