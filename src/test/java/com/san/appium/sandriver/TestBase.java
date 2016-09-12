package com.san.appium.sandriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase extends SelBase{
	
	

	public AndroidDriver<MobileElement> driver;
	public static  DesiredCapabilities capabilities;
	//public AppiumServer appiumServer;
	
	@BeforeTest()
	@Parameters({"port", "device", "platform_name", "platform_version"})
	public void setUp(String port, String device, String platform_name, String platform_version) throws MalformedURLException{
		//File file = new File("/Users/Khaja/Documents/Appium/appium_downloads/selendroid-test-app-0.17.0.apk");
/*		ServerArguments serverArguments = new ServerArguments();
		serverArguments.setArgument("--address", "127.0.0.1");
		serverArguments.setArgument("--chromedriver-port", 9516);
		serverArguments.setArgument("--bootstrap-port", 4725);
		serverArguments.setArgument("--no-reset", true);
		serverArguments.setArgument("--local-timezone", true);

		AppiumServer appiumServer = new AppiumServer(serverArguments);

		appiumServer.startServer();
*/		
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", platform_name);
		capabilities.setCapability("platformVersion", platform_version);
		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("app", "C:\\Users\\santhosh\\Downloads\\SHAREit\\SM-G935F\\app\\AJIO.apk");
		capabilities.setCapability("newCommandTimeout", "30");
		capabilities.setCapability("appPackage", "com.ril.ajio");
		capabilities.setCapability("appActivity", "SplashScreenActivity");
		/*cap.setCapability(MobileCapabilityType.PLATFORM_NAME , platform_name);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP, file);
		cap.setCapability("appPackage", "io.selendroid.testapp");
		cap.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		*/
		URL url = new URL("http://localhost:"+port+"/wd/hub");
		System.out.println(url.toString());
		driver = new AndroidDriver<MobileElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void teardown()
	{
	 driver.quit();	
//	 appiumServer.stopServer();
	}
}
