package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends ObjectPage {
	
	public WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='username']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//button[normalize-space()='MaheshReddy']")
	WebElement ProfileName;
	
	@FindBy(xpath="//button[normalize-space()='Donate Monthly']")
	WebElement DonateMonthly;

	@FindBy(xpath="//div[text()='Incorrect credentials!!']")
	WebElement InvalidCredentials;
	
	
	
	public Login_Page(WebDriver driver) 
	{
		super(driver);
		
	}


	public WebElement Email()
	{
		return Email;
	}
	
	public WebElement Password()
	{
		return Password;
	}

	public WebElement LoginButton()
	{
		return LoginButton;
	}
	
	public WebElement ProfileName()
	{
		return ProfileName;
	}
	
	public WebElement DonateMonthly()
	{
		return DonateMonthly;
	}
	
	
	public WebElement InvalidCredentials()
	{
		return InvalidCredentials;
	}
	

}
