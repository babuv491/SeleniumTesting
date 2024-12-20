package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learn.selenium.util.Base;

public class HandleDropDown_Amazon {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Base.getDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in");

		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		
		search.sendKeys("laptop");
		
		Thread.sleep(3000);
		
		List<WebElement> elements = search.findElements(By.xpath("//div[@class='autocomplete-results-container']//span"));
		
		System.out.println("Total elements found:"+elements.size());
		
		for(int i=0;i<elements.size();i++) {
			WebElement webElement = elements.get(i);
			System.out.println("Dropdown Value:"+webElement.getText());
			if(webElement.getText().contains("apple")) {
				webElement.click();
				break;
			}
		}

	}
}
