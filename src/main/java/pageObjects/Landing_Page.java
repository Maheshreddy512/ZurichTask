package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page extends ObjectPage{
	
	public WebDriver driver;

	
	@FindBy(xpath="//a[@id='navbarBrand']")
	 WebElement Title;
	
	@FindBy(xpath="//a[@id='loginLink']")
	 WebElement Login;

	
	public Landing_Page(WebDriver driver)
	{
		super(driver);
		
	}
	
	public WebElement Title()
	{
 return Title;
}
	
	public WebElement Login()
	{
		return Login;
	}
	
}
