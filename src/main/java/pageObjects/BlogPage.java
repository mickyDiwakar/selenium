package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.TestBase;

public class BlogPage extends TestBase{
	
	

	@FindBy(xpath="//div[@id='navMenu']/ul//li/a")
	private List<WebElement> sidemenuselection;
	
	public BlogPage() {
		PageFactory.initElements(driver, this);
	}
	//select side menu
	public List<WebElement> getSidemenuselection() {
		
		return sidemenuselection;
	}
	
	public void sidemenuselection() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));
		for(WebElement ele: getSidemenuselection()) {
			if(ele.getAttribute("title").equals("Blog")) {
				ele.click();
			}
		}
	
		
	}
	
	

}
