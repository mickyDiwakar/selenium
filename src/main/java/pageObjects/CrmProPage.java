package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import resources.TestBase;

public class CrmProPage extends TestBase{
	public static String parentwindow;	
@FindBy(xpath="//h3[@class='post-title' ]/a[contains(@title,'Windows XP – Service Pack 3 Required')]")
WebElement WinXPTiles;
@FindBy(xpath="//ul[@class='widget-categories']/li/a")
List<WebElement> categoriesselection;





public CrmProPage() {
	PageFactory.initElements(driver, this);
}

public WebElement getWinXPTiles() {
	return WinXPTiles;
}
public List<WebElement> getCategoriesselection() {
	return categoriesselection;
}
public void clickonWindowXpTiles() {
	parentwindow=driver.getWindowHandle();
	Set<String> handles=driver.getWindowHandles();
	Iterator<String>it=handles.iterator();
	while(it.hasNext()) {
		String window=it.next();
		if(!window.equals(parentwindow)) {
			driver.switchTo().window(window);
			break;
		}
		
	}
	getWinXPTiles().click();
}
public void clickonCategories(DataTable dt) {
	
	List<List<String>>l=dt.asLists();
	String categories=l.get(0).get(0);
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(getCategoriesselection().get(0)));
	for(WebElement ele:getCategoriesselection()) {
	if(ele.getText().equals(categories)) {
		ele.click();
		break;
	}
		
	}
	
}

}
