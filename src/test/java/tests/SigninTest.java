package tests;

import common.BaseTest;
import org.testng.annotations.Test;
import java.util.Map;

public class SigninTest extends BaseTest {
    @Test
    public void verifySigninWithValidCredentials(){
        homePageAction.signinAsNewUserWithDefaultValues();
        AssertFail(homePageAction.verifyUserSignInPopup(), "Verify login with valid credentials");
    }

    @Test
    public void verifySigninWithExistingUsername(){
        Map<String, String> data = testData.getExcelData("signin", "ExistingUser");
        homePageAction.signin(data.get("username"), data.get("password"));
        AssertFail(homePageAction.checkSigninError(data.get("error")), "Verify login with valid credentials");
    }

    @Test
    public void verifySigninWithEmptyField(){
        Map<String, String> data = testData.getExcelData("signin", "EmptyData");
        homePageAction.signin(data.get("username"), data.get("password"));
        AssertFail(homePageAction.checkSigninError(data.get("error")), "Verify login with valid credentials");
    }

}
