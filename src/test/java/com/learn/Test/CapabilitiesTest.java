package com.learn.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.learn.selenium.util.Base;

public class CapabilitiesTest {
	WebDriver driver = null;
	
	
	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}
	
	
	@Test
	public void testNavigationMethods() throws InterruptedException {
		
		
		
		//System.setProperty("org.openqa.selenium.edge.EdgeDriver", "");
		
		driver.get("https://webcamtests.com/");
		
		
		System.out.println("Success");
		
	
		
		
	}
}
