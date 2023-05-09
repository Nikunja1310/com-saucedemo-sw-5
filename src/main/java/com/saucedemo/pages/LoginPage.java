package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created By Nikunja A Senjalia
 */
public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement productsText;



    public void enterUserName(String username) {
        sendTextToElement(usernameField, username);
        Reporter.log("Enter User Name : " + username + " to user name field " + usernameField.toString());
        CustomListeners.test.log(Status.PASS,"Enter UserName " + username);

    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Enter password : " + password + " to password field " + passwordField.toString());

        CustomListeners.test.log(Status.PASS,"Enter Password " +password);

    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("Clicking on Login button " + loginButton.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on Login Button " );
    }


    public String getProductText() {
        Reporter.log("Getting text of product " + productsText);
        CustomListeners.test.log(Status.PASS," Getting Text from Product");
        return getTextFromElement(productsText);


    }
//
//    public String getErrorMessage(){
//        return getTextFromElement(errorMessage);
//    }
}
