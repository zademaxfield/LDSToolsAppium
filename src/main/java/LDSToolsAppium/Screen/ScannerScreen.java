package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ScannerScreen extends BasePage {

    public ScannerScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    public Elements getAllElements() throws Exception {
        BasePage myBasePage = new BasePage(driver);
        String pageSource;
        List<Attribute> elementAttributes = new ArrayList<Attribute>();

        pageSource = myBasePage.getSourceOfPage();
        Document doc = Jsoup.parse(pageSource);
        Elements myTest = doc.getAllElements();


//        for (Element myElement : myTest ) {
//            System.out.println("*********************************************************************");
//            //System.out.println(myElement.toString());
//
//            elementAttributes = myElement.attributes().asList();
//            for (Attribute myAttribute : elementAttributes ) {
//                System.out.println("---------------------------------------------------------------------");
//                System.out.println("To String: " + myAttribute.toString());
//                System.out.println("---------------------------------------------------------------------");
//                //System.out.println("Get Key: " + myAttribute.getKey());
//                //System.out.println("Get Value: " + myAttribute.getValue());
//                //System.out.println(" ");
//                //System.out.println("Get HTML: " + myAttribute.html());
//                //System.out.println("Get Class: " + myAttribute.getClass());
//            }
//            System.out.println("*********************************************************************");
//
//        }

        return myTest;

    }

    public List<Element> getClickableElements() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        List<Attribute> elementAttributes = new ArrayList<Attribute>();
        List<Element> clickableElements = new ArrayList<Element>();

        pageSource = myBasePage.getSourceOfPage();
        Document doc = Jsoup.parse(pageSource);
        Elements myTest = doc.getAllElements();

        for (Element myElement : myTest ) {
            elementAttributes = myElement.attributes().asList();
            for (Attribute myAttribute : elementAttributes ) {
                if(getOS().equals("ios")) {
                    if (myAttribute.toString().equals("visible=\"true\"")) {
                        clickableElements.add(myElement);
                    }
                } else {
                    if (myAttribute.toString().equals("clickable=\"true\"")) {
                        clickableElements.add(myElement);
                    }
                }
            }
        }


//        for (Element oneElement : clickableElements) {
//            elementAttributes = oneElement.attributes().asList();
//            System.out.println("---------------------------------------------------------------------");
//            for (Attribute myAttribute : elementAttributes ) {
////                System.out.println("---------------------------------------------------------------------");
////                System.out.println("To String: " + myAttribute.toString());
////                System.out.println("---------------------------------------------------------------------");
//                if (myAttribute.getKey().equals("text")) {
//                    System.out.println("TEXT: " + myAttribute.getValue());
//                }
//                if (myAttribute.getKey().equals("content-desc")) {
//                    System.out.println("CONTENT-DESC: " + myAttribute.getValue());
//                }
//                if (myAttribute.getKey().equals("resource-id")) {
//                    System.out.println("RESOURCE-ID: " + myAttribute.getValue());
//                }
//                if (myAttribute.getKey().equals("name")) {
//                    System.out.println("NAME: " + myAttribute.getValue());
//                }
//                if (myAttribute.getKey().equals("value")) {
//                    System.out.println("VALUE: " + myAttribute.getValue());
//                }
//
//            }
//            System.out.println("---------------------------------------------------------------------");
//        }
        return clickableElements;
    }

    public boolean checkForElementsTEST(String attributeCheck ) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        String pageSource;
        boolean elementFound = false;
        List<Attribute> elementAttributes = new ArrayList<Attribute>();

        pageSource = myBasePage.getSourceOfPage();
        Document doc = Jsoup.parse(pageSource);
        Elements myTest = doc.getAllElements();

        for (Element oneElement : myTest) {
            elementAttributes = oneElement.attributes().asList();

            for (Attribute myAttribute : elementAttributes ) {
                if (myAttribute.toString().contains(attributeCheck)) {
                    elementFound = true;
                }
            }

        }
        return elementFound;
    }

    public boolean quickCheckForElements(List<Element> listToCheck, String attributeCheck ) {

        boolean elementFound = false;
        List<Attribute> elementAttributes = new ArrayList<Attribute>();
        for (Element oneElement : listToCheck) {
            elementAttributes = oneElement.attributes().asList();

            for (Attribute myAttribute : elementAttributes ) {
                if (myAttribute.toString().contains(attributeCheck)) {
                    elementFound = true;
                }
            }

        }
        return elementFound;
    }

    public boolean scannerCheckForText( String searchText ) throws Exception {
        List<Element> clickableElements = new ArrayList<Element>();
        clickableElements = getClickableElements();
        boolean elementFound = false;
        List<Attribute> elementAttributes = new ArrayList<Attribute>();

        for (Element oneElement : clickableElements) {
            elementAttributes = oneElement.attributes().asList();

            for (Attribute myAttribute : elementAttributes ) {
                if (myAttribute.toString().contains(searchText)) {
                    elementFound = true;
                }
            }

        }
        return elementFound;
    }




}
