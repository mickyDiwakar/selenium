package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import resources.TestBase;
import utilities.logger;

public class userCreation extends TestBase {
	public WebDriver driver;
	 final static Logger log=logger.getLogger(userCreation.class);
	@FindBy(xpath="//a/font/b")
	WebElement messageForMemebrcraetion;
	
	public userCreation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
 public void verfiytheUserCreation(String UserName){
	//driver.findElements(By.xpath("//a[\"href=mercurysignon.php\"]")).get(0).click();
	//String str2= driver.findElement(By.xpath("//a/font/b")).getText();
	//boolean b=driver.getPageSource().contains(UserName);
	//String str1= messageForMemebrcraetion.getText();
	//System.out.println(str1+b);
		 try {
			 WebDriverWait wait= new WebDriverWait(driver,8);
			 wait.until(ExpectedConditions.visibilityOf(messageForMemebrcraetion));
			 //WaitVisibilityOf(messageForMemebrcraetion, 8000);
			String str=messageForMemebrcraetion.getText();
	
			 if (str.contains(UserName)) {
				 Assert.assertTrue(true);
				 System.out.println("x value in other page="+newtourSignupPage.x);
				log.info("********************memeber creaated*****************");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.assertFalse(true);
			log.info("********************memeber not creaated*****************");

		}
	 }
}
