package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import resources.TestBase;

public class ArchiveCrmpro extends TestBase {
	@FindBy(xpath="//div/ul[@class='categories archives']/li/a")
	List<WebElement> Archivelinks;
	
	@FindBy(linkText = "CRMPRO News")
	WebElement crmpronewsLink;
	public ArchiveCrmpro() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(tagName="h2")
	List<WebElement> geterrormessage;

	public List<WebElement> getGeterrormessage() {
		return geterrormessage;
	}

	

	public List<WebElement> getArchivelinks() {
		return Archivelinks;
	}
	
	public WebElement getCrmpronewsLink(String crmprolink) {
		
		return crmpronewsLink;
	}
	public void clickOnArchiveLink(String s) {
		for(WebElement ele:getArchivelinks()) {
			if(ele.getText().contains(s)) {
				ele.click();
				break;
				
			}
		}
	}
	public void ClickOnCrmpronewLink(String Crmprolink) {
		getCrmpronewsLink(Crmprolink).click();
	}	
	public void verfiytheresult(String s) {
		//Assert.assertFalse(true);
		Assert.assertTrue("verfiy the crmproarchived",geterrormessage.get(1).getText().contains(s) );
		driver.close();
		driver.switchTo().window(CrmProPage.parentwindow);
	}
	
	
	   
	

}
