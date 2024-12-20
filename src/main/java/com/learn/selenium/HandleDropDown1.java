package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learn.selenium.util.Base;

public class HandleDropDown1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Base.getDriver();

		driver.manage().window().maximize();

		driver.get("https://www.linkedin.com/");

		Thread.sleep(3000);

		WebElement login = driver.findElement(By.xpath("(//a[contains(string(),'Sign in')])[1]"));

		login.click();

		Thread.sleep(3000);

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("babuv491@gmail.com");

		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("******");

		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();

		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@aria-label='Recent']"));

		for (WebElement element : elements) {
			System.out.println("Each Value:" + element.getText());
		}
		
		System.out.println("Done");

	}
}
