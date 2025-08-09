package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPageRepo extends UiBase {

    @FindBy(xpath = "//tbody/tr/td[2]")
    protected List<WebElement> cartItemsTitle;

    @FindBy(xpath = "(//tbody/tr/td)[2]")
    protected WebElement firstCartItemTitle;

    @FindBy(xpath = "(//tbody/tr/td)[4]/a")
    protected WebElement firstItemDelete;

    @FindBy(xpath = "//tbody/tr/td[3]")
    protected List<WebElement> cartItemsPrice;

    @FindBy(xpath = "//button[contains(text(),\"Place Order\")]")
    protected WebElement placeOrderBtn;

    @FindBy(css = "#totalp")
    protected WebElement orderTotal;

    @FindBy(css = "#name")
    protected WebElement nameField;

    @FindBy(css = "#country")
    protected WebElement countryField;

    @FindBy(css = "#city")
    protected WebElement cityField;

    @FindBy(css = "#card")
    protected WebElement cardField;

    @FindBy(css = "#month")
    protected WebElement monthField;

    @FindBy(css = "#year")
    protected WebElement yearField;

    @FindBy(xpath = "//button[contains(text(),\"Purchase\")]")
    protected WebElement purchaseBtn;

    @FindBy(xpath = "//h2[contains(text(),\"Thank\")]")
    protected WebElement thankMsg;

    @FindBy(xpath = "//p[contains(text(), \"Id:\")]")
    protected WebElement orderID;


}
