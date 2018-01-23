package LDSToolsAppium;

import LDSToolsAppium.Screen.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import javafx.stage.Screen;

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

    //Directory Screen
    public DirectoryScreen directoryScreenScreen() {
        return new DirectoryScreen(driver);
    }

}