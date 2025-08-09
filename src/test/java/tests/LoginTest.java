package tests;

import common.BaseTest;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.util.Map;

public class LoginTest extends BaseTest {
    @Test
    public void verifyLoginWithValidCredentials(){
        Map<String, String> data = testData.getExcelData("login", "validData");
        homePageAction.login(data.get("username"), data.get("password"));
        homePageAction.loginAlertAccept();
        AssertFail(homePageAction.checkIfUserLogin(), "Verify login with valid credentials");
    }

    @Test
    public void verifyLoginWithIncorrectPassword(){
        Map<String, String> data = testData.getExcelData("login", "InvalidPassword");
        homePageAction.login(data.get("username"), data.get("password"));
        AssertFail(homePageAction.checkLoginError(data.get("error")), "Verify login with valid credentials");
    }

    @Test
    public void verifyLoginWithEmptyFields(){
        Map<String, String> data = testData.getExcelData("login", "EmptyData");
        homePageAction.login(data.get("username"), data.get("password"));
        AssertFail(homePageAction.checkLoginError(data.get("error")), "Verify login with valid credentials");
    }

    @Test
    public void verifyLoginWithInvalidEmailFormat(){
        Map<String, String> data = testData.getExcelData("login", "InvalidEmailFormat");
        homePageAction.login(data.get("username"), data.get("password"));
        AssertFail(homePageAction.checkLoginError(data.get("error")), "Verify login with valid credentials");
    }

    @Test
    public void verifyPasswordMasked(){
        Map<String, String> data = testData.getExcelData("login", "validData");
        homePageAction.login(data.get("username"), data.get("password"));
        AssertFail(homePageAction.checkPasswordFieldMasked(), "Verify login with valid credentials");
    }

}
