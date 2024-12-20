package com.learn.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learn.selenium.util.Base;

public class IFrameTest {

	WebDriver driver = null;
	
	
	@BeforeClass
	public void beforeClassTest() {
		driver = Base.getDriver();
	}
	
	
	@Test
	public void testIframe() throws InterruptedException {
		
		
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows");
		
		Base.clickElement(By.xpath("//li[text()='iFrame']"));
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("globalSqa");
		
		//Base.clickElement(By.xpath("//input[@id='s']"));
		Base.enterValue(By.xpath("//input[@id='s']"), "Testing");
		
		driver.findElement(By.tagName("button")).click();
		
		Thread.sleep(3000);
		
		
		driver.switchTo().parentFrame();// immediate parent of current iframe
		
		Base.clickElement(By.xpath("(//a[text()='About'])[1]"));
		
		
		//driver.switchTo().defaultContent();//main parent or top parent
		
		//main.html	driver.switchTo("inner1")
			//inner1.html driver.switchTo("inner2")
				//inner2.html
		
		
	}
	
	
}
