package pageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.TestBase;
import utilities.logger;

public class newtourSignupPage extends TestBase {
	//newtoursdemoautURl
	final static Logger log=logger.getLogger(automationpracticePage.class);
	static int x=5;
	public WebDriver driver;
	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement linkRegister;
	@FindBy(name="firstName")
	WebElement txtFirstName;
	@FindBy(name="lastName")
	WebElement txtlastName;
	@FindBy(name="phone")
	WebElement txtphone;
	@FindBy(id="userName")
	WebElement txtemail;
	@FindBy(name="address1")
	WebElement txtaddress1;
	@FindBy(name="address2")
	WebElement txtaddress2;
	@FindBy(name="city")
	WebElement txtcity;
	@FindBy(name="state")
	WebElement txtstate;
	@FindBy(name="postalCode")
	WebElement txtpostalCode;
	@FindBy(name="country")
	WebElement selcountry;
	@FindBy(name="email")
	WebElement txtUserName;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="confirmPassword")
	WebElement txtconfirmPassword;
	@FindBy(name="register")
	WebElement btnSubmit;
	

	 public newtourSignupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	 public void naviagtTomercuryTourURL() {
		 log.info("*****************************newtourstared**************************");
		driver.get(p.getProperty("newtoursdemoautURl"));
		WebDriverWait wait=new WebDriverWait(driver,8000);
		wait.until(ExpectedConditions.visibilityOf(linkRegister));
		// WaitVisibilityOf(linkRegister, 8000);
	 }
	 public void linkclick() {
		 linkRegister.click();
		 WebDriverWait wait=new WebDriverWait(driver,8000);
			wait.until(ExpectedConditions.visibilityOf(linkRegister));
			log.info("**************************linkregisterclicked*******************************");
		//WaitVisibilityOf(txtFirstName, 8000);
	 }
	 public void contactInfo(String FN,String LN,String PH,String Email) {
		 txtFirstName.sendKeys(FN);
		 txtlastName.sendKeys(LN);
		 txtphone.sendKeys(PH);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].value='"+Email+"';", txtemail);
		 log.info("*****************************************username lstname phon email enterd******************************");
	 }
	 public void mailingInfo(String ads1, String ads2,String city,String state,String post,String country) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 //syntax js.executeScript("arguments[0].value='value1';", args)
		 //js.exceuteScript("window.scrollBy(0,600)");
		 js.executeScript("arguments[0].value='"+ads1+"';", txtaddress1);
		 js.executeScript("arguments[0].value='"+ads2+"'", txtaddress2);
		 txtcity.sendKeys(city);
		 txtstate.sendKeys(state);
		 txtpostalCode.sendKeys(post);
		 Select s=new Select(selcountry);
		 s.selectByVisibleText(country.toUpperCase());
	 }
	 public int userInfo(String UserName,String Password,String ConfirmPassword) {
		 int val=1;
		 txtUserName.sendKeys(UserName);
		 txtPassword.sendKeys(Password);
		 txtconfirmPassword.sendKeys(ConfirmPassword);
		 System.out.println("x is "+x);
		 return val;
		 
	 }
	 public userCreation clickSubmitButton() {
		 btnSubmit.click();
		 log.info("***************************butn submit clicked******************");
		return new userCreation(driver) ;
	 }
 
}
