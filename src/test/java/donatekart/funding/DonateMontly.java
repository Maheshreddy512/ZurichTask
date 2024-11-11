package donatekart.funding;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.DonateMonthly_Page;
import pageObjects.Landing_Page;
import pageObjects.Login_Page;
import resources.Base;

public class DonateMontly extends Base{
	
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	@Test(dataProvider="InputData")
	public void donatemonthlycart(String UserName,String Password,String InvalidUserName, String InvalidPassword,String ProfileName) throws IOException, InterruptedException
	{
	    driver =initializeDriver();		
		driver.get(prop.getProperty("url"));
		
		Landing_Page LP = new Landing_Page(driver);
		
		LP.Login().click();
		
		Login_Page LP1 = new Login_Page(driver);
		
		LP1.Email().sendKeys(UserName);
		
		LP1.Password().sendKeys(Password);
		
		LP1.LoginButton().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(LP1.DonateMonthly()));
		
		LP1.ProfileName().getText().equals(ProfileName);
		
		Assert.assertTrue(LP1.DonateMonthly().isDisplayed(), "the element is not displayed on checkout page");
				
		LP1.DonateMonthly().click();
		
		DonateMonthly_Page DMP = new DonateMonthly_Page(driver);
		
		DMP.Donateclick().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(DMP.Continueclick()));
		
		DMP.Continueclick().click();
		
		Assert.assertTrue(DMP.PaymentsOptions().isDisplayed(), "the element is not displayed on checkout page");
		
	
	}
	

	@AfterMethod
	public void browserclose()
	
	{
		driver.close();
	}
	

}
