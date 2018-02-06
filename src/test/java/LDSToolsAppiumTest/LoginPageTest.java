package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseDriver {

    @Test( groups = {"all1", "all"})
    public void loginPageSimple() throws Exception {
        HelperMethods myHelper = new HelperMethods(driver);

        myHelper.loginUAT("LDSTools2", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

    }

    //Todo: Need more tests!!!!!



}
