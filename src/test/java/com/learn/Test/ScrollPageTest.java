package com.learn.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class ScrollPageTest {

	private static String upload = "((//button)//span//span)[string()='Upload a file']";

	WebDriver driver = null;

	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}

	@Test
	public void testNavigationMethods() throws InterruptedException, AWTException {

		// System.setProperty("org.openqa.selenium.edge.EdgeDriver", "");

		driver.get("https://www.grammarly.com/plagiarism-checker");

		System.out.println("Upload BUtton visible before scroll ?:" + Base.isElementDisplayed(By.xpath(upload)));

		Base.scrollTillElementIsVisible(upload);

		/*
		 * if
		 * (Base.isElementDisplayed(By.xpath("(//a[contains(text(),'AI Detector ')])[1]"
		 * ))) { System.out.println("Element Found hence clicking");
		 * Base.clickElement(By.xpath("(//a[contains(text(),'AI Detector ')])[1]")); }
		 * else {
		 * 
		 * System.out.println("Element not found"); }
		 */

		Thread.sleep(3000);

		System.out.println("Upload BUtton visible after scroll ?:" + Base.isElementDisplayed(By.xpath(upload)));
		if (Base.isElementDisplayed(By.xpath(upload))) {

			Base.clickElement(By.xpath(upload));
			fileUpload("w3schools.html");

		}
		
		

		Thread.sleep(5000);

	}

	public void fileUpload(String filePath) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		StringSelection fileName = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileName, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("Success");

	}

}
