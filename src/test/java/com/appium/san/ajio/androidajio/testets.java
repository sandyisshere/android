package com.mrmoin.appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 * @author Khaja
 *
 *         Grid: java -jar
 *         /Users/Khaja/Documents/jars/selenium-server-standalone-2.53.0.jar
 *         -role huhttp://127.0.0.1:4444/grid Node 1: appium -a 127.0.0.1 -p
 *         4723 --no-reset --bootstrap-port 4728 -U 192.168.57.102:5555
 *         --nodeconfig /Users/Khaja/Documents/jars/node_config_1.json Node 2:
 *         appium -a 127.0.0.1 -p 4725 --no-reset --bootstrap-port 4729 -U
 *         192.168.57.101:5555 --nodeconfig
 *         /Users/Khaja/Documents/jars/node_config_2.json Node 3: appium -a
 *         127.0.0.1 -p 4726 --no-reset --bootstrap-port 4730 -U
 *         192.168.0.20:5555 --nodeconfig
 *         /Users/Khaja/Documents/jars/node_config_3.json
 *
 */
public class dsa {

	String port = "";
	String device = "";
	String platform_name = "";
	String platform_version = "";
	public AndroidDriver driver;
	public DesiredCapabilities cap;

	@BeforeTest
	@Parameters({ "port", "device", "platform_name", "platform_version","mobilename","apk" })
	public void beforeTest(String port, String device, String platform_name,
			String platform_version, String mobilename,String apk) throws MalformedURLException {
		this.port = port;
		long id = Thread.currentThread().getId();
		System.out.println("Before test " + port + ". Thread id is: " + id);
		File file = new File(
				apk);

		System.out.println(device);
		this.cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				platform_version);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, mobilename);
		cap.setCapability(MobileCapabilityType.APP, file);
		cap.setCapability(MobileCapabilityType.UDID, device);
		cap.setCapability("appPackage", "com.ril.ajio");
		cap.setCapability("appActivity", "SplashScreenActivity");

		URL url = new URL("http://localhost:" + port + "/wd/hub");
		
		this.driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	

	@Test
	public void testMethodOne() {

		long id = Thread.currentThread().getId();
		System.out.println("Sample <--------------------> " + port + ". Thread id is: "
				+ id);

		System.out.println(driver.getCapabilities().toString());
		

		System.out.println("during. Thread id is: " + id);

//		driver.findElement(By.id("com.ril.ajio:id/txt_email")).sendKeys(			"santhosh.baby@ril.com");

		/*// driver.findElementByAndroidUIAutomator(
		// "new UiSelector().resourceId(\"com.ril.ajio:id/txt_email\")")
		// .sendKeys("santhosh.baby@ril.com");

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/txt_password\")")
				.sendKeys("test@321");
		driver.hideKeyboard();

		driver.findElementByAndroidUIAutomator(
				"new UiSelector().resourceId(\"com.ril.ajio:id/login_button\")")
				.click();
		driver.hideKeyboard();*/

		/*
		 * driver.findElementById("io.selendroid.testapp:id/my_text_field").sendKeys
		 * ("Hello World!");
		 * 
		 * File file = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFileToDirectory(file, new
		 * File("/Users/Khaja/Documents/workspace/ParallelTests/screens"));
		 */
	}

	@AfterClass
	public void afterClass() {
		long id = Thread.currentThread().getId();
		System.out.println("After test-method  " + port + ". Thread id is: "
				+ id);
	}

	@AfterTest
	public void afterTest() {
		long id = Thread.currentThread().getId();
		System.out.println("After test  " + port + ". Thread id is: " + id);

		System.out.println(driver.getCapabilities().toString());
		System.out.println("After test  " + port + ". Thread id is: " + id);
	}
}


appium --nodeconfig D:\devel\RILworkspace\sandriver\s7edge.json -p 4726 -bp 5724
appium -a 127.0.0.1 -p 4726 --no-reset --bootstrap-port 5724 -U 98857538485134424f --nodeconfig D:\devel\RILworkspace\sandriver\s7edge.json
appium -a 127.0.0.1 -p 4727 --no-reset --bootstrap-port 5725 -U 50a44df8 --nodeconfig D:\devel\RILworkspace\sandriver\oneplusone.json

appium --nodeconfig D:\devel\RILworkspace\sandriver\oneplusone.json -p 4727 -bp 5725


50a44df8        dev
98857538485134424f
hub
java -jar D:\softwares\selenium-server-standalone-2.53.1.jar -role hub ttp://127.0.0.1:4444/grid
	
{
    "capabilities":
 [
{
"browserName": "Chrome",
"deviceName": "A0001",
"device": "device",
"udid":"50a44df8",
"version":"6.0.1",
"maxInstances": 5,
"platform":"ANDROID",
"platformName": "Android"
}
],	
    "configuration":
   { 
    "nodeTimeout":120, 
    "port":4726, 
    "hubPort":4444,
	"proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "url":"http://127.0.0.1:4726/wd/hub",
	"hub": "127.0.0.1:4444/grid/register",
    "hubHost":"127.0.0.1",
    "nodePolling":2000, 
    "registerCycle":10000,
    "register":true,
    "cleanUpCycle":2000, 
    "timeout":30000, 
    "maxSession":1
 } 
   } 


{
    "capabilities":
 [
{
"browserName": "Chrome",
"deviceName": "san",
"device": "device",
"udid":"98857538485134424f",
"version":"6.0.1",
"maxInstances": 5,
"platform":"ANDROID",
"platformName": "Android"
}
], 
	
    "configuration":
   { 
    "nodeTimeout":120, 
    "port":4727, 
    "hubPort":4444,
	"proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "url":"http://127.0.0.1:4727/wd/hub",
	"hub": "127.0.0.1:4444/grid/register",
    "hubHost":"127.0.0.1",
    "nodePolling":2000, 
    "registerCycle":10000,
    "register":true,
    "cleanUpCycle":2000, 
    "timeout":30000, 
   "maxSession":1
 } 
   } 


<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Test-class Suite" parallel="tests" thread-count="2">
    <test name="Test-class test 1">
        <parameter name="test-name" value="test-method One" />
            <parameter name="port" value="4727"></parameter>
			<parameter name="mobilename" value="A0001"></parameter>
		    <parameter name="device" value="50a44df8"></parameter>
			
			<parameter name="platform_name" value="Android"></parameter>
			<parameter name="platform_version" value="6.0.1"></parameter>
			<parameter name="apk" value="C:\\Users\\santhosh\\Downloads\\SHAREit\\SM-G935F\\app\\AJIO.apk"></parameter>
        <classes>
            <class name="com.mrmoin.appium.dsa" />
        </classes>
    </test>
    <test name="Test-class test 2">
            <parameter name="port" value="4726"></parameter>
			<parameter name="device" value="98857538485134424f"></parameter>
			<parameter name="mobilename" value="san"></parameter>			
			<parameter name="platform_name" value="Android"></parameter>
			<parameter name="platform_version" value="6.0.1"></parameter>
		    <parameter name="apk" value="C:\\Users\\santhosh\\Downloads\\SHAREit\\SM-G935F\\app\\AJIO1.apk"></parameter>
        <classes>
            <class name="com.mrmoin.appium.dsa" />
        </classes>
    </test>
</suite>
