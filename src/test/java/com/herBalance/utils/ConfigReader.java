package com.herBalance.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static ThreadLocal<Properties> property = new ThreadLocal<Properties>();
	private static String browserType = null;
	public static Properties prop;

	public static void loadProperties() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config/config.properties");
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Config properties file not found");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	public static String getUsername() {
		return property.get().getProperty("username");
	}

	public static String getPassword() {
		return property.get().getProperty("password");
	}

	public static String getBrowserType() {
		return browserType;
	}

	public static void setBrowserType(String browser) {
		if (browser != null && !browser.isBlank())
			browserType = browser;
	}

	public static String getUrl() {
		return property.get().getProperty("url");

	}

}
