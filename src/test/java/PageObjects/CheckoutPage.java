package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    public WebDriver driver;

    By Continue =By.id("continue");
    By errormsg= By.cssSelector("button.error-button");

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickContinue(){
        driver.findElement(Continue).click();
    }

    public void VerifyErrormsg(){
        driver.findElement(errormsg).getText().trim().contains("Error: First Name is required");
    }

}
