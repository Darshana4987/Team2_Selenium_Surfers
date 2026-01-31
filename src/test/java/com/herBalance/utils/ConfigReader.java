package com.herBalance.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {

	private static ThreadLocal<Properties> property = new ThreadLocal<Properties>();
	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	private static String browserType = null;

	public void loadProperties() {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			Properties properties = new Properties();
			if (input == null) {
				throw new FileNotFoundException("config.properties file not found in resources");
			}
			properties.load(input);
			property.set(properties);

			if (getBrowserType() == null || getBrowserType().isEmpty()) {
				setBrowserType(property.get().getProperty("browser"));
			}
			logger.info("Config properties loaded");
		} catch (Exception e) {
			logger.error("Config not found: " + e.getMessage());
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
