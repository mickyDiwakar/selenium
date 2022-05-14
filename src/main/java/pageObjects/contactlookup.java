package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.TestBase;

public class contactlookup extends TestBase{
	String parentwindow;
	@FindBy(xpath="//input[@name='search']/following::input")
	WebElement searchbtn;
	@FindBy(xpath="//input[@type='submit']/preceding::input[@name='search']")
	WebElement searchbox;
	@FindBy(xpath="//td[@class='datatitle']/parent::tr/parent::tbody/tr")
	List<WebElement> Tablerow;
	@FindBy(xpath="//td[@class='datatitle']/parent::tr/parent::tbody/tr[1]/td")
	List<WebElement> Tablecol;
	
	public contactlookup() {
		PageFactory.initElements(driver, this);
	}
	public void contactLookupsearch(String searchmessage) throws InterruptedException {
		Thread.sleep(5000);
		parentwindow=driver.getWindowHandle();
		Set<String>handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		while(it.hasNext()) {
			String child=it.next();
			if(!child.equals(parentwindow)) {
				driver.switchTo().window(child);
				break;
			}
			
		}
		
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(searchbtn));
		JavascriptExecutor jscript=(JavascriptExecutor)driver;
		searchbox.clear();
		jscript.executeScript("arguments[0].value='"+searchmessage+"';",searchbox);
			searchbtn.click();
	}
	public crmnewTaskPage  contactLookupTableSecletion(String searchmessage) {
		int rowcount=Tablerow.size();
		int colcount=Tablecol.size();
		for(int i=1;i<=rowcount;i++) {
			for(int j=1;j<=colcount;j++) {
				WebElement table=driver.findElement(By.xpath("//td[@class='datatitle']"
						+ "/parent::tr/parent::tbody/tr["+i+"]/td["+j+"]"));
				
				String str=table.getText();
				if(str.trim().contains(searchmessage)) {
					driver.findElement(By.xpath("//td[@class='datatitle']"
							+ "/parent::tr/parent::tbody/tr["+i+"]/td["+j+"]/a")).click();
					
					break;
				}
			}
			
		}
		driver.switchTo().window(parentwindow);
		driver.switchTo().frame("mainpanel");
		
		return new crmnewTaskPage();
	}
	
	
}
