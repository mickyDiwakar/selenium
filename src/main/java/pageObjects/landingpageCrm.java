package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.TestBase;

public class landingpageCrm extends TestBase{
	//public  WebDriver driver;
	By usernamedisplay=By.xpath("//span[@class='user-display']");
	By logotag=By.xpath("//div[@href='#']");
	@FindBy(xpath="//ul[@class='mlddm']/li/a")
	List<WebElement> tabselection;
	@FindBy(xpath="//ul[@class='mlddm']/li/a[@title='Cases']/parent::li/ul/li")
	List<WebElement> taskElement;
	public landingpageCrm() {
		PageFactory.initElements(driver, this);
		
	}
	public WebElement logcheck() {
		return driver.findElement(logotag);
	}
	public WebElement usernameonhomepage() {
		return driver.findElement(usernamedisplay);
	}
	public crmnewTaskPage clickLInkonTable(String tabname,String tabvalue) {
		driver.switchTo().frame("mainpanel");
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(tabselection.get(0)));
		for(WebElement ele:tabselection) {
			int flag=0;
			String tab=ele.getAttribute("title");
			if(tab.equalsIgnoreCase(tabname)) {
				Actions action=new Actions(driver);
				action.moveToElement(ele).build().perform();;
			
				for(int i=0;i<taskElement.size();i++) {
					String tabele=taskElement.get(i).getText().trim();
					if(tabele.equalsIgnoreCase(tabvalue)){
						taskElement.get(i).click();
						flag=1;
						break;
					}
				}
				
				
			}
			if(flag==1) {
				break;
			}
			
		}
		return new crmnewTaskPage()	;
		
		
		
	}

}
