package com.herBalance.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {

	private static Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	private static String browserType = null;
	private static Properties prop;

	public static void loadProperties() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config.properties");

			prop = new Properties();
			try {
				prop.load(fis);

				if (getBrowserType() == null || getBrowserType().isEmpty()) {
					setBrowserType(prop.getProperty("browser"));
				}

			} catch (IOException e) {
				logger.error("Unable to load config properities. {}", e.getMessage());
				throw new RuntimeException("Unable to load config properties file.");
			}
		} catch (FileNotFoundException e) {
			logger.error("Config properties file not found. {}", e.getMessage());
			throw new RuntimeException("Config properties file not found.");
		}
	}

	public static String getUsername() {
		return prop.getProperty("userName");
	}

	public static String getPassword() {
		return prop.getProperty("password");
	}

	public static String getUrl() {
		return prop.getProperty("url");
	}

	 public static String getLaunchUrl() {
	        return prop.getProperty("launchUrl");

	    }
	public static String getUseremail() {
		return prop.getProperty("useremail");
	}

	public static String getpassword1() {
		return prop.getProperty("password1");
	}

	public static String getpassword2() {
		return prop.getProperty("password2");
	}

	public static String getTestDataPath() {
		return prop.getProperty("test_data_path");
	}

	public static String getBrowserType() {
		return browserType;
	}

	public static void setBrowserType(String browser) {
		if (browser != null && !browser.isBlank())
			browserType = browser;
	}
}