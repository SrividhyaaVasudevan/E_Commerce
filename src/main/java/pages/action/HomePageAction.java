package pages.action;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.repo.HomePageRepo;

import java.util.List;

public class HomePageAction extends HomePageRepo {
    WebDriver driver;
    public HomePageAction(WebDriver driver){
        this.driver = driver;
        setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogin(){
        waitUntilElementDisplayed(loginBtn);
        click(loginBtn);
    }

    public void clickOnLogInSubmit(){
        waitUntilElementDisplayed(loginSubmit);
        click(loginSubmit);
    }

    public void clickOnSignUp(){
        waitUntilElementDisplayed(signinSubmit);
        click(signinSubmit);
    }

    public void clickOnSignin(){
        waitUntilElementDisplayed(SigninBtn);
        click(SigninBtn);
    }

    public void fillLoginDetails(String username, String password){
        waitUntilElementDisplayed(loginUsernameField);
        fill(loginUsernameField, username);
        fill(loginPasswordField, password);
    }

    public void fillSigninDetails(String username, String password){
        waitUntilElementDisplayed(signinUsernameField);
        fill(signinUsernameField, username);
        fill(signinPasswordField, password);
    }

    public void login(String username, String password){
        clickOnLogin();
        fillLoginDetails(username, password);
        clickOnLogInSubmit();
    }

    public void signin(String username, String password){
        clickOnSignin();
        fillSigninDetails(username, password);
        clickOnSignUp();
    }

    public void signinAsNewUser(String username, String password){
        clickOnSignin();
        fillSigninDetails(username, password);
        clickOnSignUp();
    }

    public boolean verifyUserSignInPopup(){
        return getAlertMessage().equalsIgnoreCase("Sign up successful.");
    }

    public void signinAsNewUserWithDefaultValues(){
        String username = generateUniqueUsername();
        System.out.println(username);
        clickOnSignin();
        fillSigninDetails(username, "testing");
        clickOnSignUp();
    }

    public void clickOnFirstProduct(){
        waitUntilElementDisplayed(products.get(0));
        click(products.get(0));
    }

    public boolean verifyHomePageDisplayed(){
        return waitUntilElementDisplayed(homePageCategories);
    }


    public boolean checkPasswordFieldMasked(){
        return getAttribute(loginPasswordField, "type").equalsIgnoreCase("password");
    }

    public void loginAlertAccept(){
        acceptAlert();
    }

    public boolean checkIfUserLogin(){
        return waitUntilElementDisplayed(nameOfUser);
    }

    public boolean checkLoginError(String error){
        return getAlertMessage().equalsIgnoreCase(error);
    }

    public boolean checkSigninError(String error){
        return getAlertMessage().equalsIgnoreCase(error);
    }

    public boolean verifyContactsNavbar(){
        waitUntilElementDisplayed(contact);
        click(contact);
        boolean res = waitUntilElementDisplayed(contactEmailField);
        staticWait(3000);
        click(contactPopupClose);
        return res;
    }

    public boolean verifyAboutUsNavbar(){
        waitUntilElementDisplayed(about);
        click(about);
        boolean res = waitUntilElementDisplayed(aboutUsHeader);
        staticWait(3000);
        click(aboutUsClose);
        return res;
    }

    public boolean verifyCartNavbar(){
        waitUntilElementDisplayed(cart);
        click(cart);
        return waitUntilElementDisplayed(placeOrderBtn);
    }

    public void clickOnPhoneCategories(){
        scrollIntoView(homePageCategories);
        click(phoneCategories);
    }

    public void clickOnLaptopCategories(){
        scrollIntoView(homePageCategories);
        click(laptopCategories);
    }

    public void clickOnMonitorCategories(){
        scrollIntoView(homePageCategories);
        click(monitorCategories);
    }

    public boolean verifyIfProductPresent(String expected){
        waitUntilElementDisplayed(homePageCategories);
        scrollIntoView(homePageCategories);
        waitUntilElementDisplayed(firstProducts);
        staticWait(5000);
        for(WebElement product: productTitles){
            String actual = getText(product).toLowerCase();
            if(actual.contains(expected)){
                return true;
            }
        }
        return false;
    }

    public List<WebElement> getProductsElement(){
        return products;
    }

    public WebElement getFirstProductElement(){
        return productTitles.get(0);
    }

    public boolean responsiveTest(){
        driver.manage().window().setSize(new Dimension(400, 800));
        waitUntilElementDisplayed(laptopCategories);
        staticWait(5000);
        return isDisplayed(laptopCategories);
    }

}
