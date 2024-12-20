package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.learn.selenium.util.Base;

public class HandleDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Base.getDriver();

		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		Thread.sleep(3000);

		WebElement dropdownElement = driver.findElement(By.id("course"));

		if (dropdownElement.isDisplayed()) {
			System.out.println("Dropdown is visible");

			Select courseName = new Select(dropdownElement);

			courseName.selectByIndex(2);

			Thread.sleep(3000);

			List<WebElement> options = courseName.getOptions();

			for (WebElement element : options) {
				System.out.println("Option Name:" + element.getText());
				if (element.getText().contentEquals("Python")) {
					courseName.selectByVisibleText(element.getText());

				}
			}

			Thread.sleep(3000);
			if (!courseName.getFirstSelectedOption().getText().contentEquals("Python"))
				courseName.selectByValue("js");
			else
					System.out.println("Python is already selected");

		} else {
			System.out.println("Dropdown is not visible");
		}

	}
}
