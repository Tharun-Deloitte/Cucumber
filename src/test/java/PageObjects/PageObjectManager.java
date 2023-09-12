package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public WebDriver driver;
	public CheckoutPage checkoutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	public LoginPage getLoginPage()
	{
	
	 loginPage= new LoginPage(driver);
	 return loginPage;
	}

	public HomePage getHomePage()
	{
		homePage = new HomePage(driver);
		return homePage;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
