package com.learn.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class AlertTest {

	WebDriver driver = null;
	
	
	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}
	
	
	@Test
	public void testAlerts() throws InterruptedException {
		
		
		driver.get("file:///D:/ws/santhosh/SeleniumTesting/alert.html");
		
		//driver.switchTo().frame("iframeResult");
		
		Base.clickElement(By.tagName("button"));
		
		
		
		String text = driver.switchTo().alert().getText();
		Thread.sleep(5000);
		System.out.println("Alert box text:"+text);
		if(text.contains("director")) {
			driver.switchTo().alert().accept();//alert display Ok
		}else {
			driver.switchTo().alert().dismiss();//cancel
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	
}
