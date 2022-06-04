package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By header= By.cssSelector("div[class*='video-banner'] h3");
	private By popup= By.xpath("//button[text()='NO THANKS']");
	
	
	
	
	
	
	//Constructor created to receive the driver as argumant
	public LandingPage(WebDriver driver) {
		//this.driver is the variable created inside the class
		this.driver=driver;
	}

	//we are sure Login page is the next after landing page
	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
		
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navbar);
		
	}

	public List<WebElement> getPopUpSize() {
		return driver.findElements(popup);
		
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popup);
		
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
		
	}
}
