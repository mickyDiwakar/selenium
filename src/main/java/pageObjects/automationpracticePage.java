package pageObjects;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
//import cucumber.api.DataTable;
//import io.cucumber.datatable.DataTable;
//import cucumber.api.DataTable;
import resources.TestBase;
import utilities.excelUtilities;
import utilities.logger;



public class automationpracticePage extends TestBase{
final static Logger log=logger.getLogger(automationpracticePage.class);

	public WebDriver driver;
	public String alias="Home";
	@FindBy(xpath="//a[@class='login']")
	private WebElement linksignin;
	@FindBy(id="email_create")
	private WebElement txtEmailAddress;
	@FindBy(id="SubmitCreate")
	private WebElement btnCreateAccount;
	@FindBy(xpath="//div[@class='radio-inline']//input[@type='radio']")
	private List<WebElement> rbtnTitle;
	@FindBy(id="customer_firstname")
	private WebElement txtFirstName;
	@FindBy(id="customer_lastname")
	private WebElement txtLastName;
	@FindBy(name="email")
	private WebElement txtEmail;
	@FindBy(id="passwd")
	private WebElement txtPassword;
	@FindBy(id="days")
	private WebElement selDays;
	@FindBy(id="months")
	private WebElement selMonth;
	@FindBy(id="years")
	private WebElement selYear;
	@FindBy(id="firstname")
	private WebElement txtAddressFirstName;
	@FindBy(name="lastname")
	private WebElement txtAddressLastName;
	@FindBy(name="address1")
	private WebElement txtAddress1;
	@FindBy(id="address2")
	private WebElement txtAddress2;
	@FindBy(name="city")
	private WebElement txtAddressCity;
	@FindBy(id="id_state")
	private WebElement selAddressState;
	@FindBy(id="postcode")
	private WebElement txtAddresspostalCode;
	@FindBy(id="id_country")
	private WebElement selAddressCountry;
	@FindBy(id="phone_mobile")
	private WebElement txtAddressmobilenumber;
	@FindBy(id="alias")
	private WebElement txtAddressAlias;
	@FindBy(id="submitAccount")
	private WebElement btnRegister;
	@FindBy(xpath="//a[@class='account']/span")
	private WebElement profile;
	@FindAll(@FindBy(xpath="//div[@class='checker']"))
	private List<WebElement> checkbox;
	String emailpassed="";
	String firstname="";
	String lastname="";
	
	
	public automationpracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	 
	public void naviagteToPracticeURL() {
		log.info("*******************aautomationpractice url stared***************************");
		driver.get(p.getProperty("automationpracticeURL"));
	}
	public void SignIn() {
		try {
		linksignin.click();;
		//WaitVisibilityOf(btnCreateAccount, 10);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(btnCreateAccount));
		}
		catch(Exception e){
			Assert.assertFalse("account already exist", true);
			
		}
	}
	public void CreateAnAccount(DataTable dt) {
		//WaitVisibilityOf(btnCreateAccount, waitTime);
		try {
			List<Map<String, String>>map=dt.asMaps(String.class, String.class);
			
			 emailpassed=map.get(0).get("email");
			txtEmailAddress.sendKeys(emailpassed);
			btnCreateAccount.click();
			//WaitVisibilityOf(txtAddressLastName, 8);
			//WebDriverWait wait=new WebDriverWait(driver,20);
			//wait.until(ExpectedConditions.elementToBeClickable(txtAddressLastName));
			//wait.until(ExpectedConditions.visibilityOf(txtAddressLastName));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertTrue("user is not naviagted to registeration page", false);
		}
		
		
		
	}
	public void DetailsToRegister(DataTable dt) {
		List<Map<String, String>> map=dt.asMaps(String.class, String.class);
		String title=map.get(0).get("title");
		 firstname=map.get(0).get("firstname");
		lastname=map.get(0).get("lastname");
		String password =map.get(0).get("password");
		//String emailPassed =map.get(0).get("emailPassed");
		String date =map.get(0).get("date");
		String month =map.get(0).get("month");
		String year =map.get(0).get("year");
		String Address1 =map.get(0).get("Address1");
		String Address2 =map.get(0).get("Address2");
		String City =map.get(0).get("City");
		String country =map.get(0).get("country");
		String state =map.get(0).get("state");
		String postalcode =map.get(0).get("postalcode");
		String MbPhone  =map.get(0).get("MbPhone");	
			if(title.equals("Mr")) {
				rbtnTitle.get(0).click();
				
			}else {
				rbtnTitle.get(1).click();
			}
			txtFirstName.sendKeys(firstname);
			txtLastName.sendKeys(lastname);
			String emailactual=txtEmail.getText();
			if (emailactual.equals(emailpassed)) {
				
				Assert.assertTrue("email is correct", true);
			}else {
				Assert.assertTrue("email is incorrect", false);
			}
			txtPassword.sendKeys(password);
			Select selday=new Select(selDays);
			selday.selectByValue(date);
			Select selmon=new Select(selMonth);
			selmon.selectByValue(month);
			 
			Select selyr=new Select(selYear);
			selyr.selectByValue(year);
			//List<WebElement> l=checkbox;
			int countcheckbox=checkbox.size();
			WebElement a=checkbox.get(0);
			a.click();
			//WebElement b=checkbox.get(1);
			//b.click();
			WebElement ele = null;
			for(int i=0;i<checkbox.size();i++) {
				ele=checkbox.get(i);
				if(ele.isDisplayed()&& ele.isEnabled()) {
					if(ele.isSelected()) {
						ele.click();
					}
					else {
						ele.click();
					}
				}
			}
		
		 
		 	txtAddress1.sendKeys(Address1);
			txtAddress2.sendKeys(Address2);
			txtAddressCity.sendKeys(City);
			
			Select selState =new Select(selAddressState);
			selState.selectByVisibleText(state);
			
			txtAddresspostalCode.sendKeys(postalcode);
			Select selCountry=new Select(selAddressCountry);
			WebElement Selcountry=selCountry.getFirstSelectedOption();
			if(!Selcountry.getText().equals(country.trim())) {
				selCountry.selectByVisibleText(country);
			}
			txtAddressmobilenumber.sendKeys(MbPhone);
			txtAddressAlias.sendKeys(alias);
			btnRegister.click();
			
	}	
	public void checkRegisterationsucess() {
		Assert.assertTrue("account created", profile.getText().equals(firstname+" "+lastname));
		
	}

}

