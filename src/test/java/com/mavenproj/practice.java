package com.mavenproj;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class practice {
	@Test(invocationCount = 1)
	public void practice1() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\SeleniumBDDFramework\\\\drivers\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement ele=driver.findElement(By.id("twotabsearchtextbox"));
		if(ele.isEnabled()) {
			ele.clear();
			//ele.sendKeys("Mob");
		}
		List<WebElement>l=driver.findElements(By.xpath("//div[@id=\"nav-xshop-container\"]/div/a"));
		for(WebElement e:l) {
			if(e.getText().equals("Home & Kitchen")) {
				System.out.println(e.getAttribute("href"));
				System.out.println(e.getCssValue("color"));
				String color=e.getCssValue("color");
				System.out.println(Color.fromString(color).asHex());
				
				e.click();
				
				break;
			}
		}
		
	}

}
