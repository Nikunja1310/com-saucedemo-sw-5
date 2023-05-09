package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * Created by Nikunja A Senjalia
 * */
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        loginPage = new LoginPage();
       productsPage = new ProductsPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        softAssert(loginPage.getProductText(),"Products","User login not success");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(productsPage.countItems(),6,"Products are not displayed correctly");
    }
}