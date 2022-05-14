package stepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.automationpracticePage;
import pageObjects.flightHomePage;
import resources.TestBase;
import utilities.constant;



public class masterHooks extends TestBase  {
	
	public WebDriver driver;
	//Navigate to "http://automationpractice.com/index.php"
	@Before("@automationpractice")
	public void setUpautomationpractice() throws IOException {
		driver=new TestBase().initializeDriver();
		//driver = initializeDriver();
		new automationpracticePage(driver).naviagteToPracticeURL();
		
	}

	@After("@automationpractice") 
	public  void tearDownautomationpractice(Scenario scenario) throws IOException {
		/*
		 * if(scenario.isFailed()) {
		 * //System.out.println("scenario name os"+scenario.toString());
		 * System.out.println("scnarioname="+scenario.getName());
		 * 
		 * TakesSnapshot(scenario.getName().toString()); }
		 */
		// scenario.
			//scenario.log(scenario.getName()+"tear down");;
		  if(scenario.isFailed())
			
			  { byte[] screenshot = ((TakesScreenshot)
			  driver).getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot,
			  "image/png", scenario.getName());
			  
			  
			  }
			 
		  if (driver!=null) {
				driver.quit();
			}
		
	}
	//air aissa site
	
	  @Before("@airAsia1")
	  public void setUpairAsia() throws IOException { 
		  //driver= initializeDriver(); 
	  driver = new TestBase().initializeDriver(); 
	  new flightHomePage(driver).getflightUrl();
	  }
	  
	  @After ("@airAsia1") 
	  public void tearDownairAsia()
	  { if (driver!=null) {
			driver.quit();
		} }
	 
	  @Before("@travel" )
		public  void setUpnewtour() throws IOException  {
			//driver = initializeDriver();
			driver = new TestBase().initializeDriver();
		  
			
		}
		@After ("@travel")
		public  void tearDownnewtout(Scenario scenario) {
		//scenario.log("test is in tear down");
		  if(scenario.isFailed()) { byte[] screenshot = ((TakesScreenshot)
		  driver).getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot,
		  "image/png", scenario.getName()); //scenario.embed(data, mediaType);
		  }
		 
			if (driver!=null) {
				driver.quit();
			}
			
		}
		public WebDriver getdriver() {
			return driver;
			
		}
		
		
		 @Before("@E2ETest")
			public void setUpCrm() throws IOException {
				//driver = initializeDriver();
				driver = new TestBase().initializeDriver();
				
				
			}
			@After ("@E2ETest")
			public  void tearDownCrm() {
				if (driver!=null) {
					driver.quit();
				}
			}

			@Before("@CRM")
			public void setUpCrm1() throws IOException {
				//driver = initializeDriver();
				driver=initializeDriver();
				driver.get(p.getProperty("crmProUrl"));
				
			}
			@After ("@CRM")
			public  void tearDownCrm1(Scenario scenario) {
				if(scenario.isFailed()) { byte[] screenshot = ((TakesScreenshot)
						  driver).getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot,
						  "image/png", scenario.getName()); //scenario.embed(data, mediaType);
						  }
						 
							if (driver!=null) {
								driver.close();
							}
			}
			
			
			
			
}
