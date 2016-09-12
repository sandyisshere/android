package com.san.appium.sandriver;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelBase {

	protected AndroidDriver driver;
	protected WaitEvent we = null;

	public SelBase() {
		we = new WaitEvent(driver);
	}

	public void setValue(By locator, String val, int durationSecs)
			throws Exception {
		if (durationSecs > 0) {
			if (we == null)
				we = new WaitEvent(driver);

			we.waitForElement(locator, durationSecs);
		}
		driver.findElement(locator).sendKeys(val);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {

		}
	}

	public void setValue(By locator, String val) throws Exception {
		setValue(locator, val, 0);
	}

	public void click(By locator, int durationSecs) throws Exception {
		if (durationSecs > 0) {
			if (we == null)
				we = new WaitEvent(driver);

			we.waitForElement(locator, durationSecs);
		}

		driver.findElement(locator).click();
	}

	public void click(By locator) throws Exception {
		click(locator, 0);
	}

}
