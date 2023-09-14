package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    GenericUtils utils;

    public WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        this.utils=new GenericUtils(this.driver);
    }
    By Products= By.cssSelector("div.cart_item");
    By Productname=By.cssSelector("div.inventory_item_name");
    By Productprice=By.cssSelector("div.inventory_item_price");

    public ArrayList<ArrayList<String>> verifyCartPageProducts(){
        List<WebElement> products=driver.findElements(Products);
        ArrayList<ArrayList<String >> CartPageProducts=new ArrayList<>();
        if(products.size()>1){
            for(WebElement product:products){
                ArrayList<String> productdesc=new ArrayList<>();
                String Name=product.findElement(Productname).getText().trim();
                String price=product.findElement(Productprice).getText().split("$")[0];
                productdesc.add(Name);
                productdesc.add(price);
                CartPageProducts.add(productdesc);
            }
        }
        return CartPageProducts;

    }
}
