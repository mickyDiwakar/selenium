package stepDefinations;

import java.util.List;
//import java.util.List;
import java.util.Map;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.mavenproj.dealcreationClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.landingpageCrm;
import pageObjects.loginToCrm;
import resources.TestBase;

public class DealsTab extends TestBase {
	

@Given("^User is logged in with chrome browser$")
public void user_is_logged_in_with_chrome_browser() throws Throwable {
	//driver=initializeDriver();
	//driver.get(strArg1);
}
@And("^user enter the url$")
public void user_enter_the_url() throws Throwable {
	driver.get(p.getProperty("crmurl"));
    //throw new PendingException();
}

@When("^User login to crm application with \"([^\"]*)\" and \"([^\"]*)\"$")
	
	  public void user_login_to_crm_application_with_and(String arg1, String arg2) throws Throwable{
		loginToCrm ltc=new loginToCrm();
	  ltc.getEmail().sendKeys(arg1); 
	  ltc.getPassword().sendKeys(arg2);
	  ltc.clickLogin().click(); 
	  Assert.assertTrue(true);
	  
	  }
	 



@Then("^Home page is displayed$")
public void home_page_is_displayed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    landingpageCrm lpc=new landingpageCrm();
    try {
    	WebDriverWait wait=new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(lpc.logcheck()));
        Assert.assertTrue(lpc.logcheck().isDisplayed());
    }
    catch(Exception e) {
    	System.out.println(e.getMessage());
    	close_browser();
    }
    
    
}

@And ("^Username is displayed$")
public void username_is_displayed() throws Throwable {
 landingpageCrm lpc=new landingpageCrm();
 Assert.assertEquals(lpc.usernameonhomepage().getText(), "diwakar kumar");
    
}
@And("^Close browser$")
public void close_browser() throws Throwable {
	driver.close();
	//System.out.println();
    
}

@When("^User login to crm application with username and password$")
public void user_login_to_crm_application_with_username_and_password(DataTable dt) throws Throwable {
	for(Map<Object, Object> data:dt.asMaps(String.class, Object.class)) {
		Object username=data.get("uname");
		Object password= data.get("pwd");
		loginToCrm ltc=new loginToCrm();
		  ltc.getEmail().sendKeys(username.toString());
		  ltc.getPassword().sendKeys(password.toString());
		  Thread.sleep(3000);
		  ltc.getEmail().clear();
		  Thread.sleep(3000);
		  ltc.getPassword().clear();
		  //ltc.clickLogin().click(); 
		  Assert.assertTrue(true);
	}
}
	
	@When("^User login to crm application with username1 and password1$")
	public void user_login_to_crm_application_with_username1_and_password1(DataTable dt) throws Throwable {
		List<List<String>> data=dt.asLists(String.class) ;
			String username=data.get(1).get(0);
			String password= data.get(1).get(1);
			loginToCrm ltc=new loginToCrm();
			  ltc.getEmail().sendKeys(username);
			  ltc.getPassword().sendKeys(password);
			  
			  ltc.clickLogin().click(); 
			  Assert.assertTrue(true);
    
}




	


}
