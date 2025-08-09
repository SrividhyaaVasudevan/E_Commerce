package pages.action;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.repo.ProductDetailPageRepo;

public class ProductDetailPageAction extends ProductDetailPageRepo {
    WebDriver driver;
    public ProductDetailPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToCart(){
        waitUntilElementDisplayed(addToCartBtn);
        click(addToCartBtn);
    }

    public boolean verifyIfProductAdded(){
        return getAlertMessage().equalsIgnoreCase("Product added");
    }

    public void clickOnCartHeader(){
        waitUntilElementDisplayed(cartHeader);
        click(cartHeader);
    }

    public String getProductName(){
        waitUntilElementDisplayed(addToCartBtn);
        return getText(productName);
    }

    public boolean verifyProductNameDisplayed() {
        waitUntilElementDisplayed(addToCartBtn);
        return waitUntilElementDisplayed(productName);
    }

    public boolean verifyProductDescriptionDisplayed() {
        waitUntilElementDisplayed(addToCartBtn);
        return waitUntilElementDisplayed(productDescription);
    }

    public boolean verifyProductPriceDisplayed() {
        waitUntilElementDisplayed(addToCartBtn);
        return waitUntilElementDisplayed(productPrice);
    }

    public void navigateToHomePage() {
        waitUntilElementDisplayed(homeBtn);
        click(homeBtn);
    }


}
