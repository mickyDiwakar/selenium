package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArchiveCrmpro;
import pageObjects.BlogPage;
import pageObjects.CrmProPage;
import resources.TestBase;
import io.cucumber.datatable.DataTable;

public class Blog extends TestBase{
	
	@When("user click on {string}")
	public void user_click_on(String string) {
	    new BlogPage().sidemenuselection();
	}
	@When("click WindowXP tiles and click Announcement in categories")
	public void click_WindowXP_tiles_and_click_Announcement_in_categories(DataTable dataTable) {
	   new CrmProPage().clickonWindowXpTiles();
	   new CrmProPage().clickonCategories(dataTable);
	}
	
	@When("click on Archive {string}")
	public void click_on_Archive(String archivelink) {
		new ArchiveCrmpro().clickOnArchiveLink(archivelink);
	}
	@When("click on {string}")
	public void click_on(String Crmprolink) {
	    new ArchiveCrmpro().ClickOnCrmpronewLink(Crmprolink);
	    
	}
	@Then("Verify the result as {string}")
	public void verify_the_result_as(String s) {
		new ArchiveCrmpro().verfiytheresult( s);
	}

}
