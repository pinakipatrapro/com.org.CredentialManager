package com.org.UI5ExploredBasicStep.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
	public WebElement getElementById(String id,WebDriver wd) {
		System.out.println("Finding element with ID : " + id);
		WebDriverWait wait = new WebDriverWait(wd, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		System.out.println("Success. " + id + " found !!");
		return wd.findElement(By.id(id));
	}
	public WebElement getElementByXpath(String xpath,WebDriver wd) {
		System.out.println("Finding element with XPath : " + xpath);
		WebDriverWait wait = new WebDriverWait(wd, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		System.out.println("Success. " + xpath + " found !!");
		return wd.findElement(By.xpath(xpath));
	}
}
