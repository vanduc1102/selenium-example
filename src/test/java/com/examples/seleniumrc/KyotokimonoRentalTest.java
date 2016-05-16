package com.examples.seleniumrc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KyotokimonoRentalTest {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\TODO\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kyotokimono-rental.com/reserve");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void fisrtSelectBox() throws InterruptedException {
		
		WebElement checkBoxElement = driver.findElement(By.id("list_plans_1SelectBoxItContainer"));
		checkBoxElement.click();
		Thread.sleep(500);
		
		WebElement itemElement3 = driver
				.findElement(By.xpath(".//*[@id='list_plans_1SelectBoxItOptions']/li[4]/a/span[2]"));
		itemElement3.click();
		Thread.sleep(500);
		
		WebElement resultElement = driver.findElement(By.xpath(".//*[@id='list_plans_1SelectBoxItText']/span[1]"));
		String textResult = resultElement.getText();
		
		System.out.println("The text result is : " + textResult);
		Assert.assertEquals("3", textResult);
	}
}
