package tests;

import common.BaseTest;
import org.testng.annotations.Test;

public class ProductNavigationTest extends BaseTest {
    @Test
    public void verifyProductDetails() {
        homePageAction.clickOnFirstProduct();
        AssertFail(productDetailPageAction.verifyProductNameDisplayed(), "Verify if product name is displayed");
        AssertFail(productDetailPageAction.verifyProductDescriptionDisplayed(), "Verify if product description is displayed");
        AssertFail(productDetailPageAction.verifyProductPriceDisplayed(), "Verify if product price is displayed");
        productDetailPageAction.navigateToHomePage();
        AssertFail(homePageAction.verifyHomePageDisplayed(), "Verify navigation to Homepage");

    }

    @Test
    public void verifyNavbarLinks() {
        AssertFail(homePageAction.verifyContactsNavbar(), "Verify Contact navbar link");
        AssertFail(homePageAction.verifyAboutUsNavbar(), "Verify About us navbar link");
        AssertFail(homePageAction.verifyCartNavbar(), "Verify cart navbar link");
    }

    @Test(priority = -1)
    public void verifyCategories() {
        homePageAction.clickOnPhoneCategories();
        AssertFail(homePageAction.verifyIfProductPresent("samsung"), "Verify Phone Categories displayed");
        homePageAction.clickOnLaptopCategories();
        AssertFail(homePageAction.verifyIfProductPresent("dell"), "Verify Laptop Categories displayed");
        homePageAction.clickOnMonitorCategories();
        AssertFail(homePageAction.verifyIfProductPresent("apple"), "Verify Monitor Categories displayed");
    }

}
