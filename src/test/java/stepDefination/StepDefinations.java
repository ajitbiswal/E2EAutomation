package stepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class StepDefinations extends Base {
	@Given("^initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	    
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String url) throws Throwable {
		driver.get(url);
	    
	}

	@When("^User click on login link and  enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_click_on_login_link_and_enters_and_and_logs_in(String username, String password) throws Throwable {
		
		LandingPage l = new LandingPage(driver);
		if(l.getPopUpSize().size()>0) {
			l.getPopUp().click();
		}
		LoginPage lp = l.getLogin();
		//l.getLogin().click();
		//LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		lp.getLoginButton().click();
		driver.close();
	}

	@Then("^Verify that user is sucessfully logged in$")
	public void verify_that_user_is_sucessfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
