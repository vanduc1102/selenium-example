package com.examples.seleniumrc.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHelperSingleton {
	private WebDriver driver;
	private static ElementHelperSingleton elementHelperSingleton;

	private ElementHelperSingleton() {

	}

	private ElementHelperSingleton(WebDriver driver) {
		this.driver = driver;
	}

	public static ElementHelperSingleton getInstance(WebDriver driver) {
		if (driver == null) {
			throw new RuntimeException(
					"Cannot create new elementHelper with empty driver.");
		}
		if (ElementHelperSingleton.elementHelperSingleton == null) {
			return new ElementHelperSingleton(driver);
		}
		return ElementHelperSingleton.elementHelperSingleton;
	}

	/**
	 * Get WebElements by xpath
	 * 
	 * @param xpath
	 * @return
	 */
	public List<WebElement> findElementsByXpath(String xpath) {
		return this.driver.findElements(By.xpath(xpath));
	}

	/**
	 * Get WebElement by xpath
	 * 
	 * @param xpath
	 * @return
	 */
	public WebElement findElementByXpath(String xpath) {
		return this.driver.findElement(By.xpath(xpath));
	}

	/**
	 * Get WebElement by id
	 * 
	 * @param id
	 * @return
	 */
	public WebElement findElementById(String id) {
		return this.driver.findElement(By.id(id));
	}

	/**
	 * Get WebElement by cssSelector
	 * 
	 * @param id
	 * @return
	 */
	public WebElement findElementByCssSelector(String cssSelector) {
		return this.driver.findElement(By.cssSelector(cssSelector));
	}

	/**
	 * Get WebElements by cssSelector
	 * 
	 * @param cssSelector
	 * @return
	 */
	public List<WebElement> findElementsByCssSelector(String cssSelector) {
		return this.driver.findElements(By.cssSelector(cssSelector));
	}

	/**
	 * Get WebElement class by xpath
	 * 
	 * @param cssSelector
	 * @return
	 */
	public String getElementClassByXpath(String xpath) {
		WebElement webElement = this.findElementByXpath(xpath);
		return webElement.getAttribute("class");
	}

	/**
	 * Get WebElement attribute by xpath
	 * 
	 * @param cssSelector
	 * @return
	 */
	public String getElementAttributeByXpath(String xpath, String attribute) {
		WebElement webElement = this.findElementByXpath(xpath);
		return webElement.getAttribute(attribute);
	}

	/**
	 * Get WebElement class by id
	 * 
	 * @param cssSelector
	 * @return
	 */
	public String getElementClassById(String id) {
		WebElement webElement = this.findElementById(id);
		return webElement.getAttribute("class");
	}

	/**
	 * Get WebElement class by cssSelector
	 * 
	 * @param cssSelector
	 * @return
	 */
	public String getElementClassByCss(String cssSelector) {
		WebElement webElement = this.findElementByCssSelector(cssSelector);
		return webElement.getAttribute("class");
	}

}