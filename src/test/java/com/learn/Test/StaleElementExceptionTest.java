package com.learn.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class StaleElementExceptionTest {

	
	WebDriver driver = null;

	@BeforeClass
	public void beforeClassTest() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void initilize() {
		System.out.println("Before method");
		driver = Base.getDriver();
	}

	
	@Test
	public void testStaleElementException() {
		
		
		driver.get("https://www.w3schools.com/");
		
		WebElement javascriptElement = driver.findElement(By.xpath("(//a[@title='JavaScript Tutorial' and text()='JAVASCRIPT'])"));
		
		System.out.println("Visibility:"+javascriptElement.isDisplayed());
		
		driver.navigate().refresh();
		
		
		try {
			javascriptElement.click();
		}catch(StaleElementReferenceException ex) {
			System.out.println("Exception Occured:"+ex.getMessage());
			javascriptElement = driver.findElement(By.xpath("(//a[@title='JavaScript Tutorial' and text()='JAVASCRIPT'])"));
			
			javascriptElement.click();
		}
		
	}
}
