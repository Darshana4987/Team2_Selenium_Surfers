package com.herBalance.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {
	
	public static ThreadLocal<Properties> property= new ThreadLocal<Properties>();

	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

	public ConfigReader() {
	Properties	properties = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			if (input == null) {
				throw new FileNotFoundException("config.properties file not found in resources");
			}
			properties.load(input);
			property.set(properties);
			logger.info("Config properties loaded");
		} catch (Exception e) {
			logger.error("Config not found: " + e.getMessage());
		}
	}

	public String getUsername() {
		return property.get().getProperty("username");
	}

	public String getPassword() {
		return property.get().getProperty("password");
	}

	public String getBrowser() {
		return property.get().getProperty("browser");
	}

	public void setBrowser(String value) {
		property.get().setProperty("browser", value);
	}

	public String getUrl() {
		return property.get().getProperty("url");

	}
	
	public String getHomeUrl() {
		return property.get().getProperty("Homeurl");

	}
	
	public String getLoginUrl() {
		return property.get().getProperty("Loginurl");

	}

}
