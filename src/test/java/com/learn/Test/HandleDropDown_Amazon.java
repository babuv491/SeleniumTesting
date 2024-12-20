package com.learn.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learn.selenium.util.Base;

@Test
public class HandleDropDown_Amazon {

	@Test
	public void calculation() {

		String str = "babu";

		String str1 = "babu1";

		// Assert.assertEquals(str, str1,"Invalid UserName");

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(str, str1, "Invalid UserName");

		System.out.println("successfully completed");

		softAssert.assertAll();

	}

	@Test
	public void multiplication() {

		System.out.println(5 * 6);

	}

	public void dropdown_Amazon() throws InterruptedException {

		WebDriver driver = Base.getDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in");

		Thread.sleep(3000);

		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));

		search.sendKeys("laptop");

		Thread.sleep(3000);

		List<WebElement> elements = search
				.findElements(By.xpath("//div[@class='autocomplete-results-container']//span"));

		System.out.println("Total elements found:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
			WebElement webElement = elements.get(i);
			System.out.println("Dropdown HTML:" + webElement);
			System.out.println("Dropdown Value:" + webElement.getText());
			if (webElement.getText().contains("apple")) {
				webElement.click();
				break;
			}
		}

	}
}
