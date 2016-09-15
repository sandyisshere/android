package com.appium.san.ajio.androidajio.components;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import com.san.appium.sandriver.TestBase;
import com.san.appium.sandriver.WaitEvent;

public class Components extends TestBase {

	public Components(AndroidDriver driver) throws Exception {
		System.out.println("uuuuuuuuuuuuu");
		this.driver = driver;
		//we = new WaitEvent(driver);

		// ui = new UIMapParser(utils.getConfig("ObjectRepository"));
	}

	public void navigatetologin() throws Exception {

		By clic = By.id("com.ril.ajio:id/icon_account_tab");
		click(clic, 30);
		By fac = By.id("com.ril.ajio:id/signin_bt_myact");
		click(fac, 30);

	}

	public void login() throws Exception {
		setValue(By.id("com.ril.ajio:id/txt_email"),"santhosh.baby@ril.com");
		setValue(By.id("com.ril.ajio:id/txt_password"),"test@321");
click(By.id("com.ril.ajio:id/login_button"));
/*		// driver.findElementByAndroidUIAutomator(
		// "new UiSelector().resourceId(\"com.ril.ajio:id/txt_email\")")
		// .sendKeys("santhosh.baby@ril.com");

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/txt_password\")")
				.sendKeys("test@321");
		driver.hideKeyboard();

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/login_button\")")
				.click();
		driver.hideKeyboard();

*/	}

}
