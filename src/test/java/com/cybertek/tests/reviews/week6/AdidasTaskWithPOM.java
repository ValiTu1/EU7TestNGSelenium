package com.cybertek.tests.reviews.week6;

import com.cybertek.pages.adidasPage.CartPage;
import com.cybertek.pages.adidasPage.ProductPage;
import com.cybertek.tests.TestBaseTwo;
import org.testng.annotations.Test;

public class AdidasTaskWithPOM extends TestBaseTwo {



    ProductPage productPage = new ProductPage();

    CartPage cartPage = new CartPage();

    int expectedPurchaseAmount = 0;
    @Test
    public void PurchaseTest(){

        productPage.navigateTo("Laptops");
        productPage.navigateTo("Sony vaio i5");
        System.out.println("productPage.priceElement.getText() = " + productPage.priceElement.getText());

        expectedPurchaseAmount = productPage.productAdder("Laptop" , "Sony vayo i5");

        expectedPurchaseAmount = productPage.productAdder("Laptop" , "Dell i7 8gb");
        System.out.println("expectedPurchaseAmount: " + expectedPurchaseAmount);

        expectedPurchaseAmount = productPage.productRemover("Sony vayo i5");

        System.out.println("expectedPurchaseAmount: " + expectedPurchaseAmount);

        productPage.navigateTo("Cart");

        cartPage.placeOrderButton.click();

        //need to fill up the form, I want to create a method that fills up the form

        cartPage.fillForm();

    }
}
