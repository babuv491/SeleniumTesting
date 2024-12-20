package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learn.selenium.util.Base;

public class HandleDropDown_Google {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Base.getDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.co.in/");

		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.className("gLFyf"));
		
		if(search.isDisplayed()) {
			
			search.sendKeys("Hyderbad");
			Thread.sleep(3000);
			
			List<WebElement> dropdownValues = driver.findElements(By.xpath("((//div[@role='presentation' and @class='OBMEnb'])[1]//ul/li)//div[@class='wM6W7d']//span"));
			
			for(WebElement  dropdown: dropdownValues) {
				System.out.println(dropdown.getText());
				if(dropdown.getText().contentEquals("hyderabad weather today")) {
					dropdown.click();
					
					
				}
			}
		}

	}
}
