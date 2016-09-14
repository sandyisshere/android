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
	
	

	
	public static  DesiredCapabilities cap;
	//public AppiumServer appiumServer;
	
	@BeforeTest()
	@Parameters({ "port", "device", "platform_name", "platform_version","mobilename","apk" })
	public void setUp(String port, String device, String platform_name,
			String platform_version, String mobilename,String apk) throws MalformedURLException{
		File file = new File(apk);
/*		ServerArguments serverArguments = new ServerArguments();
		serverArguments.setArgument("--address", "127.0.0.1");
		serverArguments.setArgument("--chromedriver-port", 9516);
		serverArguments.setArgument("--bootstrap-port", 4725);
		serverArguments.setArgument("--no-reset", true);
		serverArguments.setArgument("--local-timezone", true);

		AppiumServer appiumServer = new AppiumServer(serverArguments);

		appiumServer.startServer();
*/		
		this.cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				platform_version);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, mobilename);
		cap.setCapability(MobileCapabilityType.APP, file);
		cap.setCapability(MobileCapabilityType.UDID, device);
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.ril.ajio");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "SplashScreenActivity");


		URL url = new URL("http://localhost:"+port+"/wd/hub");
		System.out.println(url.toString());
		this.driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println(this.driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void teardown()
	{
	 driver.quit();	
//	 appiumServer.stopServer();
	}
}
