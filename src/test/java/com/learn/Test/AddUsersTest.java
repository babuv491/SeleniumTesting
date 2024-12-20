package com.learn.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learn.selenium.util.Base;

import model.User;

public class AddUsersTest {

	WebDriver driver = null;

	@BeforeClass
	public void beforeClassTest() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void initilize() {
		System.out.println("Before method");
		driver = Base.getDriver();
	}

	@AfterMethod
	public void closeDriver() throws IOException {
		System.out.println("After method");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotAs, new File("screenshots/screen_" + new Date().getTime() + ".jpg"));

		System.out.println("Screenshot taken successfully");

	}

	@AfterClass
	public void afterClassTest() {
		System.out.println("After Class");
		driver.quit();
	}

	@DataProvider(name = "users")
	public Object[][] customerNumbers() {
		
		return new Object[][] { 
			
			{ new User("santhosh", "wipro", "santhosh@gmail.com", "santhosh") },
				
			{ new User("hi", "tcs", "tcs@gmail.com", "tcs") }, 
			
			{new User ("wipro", "ceo", "wipro@gmail.com", "wipro" )} };
	}

	@Test(dataProvider = "users")
	public void addUsers(User user) throws InterruptedException {

		System.out.println("fName:" + user.getFirstName() + " , lName: " + user.getLastName() + " , email: " + user.getEmail() + " , password: " + user.getPassword());

		SoftAssert softAssert = new SoftAssert();

		driver.get("http://localhost:8080/register");

		Thread.sleep(9000);

		boolean fNameVisibility = Base.isElementDisplayed(By.id("firstName"));

		softAssert.assertTrue(fNameVisibility, " Unable to find First Name within DOM");

		if (fNameVisibility) {
			Base.enterValue(By.id("firstName"), user.getFirstName());
		}

		boolean lNameVisibility = Base.isElementDisplayed(By.id("lastName"));

		softAssert.assertTrue(lNameVisibility, " Unable to find Last Name within DOM");

		if (lNameVisibility) {
			Base.enterValue(By.id("lastName"), user.getLastName());
		}

		boolean emailVisibility = Base.isElementDisplayed(By.id("email"));

		softAssert.assertTrue(emailVisibility, " Unable to find Email within DOM");

		if (emailVisibility) {
			Base.enterValue(By.id("email"), user.getEmail());
		}

		boolean passwordVisibility = Base.isElementDisplayed(By.id("password"));

		softAssert.assertTrue(fNameVisibility, " Unable to find password within DOM");

		if (passwordVisibility) {
			Base.enterValue(By.id("password"), user.getPassword());
		}

		Base.clickElement(By.xpath("//button[text()='Register']"));

		softAssert.assertTrue(Base.isElementDisplayed(By.xpath("//div[@class='alert alert-info']")),"Registration failed");
		
		if (Base.isElementDisplayed(By.xpath("//div[@class='alert alert-info']"))) {
			System.out.println("Successfully registered user :" + user.getFirstName() + " " + user.getLastName());
		}

		softAssert.assertAll();
		// Base.closeBrowser();

	}
	
	
	public SoftAssert performValidation(boolean flag,By xpath, String exceptionMsg, SoftAssert softAssert, User user) {
		softAssert.assertTrue(flag, exceptionMsg);
		if (flag) {
			Base.enterValue(xpath, user.getLastName());
		}
		return softAssert;
		
	}

}
