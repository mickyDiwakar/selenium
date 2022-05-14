 package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.constant;
//css selector input[name^='pass'] //identify all which start with pass(prefix)
//css selector input[name$='pass'] //identify all which end with pass(sufix)
public class TestBase {
	public TestBase() {
		
	}
	
	public  WebDriver driver;
	public static Properties p;
	
	public WebDriver initializeDriver() throws IOException {
		
		  p = new Properties(); 
		  FileInputStream fis = new FileInputStream(  "C:\\selenium\\mavenproj\\src\\main\\java\\resources\\data.properties");
		  p.load(fis); 
		  String browser = p.getProperty("browser");
		 
		// browser select
		
		switch (browser.toLowerCase()) {
			case "chrome":
			
			/*
			 * System.setProperty("webdriver.chrome.driver", constant.CHROMEDRIVERPATH);
			 * driver = new ChromeDriver();
			 */
			
			
			  DesiredCapabilities cap=new DesiredCapabilities();
			  cap.setBrowserName("chrome"); cap.setPlatform(Platform.ANY); ChromeOptions
			  coption=new ChromeOptions(); coption.merge(cap); String
			  huburl="http://192.168.43.118:4444/wd/hub"; driver=new RemoteWebDriver(new
			  URL(huburl),coption);
			 
							
				break;
			case "firefox":
				
				//System.setProperty("webdriver.gecko.driver",
				//		System.getProperty(("user.dir") + "\\drivers\\New folder\\geckodriver.exe"));
				System.setProperty("webdriver.gecko.driver",constant.FFDRIVERPATH);
				driver = new FirefoxDriver();
			
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", constant.IEDRIVERPATH);
				driver = new InternetExplorerDriver();
				break;
			
				
						
		}
		driver.manage().timeouts().implicitlyWait(constant.IMPLICIT_WAIT, TimeUnit.SECONDS);// wait for 40 sec before loading fail of
																		// browser
		driver.manage().timeouts().pageLoadTimeout(constant.PAGELOADTIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	// Sceenshot method
	public  void TakesSnapshot(String stepName) throws IOException {
		/*
		 * File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * Date date = new Date(); String Datepattern = "YYYY-MM-DD_hh-mm-ss";
		 * SimpleDateFormat formatter = new SimpleDateFormat(Datepattern); String
		 * Dateformat = formatter.format(date); File destFile = new
		 * File("./ScreenShots/" + Dateformat + "_" + stepName + ".png");
		 * System.out.println(destFile); FileUtils.copyFile(srcFile, destFile);
		 */
	}
	//wait for an element to visible
	
	/*
	 * public static void WaitVisibilityOf( WebElement element,long waitTime) { try
	 * { WebDriverWait wait=new WebDriverWait(driver,waitTime);
	 * wait.until(ExpectedConditions.visibilityOf(element)); }catch(Exception e){
	 * Assert.assertTrue("element not found",false); }
	 * 
	 * }
	 */
	 
	//to click on any webelement
	public static void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	
	
	/*
	 * public static void main(String[] args) throws IOException { //TestBase tb=new
	 * TakesSnapshot("ji"); //tb.initializeDriver(); tb.TakesSnapshot(driver,
	 * "login"); }
	 */
	 
}
