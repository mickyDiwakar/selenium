package stepDefinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import pageObjects.Homepage1;
import resources.TestBase;

public class homepage extends TestBase {
	Logger log=Logger.getLogger(homepage.class);
	
	//public WebDriver driver;
	 @Then("^Click on column refered by column$")
	    public void click_on_column_refered_by_column(DataTable dt) throws Throwable {
		 Homepage1 homepage= new Homepage1(driver);
		 homepage.linkclickonTable(dt);
	    }

}
