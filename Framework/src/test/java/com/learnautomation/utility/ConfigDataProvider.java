package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties properties;

	public ConfigDataProvider() {

		File file = new File("./Configuration/Config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to read property file" + e.getMessage());
			e.printStackTrace();
		}
	}

	public String getDataFromConfig(String keyToSearch) {
		String keytoSearch = properties.getProperty(keyToSearch);
		return keytoSearch;

	}

	public String getBrowser() {
		String browser = properties.getProperty("Browser");
		return browser;

	}

	public String getURL() {
		String URL = properties.getProperty("qaURL");
		return URL;

	}

}
