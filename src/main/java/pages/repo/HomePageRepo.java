package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageRepo extends UiBase {

    @FindBy(css = "#login2")
    protected WebElement loginBtn;

    @FindBy(css = "#signin2")
    protected WebElement SigninBtn;

    @FindBy(css = "#loginusername")
    protected WebElement loginUsernameField;

    @FindBy(css = "#loginpassword")
    protected WebElement loginPasswordField;

    @FindBy(css = "#sign-username")
    protected WebElement signinUsernameField;

    @FindBy(css = "#sign-password")
    protected WebElement signinPasswordField;

    @FindBy(css = "#nameofuser")
    protected WebElement nameOfUser;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    protected WebElement loginSubmit;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    protected WebElement signinSubmit;

    @FindBy(xpath = "//div[@id=\"tbodyid\"]//div/a")
    protected List<WebElement> products;

    @FindBy(xpath = "(//div[@id=\"tbodyid\"]//div/a)[1]")
    protected WebElement firstProducts;

    @FindBy(css = "#cat")
    protected WebElement homePageCategories;

    @FindBy(xpath = "//a[contains(text(),\"Home\")]")
    protected WebElement home;

    @FindBy(xpath = "//a[contains(text(),\"Contact\")]")
    protected WebElement contact;

    @FindBy(xpath = "//a[contains(text(),\"About us\")]")
    protected WebElement about;

    @FindBy(xpath = "//a[contains(text(),\"Cart\")]")
    protected WebElement cart;

    @FindBy(css = "#recipient-email")
    protected WebElement contactEmailField;

    @FindBy(css = "#videoModalLabel")
    protected WebElement aboutUsHeader;

    @FindBy(xpath = "//*[@id=\"exampleModal\"]//button[text()=\"Close\"]")
    protected WebElement contactPopupClose;

    @FindBy(xpath = "//*[@id=\"videoModalLabel\"]/parent::div/parent::div//button[text()=\"Close\"]")
    protected WebElement aboutUsClose;

    @FindBy(xpath = "//button[contains(text(),\"Place Order\")]")
    protected WebElement placeOrderBtn;

    @FindBy(xpath = "//*[@id=\"itemc\" and text()=\"Phones\"]")
    protected WebElement phoneCategories;

    @FindBy(xpath = "//*[@id=\"itemc\" and text()=\"Laptops\"]")
    protected WebElement laptopCategories;

    @FindBy(xpath = "//*[@id=\"itemc\" and text()=\"Monitors\"]")
    protected WebElement monitorCategories;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]//h4/a")
    protected List<WebElement> productTitles;


}
