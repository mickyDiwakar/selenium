package pageObjects;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.TestBase;

public class loginToCrm extends TestBase {
	//public WebDriver driver;
	By email=By.name("email");
	By password=By.name("password");
	By loginbutton=By.xpath("//div[text()='Login']");
	@FindBy(name="username")
	private WebElement username;
	@FindBy(name="password")
	private WebElement Passwordofpro;
	@FindBy(css="input[value=Login]")
	private WebElement loginbtn;
	
	public loginToCrm() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement clickLogin() {
		return driver.findElement(loginbutton);
	}
	
	
	
public void  login(String username,String password) {
		getEmail().sendKeys(username);
		getPassword().sendKeys(password);
		//return new loginToCrm() ;

		
		
	}

public void usernameofProCrm() {
	username.sendKeys(p.getProperty("userName"));
}
public void PasswordOfProCrm() {
		/*
		 * byte[] password=p.getProperty("Password").getBytes(); String
		 * encodedpassword=Base64.getEncoder().encodeToString(password);
		 * Passwordofpro.sendKeys(encodedpassword);
		 */
		
		  String crmapss=p.getProperty("Password"); 
		  Passwordofpro.sendKeys(crmapss);
		 
}
public landingpageCrm logintoClassicCrmPro() {
	usernameofProCrm();
	PasswordOfProCrm();
	loginbtn.click();
	return new landingpageCrm();
}


}


