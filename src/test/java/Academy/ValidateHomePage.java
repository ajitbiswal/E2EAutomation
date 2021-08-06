package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

//Inheriting the base class
public class ValidateHomePage extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void ValidateLogIn(String username,String password) throws IOException {
		//driver.get("http://qaclickacademy.com/");
		driver.get(prop.getProperty("url"));
		
		//There are two page objects we have initiated 
		//we are sure that landing page	will navigate next to login page 
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		//l.getLogin().click();
		//LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//log.info(text);
		lp.getLoginButton().click();
	}
	
	
	@AfterTest
	public void teardown() {
		
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object [][] data = new Object[1][2];
		data[0][0]="ajit1.biswal@gmail.com";
		data[0][1]="123";
		
		
	
		return data;
	}
	
	

}
