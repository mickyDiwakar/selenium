 package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacts {
	public WebDriver driver;
	@FindBy(xpath="//ul[@class='mlddm']/child:: li/a[@title='Contacts']/parent::li/ul/child::li/a[text()='Full Search Form']")
	WebElement FullSearchForm;
	
	@FindBy(name="cs_first_name")
	WebElement wfirstName;
	@FindBy(name="cs_title")
	WebElement wtitle;
	//following sibling expalmple
	@FindBy(xpath="//input[@name='contact_lookup_sup']/following-sibling::input")
	WebElement wSupervisor;
	@FindBy(name="search")
	WebElement wsearch;
	@FindBy(xpath="//input[@value='Search']")
	WebElement wbtnsearch;
	
	public  Contacts(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void conatctTabSelection(String Tabname) {
		driver.switchTo().frame("mainpanel");
		WebDriverWait wait=new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//ul[@class='mlddm']/child:: li/a[text()='"+Tabname+"']")));
		Actions action=new Actions(driver);
		WebElement Tabs=driver.findElement(By.xpath("//ul[@class='mlddm']/child:: li/a[text()='"+Tabname+"']"));
		action.moveToElement(Tabs).build().perform();
		FullSearchForm.click();
	}
		
	public void searchContact(String title,String firstName, String Supervisor) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.name("cs_first_name")));
		Select s=new Select(wtitle);
		s.selectByVisibleText(title);
	
		Thread.sleep(1000);
		wfirstName.sendKeys(firstName);
		Thread.sleep(1000);
		wSupervisor.click();
		Thread.sleep(3000);
		Set<String>handle=driver.getWindowHandles();
		Iterator<String> it=handle.iterator();
		String parentwidnow=it.next();
		String childwindow=it.next();
		
		driver.switchTo().window(childwindow);
		wait.until(ExpectedConditions.elementToBeClickable(wsearch));
		wsearch.sendKeys(Supervisor);
		wbtnsearch.click();
		Thread.sleep(2000);
		int tablesize=driver.findElements(By.xpath("//td[@class='datatitle']/parent::tr/parent::tbody/tr")).size();
		//int colsize=driver.findElements(By.xpath("//td[@class='datatitle']/parent::tr/parent::tbody/tr[1]/td")).size();
		for(int i=2;i<=tablesize;i++) {
			WebElement col=driver.findElement(By.xpath("//td[@class='datatitle']/parent::tr/parent::tbody/tr["+i+"]/td/a"));
			String colval=col.getText();
			if (colval.contains(Supervisor)) {
				col.click();
				break;
			}
		}
		
		
		
	}
	
	

}
