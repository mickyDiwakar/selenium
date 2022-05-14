package com.mavenproj;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.loginToCrm;
import resources.TestBase;
import utilities.excelUtilities;

public class CRM extends TestBase {
	public  String fileName;
	public String sheetName;
	@BeforeTest
	public void beofretest() {
		System.out.println("test start");
	}
	@DataProvider
	public Object[] getTestData() throws FileNotFoundException {
		System.out.println(fileName);
		Object[][] data=excelUtilities.getData(fileName, sheetName);
		return data;
		
	}
	
  @Test(priority=1)
  public void getlogin() throws IOException, InterruptedException {
	  initializeDriver();
	  driver.get(p.getProperty("crmurl"));
	 loginToCrm ltc=new loginToCrm();
	  ltc.getEmail().sendKeys("micky.diwakar@gmail.com");
	  ltc.getPassword().sendKeys("Crm@12345");
	  ltc.clickLogin().click(); 
	  Assert.assertTrue(true);
	  
	  WebDriverWait wait=new WebDriverWait(driver, 5000);
	  String loc="//a[@href='/deals']/span";
	  driver.findElement(By.xpath(loc));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
		driver.findElement(By.xpath(loc)).click();
		driver.findElement(By.xpath("//a[@href='/deals/new']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='ui toggle checkbox']")).click();
		Set<String>handle=driver.getWindowHandles();
		List<String>tab=new ArrayList<String>(handle);
		String parentwindow=tab.get(0);
		String pagetitle=driver.switchTo().window(parentwindow).getTitle();
		System.out.println("parent tab is :"+pagetitle);
		//driver.switchTo().window(tab.get(1));
	
		

	 
  }
  @Test(priority=2,enabled=false)
  public void googlesearch() throws IOException {
	  driver=initializeDriver();
	  driver.get("https://google.com");
  }
  @AfterTest
  public void teardown() {
	  System.out.println("test end");
  }
  
}
