package tests;

import common.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test(dataProvider="mapData")
    public void verifyLoginFunctionality(Map<String, String> data){
        homePageAction.login(data.get("username"), data.get("password"));
        if(data.get("scenario").equalsIgnoreCase("valid")){
            AssertFail(homePageAction.checkPasswordFieldMasked(), "Verify login with valid credentials");
            homePageAction.loginAlertAccept();
            AssertFail(homePageAction.checkIfUserLogin(), "Verify login with valid credentials");
        }else{
            AssertFail(homePageAction.checkLoginError(data.get("error")), "Verify login with valid credentials");
        }
    }

    @DataProvider(name = "mapData")
    public Object[][] provideObjectData() {
        return testData.provideData("login");
    }

}
