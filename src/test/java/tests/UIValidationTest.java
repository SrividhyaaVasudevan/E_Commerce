package tests;

import common.BaseTest;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Map;

public class UIValidationTest extends BaseTest {

    @Test
    public void verify_form_alignment() {
        WebElement username = homePageAction.getProductsElement().get(0);
        WebElement password = homePageAction.getProductsElement().get(1);

        Point usernameLoc = username.getLocation();
        Point passwordLoc = password.getLocation();

        // Example alignment check: fields should be vertically aligned
        AssertFail(usernameLoc.getY() == passwordLoc.getY(),"Alignment is correct");
    }


    @Test
    public void verify_font_and_theme() {
        String fontFamily = homePageAction.getFirstProductElement().getCssValue("font-family");
        System.out.println(fontFamily);
        AssertFail(fontFamily.toLowerCase().contains("latoweb") || fontFamily.toLowerCase().contains("sans-serif"),"Font Verification");
    }

    @Test
    public void verify_layout_responsiveness() {
        AssertFail(homePageAction.responsiveTest(), "Responsive Test");
    }



}
