package com.org.UI5ExploredBasicStep;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.org.UI5ExploredBasicStep.util.LoadDrivers;
import com.org.UI5ExploredBasicStep.util.ElementHelper;

public class NavigateTest {
	static LoadDrivers drivers = new LoadDrivers();
	private static final WebDriver wd = drivers.openUrl("http://127.0.0.1:5500/LocalStorage/WebContent/index.html");;
	private static final ElementHelper eh = new ElementHelper();
}
