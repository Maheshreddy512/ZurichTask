
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ObjectPage {

	WebDriver driver;
	public ObjectPage(WebDriver webdriver)
	{
		this.driver=webdriver;
		PageFactory.initElements(webdriver,this);
		
	}
}
