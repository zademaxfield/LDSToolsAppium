package LDSToolsAppium;

import LDSToolsAppium.Screen.LoginPageScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.SettingsScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LDSToolsApp {
    private final AppiumDriver<MobileElement> driver;

    public LDSToolsApp(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    //Login Page
    public LoginPageScreen loginPage() {
        return new LoginPageScreen(driver);
    }

    //Setings Screen
    public SettingsScreen settingsScreen() {
        return new SettingsScreen(driver);
    }

    //Menu Screen
    public MenuScreen menuScreen() {
        return new MenuScreen(driver);
    }

    //PIN Screen
    public PinScreen pinScreen() {
        return new PinScreen(driver);
    }

}