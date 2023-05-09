package com.saucedemo.pages;

import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created By Nikunja A Senjalia
 */
public class ProductsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_item']")
    List<WebElement> actualProducts;

    public int countItems(){
        return countItem(actualProducts);
    }

}
