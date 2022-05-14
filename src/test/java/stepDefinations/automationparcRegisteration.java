package stepDefinations;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.datatable.DataTable;
import pageObjects.automationpracticePage;
import resources.TestBase;
//import resources.TestBase;

public class automationparcRegisteration extends TestBase  {
	//public WebDriver driver;
	String emailpassed="";
	@Given("^Click on Sign In2 Button$")
    public void click_on_sign_in_button() throws Throwable {
		
		new automationpracticePage(driver).SignIn();
    }
   

    @And("^Create an account box$")
    public void create_an_account_box(DataTable dt) throws Throwable {
    	new automationpracticePage(driver).CreateAnAccount(dt);
    }
 

    @When("^Select the below data and Click on Register button$")
    public void select_the_below_data_and_click_on_register_button(DataTable dt) throws Throwable {
    	new automationpracticePage(driver).DetailsToRegister(dt);
    }
    @Then("^Validate that you are successfully registered$")
    public void validate_that_you_are_successfully_registered() throws Throwable {
    	new automationpracticePage(driver);
    }

}
