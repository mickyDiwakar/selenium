package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
//import cucumber.api.DataTable;

//import cucumber.api.DataTable;

public class Homepage1 {
	
	public WebDriver driver;
	@FindBy(xpath="//*[@id='homebox_CALDAY']/table/tbody/tr")
	 List<WebElement> rowdateTable;
	@FindBy(xpath="//*[@id='homebox_CALDAY']/table/tbody/tr[1]/td")
	List<WebElement> coldateTable;
	@FindBy(xpath="//*[@id=\"homebox_CALDAY\"]/table/tbody/tr/td/a[2]")
	List<WebElement>linkNewEvent;
	

	public  Homepage1(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void linkclickonTable(DataTable dt) {
		
		List<List<String>> val=dt.asLists(String.class);
		String time=val.get(0).get(0);
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.name("company_name")).sendKeys("test");
		//int rowCount=rowdateTable.size();
		int rowCount=rowdateTable.size();
		//rowdateTable.get(i);
		 
		for(int i=1;i<rowCount;i++) {
			//WebElement w=rowdateTable
			
			WebElement elemen=driver.findElement(
					By.xpath("//*[@id='homebox_CALDAY']/table/tbody/tr["+i+"]/td[1]/a"));
			String s=elemen.getAttribute("name");
			//String eletext=s
			if(s.equals(time)) {
				driver.findElement(By.xpath("//*[@id='homebox_CALDAY']/table/tbody/tr["+i+"]/td[3]/a[2]")).click();
				break;
			}
			
		}
		
	}
	
}
 