package com.learn.Test;

import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class ExplicitWaitTest {

	WebDriver driver = null;

	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}

	public static void printCurrentTime() {

		System.out.println(new Date());
	}

	@Test
	public void testExplicitWait() {

		WebDriverWait webDWait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class)
				.ignoring(NullPointerException.class)
				;

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
			webDWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='bau']")));

		} catch (Exception e) {
			e.printStackTrace();
		}

		printCurrentTime();

		Base.closeBrowser();
	}
}
