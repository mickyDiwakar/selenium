package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calender {
	public WebDriver driver;
	@FindBy(xpath = "//select[@name='assigned_to_user_id_src']/option")
	WebElement AssignedTo;
	@FindBy(xpath = "//input[@value='==ADD==>']")
	WebElement addTo;
	@FindBy(xpath = "//input[@value='Lookup']")
	List<WebElement> btnLookup;
	@FindBy(name="search")
	WebElement searchbox;
	@FindBy(xpath="//input[@value='Search']")
	WebElement btnSearch;
	@FindBy(tagName = "strong")
	WebElement Notfoundmessage;
	@FindBy(name="contact_lookup")
	WebElement editConatct;
	

	public calender(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void tabselection(String tab) {
		Actions action = new Actions(driver);
		
		WebElement tabs = driver.findElement(By.xpath("//*[@class='mlddm']/child::li/a[text()='"+tab+"']"));
		action.moveToElement(tabs).build().perform();
		
		
	}

	public void calenderdropdownselection(String calender) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//ul[@class='mlddm']/child::li/a[text()='Calendar']/parent::li/ul/child::li/a[text()='"
						+ calender + "']"))
				.click();
		
	}

	public void eventSelection(String time,String Contnum) throws InterruptedException {
		
		List<WebElement> row = driver
				.findElements(By.xpath("//tbody/tr/td[text()='Time']/parent::tr/following-sibling::tr"));
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElements(row));
		

		for (int i = 1; i <= row.size(); i++) {
			WebElement col=driver.findElement(By.
					xpath("//tbody/tr/td[text()='Time']/parent::tr/following-sibling::tr["+i+"]/td[1]/a"));
			if (col.getAttribute("name").contains(time)) {
				driver.findElement(By.xpath(
						"//tbody/tr/td[text()='Time']/parent::tr/following-sibling::tr["+i+"]/td[3]/a[2]"))
						.click();
				break;
			}

		}
		
		
		  
		  wait.until(ExpectedConditions.visibilityOf(AssignedTo));
		  if(AssignedTo.isSelected()==false) {
			  AssignedTo.click();
		  }
		 
		  //Thread.sleep(2000);
		  addTo.click();
		 
		wait.until(ExpectedConditions.elementToBeClickable(btnLookup.get(0)));
		btnLookup.get(0).click();;
		Set<String>handle=driver.getWindowHandles();
		Iterator<String> it=handle.iterator();
		String parentwindow=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
		
		searchbox.sendKeys(Contnum);
		btnSearch.click();
		Thread.sleep(2000);
		
		if(Notfoundmessage.getText().contains("No result")) {
			driver.close();
		}
		driver.switchTo().window(parentwindow);
		driver.switchTo().frame("mainpanel");
		Thread.sleep(1000);
		editConatct.sendKeys(Contnum);

	}

	

}
