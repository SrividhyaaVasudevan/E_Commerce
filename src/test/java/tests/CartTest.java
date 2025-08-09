package tests;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class CartTest extends BaseTest {
    @Test
    public void verifyAddItemToCart() {
        homePageAction.clickOnFirstProduct();
        productDetailPageAction.clickOnAddToCart();
        AssertFail(productDetailPageAction.verifyIfProductAdded(), "Verify If product added to cart");
        String productName = productDetailPageAction.getProductName();
        productDetailPageAction.clickOnCartHeader();
        AssertFail(cartPageAction.cartItemsCount() == 1, "Verify if item added to Cart Page");
        AssertFail(cartPageAction.verifyCartItemPresent(productName), "Verify if item name is present in Cart Page");
        AssertFail(cartPageAction.verifyCartTotalPrice(), "Verify if total price is calculated");
    }

    @Test
    public void verifyMultipleItemToCart() {
        homePageAction.clickOnFirstProduct();
        productDetailPageAction.clickOnAddToCart();
        AssertFail(productDetailPageAction.verifyIfProductAdded(), "Verify If product added to cart");
        String productName = productDetailPageAction.getProductName();
        productDetailPageAction.clickOnAddToCart();
        AssertFail(productDetailPageAction.verifyIfProductAdded(), "Verify If product added to cart");
        productDetailPageAction.clickOnCartHeader();
        AssertFail(cartPageAction.cartItemsCount() == 2, "Verify if item added to Cart Page");
        AssertFail(cartPageAction.verifyCartItemPresent(productName), "Verify if item name is present in Cart Page");
        AssertFail(cartPageAction.verifyCartTotalPrice(), "Verify if total price is calculated");

    }

    @Test
    public void verifyRemoveProduct() {
        homePageAction.clickOnFirstProduct();
        productDetailPageAction.clickOnAddToCart();
        AssertFail(productDetailPageAction.verifyIfProductAdded(), "Verify If product added to cart");
        productDetailPageAction.clickOnAddToCart();
        AssertFail(productDetailPageAction.verifyIfProductAdded(), "Verify If product added to cart");
        productDetailPageAction.clickOnCartHeader();
        AssertFail(cartPageAction.cartItemsCount() == 2, "Verify if item added to Cart Page");
        AssertFail(cartPageAction.verifyCartTotalPrice(), "Verify if total price is calculated");
        cartPageAction.deleteFirstProduct();
        AssertFail(cartPageAction.cartItemsCount() == 1, "Verify if item removed to Cart Page");
        AssertFail(cartPageAction.verifyCartTotalPrice(), "Verify if total price is calculated after product removed");
        cartPageAction.deleteFirstProduct();
        AssertFail(cartPageAction.cartItemsCount() == 0, "Verify if item removed to Cart Page");
        AssertFail(!cartPageAction.verifyCartTotalPrice(), "Verify if total price is calculated after product removed");

    }

}
