package com.learn.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learn.selenium.util.Base;

public class NavigationTest {
WebDriver driver = null;
	
	
	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}
	
	
	@Test
	public void testNavigationMethods() throws InterruptedException {
		
		
		
		System.setProperty("org.openqa.selenium.edge.EdgeDriver", "");
		
		driver.get("https://www.google.co.in/");
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertTrue(Base.isElementDisplayed(By.xpath("//textarea[@title='Search']")),"Search textbox is not visible");
		
		softAssert.assertTrue(Base.isElementDisplayed(By.xpath("//textarea[@title='12345']")),"Search textbox doesnt exist in dom");
		
		
		Base.enterValue(By.xpath("//textarea[@title='Search']"), "Laptop");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//textarea[@title='Search']")).submit();
		
		Thread.sleep(3000);
		
		driver.navigate().to("https://youtube.com");
		Thread.sleep(3000);
		
		Base.enterValue(By.xpath("//input[@id='search']"), "testing");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='search']")).submit();
		Thread.sleep(5000);
		
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().refresh();
		
		
		
		softAssert.assertAll();
		
		
	}
}
