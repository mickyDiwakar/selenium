package stepDefinations;



import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import pageObjects.flightHomePage;
import pageObjects.flightLoginPage;
import resources.TestBase;




public class Assignment extends TestBase {
	//public WebDriver driver;
	/*
	 * @Before public void setUp() throws IOException { driver = new
	 * TestBase().initializeDriver(); }
	 * 
	 * @After public void tearDown() { driver.quit(); }
	 */

	@Given("^User is navigated successfully to the website$")
	public void user_is_navigated_successfully_to_the_website() throws Throwable {
		 //driver = new TestBase().initializeDriver();
		
	    
	}

	@When("^Verify its Title$")
	public void verify_its_Title() throws Throwable {
		//new flightHomePage(driver).getTitle();
		new flightHomePage(driver).getTitle();
		
	    
	}

	@And("^Click on Flights Icon$")
	public void click_on_Flights_Icon() throws Throwable {
		new flightHomePage(driver).ClickonFlighttab() ;
	   
	}

	@And("^Enter Origin as \"([^\"]*)\"$")
	public void enter_Origin_as_Bengaluru_BLR(String origin) throws Throwable {
		new flightHomePage(driver).fromDropdown(origin);
	    
	}

	@And("^Enter Destination as \"([^\"]*)\"$")
    public void enter_destination_as_something(String dest) throws Throwable {
        new flightHomePage(driver).toDropdown(dest);
    }

	@And("^Select depart date as \"([^\"]*)\"$")
    public void select_depart_date_as_something(String date) throws Throwable {
		new flightHomePage(driver).deptdate(date);
    }


    @And("^Select Return date as \"([^\"]*)\"$")
    public void select_return_date_as_something(String rbtn) throws Throwable {
        new flightHomePage(driver).returnradiobuttonseelction(rbtn);;
       
    }


	@And("^Click on Search Button$")
	public void click_on_Search_Button() throws Throwable {
		 new flightHomePage(driver).SearchbuttonClick();
	    
	}

	@Then("^Verify that you are navigated successfully to search flight page$")
	public void verify_that_you_are_navigated_successfully_to_search_flight_page() throws Throwable {
	    new flightHomePage(driver).verificationofpage();
	    
	}
	

    @Then("^Verify that error message$")
    public void verify_that_error_message() throws Throwable {
    	new flightLoginPage(driver).errorMessageforLoginFail();
    }

    @And("^Click on login button$")
    public void click_on_login_button() throws Throwable {
       new flightLoginPage(driver).clickOnLogin();
    }

    @And("^Enter username as \"([^\"]*)\"$")
    public void enter_username_as_something(String emailid) throws Throwable {
       new flightLoginPage(driver).enterEmailId(emailid);
    }

    @And("^Enter password as \"([^\"]*)\"$")
    public void enter_password_as_something(String password) throws Throwable {
    	new flightLoginPage(driver).enterPassword(password);
    }

    @And("^Click on Sign In Button$")
    public void click_on_sign_in_button() throws Throwable {
    	new flightLoginPage(driver).clickLoginButton();
    }

}
