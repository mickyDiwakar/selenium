package stepDefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CaseCreationpage;
import pageObjects.contactlookup;
import pageObjects.crmnewTaskPage;
import pageObjects.landingpageCrm;
import pageObjects.loginToCrm;
import resources.TestBase;

public class crmnewTask extends TestBase{
	
	  crmnewTaskPage crmnewtaskpageobj;
	  loginToCrm logintocrmpageobj;
	  landingpageCrm landingtoCrmHomeObj;
	  CaseCreationpage CaseCreationpageobj;
	  
	  
	@Given("^user logged in to CRM Application$")
	public void user_logged_in_to_CRM_Application() throws Exception {
		logintocrmpageobj=new loginToCrm();
		landingtoCrmHomeObj=logintocrmpageobj.logintoClassicCrmPro();
	}

	@When("^user mouse hover to \\\"([^\\\"]*)\\\" and select \"([^\"]*)\"$")
	public void user_mouse_hover_to_Task_and_select(String arg1,String arg2) throws Exception {
		crmnewtaskpageobj=landingtoCrmHomeObj.clickLInkonTable(arg1, arg2);
	}

	@When("^User enter the \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\","
			+ "\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" details for task creation$")
	public void user_enter_the_and_details_for_task_creation(String arg1, String arg2, String arg3, String arg4, 
			String arg5, String arg6, String arg7, String arg8, String arg9) throws Exception {
		//crmnewtaskpageobj=new crmnewTaskPage();
		CaseCreationpageobj=crmnewtaskpageobj.newTaskCreation(arg1, arg2, arg3, arg4, arg5, arg6, arg7,arg8,arg9);
		
	}
	@Then("^verify task created$")
	public void verify_task_created() throws Exception {
	   CaseCreationpageobj.verfiythecasecraeted();
	}

}
