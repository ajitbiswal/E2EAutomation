package Academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

//Inheriting the base class
public class ValidateTitle extends Base {
	public WebDriver driver;
	LandingPage l;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get("http://qaclickacademy.com/");
		log.info("Navigated to home page");
	}
	
	@Test
	public void validateAppTitle() throws IOException {
		
		 l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("sucessfully validated");
		
	}
	
	@Test
	public void validateHeader() throws IOException {
		//This is not required since it is already initiated in previous test case
		//l = new LandingPage(driver);
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("sucessfully validated");
		
	}
	@AfterTest
	public void teardown() {
		
		driver.close();
	}

	
}
