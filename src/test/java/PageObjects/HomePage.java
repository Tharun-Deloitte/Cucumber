package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    public WebDriver driver;


    By price=By.cssSelector("div.inventory_details_price");
//    By addtocart=By.cssSelector("button.btn_primary");
    By addtocart=By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\"][1]");
    By removefromcart=By.xpath("//button[@class=\"btn btn_secondary btn_small btn_inventory\"][1]");
    By back=By.cssSelector("button.btn");
    By cartcount=By.cssSelector("span.shopping_cart_badge");
    int BeforeCartcount;
    int AfterCartcount;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }


    public void clickonproductname(String name){
        driver.findElement(By.linkText(name)).click();
        String poductPrice=driver.findElement(price).getText();
        System.out.println(poductPrice);
    }

    public void clickaddtocart(){
        driver.findElement(addtocart).click();
    }

    public void GoTOHomeFromProductPage(){
        driver.findElement(back).click();
    }

    public void GetCartCountBefore(){
        BeforeCartcount= Integer.parseInt(driver.findElement(cartcount).getText().trim());
    }


    public void compareCartcount(){
        AfterCartcount= Integer.parseInt(driver.findElement(cartcount).getText().trim());
        assert BeforeCartcount==AfterCartcount-1;
    }

    public void Deleteitem(){
        driver.findElement(removefromcart).click();
    }

    public void CartCountDecreases() throws InterruptedException {
        Thread.sleep(3000);
        AfterCartcount= Integer.parseInt(driver.findElement(cartcount).getText().trim());
        System.out.println(AfterCartcount);
        System.out.println(BeforeCartcount);
        assert BeforeCartcount==AfterCartcount+1;
    }


}
