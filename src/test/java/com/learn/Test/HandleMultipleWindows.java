package com.learn.Test;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class HandleMultipleWindows {
	
	
	private static String javaXpath="//strong[contains(string(),'Java')]";
	
	private static String springbootXpath="//span[contains(string(),'Spring Boot')]";
	
	WebDriver driver = null;

	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}

	public static void printCurrentTime() {

		System.out.println(new Date());
	}
	
	
	@Test
	public void navigateToAnotherTab() throws InterruptedException {
		
		driver.get("https://www.javatpoint.com/");
		
		
		Base.scrollTillElementIsVisible(javaXpath);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(5000);	
		
		
		Base.clickElement(By.xpath(javaXpath));
		
		
		Base.waitForAnElement(driver, By.xpath(springbootXpath), 5, 500);
		
		
		Base.clickElement(By.xpath(springbootXpath));
		
		
		String parentWindowAddr = driver.getWindowHandle();
		
		System.out.println("parentWindowAddr:"+parentWindowAddr);
		
		System.out.println("Parent Title:"+driver.getTitle());
		
		Set<String> allOpenedTabs = driver.getWindowHandles();
		
		for(String tabAddress: allOpenedTabs) {
			
			System.out.println("tabAddress:"+tabAddress);
			
			if(!tabAddress.contains(parentWindowAddr)) {
				driver.switchTo().window(tabAddress);
				
				
				Base.clickElement(By.xpath("//img[@alt='python']"));
				System.out.println("Successfully clicked on Python tab");
				System.out.println("Title:"+driver.getTitle());
			}
			
		}
		
		
		Base.closeBrowser();
		
	}
}
