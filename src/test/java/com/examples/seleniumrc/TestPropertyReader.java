package com.examples.seleniumrc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.examples.seleniumrc.utils.PropertyReader;

public class TestPropertyReader {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readChromeDriver() throws InterruptedException {
		String testValue = PropertyReader.getValue("test");
		Assert.assertTrue("The value is 1", "1".equals(testValue));
	}

}
