package LDSToolsAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.*;

public class BaseDriver {
    public AppiumDriver<MobileElement> driver;
    public String deviceSerial = "";
    public String testOS = "";
    //public AppiumService myAppiumService;
    public AppiumService myAppiumService = new AppiumService();

    protected LDSToolsApp app;
    public LDSWeb myWeb = new LDSWeb();


    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "fileName", "testDevice", "startSleepTime"})
    public void setUp(String os, String fileName, String testDevice, int startSleepTime) throws Exception {

        int myPort;
        testOS = os;

        //Sleep so when multiple tests start they don't break
        System.out.println("Sleep Time: " + startSleepTime);
        Thread.sleep(startSleepTime);

        //Get Random Port Number
        myPort = getRandomPort();


        //System.out.println("OS: " + os);
        //System.out.println("Port: " + myPort);
        //Start Appium Server for iOS or Android with the Random Port
        //myAppiumService.startAppiumService(os, myPort);
        AppiumService.startAppiumService(os, myPort);


        //AppiumService.startAppiumService(os, myPort);





        driver = appiumCapabilities(os, fileName, testDevice, myPort);

        app = new LDSToolsApp(driver);

        
    }


    @DataProvider(name = "Members")
    public Iterator<Object []> provider(ITestContext context) throws InterruptedException {
        String myFileName = "src/main/java/LDSToolsAppium/membersOne.csv";;
        List<String> includedGroups = Arrays.asList(context.getIncludedGroups());
        if (includedGroups.contains("smoke")) {
            myFileName = "src/main/java/LDSToolsAppium/membersSmall.csv";
        } else if (includedGroups.contains("all")) {
            myFileName = "src/main/java/LDSToolsAppium/members.csv";
        }



        //String myFileName = "src/main/java/LDSToolsAppium/membersOne.csv";
        BufferedReader br = null;
        String line;
        String splitBy = ",";
        String[] data = null;
        List<Object []> testCases = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(myFileName));
            while ((line = br.readLine()) != null) {
                data = line.split(splitBy);
                testCases.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testCases.iterator();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) throws Exception {
        System.out.println("Start teardown");
        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus()) {
            //printPageSource();
            takeScreenShot();
        }

        if(getRunningOS().equals("mac")) {
            Thread.sleep(2000);
            driver.resetApp();
            Thread.sleep(5000);

        } else {
            System.out.println("Clear App");
            adbCommand("clearApp");
            Thread.sleep(5000);
            driver.launchApp();
            Thread.sleep(5000);
            System.out.println("SERIAL NUMBER: " + deviceSerial);
        }

        System.out.println("Check to see if web is running");
        if (myWeb.isRunning() == null) {
            System.out.println("Web is not running!");
        } else {
            myWeb.tearDown();
        }

        System.out.println("End teardown");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() throws Exception {
        if (!getRunningOS().equals("mac")) {
            driver.quit();
            if (!deviceSerial.equals("")) {
                STFService mySTFService = new STFService("http://10.109.45.162:7100", "4e625e83995b4d0d85279844dd0839b547283386c7a84b0787abeb080cc45828");
                DeviceApi myDevice = new DeviceApi(mySTFService);
                System.out.println("SERIAL NUMBER: " + deviceSerial);
                myDevice.releaseDevice(deviceSerial);
            }
        }
    }



    @AfterSuite(alwaysRun = true)
    public void afterAllTests() throws Exception {
        System.out.println("Stopping the driver");
        if (getRunningOS().equals("mac")) {

            //I don't think this is needed anymore
            //driver.quit();
            //driver.close();

            Thread.sleep(5000);
            stopFbSim();
            //System.out.println("Kill instruments");
            killProcess("instruments");
            //System.out.println("Kill Simulator");
            killProcess("Simulator");
            //System.out.println("Kill CoreSimulator");
            killProcess("com.apple.CoreSimulator.CoreSimulatorService");

        } else {
            //driver.quit();
            STFService mySTFService = new STFService("http://10.109.45.162:7100", "4e625e83995b4d0d85279844dd0839b547283386c7a84b0787abeb080cc45828");
            DeviceApi myDevice = new DeviceApi(mySTFService);

            System.out.println("SERIAL NUMBER: " + deviceSerial);
            if (!deviceSerial.isEmpty()) {
                myDevice.releaseDevice(deviceSerial);
            }


        }

        System.out.println("Killing Chrome and chromedriver");
        killProcess("Chrome");
        killProcess("chromedriver");
        myAppiumService.stopAppiumService();

        Thread.sleep(1000);
        System.out.println("Killing the Appium Service");
        killProcess("main.js");

    }

    private AppiumDriver<MobileElement> appiumCapabilities(String os, String fileName, String testDevice, int myPort) throws Exception {
        String myAppPackage;
        String myUdid = null;

        //Android Setup
        if (os.equals("android")) {
            List<String> deviceList;
            if (testDevice.contains("STF")) {
                String accessToken = "4e625e83995b4d0d85279844dd0839b547283386c7a84b0787abeb080cc45828";

                String deviceIPPort;


                String[] parts = testDevice.split("-");
               // String part1 = parts[0];


                deviceSerial = parts[1];
                System.out.println("SERIAL NUMBER: " + deviceSerial);

                LDSToolsAppium.STFService mySTFService = new LDSToolsAppium.STFService("http://10.109.45.162:7100", accessToken);
                LDSToolsAppium.DeviceApi myDevice = new LDSToolsAppium.DeviceApi(mySTFService);


                if (deviceSerial.equals("Pool")) {

                    deviceList = myDevice.getAvalibleDevices();
                    deviceSerial = deviceList.get(new Random().nextInt(deviceList.size()));
                    System.out.println("DEVICE TO USE: " + deviceSerial);
                    deviceSerial = deviceSerial.replace("\"", "");
                    System.out.println("SERIAL NUMBER: " + deviceSerial);
                }


                myDevice.connectDevice(deviceSerial);
                deviceIPPort = myDevice.remoteControl(deviceSerial);
                testDevice = getRemoteIPPort(deviceIPPort);
                adbRemoteConnect(testDevice);
            }



            // set up appium
            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "../../../Selenium");
            File app = new File(appDir, fileName);

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("app", app.getAbsolutePath());
            if (fileName.contains("alpha")) {
                capabilities.setCapability("appPackage", "org.lds.ldstools.dev"); // *** ALPHA ***
                myAppPackage = "org.lds.ldstools.dev";
            } else {
                capabilities.setCapability("appPackage", "org.lds.ldstools"); //*** BETA and RELEASE ***
                myAppPackage = "org.lds.ldstools";
            }

            capabilities.setCapability("deviceName", testDevice);
            capabilities.setCapability("udid", testDevice);
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("automationName","uiautomator2");
            capabilities.setCapability("appPackage", myAppPackage);
            capabilities.setCapability("newCommandTimeout", 600);

            capabilities.setCapability("appActivity", "org.lds.ldstools.ui.activity.SignInActivity");

            capabilities.setCapability("unicodeKeyboard", "true");
            capabilities.setCapability("resetKeyboard", "true");
            capabilities.setCapability("deviceReadyTimeout", "60");
            capabilities.setCapability("noSign", true);

            capabilities.setCapability("fullReset", false);
            capabilities.setCapability("dontStopAppOnReset", true);
            capabilities.setCapability("maxTypingFrequency", "8");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + myPort + "/wd/hub"), capabilities);

            Thread.sleep(2000);

        }

        //Setup for iOS
        if (os.equals("ios")) {
            //String webDriverURL = "http://localhost:";
            //String webDriverPort;
            int tempPort;

            tempPort = myPort + 1000;
            //webDriverPort = String.valueOf(tempPort);
            //webDriverURL = webDriverURL + webDriverPort;

            if (testDevice.contains("REAL")) {

                String[] parts = testDevice.split("-");
               // String part1 = parts[0];

                testDevice = parts[1];

                myUdid = getUDIDfromDeviceName(testDevice);


                //myUdid = deviceUDID();
            }

            if (testDevice.contains("FBSIM")) {

                String[] parts = testDevice.split("-");
                //String part1 = parts[0];
                //Remove all whitespace
                //part1 = part1.trim();
                //part2 = part2.trim();

                testDevice = parts[1];

                myUdid = getUDIDfromDeviceNameFBSIM(testDevice);

                //Start Simulator
                startFbSim(myUdid, tempPort);

                //Just a test
                Thread.sleep(6000);

            }

            System.out.println("Device Name: " + testDevice + " UDID: " + myUdid);


            // set up appium
            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "../../../Selenium");
            File app = new File(appDir, fileName);
            myAppPackage = "org.lds.ldstools.dev";
            
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
            capabilities.setCapability("deviceName",testDevice);
            capabilities.setCapability("automationName","XCUITest");
            capabilities.setCapability("browserName","");
            capabilities.setCapability("fullReset", true);
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("newCommandTimeout", 600);
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("launchTimeout", 300000);
            capabilities.setCapability("platformVersion", "11.3");
            capabilities.setCapability("nativeInstrumentsLib", false);
            capabilities.setCapability("clearSystemFiles", true);
            capabilities.setCapability("allowTouchIdEnroll", true);
            capabilities.setCapability("maxTypingFrequency", "8");
            capabilities.setCapability("appPackage", myAppPackage);


            if (myUdid != null) {
                capabilities.setCapability("xcodeOrgId", "U3SP4KMCK6");
                capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                capabilities.setCapability("udid", myUdid);
                capabilities.setCapability("wdaLocalPort", tempPort);
            }


            driver = new IOSDriver<>(new URL("http://127.0.0.1:" + myPort + "/wd/hub"),capabilities);
        }

        return driver;
    }

    private int getRandomPort() throws Exception {
        //System.out.println("OS: " + os );
        //System.out.println("File Name: " + fileName);
        //String myUdid = "";
        Random randomPort = new Random();
        int myPort;
        int lowPort = 4500;
        int highPort = 4999;
        //Random randomSleep = new Random();
        //int sleepTime = 1000;
        //int lowSleep = 1000;
        //int highSleep = 9999;

        Boolean portOpen;

        //Check to see if the random port is open
        //If the port is in use try a different port
        do {
            myPort = randomPort.nextInt(highPort - lowPort) + lowPort;
            portOpen = portCheck(myPort);
        } while (portOpen.equals(false));


        //System.out.println("OS: " + os);
        //System.out.println("PORT: " + myPort);

        return myPort;

    }


    private String getRemoteIPPort(String myText) {
        String myIPPort;
        System.out.println("MY PORT: " + myText);
        String[] ipArray = StringUtils.substringsBetween(myText, "\"", "\"");

        for (String getIP : ipArray) {
            System.out.println("GET IP: " + getIP);
        }

        myIPPort = ipArray[ipArray.length -1];

        return myIPPort;
    }


    private void adbRemoteConnect(String ipPort) throws Exception {
        String pathToADB = "../../../android-sdks/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.dev";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {pathToADB, "connect", ipPort});
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }



    }

    private String getUDIDfbsim(String deviceNameSearch) throws Exception {
        String line;

        //System.out.println("UDID to Test: " + myUDID);
        Runtime run = Runtime.getRuntime();
        deviceNameSearch = "'" + deviceNameSearch + "'";
        System.out.println("EDIT TO SEARCH " + deviceNameSearch);

        //Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl list ", " | grep", deviceNameSearch});
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl list | grep " + deviceNameSearch});
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        System.out.println(line);


        String[] parts = line.split(" | ");
        String simUDID = parts[0];
//        String simName = parts[1];
//        String simStatus = parts[2];
//        String simModel = parts[3];
//        String simOSVersion = parts[4];


        //System.out.println(deviceName);

        return simUDID;
    }

    private String getUDIDfromDeviceName(String deviceName) throws Exception {
        List<String> connectedUDID;
        String checkDeviceName;
        String returnUDID = "Not Found!";
        //Get UDID from devices
        connectedUDID = multipleDeviceUDID();

        //Match deviceName to UDID
        for(String oneUDID : connectedUDID){
            checkDeviceName = getDeviceName(oneUDID);
            if (checkDeviceName.equals(deviceName))	{
                returnUDID = oneUDID;
            }
        }

        return returnUDID;
    }


    private String deviceUDID() throws IOException{
        ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "/usr/local/bin/idevice_id -l");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        line = r.readLine();
        System.out.println(line);
        return line;
    }

    private List<String> multipleDeviceUDID() throws Exception {
        List<String> line = new ArrayList<String>();
        String myLine;

        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/usr/local/bin/idevice_id", "-l"});
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        while ((myLine=buf.readLine())!=null) {
            //System.out.println(myLine);
            line.add(myLine);

        }

        return line;
    }

    private String getDeviceName(String myUDID) throws Exception {
        String deviceName;
        String line;

        //System.out.println("UDID to Test: " + myUDID);
        Runtime run = Runtime.getRuntime();
        //Process pr = run.exec(new String[] {"/usr/local/bin/ideviceinfo", "--udid", myUDID, "|", "grep", "DeviceName"});
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "/usr/local/bin/ideviceinfo --udid " + myUDID + " | grep DeviceName"});
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        //System.out.println(line);


        String[] parts = line.split(" ");
        //String part1 = parts[0];

        deviceName = parts[1];

        //System.out.println(deviceName);

        return deviceName;
    }


    private String getUDIDfromDeviceNameFBSIM(String deviceName) throws Exception {
        String simUDID;
        String deviceNameSearch = "| " + deviceName + " |";
        System.out.println("TO SEARCH: " + deviceNameSearch);

        simUDID = getUDIDfbsim(deviceNameSearch) ;

        return simUDID;
    }

    private void startFbSim(String myUdid, int tempPort) throws Exception {
        String line;
        String listenPort = Integer.toString(tempPort);
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl ", myUdid, " boot"});
        //Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl ", myUdid, " boot",  "--", "listen", "--http ", listenPort});
        //Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl ", myUdid });
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        //System.out.println(line);
    }

    private void stopFbSim() throws Exception {
        String line;
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl shutdown" });
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        //System.out.println(line);
    }




    private boolean portCheck(int port) throws IOException {
        // Assume no connection is possible.
        boolean result = false;

        try {
            Socket s = new Socket("localhost", port);
            s.close();
            System.out.println("Port " + port + " is in use.");
            result = false;
        }
        catch(SocketException e) {
            // Could not connect.
            //System.out.println("Port " + port + " is open.");
            result = true;
        }

        return result;
    }


    public void killProcess(String processToKill) throws Exception {
        String line = "";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/usr/bin/pkill", "-9", "-f", "-l", processToKill});
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }


    public String getRunningOS() {
        String myOs = "";

        if (testOS.equalsIgnoreCase("android")) {
            myOs = "android";
        }

        if (testOS.equalsIgnoreCase("ios")) {
            myOs = "mac";
        }

        myOs = myOs.toLowerCase();
        //System.out.println("MY OS: "  + myOs);
        return myOs;
    }

    private void adbCommand(String myCommand) throws Exception {
        String pathToADB = "../../../android-sdks/platform-tools/adb";



        if (myCommand.equals("stopApp")) {
            //String cmd = "adb shell am force-stop org.lds.ldstools.dev";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(new String[] {pathToADB, "shell", "am", "force-stop", "org.lds.ldstools.dev"});
            //Process pr = run.exec(cmd);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line=buf.readLine())!=null) {
                System.out.println(line);
            }
        }

        if (myCommand.equals("clearApp")) {
            //String cmd = "adb shell am force-stop org.lds.ldstools.dev";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(new String[] { pathToADB, "shell", "pm", "clear", "org.lds.ldstools.dev"});
            //Process pr = run.exec(cmd);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line=buf.readLine())!=null) {
                System.out.println(line);
            }
        }
    }

    public void takeScreenShot() {
        String imagesLocation = "screenshot/";
        new File(imagesLocation).mkdirs(); // Insure directory is there

        try {
            File srcFile=driver.getScreenshotAs(OutputType.FILE);
            String filename= UUID.randomUUID().toString();
            System.out.println("Screenshot File: " + filename);
            File targetFile=new File(imagesLocation + filename +".png");
            FileUtils.copyFile(srcFile,targetFile);
        }
        catch(Exception e){
            System.out.println("Warning: Some Other exception");
        }

    }

}
