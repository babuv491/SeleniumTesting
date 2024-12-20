package com.learn.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class ImplicitWaitTest {

	WebDriver driver = null;

	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}
	
	public static void printCurrentTime() {
		
		System.out.println(new Date());
	}
	
	@Test
	public void testImplicitWait() {
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		printCurrentTime();
		
		driver.get("http://www.google.com");
		
		
		//Base.isElementDisplayed(By.xpath("//*[@id='santhosh']"));
		System.out.println(driver.findElement(By.xpath("//img[@alt='Google']")));
		
		printCurrentTime();
		
		//Base.isElementDisplayed(By.xpath("//*[@id='babu']"));
		
		try {
			System.out.println(driver.findElement(By.xpath("//img[@alt='bau']")));
		}catch(Exception e) {
			e.printStackTrace();
		}
		printCurrentTime();
		
		
		Base.closeBrowser();
	}

}
