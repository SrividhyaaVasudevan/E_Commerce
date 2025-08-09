package tests;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.Map;

public class OrderPlacementTest extends BaseTest {
    @Test
    public void verifyOrderPlacement() {
        Map<String, String> data = testData.getExcelData("order", "validData");
        homePageAction.clickOnFirstProduct();
        productDetailPageAction.clickOnAddToCart();
        AssertFail(productDetailPageAction.verifyIfProductAdded(), "Verify If product added to cart");
        String productName = productDetailPageAction.getProductName();
        productDetailPageAction.clickOnCartHeader();
        AssertFail(cartPageAction.cartItemsCount() == 1, "Verify if item added to Cart Page");
        AssertFail(cartPageAction.verifyCartItemPresent(productName), "Verify if item name is present in Cart Page");
        AssertFail(cartPageAction.verifyCartTotalPrice(), "Verify if total price is calculated");
        cartPageAction.clickOnPlaceOrder();
        cartPageAction.fillOrderDetails(data);
        cartPageAction.clickOnPurchaseOrder();
        AssertFail(cartPageAction.verifyThankyouMessage(), "Verify if Thankyou message");
        AssertFail(cartPageAction.verifyOrderID(), "Verify if order id displayed");

    }

    @Test
    public void verifyOrderPlacementWithEmptyData() {
        Map<String, String> data = testData.getExcelData("order", "EmptyData");
        homePageAction.clickOnFirstProduct();
        productDetailPageAction.clickOnAddToCart();
        AssertFail(productDetailPageAction.verifyIfProductAdded(), "Verify If product added to cart");
        String productName = productDetailPageAction.getProductName();
        productDetailPageAction.clickOnCartHeader();
        AssertFail(cartPageAction.cartItemsCount() == 1, "Verify if item added to Cart Page");
        AssertFail(cartPageAction.verifyCartItemPresent(productName), "Verify if item name is present in Cart Page");
        AssertFail(cartPageAction.verifyCartTotalPrice(), "Verify if total price is calculated");
        cartPageAction.clickOnPlaceOrder();
        cartPageAction.fillOrderDetails(data);
        cartPageAction.clickOnPurchaseOrder();
        AssertFail(cartPageAction.getAlertMessage().equalsIgnoreCase(data.get("error")), "Verify error message");

    }

}
