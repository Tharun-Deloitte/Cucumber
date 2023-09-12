package utils;

import org.openqa.selenium.WebDriver;
import PageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;


	
	public TestContextSetup() throws IOException
	{
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		
		
		

	}
	
}
