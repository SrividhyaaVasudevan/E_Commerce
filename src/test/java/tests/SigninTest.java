package tests;

import common.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;

public class SigninTest extends BaseTest {
    @Test
    public void verifySigninWithValidCredentials(){
        homePageAction.signinAsNewUserWithDefaultValues();
        AssertFail(homePageAction.verifyUserSignInPopup(), "Verify login with valid credentials");
    }

    @Test(dataProvider = "mapData")
    public void verifySigninFunctionalityError(Map<String, String> data){
        homePageAction.signin(data.get("username"), data.get("password"));
        AssertFail(homePageAction.checkSigninError(data.get("error")), "Verify login with valid credentials");
    }

    @DataProvider(name = "mapData")
    public Object[][] provideObjectData() {
        return testData.provideData("signin");
    }

}
