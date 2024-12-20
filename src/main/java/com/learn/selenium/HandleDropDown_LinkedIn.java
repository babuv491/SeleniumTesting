package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learn.selenium.util.Base;

public class HandleDropDown_LinkedIn extends Base {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = getDriver();

		driver.manage().window().maximize();

		driver.get("https://www.linkedin.com/");

		Thread.sleep(3000);
		
		Base.clickElement(By.xpath("(//a[contains(text(),'Sign in') and @class='nav__button-secondary btn-secondary-emphasis btn-md'])"));
		
		Thread.sleep(3000);
		
		Base.enterValue(By.id("username"), "babuv491@gmail.com");
		
		Base.enterValue(By.id("password"), "Intel@oct2024");
		
		driver.findElement(By.xpath("//button[@aria-label='Sign in']")).click();
		
		Thread.sleep(5000);
		
		Base.clickElement(By.xpath("//input[@placeholder='Search']"));
		
		Thread.sleep(3000);
		
		List<WebElement> dropdown = driver.findElements(By.xpath("//div[@aria-label='Recent']"));
		
		System.out.println("Total Visible Size:"+dropdown.size());
		for(WebElement element : dropdown) {
			
			System.out.println(element.getText()+":"+element.getText().contains("tata consultancy services"));
			
			if(element.getText().contains("tata consultancy services")) {
				element.click();
				
			}
		}
		
		//driver.close();
		
		
		
	}
}
