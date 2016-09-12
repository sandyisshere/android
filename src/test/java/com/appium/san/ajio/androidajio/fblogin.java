package com.appium.san.ajio.androidajio;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

		capabilities.setCapability("app", "C:\\Users\\santhosh\\Downloads\\SHAREit\\SM-G935F\\app\\AJIO.apk");
		capabilities.setCapability("newCommandTimeout", "30");

		capabilities.setCapability("appPackage", "com.ril.ajio");

		capabilities.setCapability("appActivity", "SplashScreenActivity");

		AndroidDriver driver = new AndroidDriver(new URL(appiumServiceUrl),
				capabilities);

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.ril.ajio:id/txt_email")).sendKeys("santhoshooo.baby@ril.com");

//		driver.findElementByAndroidUIAutomator(
//				"new UiSelector().resourceId(\"com.ril.ajio:id/txt_email\")")
//				.sendKeys("santhosh.baby@ril.com");
		driver.hideKeyboard();

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/txt_password\")")
				.sendKeys("test@321");
		driver.hideKeyboard();

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/login_button\")").click();
		driver.hideKeyboard();

	}

	@AfterTest
	public void test() {
		appiumService.build().stop();
	}
}
