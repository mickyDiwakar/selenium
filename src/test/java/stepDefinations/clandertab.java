package stepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pageObjects.calender;
import resources.TestBase;

public class clandertab extends TestBase {
	
	@Then("^user hover to \"([^\"]*)\" and click on view today$")
	    public void user_hover_to_calnder_and_click_on_view_today(String tab) throws Throwable {
		 driver.switchTo().frame("mainpanel");
	       WebDriverWait wait=new WebDriverWait(driver,10000);
	       wait.until(ExpectedConditions.
	    		   visibilityOf(driver.findElement(By.xpath("//*[@class='mlddm']/child::li/a[text()='Calendar']"))));
	        new calender(driver).tabselection(tab);
	        new calender(driver).calenderdropdownselection("View Today");
	        
	       
	    }

	    @And("^For specific time click on newEvent$")
	    public void for_specific_time_click_on_newevent(DataTable dt) throws Throwable {
	    	//DataTable dt=null;
	    	List<Map<String, String>>map=dt.asMaps(String.class, String.class);
	    	String time=map.get(0).get("time");
	    	String contnum=map.get(0).get("contnum");
	    	System.out.println(time);
	    	new calender(driver).eventSelection(time, contnum);
	    	
	        
	    }

	   
}
