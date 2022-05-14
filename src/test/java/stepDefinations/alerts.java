package stepDefinations;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.collect.Maps;
//import com.mavenproj.CRMHomeMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import io.cucumber.datatable.DataTable;

//import cucumber.api.DataTable;


import resources.TestBase;
 
public class alerts extends TestBase{
	WebDriverWait wait=new WebDriverWait(driver,1000);
	@When ("^user Click on Blog and navigate in new tab$")
	public void user_Click_on_Blog_and_navigate_in_new_tab(DataTable dt) {
		String tabName = null;
		List<Map<String, String>>m=dt.asMaps(String.class, String.class);
		tabName=m.get(0).get("Tab");
		
		By tab=By.xpath("//*[@id='navMenu']/ul/li/a[@title='"+tabName+"']");
		WebDriverWait wait=new WebDriverWait(driver,8000);
		//wait.until(ExpectedConditions.elementToBeClickable(tab));
			driver.switchTo().frame("mainpanel");		
			System.out.println(tabName);
			WebElement tag=driver.findElement(tab)	;	
			wait.until(ExpectedConditions.visibilityOf(tag));
			tag.sendKeys(Keys.CONTROL);
			tag.click();
		    
		}
	
	@Then("^Click on New Help Centre and click link \\[tag and free crm\\]$")
	public void clicknewHelp() {
		Set<String> handle=driver.getWindowHandles();
		Iterator<String>it=handle.iterator();
		String newtab = "";
		for (int i=1;i<=handle.size();i++) {
			newtab=it.next();
			
		}
		driver.switchTo().window(newtab);
		WebElement newhelpcentre=driver.findElement(By.xpath("//a[@title='New Help Center']"));
		WebDriverWait wait=new WebDriverWait(driver,8000);
		wait.until(ExpectedConditions.visibilityOf(newhelpcentre));
		newhelpcentre.click();
		WebElement linktagandfreecrm=driver.findElement(By.
					xpath("//*[@id='content-wrapper']//ul/child::li/a[@title='Tags and freeCRM']"));
		//xpath("//*[@id='content-wrapper']//ul/child::li[2]/a "))
		wait.until(ExpectedConditions.visibilityOf(linktagandfreecrm));
		linktagandfreecrm.click();
		String actualText=driver.findElement(By.xpath("//h2[text()='Tags and freeCRM']")).getText();
		Assert.assertEquals(actualText, "Tags and freeCRM");
		
		
	}
	
	 @Then("^click on alert tab$")
	    public void click_on_alert_tab() throws Throwable {
		 	driver.switchTo().frame("mainpanel");
	        WebElement alert=driver.findElement(By.xpath("//div[@id='navMenu']/ul/li/a[@title='Alerts']"));
	        try {
				
				wait.until(ExpectedConditions.visibilityOf(alert));
				alert.click();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Assert.assertTrue(false);
				Reporter.log("either alert is not visible or newAlert not clickable");
				
			}
	        
	        
	    }

	    @And("^Delete existing alert$")
	    public void delete_existing_alert() throws Throwable {
	    	//table[@class='datacard']/tbody/tr[3]/td[9]/a[2]/i[@title='Delete']
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='datacard']/tbody/tr")));
	    	List<WebElement> row=driver.findElements(By.xpath("//table[@class='datacard']/tbody/tr"));
	    	int rowCount=row.size();
	    	List<WebElement> col=driver.findElements(By.xpath("//table[@class='datacard']/tbody/tr[3]/td"));
	    	int colCount=col.size();
	    	if(rowCount>=3) {
	    		for(int i=3;i<=rowCount;i++) {
	    			int k=3;
	    			driver.findElement(By.xpath("//table[@class='datacard']/tbody/"
	    					+ "tr["+k+"]/td["+colCount+"]/a[2]/i[@title='Delete']")).click();
	    			Thread.sleep(1000);
	    			driver.switchTo().alert().accept();
	    				  
	    						  
	    			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='datacard']/tbody/tr")));
	    			
	    		}
	    	}
	    }

	    @And("^Add new Alert$")
	    public void add_new_alert(DataTable dt) throws Throwable {
	    	
	    	for(Map<String, String> m:dt.asMaps()) {
	    		WebElement newAlert= driver.findElement(By.xpath("//input[@value='New Alert']"));
				wait.until(ExpectedConditions.elementToBeClickable(newAlert));
				newAlert.click();
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=Save]")));
		    	Select select=new Select(driver.findElement(By.name("alert_send_mode")));
		    	select.deselectAll();
		    	select.selectByVisibleText(m.get("Alert"));
		    	
		    	Thread.sleep(1000);
		    	Select select1=new Select(driver.findElement(By.name("object_type")));
		    	select1.selectByVisibleText(m.get("Type"));
		    	Thread.sleep(1000);
		    	Select select2=new Select(driver.findElement(By.name("alert_trigger")));
		    	select2.selectByVisibleText(m.get("Trigger"));
		    	Thread.sleep(1000);
		    	Select select3=new Select(driver.findElement(By.name("format")));
		    	select3.selectByVisibleText(m.get("Format"));
		    	Thread.sleep(1000);
		    	String Activeradiobtn=m.get("Active");
		    	if (Activeradiobtn.equalsIgnoreCase("Yes")) {
		    		driver.findElement(By.xpath("//input[@name='active' and @value='Y']")).click();
		    	}else {
		    		driver.findElement(By.xpath("//input[@name='active' and @value='N']")).click();
		    		
		    	}
		    	driver.findElement(By.cssSelector("input[value=Save]")).click();;
		    	
	    	}
	    
	    }

}
