package stepDefinations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.TestBase;
 
public class dealsCreation extends TestBase {
	String colorofdealtab;

	@Given("^ User is logged in with chrome browser$")
	public void user_is_logged_in_with_chrome_browser() throws Throwable {
		driver = initializeDriver();
		
	}

	@When("^user enter the CRM PRO url$")
	public void user_enter_the_crm_pro_url() throws Throwable {

		driver.get(p.getProperty("crmProUrl"));

	}

	@And("^User logged in to PRO with username and password$")
	public void user_logged_in_to_pro_with_username_and_password(DataTable dt) throws Throwable {
		List<Map<String, String>> data = dt.asMaps(String.class, String.class);
		String username = data.get(0).get("username");
		String password = data.get(0).get("password");

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("^Hover to Deals tab and select New Deals$")
	public void hover_to_deals_tab_and_select_new_deals() throws Throwable {
		driver.switchTo().frame("mainpanel");
		WebElement  deal=driver.findElement(By.xpath("//a[@title='Deals']"));
		WebDriverWait wait=new WebDriverWait(driver,8000);
		wait.until(ExpectedConditions.visibilityOf(deal)); 
		 colorofdealtab=deal.getCssValue("color");
		 String hexValue=Color.fromString(colorofdealtab).asHex();
		 // WebElement deal = driver.findElement(By.xpath("//a[@title='Deals']"));
		Actions action = new Actions(driver);
		action.moveToElement(deal).build().perform();
		driver.findElement(By.xpath("//a[text()='New Deal']")).click();
		

		// String Title=
		// driver.findElement(By.id("title")).sendKeys(Title);
	}

	@And("^enter all details new deals and click save$")
	public void enter_all_details_new_deals_and_click_save(DataTable dt) throws Throwable {
		WebElement ele=driver.findElement(By.cssSelector("input[name='sequence']"));
		WebDriverWait wait=new WebDriverWait(driver,8000);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		String dealnumber = ele.getAttribute("value");
		List<Map<String, String>> data = dt.asMaps(String.class, String.class);
		String Title = data.get(0).get("Title");
		String comapny = data.get(0).get("comapny");
		String Primecont = data.get(0).get("Primecont");
		String Amount = data.get(0).get("Amount");
		String probab = data.get(0).get("probab");
		String commision = data.get(0).get("commision");
		String identifier = data.get(0).get("identifier");
		String quant = data.get(0).get("quant");
		String type = data.get(0).get("type");
		String source = data.get(0).get("source");
		String status = data.get(0).get("status");
		String pdate = data.get(0).get("pdate");
		String Adate = data.get(0).get("Adate");
		String reports = data.get(0).get("reports");
		driver.findElement(By.id("title")).sendKeys(Title);
		driver.findElement(By.cssSelector("input[name='client_lookup']")).sendKeys(comapny);
		driver.findElement(By.cssSelector("input[name='contact_lookup']")).sendKeys(Primecont);
		driver.findElement(By.name("amount")).sendKeys(Amount);
		driver.findElement(By.id("probability")).sendKeys(probab);
		driver.findElement(By.id("commission")).sendKeys(commision);
		driver.findElement(By.name("identifier")).sendKeys(identifier);
		driver.findElement(By.name("quantity")).sendKeys(quant);
		Select select = new Select(driver.findElement(By.name("type")));
		select.selectByVisibleText(type.trim());
		Select selsource = new Select(driver.findElement(By.name("source")));
		selsource.selectByVisibleText(source.trim());
		if (status.equalsIgnoreCase("open")) {
			driver.findElement(By.xpath("//input[@type='radio'][1]")).click();
		}
		else
		{
			driver.findElement(By.xpath("//input[@type='radio'][2]")).click();
		}
		driver.findElement(By.id("f_trigger_c_close_date")).click();
		Thread.sleep(1000);
		
		// driver.findElement(By.id("f_trigger_c_close_date")).click();
		//table/tbody/tr[1]/td[5]
		List<WebElement> row=driver.findElements(By.xpath("//div[@class='calendar']/table/tbody/tr "));
		int rowcount=row.size();
		System.out.println(rowcount);
		List<WebElement> col=driver.findElements(By.xpath("//div[@class='calendar']/table/tbody/tr[1]/td"));
		int colcount=col.size();
		System.out.println(colcount);
		String arrpdate[]=pdate.split("/");
		String arrAdate[]=Adate.split("/");
		//month selection
		Date d=new Date();
		SimpleDateFormat format=new SimpleDateFormat("d/M/yyyy");
		String currentdate=format.format(d);
		String arrcurrentdate[]=currentdate.split("/");
		Thread.sleep(2000);
		
		//yearselection
		
		if(Integer.parseInt(arrcurrentdate[2])<Integer.parseInt(arrpdate[2])) {
			int yeardiff=Integer.parseInt(arrpdate[2])-Integer.parseInt(arrcurrentdate[2]);
			for(int i=1;i<=yeardiff;i++) {
				driver.findElement(By.xpath("//div[text()='»']")).click();
				Thread.sleep(1000);
			}
			if(Integer.parseInt(arrcurrentdate[1])>Integer.parseInt(arrpdate[1])) {
				int daydiff=Integer.parseInt(arrcurrentdate[1])-Integer.parseInt(arrpdate[1]);
				for(int i=1;i<=daydiff;i++) {
					driver.findElement(By.xpath("//div[text()='‹']")).click();
					Thread.sleep(1000);
				}
			}
			else if(Integer.parseInt(arrcurrentdate[1])<Integer.parseInt(arrpdate[1])) {
				int daydiff=Integer.parseInt(arrpdate[1])-Integer.parseInt(arrcurrentdate[1]);
				for(int i=1;i<=daydiff;i++) {
					driver.findElement(By.xpath("//div[text()='›']")).click();
					Thread.sleep(1000);
				}
			}
		}
		else {
			// month selection
			if (Integer.parseInt(arrcurrentdate[1]) > Integer.parseInt(arrpdate[1])) {
				int daydiff = Integer.parseInt(arrcurrentdate[1]) - Integer.parseInt(arrpdate[1]);
				for (int i = 1; i <= daydiff; i++) {
					driver.findElement(By.xpath("//div[text()='›']")).click();
					Thread.sleep(1000);
				}
			} else if (Integer.parseInt(arrcurrentdate[1]) < Integer.parseInt(arrpdate[1])) {
				int daydiff = Integer.parseInt(arrpdate[1]) - Integer.parseInt(arrcurrentdate[1]);
				for (int i = 1; i <= daydiff; i++) {
					driver.findElement(By.xpath("//div[text()='‹']")).click();
					Thread.sleep(1000);
				}
			}
		}
		
		//driver.findElement(By.xpath("//div[text()='›']"));
		//dayselection
		for (int i=1;i<rowcount;i++) {
			for(int j=2;j<=colcount;j++) {
				WebElement Dateseclection=driver.findElement(By.xpath("//div[@class='calendar']/table/tbody/tr["+i+"]/td["+j+"]"));
				String text=Dateseclection.getText();
				if (((Dateseclection.getText()).equals(arrpdate[0]))) {
					Dateseclection.click();
				}
			}
		}
		driver.findElement(By.name("close_date")).sendKeys(pdate);
		driver.findElement(By.name("actual_close_date")).sendKeys(Adate);
		if (reports.equalsIgnoreCase("Yes")) {
			driver.findElement(By.xpath("//input[contains(@name,'exclude')]")).click();

		}
		
		driver.findElement(By.className("mceEditor")).sendKeys(colorofdealtab + dealnumber);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		
	}
}
