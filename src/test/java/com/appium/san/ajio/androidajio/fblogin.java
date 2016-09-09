package com.appium.san.ajio.androidajio;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class fblogin {

	AppiumServiceBuilder appiumService;

	@Test
	public void testlogin() throws MalformedURLException, InterruptedException {

		String Appium_Node_Path = "C:\\Program Files (x86)\\Appium\\node.exe";
		String Appium_JS_Path = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";

		appiumService = new AppiumServiceBuilder().usingAnyFreePort()
				.usingDriverExecutable(new File(Appium_Node_Path))
				.withAppiumJS(new File(Appium_JS_Path));
		appiumService.build().start();

		String appiumServiceUrl = appiumService.build().getUrl().toString();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("automationName", "Appium");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("platformVersion", "5.1");

		capabilities.setCapability("deviceName", "Android Emulator");

		capabilities.setCapability("app", "D:\\Software\\facebook.apk");
		capabilities.setCapability("newCommandTimeout", "30");

		capabilities.setCapability("appPackage", "com.facebook.katana");

		capabilities.setCapability("appActivity", "LoginActivity");

		AndroidDriver driver = new AndroidDriver(new URL(appiumServiceUrl),
				capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.facebook.katana:id/login_username\")")
				.sendKeys("santosh.baby@gmail.com");
		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.facebook.katana:id/login_password\")")
				.sendKeys("santosh.baby@gmail.com");

		Thread.sleep(7000);
	}

	@AfterTest
	public void test() {
		appiumService.build().stop();
	}
}
