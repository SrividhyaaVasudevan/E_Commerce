package pages.action;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.repo.CartPageRepo;

import java.util.Map;

public class CartPageAction extends CartPageRepo {
    WebDriver driver;
    public CartPageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public int cartItemsCount(){
        try{
            waitUntilElementDisplayed(firstCartItemTitle);
            staticWait(2000);
            System.out.println(cartItemsTitle.size());
            return cartItemsTitle.size();
        }catch (Exception e){
            return 0;
        }
    }

    public boolean verifyCartItemPresent(String productName){
        waitUntilElementDisplayed(firstCartItemTitle);
        staticWait(2000);
        for(WebElement item: cartItemsTitle){
            if(getText(item).equalsIgnoreCase(productName)) return true;
        }
        return false;
    }

    public boolean verifyCartTotalPrice(){
        try{
            waitUntilElementDisplayed(firstCartItemTitle);
            staticWait(2000);
            int subTotal = 0;
            for(WebElement item: cartItemsPrice){
                subTotal += Integer.parseInt(getText(item));
            }
            return subTotal == Integer.parseInt(getText(orderTotal));
        }catch (Exception e){
            return false;
        }
    }

    public void deleteFirstProduct(){
        waitUntilElementDisplayed(firstItemDelete);
        click(firstItemDelete);
    }

    public void clickOnPlaceOrder(){
        waitUntilElementDisplayed(placeOrderBtn);
        click(placeOrderBtn);
    }

    public void clickOnPurchaseOrder(){
        scrollIntoView(purchaseBtn);
        click(purchaseBtn);
    }

    public void fillOrderDetails(Map<String, String> data){
        waitUntilElementDisplayed(nameField);
        fill(nameField, data.get("name"));
        fill(countryField, data.get("country"));
        fill(cityField, data.get("city"));
        fill(cardField, data.get("card"));
        fill(monthField, data.get("month"));
        fill(yearField, data.get("year"));
    }

    public boolean verifyThankyouMessage(){
        return waitUntilElementDisplayed(thankMsg);
    }

    public boolean verifyOrderID(){
        return waitUntilElementDisplayed(orderID);
    }

}
