package stepDefinations;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.hotelBookingAirAsia;
import resources.TestBase;

public class hotelbookingairasia extends TestBase{
	 @When("^User landed on search page enter leaving and going$")
	    public void user_landed_on_search_page_enter_leaving_and_going(DataTable dt) throws Throwable {
	       new hotelBookingAirAsia(driver).sourceAndDestionationSelection(dt);
	    }

	    @Then("^Click on Search button$")
	    public void click_on_search_button() throws Throwable {
	       new hotelBookingAirAsia(driver).ClickSearchButton();
	    }

	    @And("^Click on \"([^\"]*)\" tab$")
	    public void click_on_something_tab(String strArg1) throws Throwable {
	        new hotelBookingAirAsia(driver).tabSeelction( strArg1);
	    }

	    @And("^Enter departing and returing date$")
	    public void enter_departing_and_returing_date(DataTable dt) throws Throwable {
	       new hotelBookingAirAsia(driver).departdateSelection( dt);
	    }

	    @And("^select \"([^\"]*)\" rooms$")
	    public void select_something_rooms(String room) throws Throwable {
	    	 new hotelBookingAirAsia(driver).roomSelection(room);
	    }

	    @And("^Select number of adult \"([^\"]*)\" and children \"([^\"]*)\"$")
	    public void select_number_of_adult_something_and_children_something(String child, String adult) throws Throwable {
	        new hotelBookingAirAsia(driver).PessengerSelection(child, adult);
	    }

	    @And("^Select the direct flight and hotel$")
	    public void select_the_direct_flight_and_hotel() throws Throwable {
	    	new hotelBookingAirAsia(driver).selectDirectflightOrHotelOnly();
	    }

	    @And("^Select prefrred class as \"([^\"]*)\"$")
	    public void select_prefrred_class_as_something(String prefClass) throws Throwable {
	        new hotelBookingAirAsia(driver).preffredClass(prefClass);
	    }
	    @And("^Click on SNAP \"([^\"]*)\" tab$")
	    public void Snaptabselection(String tabName) {
	    	new hotelBookingAirAsia(driver).tabSeelction(tabName);
	    }
	    @When("^user landed on search booking and enter invalid bookingnumber,familySurname$")
	    public void EnterinvalidBookingandsurname(DataTable dt) {
	    	new hotelBookingAirAsia(driver).enterbookingandSuranme(dt);
	    	
	    }
	    @And ("^select departure$")
	    public void selectdepart(DataTable vdt) {
	    	new hotelBookingAirAsia(driver).SelectDeparture(vdt);
	    }
	    @And ("^click on search \\\"([^\\\"]*)\\\" button$")
	    public void clickonsedarchbutton(String btnsearch) {
	    	new hotelBookingAirAsia(driver).clickOnSearchBUtton();
	    }
	    @Then("^check the error message$")
	    public void checkerrormessage() {
	    	new hotelBookingAirAsia(driver).errormesagecheck();
	    }
}
