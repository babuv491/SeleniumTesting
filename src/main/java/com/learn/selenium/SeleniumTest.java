package com.learn.selenium;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

	WebDriver driver = null;

	public void setBrowserName(String browerName) {

		/*
		 * switch (browerName) {
		 * 
		 * case "chrome": driver = new ChromeDriver(); break; case "edge": driver = new
		 * EdgeDriver(); break; case "firefox": driver = new FirefoxDriver(); break;
		 * 
		 * }
		 */

		if (browerName.contentEquals("chrome")) {
			driver = new ChromeDriver();

		} else if (browerName.contentEquals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browerName.contentEquals("edge")) {
			driver = new EdgeDriver();

		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		SeleniumTest obj = new SeleniumTest();

		// System.out.print("Enter Browser Name:");
		Scanner scanner = new Scanner(System.in);
		obj.setBrowserName("chrome");

		// System.setProperty("webdriver.chrome.driver","chromedriver.exe");

		obj.driver.get("http://www.linkedin.com");

		obj.driver.manage().window().maximize();

		System.out.println("Current URL:" + obj.driver.getCurrentUrl());

		System.out.println("Ttitle:" + obj.driver.getTitle());

		// System.out.println("Page Source:\n"+obj.driver.getPageSource());

		Cookie cookie1 = new Cookie("name", "santhosh");

		obj.driver.manage().addCookie(cookie1);

		// obj.driver.manage().deleteAllCookies();

		Set<Cookie> cookies = obj.driver.manage().getCookies();

		for (Cookie cookie : cookies) {

			System.out.println("Cookie Name:" + cookie.getName());
			System.out.println("Cookie Value:" + cookie.getValue());
		}

		List<WebElement> elements = obj.driver.findElements(By.xpath("//span[contains(text(),'Jobs')]"));

		System.out.println(elements.size());
		
		for(WebElement element: elements) {
			
			if(element.isDisplayed()) {
				element.click();
			}
		}

		/*
		 * WebElement jobElement =
		 * obj.driver.findElement(By.xpath("//span[contains(text(),'Jobs')]"));
		 * 
		 * System.out.println("isDisplayed:" + jobElement.isDisplayed());
		 * System.out.println("isEnabled:" + jobElement.isEnabled());
		 * System.out.println("isSelected:" + jobElement.isSelected());
		 * 
		 * if(jobElement.isDisplayed()) { jobElement.click(); }
		 */

		// obj.driver.close();

		System.out.println("Success");

	}
}
