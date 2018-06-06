package com.org.UI5ExploredBasicStep.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.org.UI5ExploredBasicStep.util.LoadDrivers;

public class LoadDrivers {
	public WebDriver initiallizeChromeDriver(String url) {
		System.out.println("Initializing ChromeDriver");
		System.setProperty("webdriver.chrome.driver","E:/Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		return driver;
	} 
	public WebDriver openUrl(String url) {
		System.out.println("opening URL");
		WebDriver driver = this.initiallizeChromeDriver(url);
		return driver;
	}
}
