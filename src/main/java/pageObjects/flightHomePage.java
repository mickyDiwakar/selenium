package pageObjects;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.TestBase;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import resources.TestBase;

public class flightHomePage extends TestBase {
	
	public WebDriver driver;
	@FindBy(id = "home-origin-autocomplete-heatmap")
	WebElement from;
	@FindBy(id = "home-destination-autocomplete-heatmap")
	WebElement To;
	@FindBy(xpath = "//input[@class='input-daterange input-left from']")
	WebElement depart;
	@FindBy(xpath = "//div[@class='col s8 m4 triptype-radiobuttons']/child::div/label")
	List<WebElement> radiobutton;
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement btnSearch;
	@FindBy(id="product-tile-flight")
	WebElement tabFlight;
	@FindBy(xpath="//button[contains(text(),'Confirm')]")
	WebElement btnConfirm;
	@FindBy(xpath="//button[contains( text(), 'Continue' )]")
	WebElement btnContinue;

	public flightHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// launch the url in chrome browser
	public void getflightUrl() throws IOException {

		driver.get(p.getProperty("flightUrl"));
		//WaitVisibilityOf(btnSearch, 2000);

	}
// verfiy the title of page
	public String getTitle() {
		String titleOfHomePage = driver.getTitle();
		System.out.println("titleOfHomePage");
		try {
			Assert.assertTrue("title is same",
					titleOfHomePage.equalsIgnoreCase("Book Flights, Hotels, Deals & Activities Online | AirAsia"));
		} catch (Exception e) {
			{
				Assert.assertTrue(e.getMessage(), false);
			}
		}
		return titleOfHomePage;
	}
	//click on flight tab
	public void ClickonFlighttab() {
		clickOnElement(tabFlight);
		
	}
	//select from origin airport
	public void fromDropdown(String origin) throws InterruptedException {
		from.clear();
		from.sendKeys(origin.substring(0, 3));
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}
	public void toDropdown(String dest) throws InterruptedException {
		To.clear();
		To.sendKeys(dest.substring(0, 3));
		Thread.sleep(1000);
		To.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	}
	public void deptdate(String date) throws InterruptedException {
		Thread.sleep(2000);
		depart.click();
		depart.clear();
		depart.sendKeys(date);
	}
	public void returnradiobuttonseelction(String radiobtn){
		int btncount=radiobutton.size();
		for(int i=0;i<btncount;i++) {
			if(radiobutton.get(i).getText().equalsIgnoreCase("One way")) {
				radiobutton.get(i).click();
				break;
			}
		}
		btnConfirm.click();
	}
	public void SearchbuttonClick() {
		btnSearch.click();
		
		
	}
	public void verificationofpage() {
		try {
		//WaitVisibilityOf(btnContinue, 5000);
		Assert.assertTrue(btnContinue.isDisplayed());	
			
		}catch(Exception e){
			Assert.assertTrue(e.getMessage(),false);
			
		}
	}
	
}
