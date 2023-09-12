package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    By username=By.cssSelector("input#user-name");

    public String getTitleLoginPage()
    {
        return driver.getTitle();
    }

    public void enterlogindetails(){}
}
