package LDSToolsAppium;

import LDSToolsAppium.Screen.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileDevApp {
    private final AppiumDriver<MobileElement> driver2;

    public MobileDevApp(AppiumDriver<MobileElement> driver) {
        this.driver2 = driver;
    }

    //Mobile Dev
    public MobileDevMain mobileDevMain() throws Exception {
        return new MobileDevMain(driver2);
    }


}