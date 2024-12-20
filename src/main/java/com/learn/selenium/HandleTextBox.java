package com.learn.selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learn.selenium.util.Base;

public class HandleTextBox {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = Base.getDriver();
		
		Base.driver = driver;
		
		driver.get("https://www.facebook.com/");
		
		WebElement element = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		
		
		System.out.println("Facebook Logo Displayed:"+element.isDisplayed());
		
		if(element.isDisplayed()) {
			
			Base.enterValue("//input[@id='email']", "santhosh@gmail.com");
			Base.enterValue("//input[@id='pass']", "santhosh");
			
			driver.findElement(By.xpath("//button")).click();
			
			Thread.sleep(15000);
			
			
			WebElement exceptionMsg = driver.findElement(By.xpath("//a[text()='Find your account and log in.']"));
			
			if(exceptionMsg.getText().contains("Find your account and log in")) {
				System.out.println("Test Case Passed successfully");
			}else {
				System.out.println("Test case Failed");
			}
			
		}
		
		
		
	}

}
