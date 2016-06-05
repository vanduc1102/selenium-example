package com.examples.seleniumrc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	private PropertyReader() {

	}

	public static String getValue(String key) {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			
			String filePath = "src" + File.separator + "config.properties";
			input = new FileInputStream(filePath);
			prop.load(input);
			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}