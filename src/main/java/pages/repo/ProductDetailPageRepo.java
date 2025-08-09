package pages.repo;

import common.UiBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPageRepo extends UiBase {

    @FindBy(xpath = "//a[contains(text(), \"Add to cart\")]")
    protected WebElement addToCartBtn;

    @FindBy(xpath = "//a[contains(text(),\"Cart\")]")
    protected WebElement cartHeader;

    @FindBy(xpath = "//h2")
    protected WebElement productName;

    @FindBy(xpath = "//*[contains(text(), \"Product description\")]/following-sibling::p")
    protected WebElement productDescription;

    @FindBy(xpath = "//h3[contains(text(),\"$\")]")
    protected WebElement productPrice;
    @FindBy(xpath = "//a[contains(text(),\"Home\")]")
    protected WebElement homeBtn;


}
