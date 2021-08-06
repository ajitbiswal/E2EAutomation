package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	// Declare the driver at global level
	public WebDriver driver;
	public Properties prop;
	
	//This method is returning webdriver and providing to all the test cases
	public WebDriver initializeDriver() throws IOException
	{
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop = new Properties();
	prop.load(fis);
	
	//get the browser name from properties file 
	String browserName = prop.getProperty("browser");
	//when we pass the browser name from mvn i.e mvn test -Dbrowser=firefox
	//String browserName = System.getProperty("browser");
	
	String url = prop.getProperty("url");
	
	if(browserName.contains("chrome")) 
	   {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		
		//if you want to run a headless browser then use ChromeOption 
		ChromeOptions options = new ChromeOptions();
	     	if(browserName.contains("headless"))
		       {
			    options.addArguments("headless");
		       }
		driver = new ChromeDriver(options);
		 
	}
	else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	else if(browserName.equals("IE")){
		
		
	}
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.MICROSECONDS);
	return driver;
	}
	
	
	public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(destinationfile));
		return destinationfile;
		
	}
}
