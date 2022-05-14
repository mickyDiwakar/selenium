package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.TestBase;

public class CaseCreationpage extends TestBase{
	@FindBy(xpath="//Strong[text()='Case No.']/parent::td/following-sibling::td")
	WebElement caseno;
	
	
	
	
	public WebElement getCaseno() {
		return caseno;
	}
	
	public CaseCreationpage() {
		PageFactory.initElements(driver, this);
	}
	public void verfiythecasecraeted() {
		
		WebDriverWait wait=new WebDriverWait(driver,9);
		wait.until(ExpectedConditions.visibilityOf(caseno));
		String casenumberfromcraetion=crmnewTaskPage.casseNo;
		//String casenumberfromcraetion=new crmnewTaskPage().getTaskNo();
		if(caseno.getText().contains(casenumberfromcraetion)) {
			Assert.assertTrue("case craeted sucessfully", true);
		}else{
			Assert.assertTrue("case not craeted ", false);
		}
	}

}
