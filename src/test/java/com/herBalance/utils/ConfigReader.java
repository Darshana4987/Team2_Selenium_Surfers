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
			fis = new FileInputStream("src/test/resources/config.properties");

			prop = new Properties();
			try {
				prop.load(fis);
			
				property.set(prop);
				
				if (getBrowserType() == null || getBrowserType().isEmpty()) {
					setBrowserType(property.get().getProperty("browser"));
				}
		
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Config properties file not found");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	public static String getUsername() {
		return property.get().getProperty("userName");

	}

	public static String getPassword() {
		return prop.getProperty("password");
	}

	public static String getUrl() {
		return property.get().getProperty("url");

	}
	public static String getUseremail() {
		return property.get().getProperty("useremail");
	}
	public static String getpassword1() {
		return property.get().getProperty("password1");
	}
	public static String getpassword2() {
		return property.get().getProperty("password2");
	}
	
	public static String getTestDataPath() {
		return property.get().getProperty("test_data_path");
	}
	
	public static String getBrowserType() {
		if (browserType == null) {
			browserType = property.get().getProperty("browser");

		}
		return browserType;
	}

	public static void setBrowserType(String browser) {
		if (browser != null && !browser.isBlank())
			browserType = browser;
	}

}
