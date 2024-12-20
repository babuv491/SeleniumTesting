package com.learn.selenium.util;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

public class Base {
	public static WebDriver driver = null;

	public static ChromiumOptions setBrowserOptions(ChromiumOptions options) {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setVersion("");
		// ChromeOptions options = new ChromeOptions();

		Map<String, Object> contentSettings = new HashMap<>();
		Map<String, Object> profile = new HashMap<>();
		Map<String, Object> preferences = new HashMap<>();

		// Set Chrome Options
		// 0- Default , 1- Allow, 2- Block
		contentSettings.put("geolocation", 2);
		profile.put("managed_default_content_settings", contentSettings);

		preferences.put("profile", profile);

		options.setExperimentalOption("prefs", preferences);
		// options.addArguments("--incognito");
		// options.addArguments(Arrays.asList("disable-infobars",
		// "ignore-certificate-errors",
		// "start-maximized","use-fake-ui-for-media-stream"));

		return options;
	}

	public void setBrowserName(String browerName) {

		switch (browerName) {
		case "chrome": {

			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver((ChromeOptions) setBrowserOptions(options));
			break;
		}
		case "edge":
			ChromiumOptions<EdgeOptions> options = new EdgeOptions();
			driver = new EdgeDriver((EdgeOptions) setBrowserOptions(options));
			break;
		case "firefox":

			driver = new FirefoxDriver();
			break;
		default: {

			driver = new ChromeDriver();

		}
		}
	}

	public static WebDriver getDriver() {

		// driver = (driver == null ? new ChromeDriver() : driver);

		new Base().setBrowserName("chrome");

		driver.manage().window().maximize();
		return driver;
	}

	public static void enterValue(String xpath, String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}

	public static void enterValue(By xpath, String data) {
		driver.findElement(xpath).sendKeys(data);
	}

	public static void clickElement(By xpath) {
		driver.findElement(xpath).click();
	}

	public static boolean isElementDisplayed(By xpath) {

		List<WebElement> elements = driver.findElements(xpath);
		if (elements.size() > 0) {
			return elements.get(0).isDisplayed();
		}

		return false;

	}

	public static WebElement findDomElement(By xpath) {
		WebElement element = null;
		try {
			element = driver.findElement(xpath);
		} catch (NoSuchElementException exception) {
			System.out.println("Exception occured:" + exception.getMessage());
		}

		return element;
	}

	public static void scrollTillElementIsVisible(String inputXpath) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int count = 0;
		while (!isElementDisplayed(By.xpath(inputXpath))) {
			System.out.println("Scrolling time :" + count);
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(3000);
			count++;
		}

	}

	public static void closeBrowser() {
		System.out.println("Closing Browser");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();;

		System.out.println("Successfully Closed browser");
	}

	public static WebElement waitForAnElement(WebDriver driver, By locator, int timeout, int polling) {

		FluentWait<WebDriver> explicitWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(polling))
				.ignoring(NoSuchElementException.class);

		WebElement element = explicitWait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return driver.findElement(locator);
			}

		});

		return element;
	}

}
