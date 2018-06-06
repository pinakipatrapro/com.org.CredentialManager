package com.org.UI5ExploredBasicStep;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.UI5ExploredBasicStep.util.LoadDrivers;
import com.org.UI5ExploredBasicStep.util.ElementHelper;

public class CreateTest {
	static LoadDrivers drivers = new LoadDrivers();
	private static final WebDriver wd = drivers.openUrl("http://127.0.0.1:5500/LocalStorage/WebContent/index.html");;
	private static final ElementHelper eh = new ElementHelper();
	String randGenStr;
	
	//Generate random string
	public String randomString(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		  Random rand = new Random();
		  StringBuilder buf = new StringBuilder();
		  for (int i=0; i<length; i++) {
		    buf.append(chars.charAt(rand.nextInt(chars.length())));
		  }
		  return buf.toString();
		}
	
	@Test(priority = 1)
	public void navToCreateCredPage() {
		String buttonPath = "//button[contains(.,'Create Entry')]";
		eh.getElementByXpath(buttonPath,wd).click();
	}
	
	@Test(priority = 2)
	public void fillData() {
		System.out.println("Filling random data");
		randGenStr = randomString(10);
		eh.getElementByXpath("//input[@placeholder='Domain']",wd).sendKeys(randGenStr);
		eh.getElementByXpath("//input[@placeholder='Username']",wd).sendKeys(randGenStr);
		eh.getElementByXpath("//input[@placeholder='Password']",wd).sendKeys(randGenStr);
		eh.getElementByXpath("//textarea[@placeholder='Description']",wd).sendKeys(randomString(20));
	}
	
	@Test(priority = 3)
	public void resetFilledData() {
		System.out.println("Resetting filled data and re-filling");
		eh.getElementByXpath("//button[contains(.,'Reset')]",wd).click();
	}
	
	@Test(priority = 4)
	public void saveData() {
		//Press cancel
		eh.getElementByXpath("//button[contains(.,'Cancel')]",wd).click();
		//Go back to home and navigate again to create
		navToCreateCredPage();
		fillData();
		System.out.println("Saving data");
		eh.getElementByXpath("//button[contains(.,'Save')]",wd).click();
		System.out.println("Check if the saved data "+randGenStr+" is avilable after refreshing the page");
		wd.navigate().refresh();
		WebElement savedItem = eh.getElementByXpath("//*[contains(.,'"+randGenStr+"')]",wd);
		Assert.assertEquals(true, savedItem.isDisplayed());
	}
	
	@Test(priority = 99999)
	public void closeTab() {
		System.out.println("Waiting for the tab to close");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wd.close();
	}
}
