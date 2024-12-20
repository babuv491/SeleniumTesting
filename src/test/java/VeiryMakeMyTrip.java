

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

public class VeiryMakeMyTrip {

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

	@Test(testName = "Verifying HomePage in Make My Trip Website", description = " to make sure when page opens it should populate login/signup popup")
	public void verifyMMTHomePage() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		// WebDriver driver = Base.getDriver();

		// driver=null;

		Assert.assertNotNull(driver, " Driver Object is null");

		driver.get("https://www.makemytrip.com/");

		Thread.sleep(3000);

		WebElement login = driver.findElement(By.xpath("//p[text()='Login or Create Account']"));

		softAssert.assertTrue(login.isDisplayed(), "Login Link is not visible");

		softAssert.assertAll();

	}
	
	
	@DataProvider(name="myNumbers")
	public Object[][] customerNumbers(){
		return new Object[][] {{"9490323041"},{"8324234435"},{"1234567890"}};
	}
	
	@DataProvider(name="myemailids")
	public Object[][] myemails(){
		return new Object[][] {{"babu@gmail.com"},{"santhosh@wipro.com"},{"hey@bt.com"}};
	}
	

	@Test(dataProvider = "myNumbers")
	public void verifyLoginBtnInMMT(String mobileNumber) throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		// WebDriver driver = Base.getDriver();

		// driver=null;

		Assert.assertNotNull(driver, " Driver Object is null");

		driver.get("https://www.makemytrip.com/");

		Thread.sleep(9000);

		WebElement popup = Base.findDomElement(By.xpath("//span[@class='commonModal__close']"));

		// WebElement popup =
		// driver.findElement(By.xpath("//span[@class='commonModal__close']"));

		softAssert.assertNotNull(popup, " Close Popup is not visible");

		if (popup != null && popup.isDisplayed()) {

			popup.click();
			System.out.println("Closed popup successfully");
		}

		Thread.sleep(2000);

		WebElement domElement = Base.findDomElement(By.id("babu"));

		softAssert.assertNotNull(domElement, "Id with Babu is not visible");

		WebElement login = driver.findElement(By.xpath("//p[text()='Login or Create Account']"));

		softAssert.assertTrue(login.isDisplayed(), "Login Link is not visible");

		login.click();

		Thread.sleep(3000);

		WebElement number = driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']"));

		softAssert.assertTrue(number.isDisplayed(), "Enter Mobile Number textbox is not visible");

		number.sendKeys(mobileNumber);

		softAssert.assertAll();

	}

	@Test
	@Parameters("inputDate")
	public void verifyDate(String inputDate) throws InterruptedException {

		// (//div[@class='DayPicker-Month'][1]//div)[1]//div
		SoftAssert softAssert = new SoftAssert();

		driver.get("https://www.makemytrip.com/");

		Thread.sleep(9000);
		WebElement popup = Base.findDomElement(By.xpath("//span[@class='commonModal__close']"));

		// WebElement popup =
		// driver.findElement(By.xpath("//span[@class='commonModal__close']"));

		softAssert.assertNotNull(popup, " Close Popup is not visible");

		if (popup != null && popup.isDisplayed()) {

			popup.click();
			System.out.println("Closed popup successfully");
		}

		Thread.sleep(2000);

		Base.clickElement(By.xpath("//label[@for='departure']"));

		Thread.sleep(2000);

		WebElement leftDate = driver.findElement(By.xpath("(//div[@class='DayPicker-Month'][1]//div)[1]//div"));

		while (!leftDate.getText().contains(inputDate)) {
			System.out.println("leftDate:" + leftDate.getText());
			Base.clickElement(By.xpath("//span[@aria-label='Next Month']"));
			Thread.sleep(2000);
			leftDate = driver.findElement(By.xpath("(//div[@class='DayPicker-Month'][1]//div)[1]//div"));
		}

	}

}
