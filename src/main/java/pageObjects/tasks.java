package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

//import cucumber.api.DataTable;
import org.junit.Assert;
import resources.TestBase;

public class tasks extends TestBase{
	public WebDriver driver;
	public static String TaskNum;
	@FindBy(xpath="//ul/li//a[text()='Tasks']") private WebElement TaskTab;
	@FindBy(xpath="//ul/li//a[text()='Tasks']/parent::li/ul/li/a") private List<WebElement> TaskSelction;
	@FindBy(name="sequence") private WebElement TaskNo;
	@FindBy(id="title") private WebElement Title;
	@FindBy(name="auto_extend")private WebElement autoExtend;
	@FindBy(name="status")private WebElement status;
	@FindBy(css="input#completion")private WebElement Completion;
	@FindBy(name="task_type")private WebElement Type;
	@FindBy(name="priority") private WebElement priority;
	@FindBy(name="email_notification") private WebElement chboxAssigneto;
	@FindBy(xpath="//input[@value='Save']") private List<WebElement> btnSave;
	@FindBy(xpath="//strong[text()='Task No.']/parent::td/following-sibling::td")	private WebElement Taskcreation;
	
	@FindBy(xpath="(//input[@type='button' and @value='Lookup'])")
		private List<WebElement> btnlookup;
	
	@FindBy(id="search") private WebElement companyLookupsearchbox;
	@FindBy(xpath="//input[contains(@value,'Search')]") private WebElement companyLookupsearchbtn;
	@FindBy(xpath="//Strong[text()='Clients']/parent::td/ancestor::tr//tbody/tr/td/a") 
			private List<WebElement> comapnylookuptablecol;
	
	
	public tasks(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void newTaskSelection() {
		driver.switchTo().frame("mainpanel");
		Actions action=new Actions(driver); 
		action.moveToElement(TaskTab).build().perform();;
		int task=TaskSelction.size();
		for(int i=0;i<task;i++) {
			if(TaskSelction.get(i).getAttribute("title").equals("New Task")) {
				TaskSelction.get(i).click();
				break;
			}
		}
	}
	public String getTaskno() {
		 TaskNum=TaskNo.getAttribute("value");
		return TaskNum;
			
	}
	public void txtenterTitle(DataTable dt) {
		List<Map<String,String>>map=dt.asMaps(String.class, String.class);
		Title.sendKeys(map.get(0).get("Title"));
	}
	public void DDautoExtend(DataTable dt) {
		List<List<String>> list=dt.asLists(String.class);
		Select s=new Select(autoExtend);
		s.selectByVisibleText(list.get(1).get(1));
	}
	public void DDStatus(DataTable dt) {
		List<List<String>>l=dt.asLists(String.class);
		Select Statusdd=new Select(status);
		Statusdd.selectByVisibleText(l.get(1).get(2));
	}
	public void txtCompletion(DataTable dt) {
		List<List<String>> list=dt.asLists(String.class);
		
		Completion.sendKeys(list.get(1).get(3));
	}
	public void DDType(DataTable dt) {
		List<List<String>>l=dt.asLists(String.class);
		Select typedd=new Select(Type);
		typedd.selectByVisibleText(l.get(1).get(4));
	}
	public void DDPriority(DataTable dt) {
		List<List<String>>l=dt.asLists(String.class);
		Select prioritydd=new Select(priority);
		prioritydd.selectByVisibleText(l.get(1).get(5));
	}
	public void selectcheckbox() {
		if(!chboxAssigneto.isSelected()) {
			chboxAssigneto.click();
		}
	}
	public void clickOnLookUpbtn() throws InterruptedException {
		btnlookup.get(3).click();;
		Thread.sleep(3000);
			
	}
	
	public void enterTaskDeatils(DataTable dt) {
		txtenterTitle( dt);
		DDautoExtend( dt);
		DDStatus(dt);
		txtCompletion(dt);
		DDType(dt);
		DDPriority(dt);
		selectcheckbox();
	}
	public void ComapnyLookupSearch() {
		
		String parentwindow=driver.getWindowHandle();
		Set<String>handle=driver.getWindowHandles();
		Iterator<String> it=handle.iterator();
		while(it.hasNext()) {
			String handles=it.next();
			if(!handles.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(handles);
				break;
			}
		}
		
		companyLookupsearchbox.sendKeys("tester");
		companyLookupsearchbtn.click();
		for(int i=0;i<comapnylookuptablecol.size();i++) {
			if(comapnylookuptablecol.get(i).getText().equalsIgnoreCase("tester")) {
				comapnylookuptablecol.get(i).click();
				break;
			}
		}
		driver.switchTo().window(parentwindow);
		driver.switchTo().frame("mainpanel");
		
		
	}
	public void btnsave() throws InterruptedException {
		Thread.sleep(2000);
		
		btnSave.get(1).click();
	}
	public void checkTaskcreation() {
		//System.out.println("task is"+TaskNum);
		WebDriverWait wait=new WebDriverWait(driver,3000);
		wait.until(ExpectedConditions.visibilityOf(Taskcreation));
	
		if(Taskcreation.getText().contains(TaskNum)){
			
			Assert.assertTrue("taskcrtedsucessfully",true);
		}else {
			Assert.assertTrue("taskcrtedunsucessfully", false);
		}
		
	}
}
