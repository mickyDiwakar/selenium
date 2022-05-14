package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

 


public class hotelBookingAirAsia {
	WebDriver driver;
	@FindBy(xpath="//div[@class='product-tiles']/ul/li/button/div/following-sibling::div") private List<WebElement> TabSelection;
	@FindBy(id="FH-origin") private WebElement txtboxleavingFrom;
	@FindBy(name="DestName") private WebElement txtboxgoingTo;
	@FindBy(id="FH-fromDate") private WebElement departDate;
	@FindBy(id="FH-toDate") private WebElement returnDate;
	@FindBy(name="NumRoom") private WebElement noOfRoom;
	@FindBy(xpath="//select[@id='FH-NumAdult1']") private WebElement noOfAdult;
	@FindBy(name="NumChild1") private WebElement noOfChild;
	@FindBy(id="partialHotelBooking") private WebElement chboxIonlyneedahotel;
	@FindBy(xpath="//input[@id='Direct']") private WebElement chboxdirectFlight;
	@FindBy(xpath="//span[text()='Preferred class']/following:: select") private WebElement preffredClass;
	@FindBy(xpath="//*[@id='wizardFHform']/button") private WebElement btnSearch;
	@FindBy(xpath="//input[contains(@id,'CONFIRMATIONNUMBER1')]") private WebElement Bookingnumber;
	@FindBy(xpath="//input[contains(@id,'PAXLASTNAME1')]") private WebElement Surname;	
	@FindBy(xpath="//select[contains(@id,'ORIGINCITY1')]") private WebElement Departure;	
	@FindBy(xpath="//input[@type='submit']") private WebElement searchbtn;
	@FindBy(xpath="//div[@id='errorSectionContent']/p") private WebElement errormessage;
	
	public hotelBookingAirAsia(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//tab selection
	public void tabSeelction(String tabName){
		int tabcount=TabSelection.size();
		for(int i=0;i<tabcount;i++) {
			if(TabSelection.get(i).getText().toString().equalsIgnoreCase(tabName)) {
				TabSelection.get(i).click();
				Set<String> handle= driver.getWindowHandles();
				Iterator<String> it=handle.iterator();
			
				String childwindow = "";
				for(i=0;i<handle.size();i++) {
					childwindow=it.next();
				}
				
				driver.switchTo().window(childwindow);
				//driver.switchTo().f
				//WebDriverWait wait=new WebDriverWait(driver,8000);
				//wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
				break;
			}
		}
	}
	public void sourceAndDestionationSelection(DataTable dt) throws InterruptedException {
	List<List<String>>l=dt.asLists(String.class);
	String leavingFrom=l.get(1).get(0);
	String 	goingTo=l.get(1).get(1);
		txtboxleavingFrom.sendKeys(leavingFrom);
		Thread.sleep(3000);
		
		txtboxleavingFrom.sendKeys(Keys.ARROW_DOWN);
		txtboxleavingFrom.sendKeys(Keys.ENTER);
		txtboxgoingTo.sendKeys(goingTo);
		Thread.sleep(4000);
		txtboxgoingTo.sendKeys(Keys.ARROW_DOWN);
		txtboxgoingTo.sendKeys(Keys.ENTER);
		
	}
	public void departdateSelection(DataTable dt) throws InterruptedException {
		List<Map<String, String>> map=dt.asMaps(String.class, String.class);
			
		departDate.sendKeys(map.get(0).get("DepartingDate"));
		returnDate.sendKeys(map.get(0).get("ReturningDate"));
		Thread.sleep(2000);
	}
	public void roomSelection(String room) throws InterruptedException {
		noOfRoom.click();
		Select roomsel=new Select (noOfRoom);
		roomsel.selectByVisibleText(room);
		Thread.sleep(2000);
	}
	public void PessengerSelection(String child ,String adult) throws InterruptedException {
//		Select childsel=new Select(noOfChild);
//		childsel.selectByValue(child);
//		Thread.sleep(2000);
//		Select adultsel=new Select(noOfAdult);
//		adultsel.selectByValue(adult);
//		Thread.sleep(2000);
	}
	public void selectDirectflightOrHotelOnly() {
		chboxdirectFlight.click();
		//chboxIonlyneedahotel.click();
	}
	public void preffredClass(String prefClass) {
		Select selpref=new Select(preffredClass);
		selpref.selectByVisibleText(prefClass);
		//getFirstSelectedOption will give first selected in the dropsdown
		String s= selpref.getFirstSelectedOption().getText();
		
		Assert.assertEquals("Business",s);
	}
	public void ClickSearchButton() throws InterruptedException {
		Thread.sleep(2000);
		btnSearch.click();;
		// Assert.assertTrue(condition);
	}
	public void enterbookingandSuranme(DataTable dt) {
		List<Map<String,String>>map=dt.asMaps(String.class, String.class);
		
		String Bookingid=map.get(0).get("BookingNumber");
		String surname=map.get(0).get("FamilySurname");
		Bookingnumber.sendKeys(Bookingid);
		Surname.sendKeys(surname);
		
	}
	public void SelectDeparture(DataTable vdt) {
		List<List<String>> ls=vdt.asLists(String.class);
		String Depart=ls.get(0).get(0);
		Select s=new Select(Departure);
		s.selectByValue(Depart);
	}
	public void clickOnSearchBUtton() {
		searchbtn.click();
	}
	public void errormesagecheck() {
		String str= errormessage.getText();
		String expectedStr="We're unable to locate your flight booking. You can only search for bookings made with AirAsia or other online travel websites.";
		//Assert.assertEqual(message, condition);
		Assert.assertEquals("check error message", expectedStr, str);
		
		String actualcolor=Color.fromString(errormessage.getCssValue("color")).asHex();
		String expectedcolor="#d00";
		if(actualcolor.equalsIgnoreCase(expectedcolor)) {
			Assert.assertTrue(true);
		}
		
	}
	
}
