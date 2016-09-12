package com.san.utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.san.pages.LandingPage;
import com.san.pages.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AbstractTest {

	public static AndroidDriver driver;
	public static AppiumServiceBuilder appiumService;

	@BeforeClass
	public static void createEnvironment() throws Exception {

		// DesiredCapabilities

		//startAndroid();

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


		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

		PageFactory.initElements(new AppiumFieldDecorator(driver),
				new LoginPage());

	}

	@AfterClass
	public static void tearEnvironment() throws Exception {
		driver.quit();
		stopAppium();

	}

	public static void startAndroid() throws Exception {

		// node appium

		// node appium.js

		CommandLine command = new CommandLine(
				"C:\\Program Files (x86)\\Appium\\node.exe");

		command.addArgument(
				"C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js",
				false);

		command.addArgument("--address", false);

		command.addArgument("127.0.0.1");

		command.addArgument("--port", false);

		command.addArgument("4723");

		command.addArgument("--no-reset", false);

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

		DefaultExecutor executor = new DefaultExecutor();

		executor.setExitValue(1);

		executor.execute(command, resultHandler);

		Thread.sleep(3000);

	}

	public static void stopAppium() throws Exception {
		Runtime.getRuntime().exec("killall node");

	}

}
