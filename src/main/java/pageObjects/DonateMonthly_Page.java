package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DonateMonthly_Page extends ObjectPage{
	
	public WebDriver driver;

	
	@FindBy(xpath="//button[contains(@class,'mission-form_donateBtn')]")
	WebElement Donateclick;
	
	
	@FindBy(id="btnGuestCheckout")
	WebElement Continueclick;


	@FindBy(xpath="//h3[text()='Payment Options']")
	WebElement PaymentsOptions;


	
	public DonateMonthly_Page(WebDriver driver)
	{
		super(driver);
		
	}
	
	public WebElement Donateclick()
	{
		return Donateclick;
	}
	

	
	public WebElement Continueclick()
	{
		return Continueclick;
	}
	
	

	public WebElement PaymentsOptions()
	{
		return PaymentsOptions;
	}
	
	
}
