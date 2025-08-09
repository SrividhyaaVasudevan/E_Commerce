package common;

import org.openqa.selenium.WebDriver;
import pages.action.HomePageAction;
import pages.action.CartPageAction;
import pages.action.ProductDetailPageAction;

public class PageInitializer extends BrowserInitializer {

    public HomePageAction homePageAction;
    public CartPageAction cartPageAction;
    public ProductDetailPageAction productDetailPageAction;



    public void initializePages(WebDriver driver){
        homePageAction = new HomePageAction(driver);
        cartPageAction = new CartPageAction(driver);
        productDetailPageAction = new ProductDetailPageAction(driver);
    }

}
