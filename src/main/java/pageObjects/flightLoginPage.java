package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.TestBase;


public class flightLoginPage extends TestBase {
	public WebDriver driver;
	@FindBy(id="loginModal")
	WebElement iconLogin;
	@FindBy(id="sso-login-email-input")
	WebElement txtEmail;
	@FindBy(id="sso-login-password-input")
	WebElement txtPassword;
	@FindBy(xpath="//button[text()=' Log in ']")
	WebElement btnLogin;
	@FindBy(xpath="//*[@class='sso-error-message ng-star-inserted']/div")
	WebElement errorMessage;
	public flightLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnLogin() {
		clickOnElement(iconLogin);
		//WaitVisibilityOf(txtEmail, 10000);
	}
	public void enterEmailId(String emailid) {
		txtEmail.sendKeys(emailid);
	}
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickLoginButton() {
		btnLogin.click();
		//WaitVisibilityOf(errorMessage, 3000);
	}
	public void errorMessageforLoginFail() {
		//#e10000
		try {
			String errorStr=errorMessage.getText();
			String actualcolor=errorMessage.getCssValue("color");//rgba(225, 0, 0, 1)
			//covert string to hexa
			String Hexactualcolor=Color.fromString(actualcolor).asHex();
			
			String ExpectedColor="#e10000";
			if (errorStr.contains("Your log in attempts has been unsuccessful.")&& Hexactualcolor.equals(ExpectedColor) ) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
