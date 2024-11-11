
package donatekart.funding;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Landing_Page;
import pageObjects.Login_Page;
import resources.Base;



public class Homepage extends Base {
	
	 public WebDriver driver;
	 public static Logger log =LogManager.getLogger(Homepage.class.getName());
	 
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver =initializeDriver();		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	@Test(dataProvider="InputData")
	public void homepagenavigation(String UserName,String Password,String InvalidUserName, String InvalidPassword,String ProfileName) throws IOException, InterruptedException
	{
		driver =initializeDriver();		
		driver.get(prop.getProperty("url"));
		
		Landing_Page LP = new Landing_Page(driver);
		
		LP.Login().click();
		
		Login_Page LP1 = new Login_Page(driver);
		
		LP1.Email().sendKeys(InvalidUserName);
		
		LP1.Password().sendKeys(InvalidUserName);
		
		LP1.LoginButton().click();
		
		Assert.assertTrue(LP1.InvalidCredentials().isDisplayed(),"Login page is not displayed");
		
		driver.navigate().refresh();
		
		LP1.Email().sendKeys(UserName);
		
		LP1.Password().sendKeys(Password);
		
		LP1.LoginButton().click();
		
		LP1.ProfileName().getText().equals(ProfileName);
		
		Assert.assertTrue(LP1.DonateMonthly().isDisplayed(), "the element is not displayed on checkout page");
		

	}
	

	@AfterMethod
	public void browserclose()
	
	{
		driver.close();
	}
	

}

	
	
	