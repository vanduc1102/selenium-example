package com.examples.seleniumrc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KyotokimonoRentalTest {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/duomnguyen/dev/chromedriver");
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

	@Test
	public void getAlertMessage() throws InterruptedException {
		WebElement checkBoxElement = driver
				.findElement(By.xpath(".//*[@id='formAddPlan']/div[1]/div/ul/li[1]/div[3]/div[2]/div[1]/a"));
		checkBoxElement.click();
		Thread.sleep(500);

		Alert alert = driver.switchTo().alert();

		// Get the text of the alert or prompt
		String message = alert.getText();
		System.out.println("The message is : " + message);

		// And acknowledge the alert (equivalent to clicking "OK")
		alert.accept();
		Assert.assertEquals("男性か女性、いずれか1名以上選択してください", message);

	}

	@Test
	public void calendarSelectionTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Open first selectBox
		WebElement checkBoxElement = driver.findElement(By.id("list_plans_1SelectBoxItContainer"));
		checkBoxElement.click();

		// select 3 people
		WebElement itemElement3 = driver
				.findElement(By.xpath(".//*[@id='list_plans_1SelectBoxItOptions']/li[4]/a/span[2]"));
		itemElement3.click();

		WebElement nextButton = driver
				.findElement(By.xpath(".//*[@id='formAddPlan']/div[1]/div/ul/li[1]/div[3]/div[2]/div[1]/a"));
		nextButton.click();

		// Select second shop
		By selectedShopByCss = By.cssSelector("#choose-shop li.shop-6 label");
		wait.until(ExpectedConditions.elementToBeClickable(selectedShopByCss));
		WebElement secondShop = driver.findElement(selectedShopByCss);
		secondShop.click();

		// Select a date.
		WebElement dateElement = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@id='choose-date']/div[2]/div/table/tbody/tr[2]/td[4]/div/div")));
		dateElement.click();
		System.out.println("Clicked element " + dateElement.getText());

	}
}
