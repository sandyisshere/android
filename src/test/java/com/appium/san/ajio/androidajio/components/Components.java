package com.appium.san.ajio.androidajio.components;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import com.san.appium.sandriver.TestBase;

public class Components extends TestBase{

	
	public Components(AndroidDriver d) throws Exception {
		driver = d;
		// ui = new UIMapParser(utils.getConfig("ObjectRepository"));
	}
	
	public void login()
	{
		driver.findElement(By.id("com.ril.ajio:id/txt_email")).sendKeys("santhosh.baby@ril.com");

//		driver.findElementByAndroidUIAutomator(
//				"new UiSelector().resourceId(\"com.ril.ajio:id/txt_email\")")
//				.sendKeys("santhosh.baby@ril.com");

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/txt_password\")")
				.sendKeys("test@321");
		driver.hideKeyboard();

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/login_button\")").click();
		driver.hideKeyboard();

	}
	
}
