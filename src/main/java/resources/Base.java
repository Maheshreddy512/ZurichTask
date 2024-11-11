package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	 public static XSSFWorkbook workbook;
	 public static XSSFSheet worksheet;
	 public static DataFormatter formatter= new DataFormatter();
	 static String ROOT = System.getProperty("user.dir");
	 static String xlFilePath = ROOT +"\\TestData.xlsx"; 
	 static String SheetName = "Datasheet";
	 public  String Res;  
	 public int DataSet=-1;
	 
	
	public WebDriver initializeDriver() throws IOException
	{	
	prop= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\kmatr\\OneDrive\\Desktop\\Mahesh Malaysia\\data.properties");

	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{

		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		//1-Allow, 2-Block, 0-default
		options.setExperimentalOption("prefs",prefs);
	    driver = new ChromeDriver(options);
	}
	else if (browserName.equals("firefox"))
	{
		 driver= new FirefoxDriver();	//firefox code
	}
	else if (browserName.equals("IE"))
	{
	    driver = new InternetExplorerDriver();
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
	    TakesScreenshot ts =(TakesScreenshot) driver;
	    
	   File source= ts.getScreenshotAs(OutputType.FILE);
	   String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	   FileUtils.copyFile(source, new File(destinationFile));
	   return destinationFile;
	}
	
	


}

