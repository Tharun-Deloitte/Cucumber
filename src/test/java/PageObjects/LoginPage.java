package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    By Username=By.cssSelector("input#user-name");
    By Password=By.id("password");
    By errormsg=By.cssSelector("button.error-button");
    By login=By.id("login-button");
    By producttext=By.cssSelector("span.title");

    public String getTitleLoginPage()
    {
        return driver.getTitle();
    }

    public void enterlogindetails(String username,String password){
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(login).click();
    }

    public void Verifyerrormsg(){
        driver.findElement(errormsg).getText().contains("Epic sadface: Username and password do not match any user in this service");
    }

    public void verifylogin(){
        driver.findElement(producttext).getText().contains("Products");
    }
}
