package stepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.Contacts;
import resources.TestBase;

public class ContactsTab extends TestBase{
	
	  @Then("^mouse hover \"([^\"]*)\" and click Full Search Form$")
	    public void mouse_hover_something_and_click_full_search_form(String Tabname) throws Throwable {
		  	//Actions action=new Actions(driver);
		 new Contacts(driver).conatctTabSelection(Tabname);
	       
	    }

	    @And("^Enter Title,firstname,savesearch,supervisor,searchconatct$")
	    public void enter_titlefirstnamesavesearchsupervisorsearchconatct(DataTable dt) throws Throwable {
	     List<Map<String, String>> map=dt.asMaps(String.class, String.class);
	    String title= map.get(0).get("Title");
	   String firstName=  map.get(0).get("Firstname");
	   String Supervisor= map.get(0).get("supervisor");
	   new Contacts(driver).searchContact(title, firstName, Supervisor);
	    }

	}


