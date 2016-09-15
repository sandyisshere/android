package com.san.appium.sandriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelBase {

	 public AndroidDriver<MobileElement> driver;
     public WaitEvent we = null;

	public SelBase( ) {
		
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
System.out.println("faileeed to   perform hide keyword");
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
