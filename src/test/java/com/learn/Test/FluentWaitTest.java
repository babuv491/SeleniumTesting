package com.learn.Test;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class FluentWaitTest {

	WebDriver driver = null;

	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}

	public static void printCurrentTime() {

		System.out.println(new Date());
	}

	@Test
	public void testFluientWait() {

		printCurrentTime();
		driver.get("http://www.google.com");

		System.out.println(driver.findElement(By.xpath("//img[@alt='Google']")));

		printCurrentTime();

		try {
			System.out.println(driver.findElement(By.xpath("//img[@alt='santhosh']")));

		} catch (Exception e) {
			e.printStackTrace();
		}

		printCurrentTime();

		try {
			Base.waitForAnElement(driver, By.xpath("//img[@alt='babu']"), 20, 5);
		} catch (Exception e) {
			
		}
		printCurrentTime();

		Base.closeBrowser();
	}
}
