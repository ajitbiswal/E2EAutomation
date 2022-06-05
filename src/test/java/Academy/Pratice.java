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
public class Pratice extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	
	
	@Test
	public void ValidateLogIn(String username,String password) throws IOException {
		System.out.println("this is first test");
	}
	
	
	@Test
	public void ValidateLogIn2(String username,String password) throws IOException {
		System.out.println("this is second test");
	}
	
	@Test
	public void ValidateLogIn3(String username,String password) throws IOException {
		System.out.println("this is third test");
	}
	
	
	
	

}
