package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resources.TestBase;

public class crmnewTaskPage extends TestBase {
	 public static String casseNo;
	 
	//String casseNo;
	contactlookup contactlookupObj;
	@FindBy(css = "input#title")
	private WebElement Title;
	@FindBy(css = "input[name=sequence]")
	private WebElement caseNo;
	@FindBy(css = "select[name=status]")
	private WebElement Status1;
	@FindBy(xpath = "//input[@name='deadline']/following-sibling::img")
	private List<WebElement> Deadlineimageicon;
	@FindBy(xpath = "//input[@name='closed']")
	private List<WebElement> rbtnState;
	@FindBy(xpath = "//table/tbody//tr[@class='daysrow']/td[not(contains(@class,'wn'))]")
	private List<WebElement> daysSelectionfromcalender;
	@FindBy(xpath = "//div[@unselectable='on' and text()='›']")
	private List<WebElement> monthselectionfromcalender;
	@FindBy(xpath = "//div[@unselectable='on' and text()='»']")
	private List<WebElement> yearselectionfromcalender;
	@FindBy(name = "type")
	private WebElement type;
	@FindBy(name = "priority")
	private WebElement priority;
	@FindBy(xpath = "//select[starts-with(@name,'assigned')]")
	private WebElement AssignedTo;
	@FindBy(css = "input[name='email_notification']")
	private WebElement emailverfificationcheckbox;
	@FindBy(xpath = "//input[@value='Lookup' and contains(@onclick,'CONTACT')]")
	private WebElement lookupbutton;
	@FindBy(xpath = "//iframe[@id='processFrame']/preceding::input[@value='Save' and @class='button' and @type='submit']")
	private List<WebElement> Savebtn;

	public crmnewTaskPage() {
		PageFactory.initElements(driver, this);
	}

	public String getTaskNo() {
		
		return	caseNo.getAttribute("value");
	}
	
	

	public void setTitle(String title) {
		Title.sendKeys(title);

	}

	public void DeadlineSelection(String date1) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateofToday = sdf.format(new Date());
		Deadlineimageicon.get(0).click();

		String[] arrtoday = dateofToday.split("/");
		int daytoday = Integer.parseInt(arrtoday[0]);
		int monthtoday = Integer.valueOf(arrtoday[1]);
		int yeartoday = Integer.valueOf(arrtoday[2]);
		String[] arr = date1.split("/");
		int day = Integer.parseInt(arr[0]);
		int month = Integer.valueOf(arr[1]);
		int year = Integer.valueOf(arr[2]);
		// year selection
		for (int i = 0; i < (year - yeartoday); i++) {

			int sizeoflist = yearselectionfromcalender.size();
			yearselectionfromcalender.get(sizeoflist - 1).click();
		}
		// month selection
		for (int i = 0; i < month - monthtoday; i++) {
			monthselectionfromcalender.get(monthselectionfromcalender.size() - 1).click();
		}
		// day selection
		for (int i = 0; i < daysSelectionfromcalender.size(); i++) {
			String s = daysSelectionfromcalender.get(i).getText();
			if (!s.matches("")) {
				if ((Integer.parseInt(daysSelectionfromcalender.get(i).getText())) == day) {
					daysSelectionfromcalender.get(i).click();
					break;
				}
			}

		}
	}

	public void status(String status) {
		Select select = new Select(Status1);
		select.selectByVisibleText(status);
	}

	public void Type(String Type) {
		Select select = new Select(type);
		select.selectByVisibleText(Type);
	}

	public void state(String state) {
		for (WebElement ele : rbtnState) {
			// ele.getAttribute("value").equals("N")
			if (state.equalsIgnoreCase("Open")) {
				if (ele.getAttribute("value").equalsIgnoreCase("N")) {
					ele.click();
					break;
				}
			} else if (state.equalsIgnoreCase("Closed")) {
				if (ele.getAttribute("value").equalsIgnoreCase("Y")) {
					ele.click();
					break;
				}

			}
		}

	}

	public void priority(String p) {
		Select select = new Select(priority);
		select.selectByVisibleText(p);
	}

	public void AssignedTo(String assignto) {
		Select select = new Select(AssignedTo);
		select.deselectAll();
		select.selectByVisibleText(assignto);
	}

	public void emialNotifycheckbox(String emailyesno) {
		if (emailyesno.equalsIgnoreCase("yes") && emailverfificationcheckbox.isEnabled()) {
			emailverfificationcheckbox.click();
		} else if (emailverfificationcheckbox.isSelected()) {
			emailverfificationcheckbox.click();
		}
	}

	public contactlookup lookupbuttonclick() {
		
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();",lookupbutton) ;
		 
		lookupbutton.click();

		return new contactlookup();
	}

	public void clickOnSavebutton() {
		int Savebtn1=Savebtn.size();
		System.out.println(Savebtn1);
		Savebtn.get(0).click();

	}

	// |Title|Status|DeadLine|State|Type|priority|AssignedTo|emailnotify|Contact|ontact|
	public CaseCreationpage newTaskCreation(String Title, String Status, String DeadLine, String State, String Type,
			String priority, String AssignedTo, String emailnotify, String contactmessage) throws InterruptedException {
		casseNo=getTaskNo();
		
		setTitle(Title);
		DeadlineSelection(DeadLine);
		state(State);
		status(Status);
		Type(Type);
		priority(priority);
		AssignedTo(AssignedTo);

		emialNotifycheckbox(emailnotify);
		lookupbuttonclick();
		contactlookupObj = new contactlookup();
		contactlookupObj.contactLookupsearch(contactmessage);
		contactlookupObj.contactLookupTableSecletion(contactmessage);
		
		clickOnSavebutton();
		return new CaseCreationpage();
	}
}
