package com.training.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver driver;
	static CommonUtilities common = new CommonUtilities();
	
	public static void launchApplication(String browser) throws IOException {
		driver = getDriver(browser);
		String url = common.getProperty("url");
		driver.get(url);
	}
	
	public static WebDriver getDriver(String browser) {
		if (driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		
		return driver;
	}
		
}
