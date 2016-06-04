package com.examples.seleniumrc.util;

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
		if(ElementHelperSingleton.elementHelperSingleton == null){
		    return new ElementHelperSingleton(driver);
		}
		return ElementHelperSingleton.elementHelperSingleton;
	}

	/**
	 * Get WebElement by xpath
	 * 
	 * @param xpath
	 * @return
	 */
	public WebElement getElementByXpath(String xpath) {
		return this.driver.findElement(By.xpath(xpath));
	}

	/**
	 * Get WebElement by id
	 * 
	 * @param id
	 * @return
	 */
	public WebElement getElementById(String id) {
		return this.driver.findElement(By.id(id));
	}

	/**
	 * Get WebElement by cssSelector
	 * 
	 * @param cssSelector
	 * @return
	 */
	public WebElement getElementByCssSelector(String cssSelector) {
		return this.driver.findElement(By.cssSelector(cssSelector));
	}

}